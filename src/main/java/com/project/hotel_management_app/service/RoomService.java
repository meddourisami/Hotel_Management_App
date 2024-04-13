package com.project.hotel_management_app.service;

import com.project.hotel_management_app.model.Room;
import com.project.hotel_management_app.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;


@Service
@RequiredArgsConstructor   //dependency injection
public class RoomService implements IRoomService{
    private final RoomRepository roomRepository; //for saving objects to database
    @Override
    public Room addRoom(MultipartFile file, String roomType, BigDecimal roomPrice) throws SQLException, IOException {
        Room room = new Room();
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);
        if (!file.isEmpty()) {
            byte[] photoBytes = file.getBytes();
            Blob photoblob = new SerialBlob(photoBytes);  //the format of the photo that is stored in the database
            room.setPhoto(photoblob);
        }
        return roomRepository.save(room);
    }
}
