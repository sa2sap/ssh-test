package day08;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        //请实现一个函数。输入是一个数组，数组的元素都是数字，里面的数字有重复出现的。函数返回一个新的数组，是对输入数组去重的结果
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数组长度:");
        int length = scanner.nextInt();
        int[] list = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.print("请输入数字:");
            int num = scanner.nextInt();
            list[i] = num;
        }
        System.out.println("形成的数组:" + Arrays.toString(list));
        //数组去重
        int[] ints = new int[length];
        int index = 0;
        int num = 0;
        for (int i = 0; i < list.length; i++) {//指针指着要遍历的数字
            boolean flag = false;
            for (int i1 = 0; i1 < index; i1++) {//遍历新数组
                if (ints[i1] == list[i]) {
                    flag = true;
                    num++;
                }
            }
            if (!flag) {
                ints[index++] = list[i];
            }
        }
        int[] ints1 = new int[length - num];
        for (int i = 0; i < ints1.length; i++) {
            ints1[i] = ints[i];
        }
        System.out.println("去重后的数组:" + Arrays.toString(ints1));
    }
}
