package com.project.hotel_management_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
//generated getters setters and constructors
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {
    //generated id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    @Column(name = "Check_In")
    private LocalDate CheckInDate;
    @Column(name = "Check_Out")
    private LocalDate CheckOutDate;
    @Column(name = "guest_FullName")
    private String GuestName;
    @Column(name = "guest_Email")
    private String GuestEmail;
    @Column(name = "total_guests")
    private int Number_Of_Guests;
    @Column(name = "adults")
    private int Number_Of_Adults;
    @Column(name = "children")
    private int Number_Of_Children;
    @Column(name = "confirmation_Code")
    private String BookingConfirmationCode;
    //fetching entities only when needed for database queries optimization
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public void CalculateNumber_Of_Guests(){
        this.Number_Of_Guests = this.Number_Of_Adults + this.Number_Of_Children;
    }

    public void setNumber_Of_Adults(int number_Of_Adults) {
        Number_Of_Adults = number_Of_Adults;
        CalculateNumber_Of_Guests();
    }

    public void setNumber_Of_Children(int number_Of_Children) {
        Number_Of_Children = number_Of_Children;
        CalculateNumber_Of_Guests();
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.BookingConfirmationCode = bookingConfirmationCode;
    }
}
