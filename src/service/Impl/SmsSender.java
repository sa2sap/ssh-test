package service.Impl;

import service.Sender;

public class SmsSender implements Sender {
    @Override
    public void Send() {
        System.out.println("短信");
    }
}
