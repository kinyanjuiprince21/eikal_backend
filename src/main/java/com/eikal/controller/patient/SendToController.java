package com.eikal.controller.patient;

import com.eikal.models.patient.SendTo;
import com.eikal.service.patient.SendToService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public class SendToController {

    private final SendToService sendService;

    public SendToController(SendToService sendService) {
        this.sendService = sendService;
    }

    @PostMapping("send/save")
    public ResponseEntity<?> save(@RequestBody Map<String, Object> map) {
        SendTo send = sendService.save(map);
        return send != null ?
                ResponseEntity.status(201).body(send) :
                ResponseEntity.status(415).build();
    }

    @GetMapping("send/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        SendTo send = sendService.find(id);
        return send != null ?
                ResponseEntity.status(200).body(send) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("send/visit")
    public ResponseEntity<?> findAllByVisit(@RequestParam Long id) {
        List<SendTo> send = sendService.findAllByVisit(id);
        return !send.isEmpty() ?
                ResponseEntity.status(200).body(send) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("send/facility")
    public ResponseEntity<?> findAllByFacility(@RequestParam Long id) {
        List<SendTo> send = sendService.findAllByFacility(id);
        return !send.isEmpty() ?
                ResponseEntity.status(200).body(send) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("send/patient")
    public ResponseEntity<?> findAllByPatient(@RequestParam Long id) {
        List<SendTo> send = sendService.findAllByPatient(id);
        return !send.isEmpty() ?
                ResponseEntity.status(200).body(send) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("send/sender")
    public ResponseEntity<?> findAllBySender(@RequestParam Long id) {
        List<SendTo> send = sendService.findAllBySender(id);
        return !send.isEmpty() ?
                ResponseEntity.status(200).body(send) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("send/receiver")
    public ResponseEntity<?> findAllByReceiver_Id(@RequestParam Long id) {
        List<SendTo> send = sendService.findAllByReceiver_Id(id);
        return !send.isEmpty() ?
                ResponseEntity.status(200).body(send) :
                ResponseEntity.notFound().build();
    }
}
