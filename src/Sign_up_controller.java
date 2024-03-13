import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
public class Sign_up_controller {
public static Boolean off = false;
    @FXML
    private PasswordField Sign_up_Gmail;
    //
    @FXML
    private PasswordField Sign_up_Password;
    //
    @FXML
    private PasswordField Sign_up_Username;
    //
    
    @FXML
    private Button Sign_up_button;
   
    @FXML
    private PasswordField Sign_up_confirm_password;
    
    @FXML
    void OnSignUpbuttonclick(ActionEvent event) {
        //5accounts(str_Username, str_Password);
        String str_Gmail = Sign_up_Gmail.getText();
        String str_Password = Sign_up_Password.getText();
        String str_ConfirmPassword = Sign_up_confirm_password.getText();
        String str_Username = Sign_up_Username.getText();
        if (!str_Password.equals(str_ConfirmPassword)) {
            // gives a error Passwords don't match
            System.out.println("The pasword and the pasword confirmation must match");
        }
        else if (str_Username == null || str_Username == "" || str_Password == null || str_Password == "" || str_Username == " " || str_Password == " "){
            // gives you an error passwords/usernames are empty.
            System.out.println("The pasword or name can't be blanck");
        }
        else{
            accounts(str_Username, str_Password);
        }
        //accounts(str_Username, str_Password);
                try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login_controller.java"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();  

            Stage loginStage = (Stage) Sign_up_button.getScene().getWindow();
            loginStage.close();
            
            off = true;
        } catch (Exception e) {}
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
