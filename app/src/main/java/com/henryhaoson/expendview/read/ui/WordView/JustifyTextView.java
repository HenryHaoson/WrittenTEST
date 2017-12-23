package com.henryhaoson.expendview.read.ui.WordView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import com.zhuhao.wordtextview.WordTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : zhuhao
 * Date : 21/12/2017
 *
 * @Last Modified Time :21/12/2017
 * Description :
 */

public class JustifyTextView extends android.support.v7.widget.AppCompatTextView {
    Character[] arr = new Character[]{',', '.', ';', '!', '"', '，', '。', '！', '；', '、', '：', '“', '”', '?', '？'};
    //高亮字体画笔
    private TextPaint paint;
    private Paint bgPaint;
    private String mText;
    //普通字体颜色
    private int mColor;
    //高亮字体颜色
    private int highLightColor = Color.WHITE;
    //高亮背景颜色
    private int highLightBackColor = Color.BLUE;
    //当前处理的单词
    private WordInfo wordInfo;
    //当前单词的Y
    float currentWordY;

    private List<LineInfo> lineInfos = new ArrayList<>();
    public WordTextView.OnWordClickListener listener;

    //是否有单词被点击。
    public boolean isClicked = false;


    public JustifyTextView(Context context) {
        this(context, null);
    }

    public JustifyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mColor = getTextColors().getDefaultColor();
        getPaint().setColor(this.mColor);
        paint = new TextPaint(getPaint());
        paint.setColor(highLightColor);
        bgPaint = new Paint();
        bgPaint.setColor(highLightBackColor);
    }

    /**
     * 设置文本内容，调用setText方法
     *
     * @param str 文本
     */
    public final void setContent(String str) {
        // str=str.replaceAll(".","."+" ");
        super.setText(str);
        this.mText = str;
        requestLayout();
        invalidate();
    }

    /**
     * 设置单词点击监听器
     *
     * @param listener 监听器
     */
    public void setOnWordClickListener(WordTextView.OnWordClickListener listener) {
        this.listener = listener;
    }


    protected void onDraw(Canvas canvas) {
        //TODO 局部绘制
        if (null != mText) {
            justifyDraw(canvas);
        }
        if (isClicked) {
            drawHighLight(canvas);
        }
    }

    /**
     * 设置两端对齐
     *
     * @param canvas 画布
     */
    private void justifyDraw(Canvas canvas) {

        int lineCount = getLayout().getLineCount();
        float measuredWidth = (float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        int i = 0;
        while (i < lineCount) {

            //每行单词信息
            LineInfo lineInfo = new LineInfo();

            String substring = this.mText.substring(getLayout().getLineStart(i), getLayout().getLineEnd(i));
            if (!(substring.length() == 0 || substring.equals("\n"))) {
                float measureText;
                String[] split = substring.split(" ");
                if (substring.endsWith("\n") || i == getLineCount() - 1) {
                    measureText = getPaint().measureText(" ");
                } else {
                    float f = 0.0f;
                    for (String measureText2 : split) {
                        f += getPaint().measureText(measureText2);
                    }
                    measureText = (measuredWidth - f) / ((float) (split.length - 1));
                }

                //设置每行空格的绘制宽度
                lineInfo.setSpaceMeasure(measureText);

                int paddingLeft = getPaddingLeft();
                int lineBaseline = getLayout().getLineBaseline(i);

                //设置每行的高度
                lineInfo.setLineHeight(lineBaseline);

                int i2 = paddingLeft;
                for (String str : split) {
                    WordInfo wordInfo = new WordInfo();
                    //设置单词开始位置
                    wordInfo.setStart((float) i2);
                    //设置单词
                    String word = str.replaceAll("[^\\w]","");
                    wordInfo.setWord(word);
                    canvas.drawText(str, (float) i2, (float) lineBaseline, getPaint());
                    i2 = (int) (((float) i2) + (getPaint().measureText(str) + measureText));
                    //设置单词结束位置
                    wordInfo.setEnd((float) i2 - measureText);
                    //添加单词信息
                    lineInfo.wordInfos.add(wordInfo);
                }

                //笨方法为了解决bug" hello.world
//                for (String str : split) {
//                    String firstWord = null;
//                    boolean isFirstWord = true;
//                    String[] words = str.split("[^\\w]");
//                    for (String word : words) {
//                        if (words.length == 1) {
//                            WordInfo wordInfo = new WordInfo();
//                            //设置单词开始位置
//                            wordInfo.setStart((float) i2);
//                            //设置单词
//                            wordInfo.setWord(word);
//                            canvas.drawText(str, (float) i2, (float) lineBaseline, getPaint());
//                            i2 = (int) (((float) i2) + (getPaint().measureText(str) + measureText));
//                            //设置单词结束位置
//                            wordInfo.setEnd((float) i2 - measureText);
//                            //添加单词信息
//                            lineInfo.wordInfos.add(wordInfo);
//                            break;
//                        } else {
//                            if (isFirstWord) {
//                                firstWord = word;
//                            }
//                            WordInfo wordInfo = new WordInfo();
//                            //设置单词开始位置
//                            wordInfo.setStart((float) i2);
//                            //设置单词
//                            wordInfo.setWord(word);
//                            if (isFirstWord) {
//                                canvas.drawText(word, (float) i2, (float) lineBaseline, getPaint());
//                                i2 = (int) (((float) i2) + (getPaint().measureText(word) + measureText));
//                                isFirstWord = false;
//                            } else {
//                                String second = str.replace(firstWord, "");
//                                canvas.drawText(second, (float) i2, (float) lineBaseline, getPaint());
//                                i2 = (int) (((float) i2) + (getPaint().measureText(str.replace(firstWord, "")) + measureText));
//                            }
//                            //设置单词结束位置
//                            wordInfo.setEnd((float) i2 - measureText);
//                            //添加单词信息
//                            lineInfo.wordInfos.add(wordInfo);
//                        }
//                    }
//                }


            }
            lineInfos.add(lineInfo);
            i++;
        }
    }

    /**
     * 判断是否点击到单词
     *
     * @param event 事件
     * @return 消费事件
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();
                Log.i("justify", "x=" + x + " y=" + y);
                for (LineInfo lineInfo : lineInfos) {
                    if (lineInfo.getLineHeight() > y) {
                        for (WordInfo wordInfo : lineInfo.wordInfos) {
                            if (wordInfo.getStart() <= x && wordInfo.getEnd() >= x) {

                                listener.onClick(wordInfo.getWord());
                                highLightInfo(wordInfo, lineInfo.getLineHeight());
                                isClicked = true;
                                postInvalidate();
                                return true;
                            }

                        }
                        break;

                    }
                }
        }
        return true;
    }

    /**
     * 初始化绘制高亮信息
     *
     * @param wordInfo 单词信息
     * @param wordY    纵坐标
     */
    public void highLightInfo(WordInfo wordInfo, float wordY) {
        this.wordInfo = wordInfo;
        currentWordY = wordY;

    }

    /**
     * 绘制高亮单词
     *
     * @param canvas 画布
     */
    public void drawHighLight(Canvas canvas) {
        //画背景
        canvas.drawRect(wordInfo.getStart(), currentWordY + paint.getFontMetrics().ascent + paint.getFontMetrics().leading,
                wordInfo.getEnd(), currentWordY + paint.getFontMetrics().descent, bgPaint);
        //画高亮的单词
        canvas.drawText(wordInfo.getWord(), wordInfo.getStart(), currentWordY, paint);

    }


    public interface onWordClickedListener {
        void onClicked(String word);
    }
}
