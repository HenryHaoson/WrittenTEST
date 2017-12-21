package com.zhuhao.wordtextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhuhao on 17/7/2017.
 */

public class WordTextView extends android.support.v7.widget.AppCompatTextView {

    private CharSequence mText;
    private TextView.BufferType mBufferType;

    private OnWordClickListener mOnWordClickListener;
    private SpannableString mSpannableString;

    private BackgroundColorSpan mSelectedBackSpan;
    private ForegroundColorSpan mSelectedForeSpan;

    private int highlightColor;
    private String highlightText;
    private int selectedColor;
//    //0英语，1中文
//    private int language;

    //新增左右对其
    private boolean justify=true;
    private float textAreaWidth;
    private float spaceCharSize;
    private float lineY;

    public WordTextView(Context context) {
        this(context, null);
    }

    public WordTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WordTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.WordTextView);
        highlightColor = ta.getColor(R.styleable.WordTextView_highlightColor, Color.RED);
        highlightText = ta.getString(R.styleable.WordTextView_highlightText);
        selectedColor = ta.getColor(R.styleable.WordTextView_selectedColor, Color.BLUE);
//        language = ta.getInt(R.styleable.WordTextView_language, 0);
        ta.recycle();
    }


    @Override
    public void setText(CharSequence text, TextView.BufferType type) {
        this.mText = text;
        mBufferType = type;
        setHighlightColor(Color.TRANSPARENT);
        setMovementMethod(LinkMovementMethod.getInstance());
        setText();
    }

    private void setText() {
        mSpannableString = new SpannableString(mText);
        //设置高亮Spannable
        setHighLightSpan(mSpannableString);
//        if (language == 0) {
//            dealEnglish();
//        } else {
//            dealChinese();
//        }
        super.setText(mSpannableString, mBufferType);

    }

//    private void dealChinese() {
//        for (int i = 0; i < mText.length(); i++) {
//            char ch = mText.charAt(i);
//            if (WordUtils.isChinese(ch)) {
//                mSpannableString.setSpan(getClickableSpan(), i, i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            }
//        }
//    }

    private void dealEnglish() {
        List<WordInfo> wordInfoList = WordUtils.getEnglishWordIndices(mText.toString());
        for (WordInfo wordInfo : wordInfoList) {
            mSpannableString.setSpan(getClickableSpan(), wordInfo.getStart(), wordInfo.getEnd(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }


    private void setHighLightSpan(SpannableString spannableString) {
        if (TextUtils.isEmpty(highlightText)) {
            return;
        }
        int hIndex = mText.toString().indexOf(highlightText);
        while (hIndex != -1) {
            spannableString.setSpan(new ForegroundColorSpan(highlightColor), hIndex, hIndex + highlightText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            hIndex += highlightText.length();
            hIndex = mText.toString().indexOf(highlightText, hIndex);
        }
    }

    private void setSelectedSpan(TextView tv) {
        if (mSelectedBackSpan == null || mSelectedForeSpan == null) {
            mSelectedBackSpan = new BackgroundColorSpan(selectedColor);
            mSelectedForeSpan = new ForegroundColorSpan(Color.WHITE);
        } else {
            mSpannableString.removeSpan(mSelectedBackSpan);
            mSpannableString.removeSpan(mSelectedForeSpan);
        }
        mSpannableString.setSpan(mSelectedBackSpan, tv.getSelectionStart(), tv.getSelectionEnd(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mSpannableString.setSpan(mSelectedForeSpan, tv.getSelectionStart(), tv.getSelectionEnd(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        WordTextView.super.setText(mSpannableString, mBufferType);
    }

    public void dismissSelected() {
        mSpannableString.removeSpan(mSelectedBackSpan);
        mSpannableString.removeSpan(mSelectedForeSpan);
        WordTextView.super.setText(mSpannableString, mBufferType);
    }

    private ClickableSpan getClickableSpan() {
        return new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                TextView tv = (TextView) widget;
                String word = tv
                        .getText()
                        .subSequence(tv.getSelectionStart(),
                                tv.getSelectionEnd()).toString();
                setSelectedSpan(tv);

                if (mOnWordClickListener != null) {
                    mOnWordClickListener.onClick(word);
                }
            }

            @Override
            public void updateDrawState(TextPaint ds) {
            }
        };
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onDraw(Canvas canvas) {
        drawText(canvas);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void drawText(Canvas canvas) {
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        textAreaWidth = getMeasuredWidth() - (getPaddingLeft() + getPaddingRight());

        spaceCharSize = paint.measureText(" ");

        String text = mText.toString();
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
                drawLineJustified(canvas, line, lineWidth);
            } else {
                canvas.drawText(line, 0, lineY, paint);
            }
            lineY += textHeight;
        }

    }

    private void drawLineJustified(Canvas canvas, String line, float lineWidth) {
        TextPaint paint = getPaint();

        float emptySpace = textAreaWidth - lineWidth;
        int spaces = line.split(" ").length - 1;
        float newSpaceSize = (emptySpace / spaces) + spaceCharSize;

        float charX = 0;

        for (int i = 0; i < line.length(); i++) {
            String character = String.valueOf(line.charAt(i));
            float charWidth = StaticLayout.getDesiredWidth(character, paint);
            if (!character.equals(" ")) {
                canvas.drawText(character, charX, lineY, paint);
            }

            if (character.equals(" ") && i != line.length() - 1)
                charX += newSpaceSize;
            else
                charX += charWidth;
        }

    }


    public void setOnWordClickListener(OnWordClickListener listener) {
        this.mOnWordClickListener = listener;
    }

    public void setHighLightText(String text) {
        highlightText = text;
    }

    public void setHighLightColor(int color) {
        highlightColor = color;
    }

    public interface OnWordClickListener {
        void onClick(String word);
    }
}
