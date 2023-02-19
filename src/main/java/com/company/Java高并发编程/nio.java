package com.company.Java高并发编程;

import java.nio.IntBuffer;

public class nio {
    static IntBuffer intBuffer = null;

    public static void allocateTest() {
        intBuffer = IntBuffer.allocate(20);
        System.out.println(intBuffer.position());
        System.out.println(intBuffer.limit());
        System.out.println(intBuffer.capacity());

        // 一个整型的Buffer静态变量

        for (int i = 0; i < 5; i++) {
            intBuffer.put(i);
        }
        System.out.println(intBuffer.position());
        System.out.println(intBuffer.limit());
        System.out.println(intBuffer.capacity());

        intBuffer.flip();
        System.out.println(intBuffer.position());
        System.out.println(intBuffer.limit());
        System.out.println(intBuffer.capacity());


        for (int i = 0; i < 5; i++) {
            var r = intBuffer.get();
            System.out.println(r);
        }
        System.out.println(intBuffer.position());
        System.out.println(intBuffer.limit());
        System.out.println(intBuffer.capacity());

        // fileChannel
    }
}
