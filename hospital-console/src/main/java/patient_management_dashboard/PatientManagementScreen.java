package patient_management_dashboard;

import java.io.IOException;
import java.net.URL;

import common.StageFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class PatientManagementScreen {
	 public static void showPatientManagementScreen() throws IOException {
		    Parent actorGroup =
		        FXMLLoader.load(
		            new URL(
		                "file:///C|/Users//tambe//eclipse-workspace//hospital-console//src//main//java//patient_management_dashboard//patient-management.fxml"));
		    StageFactory.stage.setTitle("PATIENT MANAGEMENT SCREEN");
		    StageFactory.stage.setFullScreen(true);

		    Scene scene = new Scene(actorGroup);
		    StageFactory.stage.setScene(scene);
		    StageFactory.stage.show();
		  }
}
