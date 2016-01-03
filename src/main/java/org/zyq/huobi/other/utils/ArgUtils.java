package org.zyq.huobi.other.utils;

/**
 * Created by Yuquan Zou on 2015/12/27.
 */
public class ArgUtils {
    /**
     * 检验是否为数字
     *
     * @param object
     * @return
     */
    public static boolean isNum(Object object) {
        boolean flag = false;
        if (object != null) {
            try {
                Integer.parseInt(object.toString());
                flag = true;
            } catch (NumberFormatException e) {
            }
        }
        return flag;
    }

    /**
     * 数字是否在指定的范围
     *
     * @param num
     * @param begain
     * @param end
     * @return
     */
    public static boolean numBetween(Object num, int begain, int end) {
        boolean flag = false;
        if (isNum(num)) {
            Integer integer = Integer.valueOf(num.toString());
            if (integer > begain && integer < end) {
                flag = true;
            }
        }
        return flag;
    }

}
