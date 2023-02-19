package com.company.JavaGof.BuilderPattern;

public class ConcreteBuilder extends  Builder{

    @Override
    public void buildPartA() {
        product.setPartA("建造PartA");
    }

    @Override
    public void buildPartB() {
        product.setPartA("建造PartB");
    }

    @Override
    public void buildPartC() {
        product.setPartA("建造PartC");
    }
}
