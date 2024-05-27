package org.cases.service;

import org.cases.dto.CaseRequest;
import org.cases.dto.CaseResponse;

public interface CaseManagementService {
  public CaseResponse addCases(CaseRequest caseRequest);

  public CaseResponse searchCases(long caseNumber);

  public String deleteCases(long patientId);
}
