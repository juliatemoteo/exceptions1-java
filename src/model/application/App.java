package model.application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy");

        try{
            System.out.println("Room number: ");
            Integer number = sc.nextInt();
            System.out.println("Check-in date (dd/MM/yyyy): ");
            Date checkin = fmt1.parse(sc.next());
            System.out.println("Check-out date (dd/MM/yyyy): ");
            Date checkout = fmt1.parse(sc.next());
            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println("Enter date to update the reservation: ");
            System.out.println("New check-in date (dd/MM/yyyy): ");
            checkin = fmt1.parse(sc.next());
            System.out.println("New check-out date (dd/MM/yyyy): ");
            checkout = fmt1.parse(sc.next());

            reservation.updateDates(checkin, checkout);
            System.out.println("Reservation: " + reservation); 
        }
        catch(ParseException e){
            System.out.println("Invalid date format. (dd/MM/yyyy)");
        }
        catch(DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Unexpected error.");
        }
        sc.close();
    }
}
