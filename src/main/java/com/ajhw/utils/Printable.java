package com.ajhw.utils;

public interface Printable {
    default void print() {
        System.out.println(this.toString());
    }
}
