package com.asciencio.model;

public enum PropertyType {
    INDEPENDENT(1), APARTMENT(2), BUILDER(3);
    private int type;
    PropertyType(int type){
    }
    public int getType(){
        return type;
    }
}
