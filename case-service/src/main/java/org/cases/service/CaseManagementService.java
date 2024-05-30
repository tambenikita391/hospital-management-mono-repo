package org.cases.service;

import org.cases.dto.CaseRequest;
import org.cases.dto.CaseResponse;

public interface CaseManagementService {
  public CaseResponse addCases(CaseRequest caseRequest);

  public String deleteCases(String patientId);

  public CaseResponse searchCasesByCaseId(String caseId);
}
