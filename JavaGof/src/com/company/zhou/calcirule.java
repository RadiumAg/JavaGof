package com.company.zhou;

class MyException extends Exception{//Exception 类用于用户程序可能出现的异常情况
    public MyException() {
        super();
    }
    public MyException(String message) {
        super(message);
    }
}