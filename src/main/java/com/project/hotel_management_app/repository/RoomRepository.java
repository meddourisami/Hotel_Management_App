package com.project.hotel_management_app.repository;

import com.project.hotel_management_app.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
