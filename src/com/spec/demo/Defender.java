package com.spec.demo;

public interface Defender {
    public default void defend() {
        System.out.println("Droid shocked enemy");
    }
}
