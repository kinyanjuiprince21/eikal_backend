package com.eikal.controller.ward;

import com.eikal.models.ward.Bed;
import com.eikal.models.ward.BedStatus;
import com.eikal.models.ward.Room;
import com.eikal.models.ward.Ward;
import com.eikal.service.ward.WardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@RestController
public class WardController {

    private final WardService wardService;

    public WardController(WardService wardService) {
        this.wardService = wardService;
    }

    @PostMapping("ward/save")
    public ResponseEntity<?> saveWard(@RequestBody Map<String, Object> wardMap) {
        Ward ward = wardService.saveWard(wardMap);
        return ward != null ?
                ResponseEntity.status(201).body(ward) :
                ResponseEntity.status(415).build();
    }

    @GetMapping("ward/{id}")
    public ResponseEntity<?> findWard(@PathVariable Long id) {
        Ward ward = wardService.findWard(id);
        return ward != null ?
                ResponseEntity.status(200).body(ward) :
                ResponseEntity.status(404).body("Ward not found");
    }

    @GetMapping("wards/facility")
    public ResponseEntity<?> findWardsInFacility(@RequestParam("id") Long facilityId) {
        List<Ward> wards = wardService.findAllWardsInFacility(facilityId);
        return !wards.isEmpty() ?
                ResponseEntity.status(200).body(wards) :
                ResponseEntity.status(404).body("No ward found in this facility");
    }

    @PostMapping("room/save")
    public ResponseEntity<?> saveRoom(@RequestBody Map<String, Object> roomMap) {
        Room room = wardService.saveRoom(roomMap);
        return room != null ?
                ResponseEntity.status(201).body(room) :
                ResponseEntity.status(415).build();
    }

    @GetMapping("room/{id}")
    public ResponseEntity<?> findRoomById(@PathVariable Long id) {
        Room room = wardService.findRoomById(id);
        return room != null ?
                ResponseEntity.status(200).body(room) :
                ResponseEntity.status(404).body("Room not found");
    }

    @GetMapping("rooms/ward")
    public ResponseEntity<?> findAllRoomsInWard(@RequestParam("id") Long wardId) {
        List<Room> rooms = wardService.findAllRoomsInWard(wardId);
        return !rooms.isEmpty() ?
                ResponseEntity.status(200).body(rooms) :
                ResponseEntity.status(404).body("No room found in this ward");
    }

    @GetMapping("rooms/facility")
    public ResponseEntity<?> findAllRoomsInFacility(@RequestParam("id") Long facilityId) {
        List<Room> rooms = wardService.findAllRoomsInFacility(facilityId);
        return !rooms.isEmpty() ?
                ResponseEntity.status(200).body(rooms) :
                ResponseEntity.status(404).body("No room found in this facility");
    }

    @PostMapping("bed/save")
    public ResponseEntity<?> saveBed(@RequestBody Map<String, Object> bedMap) {
        Bed bed = wardService.saveBed(bedMap);
        return bed != null ?
                ResponseEntity.status(200).body(bed) :
                ResponseEntity.status(415).build();
    }

    @GetMapping("bed/{id}")
    public ResponseEntity<?> findBedById(@PathVariable Long id) {
        Bed bed = wardService.findBedById(id);
        return bed != null ?
                ResponseEntity.status(200).body(bed) :
                ResponseEntity.status(404).body("Bed not found");
    }

    @GetMapping("beds/room")
    public ResponseEntity<?> findAllBedsInRoom(@RequestParam("id") Long roomId) {
        List<Bed> beds = wardService.findAllBedsInRoom(roomId);
        return !beds.isEmpty() ?
                ResponseEntity.status(200).body(beds) :
                ResponseEntity.status(404).body("No bed found in this room");
    }

    @GetMapping("beds/ward")
    public ResponseEntity<?> findAllBedsInWard(@RequestParam("id") Long wardId) {
        List<Bed> beds = wardService.findAllBedsInWard(wardId);
        return !beds.isEmpty() ?
                ResponseEntity.status(200).body(beds) :
                ResponseEntity.status(404).body("No bed found in this ward");
    }

    @GetMapping("beds/facility")
    public ResponseEntity<?> findAllBedsInFacility(@RequestParam("id") Long facilityId) {
        List<Bed> beds = wardService.findAllBedsInFacility(facilityId);
        return !beds.isEmpty() ?
                ResponseEntity.status(200).body(beds) :
                ResponseEntity.status(404).body("No bed found in this facility");
    }

    @GetMapping("beds")
    public ResponseEntity<?> findAllBedsByStatus(@RequestParam("status") String status) {
        List<Bed> beds = wardService.findAllBedsByStatus(status.toUpperCase());
        return !beds.isEmpty() ?
                ResponseEntity.status(200).body(beds) :
                ResponseEntity.status(404).body(
                        switch (BedStatus.valueOf(status)) {
                            case OPEN -> "No open bed available";
                            case OCCUPIED -> "No bed is occupied";
                            case UNAVAILABLE -> "No bed is unavailable";
                            case IN_SERVICE -> "No bed is in service";
                        }
                );
    }
}
