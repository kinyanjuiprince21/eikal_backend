package com.eikal.repository.ward;

import com.eikal.models.ward.Bed;
import com.eikal.models.ward.BedStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BedRepository extends JpaRepository<Bed, Long> {
    List<Bed> findAllByRoom_Id(Long roomId);
    List<Bed> findAllByRoom_Ward_Id(Long wardId);
    List<Bed> findAllByRoom_Ward_Facility_Id(Long facilityId);
    List<Bed> findAllByStatus(BedStatus status);

}
