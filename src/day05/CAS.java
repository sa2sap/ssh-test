package day05;

import java.util.concurrent.atomic.AtomicInteger;

public class CAS {
    //CAS：判断内存毛哥位置的值与预期是否一致，如果一直，进行更新，其过程为原子性
//具体实现：1.保存原来的值，记录下来
//    2.将更新操作记录下来
//    3.比较现在的值与原来的值是否相等，相同，将更新的值赋值给原来的值，若不相同，更新失败
    private static AtomicInteger atomicInteger = new AtomicInteger(10);

    public static void main(String[] args) {
        int old = atomicInteger.get();
        int newValue = old + 5;
        boolean ok = atomicInteger.compareAndSet(11, newValue);
        String res = ok ? "更新成功" : "更新失败";
        System.out.println(res);
    }
}
