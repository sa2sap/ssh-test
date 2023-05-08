package day03;

import org.junit.Test;

import java.util.Arrays;

public class App {
    @Test
    public void test() {
//
        int[] arr = {1, 2, 3, 4};
//        sortArray(arr);
////        System.out.println(Arrays.toString(arr));
        int fastFind = fastFind(arr, 2);
        System.out.println(fastFind);

    }

    //冒牌排序
    public void sortArray(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {//排几次
            for (int j = i; j < arr.length - 1 - i; j++) {//每次排几下
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //快速查找 1  5  6  8  10
    public int fastFind(int[] arr, int m) {
        //排序
        Arrays.sort(arr);

        int left = 0, right = arr.length - 1, main=0;
        while (m!=arr[main]){
            main=(right+left)/2;
            if(m>arr[main]){//右边
                left=main+1;
            }else if (m<arr[main]){
                right=main-1;
            }
        }
        return main;
    }
}
