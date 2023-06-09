package day05;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock1 {
    Lock lock = new ReentrantLock();
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public static void main(String[] args) {
        final TestReentrantLock1 test = new TestReentrantLock1();

        new Thread() {
            public void run() {
                test.insert(Thread.currentThread());
            }
        }.start();

        new Thread() {
            public void run() {
                test.insert(Thread.currentThread());
            }

            ;
        }.start();
    }

    public void insert(Thread thread) {
//        Lock lock = new ReentrantLock();    //注意这个地方

        if (lock.tryLock()) {
            try {
                System.out.println(thread.getName() + "得到了锁");
//            for(int i=0;i<1000;i++) {
////                arrayList.add(i);
////            }
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                System.out.println(thread.getName() + "释放了锁");
                lock.unlock();
            }
        }else {
            System.out.println(thread.getName() + "获取锁失败");
        }
    }
}

