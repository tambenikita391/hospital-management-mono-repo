package org.appointment.service;

import org.appointment.dto.AppointmentRequest;
import org.appointment.dto.AppointmentResponse;

public interface AppointmentManagementService {
  public AppointmentResponse makeAppointment(AppointmentRequest appointmentRequest);

  public AppointmentResponse searchAppointment(String patientId);

  public String deleteAppointment(String patientId);
}
