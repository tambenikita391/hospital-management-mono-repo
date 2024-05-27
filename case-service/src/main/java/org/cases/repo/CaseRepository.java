package org.cases.repo;

import java.util.List;

import org.cases.entity.Cases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
@Component
public interface CaseRepository extends JpaRepository<Cases, Long> {
	List<Cases> findByPatientId(long patientId);
}
