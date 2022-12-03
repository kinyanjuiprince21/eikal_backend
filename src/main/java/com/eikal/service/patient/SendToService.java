package com.eikal.service.patient;

import com.eikal.repository.patient.SendToRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendToService {

    private final SendToRepository sendToRepository;

    @Autowired
    public SendToService(SendToRepository sendToRepository) {
        this.sendToRepository = sendToRepository;
    }
}
