package model;

import model.enumerations.RoomType;

public class FreeRoom extends Room {
    public FreeRoom(String roomNumber, RoomType roomType, boolean isFree) {
        super(roomNumber, 0, roomType);
    }
    @Override
    public String toString() {
        return "Free Room Number: " + getRoomNumber() + ", Room Type: " + getRoomType() + ", isFree: " + isFree();
    }
}

