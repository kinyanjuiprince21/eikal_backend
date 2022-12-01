package com.eikal.repository.people;

import com.eikal.models.people.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Repository
public interface RelationshipRepository extends JpaRepository<Relationship, Long> {
    List<Relationship> findAllByUser1_Id(Long userId);
    List<Relationship> findAllByIsNextOfKinOf(Long userId);
}
