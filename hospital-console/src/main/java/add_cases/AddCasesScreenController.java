package add_cases;

import java.io.IOException;

import org.hospital.dto.CaseRequest;
import org.hospital.dto.CaseResponse;

import add_appointments.AddAppointmentScreen;
import add_patients.AddPatientScreen;
import common.RestUtilGenerics;
import hospital_management_dashboard.HospitalManagementScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import user_management_dashboard.UserManagementScreeen;

public class AddCasesScreenController {
  @FXML private TextField symptoms;

  @FXML private Button cancleButton;

  @FXML private TextField prescription;

  @FXML private TextField examinationDate;

  @FXML private TextField patientNameInMarathi;
  @FXML private TextField patientNameInEnglish;

  @FXML private Button saveButton;
  @FXML private Button logOutButton;

  @FXML
  public void save(ActionEvent event) throws Exception {
    CaseRequest addCase = new CaseRequest();

    addCase.setExaminationDate(examinationDate.getText());
    addCase.setPatientNameInEnglish(patientNameInEnglish.getText());
    addCase.setPrescription(prescription.getText());
    addCase.setSymptoms(symptoms.getText());

    try {
      CaseResponse response =
          RestUtilGenerics.sendPostRequest(
              "http://localhost:8083/api/v1/case/add", CaseResponse.class, addCase);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Case Added ");
    alert.setContentText("Case added!");
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
  private void appointments(ActionEvent event) throws IOException {
    AddAppointmentScreen.showAddAppointmentScreen();
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
