package model.application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Reservation;

public class App {
    public static void main(String[] args) throws ParseException{
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room number: ");
        Integer number = sc.nextInt();
        System.out.println("Check-in date (dd/MM/yyyy): ");
        Date checkin = fmt1.parse(sc.next());
        System.out.println("Check-out date (dd/MM/yyyy): ");
        Date checkout = fmt1.parse(sc.next());

        if(!checkout.after(checkin)){
            System.out.println("Error! Check-out date must be after check-in date.");
        }else{
            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println("Enter date to update the reservation: ");
            System.out.println("New check-in date (dd/MM/yyyy): ");
            checkin = fmt1.parse(sc.next());
            System.out.println("New check-out date (dd/MM/yyyy): ");
            checkout = fmt1.parse(sc.next());

            String error = reservation.updateDates(checkin, checkout);
            if(error != null){
                System.out.println("Error in reservation: " + error);
            }
            else{
                System.out.println("Reservation: " + reservation);
            }
            
        }


        sc.close();
    }
}
