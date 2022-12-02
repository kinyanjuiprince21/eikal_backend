package com.eikal.repository.patient;

import com.eikal.models.patient.SendTo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendToRepository extends JpaRepository<SendTo, Long> {
}
