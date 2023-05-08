package day05;

import java.util.concurrent.atomic.AtomicInteger;

public class AutomicRandom {
    //1.无锁，进行原子操作
    //2.内部采用CAS操作：判断内存中的冒一个值是否与预期一致，相同则进行修改。不同则不修改。避免同步代码块德高开销，提高代码的执行效率
    //适合竞争规模不大，颗粒度小的操作
//    四种原子更新方式，分别是原子更新基本类型，原子更新数组，原子更新引用和原子更新字段

    private static AtomicInteger atomicInteger = new AtomicInteger(10);

    public static void main(String[] args) {
//        System.out.println(getCASValue());

        for (int i = 0; i < 20; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.print(getCASValue(atomicInteger.get()) + "\t");
                }
            }.start();
        }

    }

    public static int getCASValue(int old) {
        int value = old + 5;
        boolean ok = atomicInteger.compareAndSet(old, value);
        if (!ok) {
            old = atomicInteger.get();
            getCASValue(old);
        }
        return atomicInteger.get();
    }

}
