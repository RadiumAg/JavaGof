package com.company;
import com.company.JavaGof.Bridge.Circle;
import com.company.JavaGof.Bridge.GreenCircle;
import com.company.JavaGof.Bridge.RedCircle;
import self.my.AOCTv;
import self.my.ChangHongTv;

import java.util.Arrays;

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
        int[] a = new int[3];
        Arrays.stream(a).map(x->2);
    }
}



