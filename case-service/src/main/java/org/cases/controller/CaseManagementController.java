package org.cases.controller;

import org.cases.dto.CaseRequest;
import org.cases.dto.CaseResponse;
import org.cases.service.CaseManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseManagementController {
  @Autowired CaseManagementServiceImpl caseManagementServiceImpl;

  @PostMapping(
      path = "/api/v1/case/add",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public CaseResponse addCase(@RequestBody CaseRequest request) {
    return caseManagementServiceImpl.addCases(request);
  }

  @GetMapping(
      path = "/api/v1/case/{patientId}",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public CaseResponse searchCases(@PathVariable long patientId) {
    return caseManagementServiceImpl.searchCases(patientId);
  }

  @DeleteMapping(
      path = "/api/v1/case/{patientId}",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public String deleteCases(@PathVariable long patientId) {
    return caseManagementServiceImpl.deleteCases(patientId);
  }
}
