package com.eikal.service.patient;

import com.eikal.models.patient.SendTo;
import com.eikal.repository.patient.SendToRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SendToService {

    private final SendToRepository sendToRepository;

    @Autowired
    public SendToService(SendToRepository sendToRepository) {
        this.sendToRepository = sendToRepository;
    }

    public SendTo save(Map<String, Object> map) {
        SendTo send = new SendTo();
        return sendToRepository.save(send);
    }

    public SendTo find(Long id) {
        return sendToRepository.findById(id).orElse(null);
    }

    public List<SendTo> findAllByVisit(Long id) {
        return sendToRepository.findAllByVisit_Id(id);
    }

    public List<SendTo> findAllByFacility(Long id) {
        return sendToRepository.findAllBySender_Facility_Id(id);
    }

    public List<SendTo> findAllByPatient(Long id) {
        return sendToRepository.findAllByVisit_Patient_Id(id);
    }

    public List<SendTo> findAllBySender(Long id) {
        return sendToRepository.findAllBySender_Id(id);
    }

    public List<SendTo> findAllByReceiver_Id(Long id) {
        return sendToRepository.findAllByReceiver_Id(id);
    }
}
