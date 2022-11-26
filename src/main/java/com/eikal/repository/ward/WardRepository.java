package com.eikal.repository.ward;

import com.eikal.models.ward.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepository extends JpaRepository<Ward, Long> {

    List<Ward> findAllByFacility_Id(Long id);

}
