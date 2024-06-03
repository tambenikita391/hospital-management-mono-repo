package add_appointments;

import java.io.IOException;

import org.hospital.dto.AppointmentRequest;
import org.hospital.dto.AppointmentResponse;

import add_cases.AddCasesScreen;
import add_patients.AddPatientScreen;
import common.RestUtilGenerics;
import hospital_management_dashboard.HospitalManagementScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import user_management_dashboard.UserManagementScreeen;

public class AddAppointmentScreenController {
  @FXML private TextField appointmentTime;

  @FXML private Button logOutButton;

  @FXML private Button cancleButton;

  @FXML private Button usersButton;

  @FXML private TextField examinationDate;

  @FXML private TextField patientNameInMarathi;

  @FXML private Button dashBoardButton;

  @FXML private Button casesButton;

  @FXML private TextField patientNameInEnglish;

  @FXML private Button appointmentsButton;

  @FXML private Button saveButton;

  @FXML private Button PatientsButton;

  @FXML
  private void save(ActionEvent event) throws Exception {
    AppointmentRequest addAppointment = new AppointmentRequest();

    addAppointment.setPatientNameInMarathi(patientNameInEnglish.getText());
    addAppointment.setPatientNameInEnglish(patientNameInMarathi.getText());
    addAppointment.setAppointmentTime(appointmentTime.getText());
    addAppointment.setExaminationDate(examinationDate.getText());

    try {
      AppointmentResponse response =
          RestUtilGenerics.sendPostRequest(
              "http://localhost:8084/api/v1/appointment/add",
              AppointmentResponse.class,
              addAppointment);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Appointment Added ");
    alert.setContentText("Appointment added!");
    alert.setHeaderText("Success!!");
    alert.show();
  }

  @FXML
  private void cancle(ActionEvent event) throws IOException {
    HospitalManagementScreen.showHospitalManagementScreen();
  }

  @FXML
  private void logOut(ActionEvent event) {
    System.exit(0);
  }

  @FXML
  private void patients(ActionEvent event) throws IOException {
    AddPatientScreen.showAddPatientScreen();
  }

  @FXML
  private void cases(ActionEvent event) throws IOException {
    AddCasesScreen.showAddCasesScreen();
  }

  @FXML
  private void dashBoard(ActionEvent event) throws IOException {
    HospitalManagementScreen.showHospitalManagementScreen();
  }

  @FXML
  private void users(ActionEvent event) throws IOException {
    UserManagementScreeen.showUserManagementScreen();
  }
}
