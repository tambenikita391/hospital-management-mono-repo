package user_management_dashboard;

import java.io.IOException;

import add_appointments.AddAppointmentScreen;
import add_cases.AddCasesScreen;
import add_patients.AddPatientScreen;
import add_user.AddUserScreen;
import hospital_management_dashboard.HospitalManagementScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UserManagementScreenController {
  @FXML private Button deleteUserButton;

  @FXML private Button logOutButton;

  @FXML private Button editUserButton;

  @FXML private Button patientsButton;

  @FXML private Button dashBoardButton;

  @FXML private Button casesButton;

  @FXML private Button appointmentsButton;

  @FXML private Button addUserButton;

  @FXML private Button searchUserButton;

  @FXML
  public void addUser(ActionEvent event) throws IOException {
    AddUserScreen.showAddUserScreen();
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
  private void appointments(ActionEvent event) throws IOException {
    AddAppointmentScreen.showAddAppointmentScreen();
  }
}
