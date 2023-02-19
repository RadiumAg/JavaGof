package com.company.JavaGof.BuilderPattern;

public class Director {
    public Director(Builder builder) {
        this.builder = builder;
    }
    private Builder builder;


    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }

}
