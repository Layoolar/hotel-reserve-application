package api;

import model.IRoom;
import model.customer.Customer;
import model.reservation.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

    private static final HotelResource INSTANCE = new HotelResource();
    private final CustomerService customerService = CustomerService.getInstance();
    private final ReservationService reservationService = ReservationService.getInstance();

    private HotelResource() {}

    public static HotelResource getInstance() {
        return INSTANCE;
    }

    public Customer getCustomer(final String email) {
        return customerService.getCustomer(email);
    }

    public void createACustomer(final String email, final String firstName, final String lastName) {
        customerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(final String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(final String customerEmail, final IRoom room, final Date checkInDate, final Date checkOutDate) {
        final Customer customer = customerService.getCustomer(customerEmail);
        return reservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomersReservations(final String customerEmail) {
        final Customer customer = customerService.getCustomer(customerEmail);
        return reservationService.getCustomersReservation(customer);
    }

    public Collection<IRoom> findARoom(final Date checkIn, final Date checkOut) {
        return reservationService.findRooms(checkIn, checkOut);
    }

//    public Collection<IRoom> findAlternativeRooms(final Date checkIn, final Date checkOut) {
//        return reservationService.findAlternativeRooms(checkIn, checkOut);
//    }
}

