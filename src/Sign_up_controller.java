import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
public class Sign_up_controller {
public static Boolean off = false;
    @FXML
    private PasswordField Sign_up_Gmail;
    
    @FXML
    private PasswordField Sign_up_Password;
    
    @FXML
    private PasswordField Sign_up_Username;
    
    
    @FXML
    private Button Sign_up_button;
   
    @FXML
    private PasswordField Sign_up_confirm_password;

    @FXML
    private Label feedbackLabel;
    
    @FXML
    void OnSignUpbuttonclick(ActionEvent event) {
        //5accounts(str_Username, str_Password);
        String str_Gmail = Sign_up_Gmail.getText().strip().replace(" ", "");
        String str_Password = Sign_up_Password.getText().strip().replace(" ", "");
        String str_ConfirmPassword = Sign_up_confirm_password.getText().strip().replace(" ", "");
        String str_Username = Sign_up_Username.getText().strip().replace(" ", "");
        if (!str_Password.equals(str_ConfirmPassword)) {
            // gives a error Passwords don't match
            feedbackLabel.setText("The pasword and the pasword confirmation must match");
        }
        else if (str_Username.isBlank() || str_Username.strip() == "" || str_Password.isBlank() || str_Password.strip() == ""){
            // gives you an error passwords/usernames are empty.
            feedbackLabel.setText("The pasword or name can't be blank");
        }
        else{
            accounts(str_Username, str_Password);
        
        //accounts(str_Username, str_Password);
                try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login_window.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();  

            Stage SignUpStage = (Stage) Sign_up_Username.getScene().getWindow();
            SignUpStage.close();
            off = true;
        } catch (Exception e) {}
    }
        }
        
    

    public void accounts(String str_username, String str_Password){
        try {

            FileWriter myObj = new FileWriter("accounts.txt", true);

            myObj.write(str_username);
            myObj.write(" ");
            myObj.write(str_Password);
            myObj.write(" ");
            myObj.write("client");
            myObj.write(System.lineSeparator());
            myObj.close();
        } catch (Exception e) {
            System.out.println("Something happened " + e);
        
        }
    }
}
