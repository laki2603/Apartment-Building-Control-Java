package com.building.controls;

public class CommonRoom extends Room {
    private String type;

    public CommonRoom(String type) {
        super();
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Common Room (" + type + ") | " + super.toString();
    }
}

