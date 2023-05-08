package day04;

import java.lang.Math;
class Change{
    public void fun(int num){
        int[] number = new int[32];
        double var ;
        int i = 0;
        double result = 0;
        for (;i <= 31;i++){
            number[i] = num%10;//;将传入数的每一位分别赋值给数组元素
            num = num/10;
            if(num==0)//为0时说明已将该数的最高位剥离赋值给了数组元素
                break;
        }//此处跳出时i的值就是传入数的位数-1（如123此时i就是2）
        for(int j = 0;j - i <= j;j++){
            var = number[i];
            var = var*Math.pow(10,j);//将数组元素对应放置在他的“权”上，并将元素相加输出
            //（如123的1在百位 在变为321时在个位）
            result = var+result;
            i--;
        }
        System.out.println((int)result);
    }
}
public class Exchange_text {
    public static void main(String[] args) {
        Change change = new Change();
        change.fun(123);
    }
}

