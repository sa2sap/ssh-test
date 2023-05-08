package service.Impl;

import service.Sender;

public class ChatSender implements Sender {
    @Override
    public void Send() {
        System.out.println("微信");
    }
}
