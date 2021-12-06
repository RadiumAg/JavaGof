package com.company.JavaGof.Mediator;

public class ConcreteColleaguel extends Colleague {
    @Override
    public void receive() {
        System.out.println("具体同事类1收到请求。");
    }

    @Override
    public void send() {
        System.out.println("具体同时类1发出请求");
        mediator.relay(this);
    }
}