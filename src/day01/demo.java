package day01;


import org.junit.Test;
import pogo.Animal;
import pogo.Dog;

import java.util.HashMap;
import java.util.Map;

public class demo {
    @Test
    public void test01() {
        String abc = new String("abc");
        String c = abc;
//        c="789";
        System.out.println(abc == c);
    }

    @Test
    public void test02() {
        final Dog dog = new Dog();
        final Map<String, String> map = new HashMap<>();
        map.put("2", "5");
    }

    @Test
    public void test03() {
        System.out.println("版本切换测试");
    }

    @Test
    public void test04() {
        System.out.println("分支切换测试");
    }

    @Test
    public void test05() {
        System.out.println("pul代码测试");
    }

    @Test
    public void test06() {
        System.out.println("提交代码测试");
    }
     @Test
    public void test07() {
        System.out.println("码云测试");
    }
}
