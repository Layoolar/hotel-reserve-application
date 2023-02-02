import api.AdminResource;
import model.IRoom;
import model.Room;
import model.customer.Customer;
import model.enumerations.RoomType;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class AdminMenu {
//    private static Scanner scanner;
    private static AdminResource adminResource = AdminResource.getInstance();


    public static void showMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. See all Customers");
            System.out.println("2. See all Rooms");
            System.out.println("3. See all Reservations");
            System.out.println("4. Add a Room");
            System.out.println("5. Back to Main Menu");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    seeAllCustomers();
                    break;
                case 2:
                    seeAllRooms();
                    break;
                case 3:
                    seeAllReservations();
                    break;
                case 4:
                    addRoom();
                    break;
                case 5:
                    MainMenu.display();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void seeAllCustomers() {
        Collection<Customer> customers = adminResource.getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            adminResource.getAllCustomers().forEach(System.out::println);
        }
    }

    private static void seeAllRooms() {
        Collection<IRoom> rooms = adminResource.getAllRooms();
        if (rooms.isEmpty()) {
            System.out.println("No rooms found.");
        } else {
            adminResource.getAllRooms().forEach(System.out::println);
        }
    }

    private static void seeAllReservations() {
        adminResource.displayAllReservations();
    }

    private static void addRoom() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Enter room number:");
        final String roomNumber = scanner.nextLine();

        System.out.println("Enter price per night in double format (i.e. 25.00):");
        final double roomPrice = enterRoomPrice(scanner);

        System.out.println("Enter room type: 1 for single or 2 for double:");
        final RoomType roomType = enterRoomType(scanner);

        final Room room = new Room(roomNumber, roomPrice, roomType);

        adminResource.addRoom(Collections.singletonList(room));
        System.out.println("Room added successfully!");
        showMenu();
    }

    private static RoomType enterRoomType(final Scanner scanner) {
        try {
            return RoomType.valueOfLabel(scanner.nextLine());
        } catch (IllegalArgumentException exp) {
            System.out.println("Invalid room type! Please, choose 1 for single bed or 2 for double bed:");
            return enterRoomType(scanner);
        }
    }


    private static double enterRoomPrice(final Scanner scanner) {
        try {
            double roomPrice = Double.parseDouble(scanner.nextLine());
            return Double.parseDouble(String.format("%.2f", roomPrice));
        } catch (NumberFormatException exp) {
            System.out.println("Invalid room price! Please, enter a valid number");
            return enterRoomPrice(scanner);
        }
    }

}
