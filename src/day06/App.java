package day06;


import java.lang.String;

import org.junit.Test;

import java.util.Arrays;

public class App {
    @Test
    public void test01() {
        //将无序数字字符串转变成有序字符串
        String Snum = "5689134";
//        int parseInt = Integer.parseInt(Snum);
        char[] chars = Snum.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < chars.length - i - 1; j++) {
                Integer n1 = Integer.valueOf(chars[j]);
                Integer n2 = Integer.valueOf(chars[j + 1]);
                char temp;
                if (n1 > n2) {
                    temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
        System.out.println(chars);
    }

    @Test
    public void test02() {
        //将数组逆向输出
        int[] chars = new int[]{1, 2, 3};
//        StringBuffer stringBuffer = new StringBuffer();
//        System.out.println(stringBuffer.reverse());
//        String toString = Arrays.toString(chars);
//        System.out.println(toString);

//        Integer integer = Integer.valueOf(chars.toString());
        StringBuffer stringBuffer = new StringBuffer();
//        System.out.println(stringBuffer.reverse());
        for (int i = 0; i < chars.length; i++) {
            stringBuffer.append(chars[i]);
        }
        System.out.println(stringBuffer.reverse());
    }
}
