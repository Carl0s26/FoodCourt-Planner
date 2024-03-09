import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
// import java.io.File;


public class Login_controller {

    public static Boolean off = false;

    @FXML
    private Button Login_button;

    @FXML
    private PasswordField Password_login;
       
    @FXML
    private PasswordField User_name_login;

    @FXML
    void login(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();  
            off = true;
        } catch (Exception e) {}
    }
}
