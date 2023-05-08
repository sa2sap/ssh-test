package day05;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    public static void main(String[] args) {
// 信号量
//        设置一定的车位(许可量)
        //占位置（获得许可证）,信号量减1,当信号量为0时，线程阻塞，直到释放出来许可证
        //让位置（释放许可证）
        //创建Semaphore, 设置许可量, 模拟三个车位
        Semaphore semaphore = new Semaphore(3);

        //模拟六辆汽车
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try {
                    //获取许可
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "号车抢到车位");
                    //设置随机停车时间
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName() + "号车离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放许可
                    semaphore.release();
                }
            }, "" + i).start();
        }
    }
}

