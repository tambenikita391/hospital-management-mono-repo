package org.appointment.service;

import java.util.Optional;

import org.appointment.common.RandomStringGenerator;
import org.appointment.common.ResponseCode;
import org.appointment.dto.AppointmentRequest;
import org.appointment.dto.AppointmentResponse;
import org.appointment.entity.Appointment;
import org.appointment.repo.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class AppointmentManagementServiceImpl implements AppointmentManagementService {
  @Autowired AppointmentRepository appointmantRepo;
  @Autowired AppointmentRequest appointmentRequest;
  @Autowired AppointmentResponse appointmentResponse;

  public AppointmentResponse makeAppointment(AppointmentRequest appointmentRequest) {
    Appointment appointment =
        Appointment.getInstanace()
            .setPatientNameInEnglish(appointmentRequest.getPatientNameInEnglish())
            .setPatientNameInMarathi(appointmentRequest.getPatientNameInMarathi())
            .setAppointmentId("APMT" + RandomStringGenerator.generateRandomString(5))
            .setPatientId("PAT" + RandomStringGenerator.generateRandomString(5))
            .setExaminationDate(appointmentRequest.getExaminationDate())
            .setAppointmentTime(appointmentRequest.getAppointmentTime());

    try {
      appointment = appointmantRepo.save(appointment);
    } catch (Exception e) {
      e.printStackTrace();
    }

    appointmentResponse.setStatus(ResponseCode.ADD_APPOINTMENT_SUCCESS.getStatus());
    appointmentResponse.setMessage(ResponseCode.ADD_APPOINTMENT_SUCCESS.getMessage());
    appointmentResponse.setPatientId(appointment.getPatientId());
    appointmentResponse.setAppointmentId(appointment.getAppointmentId());
    return appointmentResponse;
  }

  public AppointmentResponse searchAppointment(String patientId) {
    Optional<Appointment> receivedAppointment = appointmantRepo.findByPatientId(patientId);
    if (receivedAppointment.isEmpty()) {
      appointmentResponse.setStatus(ResponseCode.SEARCH_APPOINTMENT_FAILURE.getStatus());
      appointmentResponse.setMessage(ResponseCode.SEARCH_APPOINTMENT_FAILURE.getMessage());
    } else {
      Appointment appointment = receivedAppointment.get();
      appointmentResponse.setPatientNameInEnglish(appointment.getPatientNameInEnglish());
      appointmentResponse.setPatientNameInMarathi(appointment.getPatientNameInMarathi());
      appointmentResponse.setAppointmentId(appointment.getAppointmentId());
      appointmentResponse.setExaminationDate(appointment.getExaminationDate());
      appointmentResponse.setAppointmentTime(appointment.getAppointmentTime());

      appointmentResponse.setStatus(ResponseCode.SEARCH_APPOINTMENT_SUCCESS.getStatus());
      appointmentResponse.setMessage(ResponseCode.SEARCH_APPOINTMENT_SUCCESS.getMessage());
    }

    return appointmentResponse;
  }

  public String deleteAppointment(String appointmentId) {
    appointmantRepo.deleteById(appointmentId);
    return "Appoint of patientId " + appointmentId + "  is deleted";
  }
}
