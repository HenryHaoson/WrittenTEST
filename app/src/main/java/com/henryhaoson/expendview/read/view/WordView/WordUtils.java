package com.henryhaoson.expendview.read.view.WordView;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhuhao on 17/7/2017.
 */

public class WordUtils {

    private static List<Character> sPunctuations;

    static {
        Character[] arr = new Character[]{',', '.', ';', '!', '"', '，', '。', '！', '；', '、', '：', '“', '”','?','？'};
        sPunctuations = Arrays.asList(arr);
    }


    @NonNull
    static List<WordInfo> getEnglishWordIndices(String content) {
        List<Integer> separatorIndices = getSeparatorIndices(content, ' ');
        for (Character punctuation : sPunctuations) {
            separatorIndices.addAll(getSeparatorIndices(content, punctuation));
        }
        Collections.sort(separatorIndices);
        List<WordInfo> wordInfoList = new ArrayList<>();
        int start = 0;
        int end;
        for (int i = 0; i < separatorIndices.size(); i++) {
            end = separatorIndices.get(i);
            if (start == end) {
                start++;
            } else {
                WordInfo wordInfo = new WordInfo();
                wordInfo.setStart(start);
                wordInfo.setEnd(end);
                wordInfoList.add(wordInfo);
                start = end + 1;
            }
        }
        return wordInfoList;
    }

    /**
     * 获取要分割的下标
     *
     * @param word 文本对象
     * @param ch   分割的字符
     * @return 分割的下标集合
     */
    private static List<Integer> getSeparatorIndices(String word, char ch) {
        int pos = word.indexOf(ch);
        List<Integer> indices = new ArrayList<>();
        while (pos != -1) {
            indices.add(pos);
            pos = word.indexOf(ch, pos + 1);
        }
        return indices;
    }
}
