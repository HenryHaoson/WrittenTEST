package com.henryhaoson.expendview.read.view.WordView;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhuhao on 17/7/2017.
 */

public class WordUtils {


    static {
        Character[] arr = new Character[]{',', '.', ';', '!', '"', '，', '。', '！', '；', '、', '：', '“', '”','?','？'};
    }
     public static void splitIllegleChar(String str,Character character){

     }
     public String[] getWord(String str){
         String words[] =new String[5];
         String s = "\\w+";
         Pattern  pattern= Pattern.compile(s);
         Matcher ma=pattern.matcher(str);
         while (ma.find()){
             Log.i("WordUitls",ma.group());
         }
         return words;
     }
}
