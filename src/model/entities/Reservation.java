 package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkinDate;
    private Date checkoutDate;

    private static SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy");



    //construtores
    public Reservation() {
    }
    public Reservation(Integer roomNumber, Date checkinDate, Date checkoutDate) {
        this.roomNumber = roomNumber;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }

    //getters e setters
    public Integer getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }
   
    public Date getCheckoutDate() {
        return checkoutDate;
    }

    //métodos
    public long duration(){
        long diff = checkoutDate.getTime() - checkinDate.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        
    }

    public void updateDates(Date checkinDate, Date checkoutDate){
            this.checkinDate = checkinDate;
            this.checkoutDate = checkoutDate;

    }

    @Override
    public String toString(){
        return "Room " 
        + roomNumber 
        + ", check-in: "
        + fmt1.format(checkinDate) 
        + ", check-out: " 
        + fmt1.format(checkoutDate) 
        + ", " 
        + duration() 
        + " nights";
    }
}

