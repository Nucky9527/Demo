package com.nucky.demo.enumpro;


public enum Color implements IColor {

    RED("红色", 1), GREEN("绿色", 2), BLUE("蓝色", 3);

    private Color(String name, int value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private int value;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getValue() {
        return this.value;
    }
}

