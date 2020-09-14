package com.company.VisitorPattern;

public interface ComputerPart {
    public  void  accept(ComputerPartVisitor computerPartVisitor);
}
