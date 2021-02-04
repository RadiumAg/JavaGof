package com.company.JavaGof.VisitorPattern;

public interface ComputerPart {
    public  void  accept(ComputerPartVisitor computerPartVisitor);
}
