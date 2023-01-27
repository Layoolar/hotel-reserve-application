package model;
import model.IRoom;
import model.enumerations.RoomType;

import java.util.Objects;

public class Room implements IRoom{
    private String roomNumber;
    private double roomPrice;
    private RoomType roomType;
    private boolean isFree;

    public Room(String roomNumber, double roomPrice, RoomType roomType, boolean isFree) {
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.roomType = roomType;
        this.isFree = isFree;
    }
    //implementation of the methods
    public String getRoomNumber() {
        return roomNumber;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public boolean isFree() {
        return isFree;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Room Price: " + roomPrice + ", Room Type: " + roomType + ", isFree: " + isFree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, roomPrice, roomType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Room other = (Room) obj;
        return Objects.equals(roomNumber, other.roomNumber) &&
                roomPrice == other.roomPrice &&
                roomType == other.roomType;
    }
}
