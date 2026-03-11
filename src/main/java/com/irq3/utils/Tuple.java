package com.irq3.utils;

public record Tuple<A,B> (A a, B b){

    public boolean isA(){
        return a!=null;
    }
    public boolean isB(){
        return b!=null;
    }

    @Override public A a() {
        return a;
    }

    @Override public B b() {
        return b;
    }
}
