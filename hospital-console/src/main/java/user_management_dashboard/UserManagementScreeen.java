package user_management_dashboard;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import common.StageFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class UserManagementScreeen {
	public static void showUserManagementScreen() throws  IOException {
		Parent actorGroup = FXMLLoader.load(new URL("file:///C|/Users//tambe//eclipse-workspace//hospital-console//src//main//java//user_management_dashboar//User managements.fxml"));
		StageFactory.stage.setTitle("USER MANAGEMENT SCRREN");
		StageFactory.stage.setFullScreen(true);
		
		Scene scene = new Scene(actorGroup);
		StageFactory.stage.setScene(scene);
		StageFactory.stage.show();
	}
}
