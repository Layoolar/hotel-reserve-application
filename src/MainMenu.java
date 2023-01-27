import api.HotelResource;
import model.IRoom;
import model.customer.Customer;
import model.reservation.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
     private static final String DATE_FORMAT = "MM/dd/yyyy";
     private static Scanner scanner;
     private static HotelResource hotelResource;

     public MainMenu(HotelResource hotelResource) {
          this.hotelResource = hotelResource.getInstance();
          this.scanner = new Scanner(System.in);
     }

     public static void main(String[] args) {
          hotelResource.getInstance();
          new Scanner(System.in);
          display();
     }
     public static void display() {
          boolean exit = false;

          while (!exit) {
               System.out.println("Main Menu:");
               System.out.println("1. Find and reserve a room");
               System.out.println("2. See my reservations");
               System.out.println("3. Create an account");
               System.out.println("4. Admin");
               System.out.println("5. Exit");

               int option = scanner.nextInt();
               scanner.nextLine();

               switch (option) {
                    case 1:
                         findAndReserveARoom();
                         break;
                    case 2:
                         seeMyReservations();
                         break;
                    case 3:
                         createAnAccount();
                         break;
                    case 4:
                         AdminMenu.showMenu();
                         break;
                    case 5:
                         exit = true;
                         break;
                    default:
                         System.out.println("Invalid option. Please try again.");
                         break;
               }
          }
     }

     private static void findAndReserveARoom() {
          System.out.println("Please enter your email:");
          String email = scanner.nextLine();
          Customer customer = hotelResource.getCustomer(email);
          if (customer == null) {
               System.out.println("No customer found with that email. Please create an account first.");
               return;
          }

          System.out.println("Please enter check-in date (yyyy-MM-dd):");
          String checkInString = scanner.nextLine();
          Date checkIn = parseInputDate(checkInString);

          System.out.println("Please enter check-out date (yyyy-MM-dd):");
          String checkOutString = scanner.nextLine();
          Date checkOut = parseInputDate(checkOutString);

          Collection<IRoom> availableRooms = hotelResource.findARoom(checkIn, checkOut);
          if (availableRooms.isEmpty()) {
               System.out.println("Sorry, no rooms are available for the specified dates.");
               return;
          }

          System.out.println("Available Rooms:");
          for (IRoom room : availableRooms) {
               System.out.println(room.getRoomNumber());
          }

          System.out.println("Please enter the room number:");
          String roomNumber = scanner.nextLine();
          IRoom room = hotelResource.getRoom(roomNumber);
          if (room == null) {
               System.out.println("Invalid room number. Please try again.");
               return;
          }

          Reservation reservation = hotelResource.bookARoom(customer.getEmail(), room, checkIn, checkOut);
          System.out.println("Room successfully booked! Room Details: " + reservation);
     }

     private static void seeMyReservations() {
          System.out.print("Enter your email: ");
          String email = scanner.nextLine();
          Collection<Reservation> reservations = hotelResource.getCustomersReservations(email);
          if (reservations.size() > 0) {
               System.out.println("Your reservations:");
               for (Reservation reservation : reservations) {
                    System.out.println("Room: " + reservation.getRoom().getRoomNumber() + ", Check-in: " + reservation.getCheckInDate() + ", Check-out: " + reservation.getCheckOutDate());
               }
          } else {
               System.out.println("You have no reservations.");
          }
     }

     private static void createAnAccount() {
          System.out.println("Enter email address:");
          String email = scanner.nextLine();
          System.out.println("Enter first name:");
          String firstName = scanner.nextLine();
          System.out.println("Enter last name:");
          String lastName = scanner.nextLine();

          hotelResource.createACustomer(email, firstName, lastName);
          System.out.println("Account created successfully!");
          display();
     }

     private static Date parseInputDate(final String dateString) {
          try {
               return new SimpleDateFormat(DATE_FORMAT).parse(dateString);
          } catch (ParseException e) {
               e.printStackTrace();
               return null;
          }
     }

}




