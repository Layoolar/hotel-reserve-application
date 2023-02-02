package model;
import model.enumerations.RoomType;

import java.util.Objects;

public class Room implements IRoom{
    private String roomNumber;
    private double roomPrice;
    private RoomType roomType;
    private boolean isFree;

    public Room(String roomNumber, double roomPrice, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.roomType = roomType;
    }
    //impleme
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

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public double getRoomPrice() {
        return roomPrice;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean isFree() {
        if(roomPrice == 0) { return true; }
        return false;
    }
}
