package com.project.hotel_management_app.repository;

import com.project.hotel_management_app.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT DISTINCT r.roomType FROM Room r  ")
    List<String> findRoomTypes();
}
