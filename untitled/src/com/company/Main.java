package com.company;

import self.my.AOCTv;
import self.my.ChangHongTv;
import self.my.RemoteControll;

import java.rmi.Remote;

public class Main {

    public static void main(String[] args) {
        var redCircle = new Circle(100, 100, 10, new RedCircle());
        var greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();

        var chRemote = new self.my.Remote(new ChangHongTv());
        var aocRemote = new self.my.Remote(new AOCTv());
        chRemote.open();
        aocRemote.open();
    }
}
