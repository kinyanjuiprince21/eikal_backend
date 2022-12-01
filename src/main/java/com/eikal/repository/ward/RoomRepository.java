package com.eikal.repository.ward;

import com.eikal.models.ward.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findAllByWard_Id(Long wardId);
    List<Room> findAllByWard_Facility_Id(Long facilityId);
}
