package com.eikal.service.ward;

import com.eikal.models.facility.Employee;
import com.eikal.models.facility.Facility;
import com.eikal.models.ward.Bed;
import com.eikal.models.ward.BedStatus;
import com.eikal.models.ward.Room;
import com.eikal.models.ward.Ward;
import com.eikal.repository.ward.BedRepository;
import com.eikal.repository.ward.RoomRepository;
import com.eikal.repository.ward.WardRepository;
import com.eikal.service.facility.EmployeeService;
import com.eikal.service.facility.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class WardService {

    private final WardRepository wardRepository;
    private final RoomRepository roomRepository;
    private final BedRepository bedRepository;
    private final EmployeeService employeeService;
    private final FacilityService facilityService;

    @Autowired
    public WardService(FacilityService facilityService, WardRepository wardRepository, RoomRepository roomRepository, BedRepository bedRepository, EmployeeService employeeService) {
        this.wardRepository = wardRepository;
        this.roomRepository = roomRepository;
        this.bedRepository = bedRepository;
        this.employeeService = employeeService;
        this.facilityService = facilityService;
    }

    public Ward saveWard(Map<String, Object> wardMap) {
        Employee employee = employeeService.findById(Long.valueOf((Integer) wardMap.get("createdBy")));
        Facility facility = new Facility(Long.valueOf((Integer) wardMap.get("facility")));

        Ward ward = new Ward();
        ward.setName((String) wardMap.get("name"));
        ward.setDetails((String) wardMap.get("details"));
        ward.setCapacity((Integer) wardMap.get("capacity"));
        ward.setCreatedBy(employee);
        ward.setModifiedBy(employee);
        ward.setFacility(facility);
        ward.setDateCreated(LocalDateTime.now());
        ward.setDateModified(LocalDateTime.now());
        return wardRepository.save(ward);
    }

    public Ward findWard(Long id) {
        return wardRepository.findById(id).orElse(null);
    }

    public List<Ward> findAllWardsInFacility(Long id) {
        return wardRepository.findAllByFacility_Id(id);
    }

    public Room saveRoom(Map<String, Object> roomMap) {
        Room room = new Room();
        Employee employee = employeeService.findById(Long.valueOf((Integer) roomMap.get("createdBy")));
        Ward ward = this.findWard(Long.valueOf((Integer) roomMap.get("ward")));

        room.setName((String) roomMap.get("name"));
        room.setDetails((String) roomMap.get("details"));
        room.setCapacity((Integer) roomMap.get("capacity"));
        room.setNumber((String) roomMap.get("number"));
        room.setCreatedBy(employee);
        room.setModifiedBy(employee);
        room.setWard(ward);
        room.setDateCreated(LocalDateTime.now());
        room.setDateModified(LocalDateTime.now());
        return roomRepository.save(room);
    }

    public Room findRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public List<Room> findAllRoomsInWard(Long wardId) {
        return roomRepository.findAllByWard_Id(wardId);
    }

    public List<Room> findAllRoomsInFacility(Long facilityId) {
        return roomRepository.findAllByWard_Facility_Id(facilityId);
    }

    public Bed saveBed(Map<String, Object> bedMap) {
        Bed bed = new Bed();
        Employee employee = employeeService.findById(Long.valueOf((Integer) bedMap.get("createdBy")));
        Room room = this.findRoomById(Long.valueOf((Integer) bedMap.get("room")));

        bed.setDetails((String) bedMap.get("details"));
        bed.setNumber((String) bedMap.get("number"));
        bed.setStatus(BedStatus.valueOf((String) bedMap.get("status")));
        bed.setCreatedBy(employee);
        bed.setModifiedBy(employee);
        bed.setRoom(room);
        bed.setDateCreated(LocalDateTime.now());
        bed.setDateModified(LocalDateTime.now());
        return bedRepository.save(bed);
    }

    public Bed findBedById(Long id) {
        return bedRepository.findById(id).orElse(null);
    }

    public List<Bed> findAllBedsInRoom(Long roomId) {
        return bedRepository.findAllByRoom_Id(roomId);
    }

    public List<Bed> findAllBedsInWard(Long wardId) {
        return bedRepository.findAllByRoom_Ward_Id(wardId);
    }

    public List<Bed> findAllBedsInFacility(Long facilityId) {
        return bedRepository.findAllByRoom_Ward_Facility_Id(facilityId);
    }

    public List<Bed> findAllBedsByStatus(String status) {
        return bedRepository.findAllByStatus(BedStatus.valueOf(status));
    }

}
