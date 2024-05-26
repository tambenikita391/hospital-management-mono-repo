package org.patient.repo;

import java.util.List;

import org.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
