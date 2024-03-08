import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import java.io.File;
import java.io.FileWriter;
public class Sign_up_controller {

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
    void Onbuttonclick(ActionEvent event) {
        //5accounts(str_Username, str_Password);
        String str_Gmail = Sign_up_Gmail.getText();
        String str_Password = Sign_up_Password.getText();
        String str_Username = Sign_up_Username.getText();

    }

    public void accounts(String str_username, String str_Password){
        try {
            FileWriter myObj = new FileWriter("accounts.txt");
            myObj.write(str_username);

            myObj.close();
        } catch (Exception e) {
            System.out.println("Something happened " + e);
        
        }
    }
}
