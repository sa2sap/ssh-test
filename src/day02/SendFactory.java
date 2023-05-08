package day02;

import org.junit.Test;
import service.Impl.ChatSender;
import service.Impl.MailSender;
import service.Impl.SmsSender;
import service.Provider;
import service.Sender;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

//普通工厂模式
public class SendFactory {
    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }
}

//多个工厂方法模式
class SendFactory1 {
    public Sender produceMail() {
        return new MailSender();
    }

    public Sender produceSms() {
        return new SmsSender();
    }
}

//静态工厂方法模式
class SendFactory2 {
    public static Sender produceMail() {
        return new MailSender();
    }

    public static Sender produceSms() {
        return new SmsSender();
    }
}

//抽象工厂模式
//生产SmsSender对象的工厂
class SendSmsFactory3 implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}

//生产MailSender对象的工厂
class SendMailFactory4 implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}

//衍生思想
class ChatFactory5 implements Provider {
    @Override
    public Sender produce() {
        return new ChatSender();
    }
}

//营造着模式
class Builder {
    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count) { // 生产count个MailSender
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count) { // 生产count个SmsSender
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }
}

//单例模式
class single {
    private single single1 = null;

    private single() {
    }

    //懒汉式
    public single getSingle() {
        if (single1 == null) {
            synchronized (single.class) {
                if (single1 == null) {
                    single1 = new single();
                }
            }
        }
        return single1;
    }

}


//单例模式
class single1 {
    private single1 single2 = new single1();

    private single1() {
    }

    //饿汉式
    public single1 getSingle() {
        return single2;
    }

}


//适配器模式
class Source1 {
    public void method1() {
        System.out.println("源对象方法");
    }
}

interface Targetable {
    /* 与原类中的方法相同 */
    public void method1();

    /* 新类的方法 */
    public void method2();
}

// 适配类
class Adapter extends Source1 implements Targetable {
    @Override
    public void method2() {
        this.method1();
        System.out.println("这是method2方法");
    }
}

//对象适配器
class Wrapper implements Targetable {
    private Source1 source;

    public Wrapper(Source1 source) {
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("这是method2方法");
    }
}
//接口适配器


//装饰器模式
interface Sourceable {
    public void method();
}


// 被装饰的类，实现Sourceable接口
class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("源数据方法");
    }
}

// 装饰的类，也要实现Sourceable 接口
class Decorator implements Sourceable {
    private Sourceable source; // 持有被装饰类的对象

    public Decorator(Sourceable source) {
        super();
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("装饰前"); // 装饰
        source.method();
        System.out.println("装饰后"); // 装饰
    }
}

//策略模式
interface Strategy {
    public void strategyInterface();
}

// 具体策略类A
class ConcreteStrategyA implements Strategy {
    @Override
    public void strategyInterface() {
        // 相关的业务
    }
}

// 具体策略类B
class ConcreteStrategyB implements Strategy {
    @Override
    public void strategyInterface() {
        //相关的业务
    }
}

// 使用策略的类
class Context {
    private Strategy strategy;

    public Context(Strategy strategy) { // 构造函数，传入一个具体策略对象
        this.strategy = strategy;
    }

    public void contextInterface() { // 策略方法
        strategy.strategyInterface();
    }
}

//模板方法模式
abstract class GetTime {
    public long getTime() {

        long start = System.currentTimeMillis();
        //表示要计算运行时间的代码
        code();
        long end = System.currentTimeMillis();
        return end - start;
    }

    public abstract void code();
}

class forDemo extends GetTime {
    //重写抽象方法
    public void code() {
        for (int x = 0; x < 1000; x++) {
            System.out.println(x);
        }
    }
}


//观察者模式


//（抽象被观察者）接口, 让（具体观察者）WeatherData 来实现
interface Subject {

    public void registerObserver(Observer1 o);

    public void removeObserver(Observer1 o);

    public void notifyObservers();
}


//具体观察者
/**
 * 类是核心
 * 1. 包含最新的天气情况信息
 * 2. 含有 观察者集合，使用ArrayList管理
 * 3. 当数据有更新时，就主动的调用   ArrayList, 通知所有的（接入方）就看到最新的信息
 *
 * @author Administrator
 */
class WeatherData implements Subject {
    private float temperatrue;
    private float pressure;
    private float humidity;
    //观察者集合
    private ArrayList<Observer1> observers;

    //加入新的第三方

    public WeatherData() {
        observers = new ArrayList<Observer1>();
    }

    public float getTemperature() {
        return temperatrue;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void dataChange() {
        //调用 接入方的 update

        notifyObservers();
    }

    //当数据有更新时，就调用 setData
    public void setData(float temperature, float pressure, float humidity) {
        this.temperatrue = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //调用dataChange， 将最新的信息 推送给 接入方 currentConditions
        dataChange();
    }

    //注册一个观察者
    @Override
    public void registerObserver(Observer1 o) {
        // TODO Auto-generated method stub
        observers.add(o);
    }

    //移除一个观察者
    @Override
    public void removeObserver(Observer1 o) {
        // TODO Auto-generated method stub
        if (observers.contains(o)) {
            observers.remove(o);
        }
    }

    //遍历所有的观察者，并通知
    @Override
    public void notifyObservers() {
        // TODO Auto-generated method stub
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this.temperatrue, this.pressure, this.humidity);
        }
    }
}

//抽象观察者
//抽象观察者接口，由具体观察者来实现（）
interface Observer1 {

    public void update(float temperature, float pressure, float humidity);
}



//具体观察者
class BaiduSite implements Observer1 {

    // 温度，气压，湿度
    private float temperature;
    private float pressure;
    private float humidity;

    // 更新 天气情况，是由 WeatherData 来调用，我使用推送模式
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    // 显示
    public void display() {
        System.out.println("===百度网站====");
        System.out.println("***百度网站 气温 : " + temperature + "***");
        System.out.println("***百度网站 气压: " + pressure + "***");
        System.out.println("***百度网站 湿度: " + humidity + "***");
    }

}

//具体观察者
class CurrentConditions implements Observer1 {

    // 温度，气压，湿度
    private float temperature;
    private float pressure;
    private float humidity;

    // 更新 天气情况，是由 WeatherData 来调用，我使用推送模式
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    // 显示
    public void display() {
        System.out.println("***Today mTemperature: " + temperature + "***");
        System.out.println("***Today mPressure: " + pressure + "***");
        System.out.println("***Today mHumidity: " + humidity + "***");
    }
}





class test{
    @Test
    public void test01(){
            // TODO Auto-generated method stub
            //创建一个WeatherData
            WeatherData weatherData = new WeatherData();

            //创建观察者
            CurrentConditions currentConditions = new CurrentConditions();
            BaiduSite baiduSite = new BaiduSite();

            //注册到weatherData
            weatherData.registerObserver(currentConditions);
            weatherData.registerObserver(baiduSite);

            //测试
            System.out.println("通知各个注册的观察者, 看看信息");
            weatherData.setData(10f, 100f, 30.3f);


            weatherData.removeObserver(currentConditions);
            //测试
            System.out.println();
            System.out.println("通知各个注册的观察者, 看看信息");
            weatherData.setData(10f, 100f, 30.3f);

    }
}

























