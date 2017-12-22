package com.henryhaoson.expendview.read.view.WordView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : zhuhao
 * Date : 22/12/2017
 *
 * @Last Modified Time :22/12/2017
 * Description :
 */

public class LineInfo {
    List<WordInfo> wordInfos;
    float spaceMeasure;
    float lineHeight;

    public LineInfo() {
        wordInfos = new ArrayList<>();
    }

    public void setSpaceMeasure(float spaceMeasure) {
        this.spaceMeasure = spaceMeasure;
    }

    public void setLineHeight(float lineHeight) {
        this.lineHeight = lineHeight;
    }

    public float getLineHeight() {
        return lineHeight;
    }

    public float getSpaceMeasure() {
        return spaceMeasure;
    }
}
