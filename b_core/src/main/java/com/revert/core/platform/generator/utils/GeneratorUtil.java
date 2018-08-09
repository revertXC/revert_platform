package com.revert.core.platform.generator.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * 代码自动生成工具包
 */
public class GeneratorUtil {

    /**
     * 把 code{splitStr} 之后的字母第一个大写
     * 例如：content:a_ba_ca, splitStr:_ 。结果为：aBaCa
     * @param content   内容
     * @param splitStr  符号之后需要大写的字母
     * @return
     */
    public static String captalAfter(String content, String splitStr){
        if(StringUtils.isEmpty(content)){
            return null;
        }
        splitStr = splitStr == null ? "" : splitStr;
        String splitArray[] = content.split(splitStr);
        StringBuffer sb = new StringBuffer(splitArray[0]);
        for(int i=1 ; i<splitArray.length ; i++){
            sb.append(StringUtils.capitalize(splitArray[i]));
        }
        return sb.toString();
    }


    public static File bulidFile(String filePath){
        return null;
    }

}
