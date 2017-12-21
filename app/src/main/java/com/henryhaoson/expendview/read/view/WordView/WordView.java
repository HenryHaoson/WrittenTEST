package com.henryhaoson.expendview.read.view.WordView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;

import com.henryhaoson.expendview.R;

/**
 * Author : zhuhao
 * Date : 21/12/2017
 *
 * @Last Modified Time :21/12/2017
 * Description :
 */

public class WordView extends android.support.v7.widget.AppCompatTextView {
    private CharSequence mText;
    private TextView.BufferType mBufferType;

    private OnWordClickListener mOnWordClickListener;
    private SpannableString mSpannableString;

    private BackgroundColorSpan mSelectedBackSpan;
    private ForegroundColorSpan mSelectedForeSpan;

    private int highlightColor;
    private String highlightText;
    private int selectedColor;


    //新增左右对其
    private boolean justify = true;
    private float textAreaWidth;
    private float spaceCharSize;
    private float lineY;

    private boolean isWordLoad = false;


    public WordView(Context context) {
        this(context, null);
    }

    public WordView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WordView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.WordTextView);
        highlightColor = ta.getColor(R.styleable.WordView_highlightColor, Color.RED);
        highlightText = ta.getString(R.styleable.WordView_highlightText);
        selectedColor = ta.getColor(R.styleable.WordView_selectedColor, Color.BLUE);
        ta.recycle();
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onDraw(Canvas canvas) {
        drawText();
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void drawText() {
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        textAreaWidth = getMeasuredWidth() - (getPaddingLeft() + getPaddingRight());

        spaceCharSize = paint.measureText(" ");
        String text = getText().toString();
        lineY = getTextSize();

        Layout textLayout = getLayout();

        if (textLayout == null)
            return;

        Paint.FontMetrics fm = paint.getFontMetrics();
        int textHeight = (int) Math.ceil(fm.descent - fm.ascent);
        textHeight = (int) (textHeight * getLineSpacingMultiplier() + textLayout.getSpacingAdd());

        for (int i = 0; i < textLayout.getLineCount(); i++) {

            int lineStart = textLayout.getLineStart(i);
            int lineEnd = textLayout.getLineEnd(i);

            float lineWidth = StaticLayout.getDesiredWidth(text, lineStart, lineEnd, paint);
            String line = text.substring(lineStart, lineEnd);

            if (line.charAt(line.length() - 1) == ' ') {
                line = line.substring(0, line.length() - 1);
            }

            if (justify && i < textLayout.getLineCount() - 1) {
//                drawLineJustified(canvas, line, lineWidth);
            } else {
//                canvas.drawText(line, 0, lineY, paint);
            }
            lineY += textHeight;
        }

    }

    private void drawLineJustified(String line, float lineWidth) {
        TextPaint paint = getPaint();

        float emptySpace = textAreaWidth - lineWidth;
        int spaces = line.split(" ").length - 1;
        float newSpaceSize = (emptySpace / spaces) + spaceCharSize;
        float charX = 0;

        for (int i = 0; i < line.length(); i++) {
            String character = String.valueOf(line.charAt(i));
            float charWidth = StaticLayout.getDesiredWidth(character, paint);
            if (!character.equals(" ")) {
//                canvas.drawText(character, charX, lineY, paint);
            }

            if (character.equals(" ") && i != line.length() - 1)
                charX += newSpaceSize;
            else
                charX += charWidth;
        }

    }

    public interface OnWordClickListener {
        void onClick(String word);
    }
}
