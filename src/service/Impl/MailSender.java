package service.Impl;

import service.Sender;

public class MailSender implements Sender {
    @Override
    public void Send() {
        System.out.println("邮件");
    }
}
