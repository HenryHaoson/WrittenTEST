package com.henryhaoson.expendview.read.view.WordView;

/**
 * Author : zhuhao
 * Date : 21/12/2017
 *
 * @Last Modified Time :21/12/2017
 * Description :
 */

import android.content.Context;
import android.graphics.Paint;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class AutoResizeTextView extends android.support.v7.widget.AppCompatTextView {
    public static final float MIN_TEXT_SIZE = 20.0f;
    private static final String mEllipsis = "...";
    private boolean mAddEllipsis;
    private float mMaxTextSize;
    private float mMinTextSize;
    private boolean mNeedsResize;
    private float mSpacingAdd;
    private float mSpacingMult;
    private a mTextResizeListener;
    private float mTextSize;

    public interface a {
        void a(TextView textView, float f, float f2);
    }

    public AutoResizeTextView(Context context) {
        this(context, null);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNeedsResize = false;
        this.mMaxTextSize = 0.0f;
        this.mMinTextSize = 20.0f;
        this.mSpacingMult = 1.0f;
        this.mSpacingAdd = 0.0f;
        this.mAddEllipsis = true;
        this.mTextSize = getTextSize();
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.mNeedsResize = true;
        resetTextSize();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i != i3 || i2 != i4) {
            this.mNeedsResize = true;
        }
    }

    public void setOnResizeListener(a aVar) {
        this.mTextResizeListener = aVar;
    }

    public void setTextSize(float f) {
        super.setTextSize(f);
        this.mTextSize = getTextSize();
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.mTextSize = getTextSize();
    }

    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.mSpacingMult = f2;
        this.mSpacingAdd = f;
    }

    public float getMaxTextSize() {
        return this.mMaxTextSize;
    }

    public void setMaxTextSize(float f) {
        this.mMaxTextSize = f;
        requestLayout();
        invalidate();
    }

    public float getMinTextSize() {
        return this.mMinTextSize;
    }

    public void setMinTextSize(float f) {
        this.mMinTextSize = f;
        requestLayout();
        invalidate();
    }

    public boolean getAddEllipsis() {
        return this.mAddEllipsis;
    }

    public void setAddEllipsis(boolean z) {
        this.mAddEllipsis = z;
    }

    public void resetTextSize() {
        if (this.mTextSize > 0.0f) {
            super.setTextSize(0, this.mTextSize);
            this.mMaxTextSize = this.mTextSize;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z || this.mNeedsResize) {
            resizeText(((i3 - i) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), ((i4 - i2) - getCompoundPaddingBottom()) - getCompoundPaddingTop());
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void resizeText() {
        resizeText((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingBottom()) - getPaddingTop());
    }

    public void resizeText(int i, int i2) {
        CharSequence text = getText();
        if (text != null && text.length() != 0 && i2 > 0 && i > 0 && this.mTextSize != 0.0f) {
            if (getTransformationMethod() != null) {
                text = getTransformationMethod().getTransformation(text, this);
            }
            Paint paint = getPaint();
            float textSize = paint.getTextSize();
            float min = this.mMaxTextSize > 0.0f ? Math.min(this.mTextSize, this.mMaxTextSize) : this.mTextSize;
            float f = min;
            int textHeight = getTextHeight(text, (TextPaint) paint, i, min);
            while (textHeight > i2 && f > this.mMinTextSize) {
                float max = Math.max(f - 2.0f, this.mMinTextSize);
                textHeight = getTextHeight(text, (TextPaint) paint, i, max);
                f = max;
            }
            if (this.mAddEllipsis && f == this.mMinTextSize && textHeight > i2) {
                StaticLayout staticLayout = new StaticLayout(text, new TextPaint(paint), i, Alignment.ALIGN_NORMAL, this.mSpacingMult, this.mSpacingAdd, false);
                if (staticLayout.getLineCount() > 0) {
                    int lineForVertical = staticLayout.getLineForVertical(i2) - 1;
                    if (lineForVertical < 0) {
                        setText("");
                    } else {
                        int lineStart = staticLayout.getLineStart(lineForVertical);
                        int lineEnd = staticLayout.getLineEnd(lineForVertical);
                        min = staticLayout.getLineWidth(lineForVertical);
                        float measureText = paint.measureText(mEllipsis);
                        while (((float) i) < min + measureText) {
                            lineEnd--;
                            min = paint.measureText(text.subSequence(lineStart, lineEnd + 1).toString());
                        }
                        setText(text.subSequence(0, lineEnd) + mEllipsis);
                    }
                }
            }
            setTextSize(0, f);
            setLineSpacing(this.mSpacingAdd, this.mSpacingMult);
            if (this.mTextResizeListener != null) {
                this.mTextResizeListener.a(this, textSize, f);
            }
            this.mNeedsResize = false;
        }
    }

    private int getTextHeight(CharSequence charSequence, TextPaint textPaint, int i, float f) {
        TextPaint textPaint2 = new TextPaint(textPaint);
        textPaint2.setTextSize(f);
        return new StaticLayout(charSequence, textPaint2, i, Alignment.ALIGN_NORMAL, this.mSpacingMult, this.mSpacingAdd, true).getHeight();
    }
}
