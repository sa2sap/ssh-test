package day04;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //123 ->321   -123->-321
        System.out.println(change(-123));
    }

    public static int change(int num) {
        //判断num
        int abs = num;
        boolean flag = true;
        if (num < 0) {
            abs = Math.abs(num);
            flag = false;
        }
        //加入数组
        char[] chars = String.valueOf(abs).toCharArray();

        //中分交换
        int i = chars.length / 2, j = chars.length / 2;
        char temp;
        while (i > 0) {
            i--;
            j++;
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        //重新组合
//        System.out.println();
        int value = Integer.parseInt(String.valueOf(chars));
//        return 1;
//        Integer value = Integer.valueOf(chars.toString());
        if (!flag) {
            return -value;
        }
        return value;
    }
}
