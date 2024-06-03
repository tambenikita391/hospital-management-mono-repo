package hospital_management_dashboard;

import java.io.IOException;

import add_cases.AddCasesScreen;
import add_patients.AddPatientScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import user_login.LoginScreen;

public class HospitalManagementScreenController {
  @FXML private Button logOutButton;

  @FXML private Button patientButton;

  @FXML private Button caseButton;

  @FXML private Button appointmentButton;

  @FXML private Button userButton;

  @FXML
  private void patients(ActionEvent event) throws IOException {
    System.out.println("Patient Screens button clicked!");
    AddPatientScreen.showAddPatientScreen();
  }

  @FXML
  private void cases(ActionEvent event) throws IOException {
    System.out.println("Cases Screens button clicked!");
    AddCasesScreen.showAddCasesScreen();
  }
  
  @FXML
  private void appointments(ActionEvent event) {
	  
  }

  @FXML
  private void logOut(ActionEvent event) throws IOException {
    LoginScreen.showLoginScreen();
  }
}
