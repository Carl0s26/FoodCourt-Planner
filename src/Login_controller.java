import java.io.File;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
// import java.io.File;


public class Login_controller {

    public static Boolean off = false;

    @FXML
    private Button Login_button;

    @FXML
    private PasswordField Password_confirm_field;

    @FXML
    private PasswordField Password_field;

    @FXML
    private Button SignUp_button;

    @FXML
    private TextField User_name_field;

    @FXML
    private Label feedbackLabel;

    public static boolean loginAttempt = false;

    public static String storedUserName = "";
    public static String storedPassword = "";  
    public static String storedStatus = "";

    public String returnStatus(){
        return storedStatus;
    }

    @FXML
    void login(ActionEvent event) {
        
        if (User_name_field == null ||  Password_field == null || Password_confirm_field == null || User_name_field.getText().isBlank() || Password_field.getText().isBlank() || Password_confirm_field.getText().isBlank()){
            // gives you an error passwords/usernames are empty.
            feedbackLabel.setText("Neither the pasword or the name can be blank");
            loginAttempt = false;
        }
        else{
            try {
                //System.out.println("reading file");
                File myObj = new File("accounts.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                  String data = myReader.nextLine();
                  char[] dataline = data.toCharArray();
                  int num =0;
                  for (int i = 0; i < dataline.length; i++) {
                    if (dataline[i] == ' ') {
                        num ++;
                    }
                    else{switch (num) {
                        case 0:
                            storedUserName += String.valueOf(dataline[i]);
                            break;
                        case 1:
                            storedPassword += String.valueOf(dataline[i]);
                            break;
                        case 2:
                            storedStatus += String.valueOf(dataline[i]);
                            break;
                        default:
                            break;
                    }}
                    //System.out.println(storedUserName + " " + storedPassword + " " + storedStatus);
                  }
                  if (storedUserName.equals(User_name_field.getText()) && storedPassword.equals(Password_field.getText()) ) {
                    loginAttempt = true;
                    break;
                  }
                  else{
                    storedPassword ="";
                    storedStatus ="";
                    storedUserName ="";
                  }
                }
                myReader.close();
              } catch (Exception e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
            if (loginAttempt) {
                try{
                    //System.out.println("entered main page");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();  

                Stage loginStage = (Stage) Login_button.getScene().getWindow();
                loginStage.close();
            
                off = true;
                } catch (Exception e) {}
            }
            else{
                feedbackLabel.setText("Wrong password or Username please try again");
            }
    }
    @FXML
    void SignUp(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Sign_up_window.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();  

            Stage loginStage = (Stage) SignUp_button.getScene().getWindow();
            loginStage.close();
            
            off = true;
        } catch (Exception e) {}

    }
    @FXML
    void Onbuttonclick(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Sign_up_window.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();  

            Stage loginStage = (Stage) Login_button.getScene().getWindow();
            loginStage.close();
            
            off = true;
        } catch (Exception e) {}
    }
}
