package com.project.hotel_management_app.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;

import java.math.BigDecimal;
import java.util.List;

//data objects for the front end
@Data
@NoArgsConstructor
public class RoomResponse {
    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private boolean is_Booked;
    //string of bytes representing the photo
    private String photo;
    private List<BookingResponse> bookings;

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice, boolean is_Booked,
                        byte[] photoBytes) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.is_Booked = is_Booked;
        //if the database return a string containing an array of bytes
        // then convert it to a photo for the user else return null
        this.photo = photoBytes != null ? Base64.encodeBase64String(photoBytes) : null;
        //this.bookings = bookings;
    }

}
