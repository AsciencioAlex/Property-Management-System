package com.asciencio.model;

public enum OccupancyStatus {
    VACANT(0), OCCUPIED(1), BOOKED(2);
    private int status;
    OccupancyStatus(int type){}
    public int getStatus(){
        return status;
    }
}
