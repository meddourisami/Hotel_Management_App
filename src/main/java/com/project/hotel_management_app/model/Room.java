package com.project.hotel_management_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private boolean is_Booked = false;
    @Lob
    private Blob photo;
    //cascade for deleting a room from the booked list if a room is deleted
    @OneToMany(mappedBy= "room",fetch =  FetchType.LAZY , cascade= CascadeType.ALL)
    private List<BookedRoom> bookings;

    //constructor
    public Room() {
        this.bookings = new ArrayList<>();
    }

    //adds a room to the booked list
    public void addBooking(BookedRoom booking) {
        if (bookings == null) {
            bookings = new ArrayList<>();
        }
        bookings.add(booking);
        booking.setRoom(this);
        is_Booked = true;
        String bookingCode = RandomStringUtils.randomNumeric(10);
        booking.setBookingConfirmationCode(bookingCode);
    }
}
