package day05;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
//闭锁
    //设置一定的线程数量,线程调用countdown计数器进行减1,当数量减到0,执行后面操作
    //协调线程
    //一个线程在等待另外一些线程完成各自工作之后, 再继续执行
    //锁大门
    public static void main(String[] args) throws Exception {
//        CountDownLatch countDownLatch = new CountDownLatch(6);
//        for (int i = 1; i <= 6; i++) {
//            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName() + "国, 被灭");
//                countDownLatch.countDown();
//            }, CountryEnum.getCountryEnum(i).getRetMessage()).start();
//
//        }
//        countDownLatch.await();
//        System.out.println(Thread.currentThread().getName() + "\t" + "秦国一统天下");
        CountDownLatch countDownLatch = new CountDownLatch(6);
        System.out.println("放假了,开始锁大门了...");
        for (int i = 0; i < 6; i++) {
            System.out.println("第"+(i+1)+"班级大门已锁");
            countDownLatch.countDown();
        }
        countDownLatch.await();
        System.out.println("放假了");
    }
}


//使用枚举类创建六个国家
enum CountryEnum {
    one(1, "齐"), two(2, "楚"), three(3, "燕"),
    four(4, "赵"), five(5, "魏"), six(6, "韩");
    private Integer retCode;
    private String retMessage;
    private CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }
    public static CountryEnum getCountryEnum(Integer index) {
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum countryEnum : countryEnums) {
            if (countryEnum.getRetCode().equals(index)) {
                return countryEnum;
            }
        }
        return null;
    }
    public Integer getRetCode() {
        return retCode;
    }
    public String getRetMessage() {
        return retMessage;
    }
}
