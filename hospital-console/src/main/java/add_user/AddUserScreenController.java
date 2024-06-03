package add_user;

import java.io.IOException;

import org.hospital.dto.UsersRequest;
import org.hospital.dto.UsersResponse;

import add_appointments.AddAppointmentScreen;
import add_cases.AddCasesScreen;
import add_patients.AddPatientScreen;
import common.RestUtilGenerics;
import hospital_management_dashboard.HospitalManagementScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import user_management_dashboard.UserManagementScreeen;

public class AddUserScreenController {
  @FXML private TextField role;

  @FXML private Button cancleButton;

  @FXML private Button usersButton;

  @FXML private TextField mobile;

  @FXML private Button appointmentsButton;

  @FXML private TextField userName;

  @FXML private TextField password;

  @FXML private Button logOutButton;

  @FXML private Button patientsButton;

  @FXML private Button dashBoardButton;

  @FXML private Button casesButton;

  @FXML private TextField confirmPassword;

  @FXML private Button saveButton;

  @FXML private TextField email;

  @FXML
  public void save(ActionEvent event) throws Exception {
    UsersRequest addUser = new UsersRequest();

    addUser.setUserName(userName.getText());
    addUser.setEmail(email.getText());
    addUser.setMobileNumber(mobile.getText());
    addUser.setRole(role.getText());
    addUser.setPassword(password.getText());
    addUser.setConfirmPassword(confirmPassword.getText());

    try {
      UsersResponse response =
          RestUtilGenerics.sendPostRequest(
              "http://localhost:8081/api/v1/directory/add", UsersResponse.class, addUser);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("User Added ");
    alert.setContentText("User added!");
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

  @FXML
  private void appointments(ActionEvent event) throws IOException {
    AddAppointmentScreen.showAddAppointmentScreen();
  }
}
