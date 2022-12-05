package com.eikal.repository.patient;

import com.eikal.models.patient.SendTo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SendToRepository extends JpaRepository<SendTo, Long> {
    List<SendTo> findAllBySender_Facility_Id(Long id);

    List<SendTo> findAllByVisit_Id(Long id);

    List<SendTo> findAllByVisit_Patient_Id(Long id);

    List<SendTo> findAllBySender_Id(Long id);

    List<SendTo> findAllByReceiver_Id(Long id);

}
