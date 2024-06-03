package add_patients;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.hospital.dto.PatientRequest;
import org.hospital.dto.PatientResponse;

import common.RestUtilGenerics;
import hospital_management_dashboard.HospitalManagementScreen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import user_login.LoginScreen;

public class AddPatientScreenController  {

  @FXML private ComboBox<String> gender;

  @FXML private TextField address;
  @FXML private TextField mobileNumber;
  @FXML private TextField patientNameInMarathi;
  @FXML private TextField patientNameInEnglish;
  @FXML private TextField birthDate;
  @FXML private TextField firstExaminationdate;

  @FXML
  private void initialize() {
      ObservableList<String> genders = FXCollections.observableArrayList("Male", "Female", "Other");
      gender.setItems(genders);
  }

  @FXML
  public void save(ActionEvent event) throws Exception {
    PatientRequest addPatient = new PatientRequest();

    addPatient.setAddress(address.getText());
    addPatient.setMobileNumber(mobileNumber.getText());
    addPatient.setPatientNameInMarathi(patientNameInMarathi.getText());
    addPatient.setPatientNameInEnglish(patientNameInEnglish.getText());
    addPatient.setBirthDate(birthDate.getText());
    addPatient.setFirstExaminationDate(firstExaminationdate.getText());
    addPatient.setGender(gender.getValue());

    // Perform your save operation here
    System.out.println("Patient information saved successfully!");

    try {
      PatientResponse response =
          RestUtilGenerics.sendPostRequest(
              "http://localhost:8082/api/v1/patient/add", PatientResponse.class, addPatient);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Patient Added ");
    alert.setContentText("Patient added!");
    alert.setHeaderText("Success!!");
    alert.show();
  }
  @FXML
  public void cancle(ActionEvent event) throws IOException {
	  HospitalManagementScreen.showHospitalManagementScreen();
  }
  @FXML
  public void logOut(ActionEvent event) throws IOException {
	  LoginScreen.showLoginScreen();
  }
}
