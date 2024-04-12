import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class Controller {

    ArrayList<Integer> XCordsTablelist = new ArrayList<>();
    ArrayList<Integer> YCordsTablelist = new ArrayList<>();
    ArrayList<String> StatusCordsTablelist = new ArrayList<>();
    ArrayList<String> VisibleCordsTablelist = new ArrayList<>();
    ArrayList<ImageView> tableImageFrames = new ArrayList<>();
    ArrayList<Object> tableList = new ArrayList<>();

    Boolean free = true;
    Boolean moves = false;
    Boolean edit_mode = false;
    static int id = 0;
    int lastTableId = 0;
    int tableId;
    int tableXcords;
    int tableYcords;
    boolean tableStatus;
    javafx.scene.image.ImageView tableImageFrame;
    Image tableImage;
    boolean isAdmin;
    
    public void Table(int tableYcords, int tableXcords, int tableId, boolean tableStatus) {
        if (moves){
            tableImage = new Image("table3.png");
        }else{
            tableImage = new Image("table.png");
        }

        this.tableId = tableId;
        this.tableXcords = tableXcords;
        this.tableYcords = tableYcords;
        this.tableStatus = tableStatus;
        tableImageFrame = new javafx.scene.image.ImageView(tableImage);
        tableImageFrame.setFitHeight(29);
        tableImageFrame.setFitWidth(29);
        tableImageFrame.setLayoutX(tableXcords);
        tableImageFrame.setLayoutY(tableYcords);
        PaneId.getChildren().add(tableImageFrame);
        

        tableImageFrame.setOnMouseClicked(event ->{
            lastTableId = tableId;
            if (!edit_mode){
                if (event.getButton() == MouseButton.SECONDARY){
                    if (free){
                        tableImageFrames.get(tableId).setImage(new Image("table1.png"));
                        free = false;
                    }else{
                        tableImageFrames.get(tableId).setImage(new Image("table2.png"));
                        free = true;
                    }
                }
            }

        });

        tableImageFrame.setOnMouseDragged(event -> {
            if(moves){
                if (event.getSceneX() < 10.00){
                    tableImageFrames.get(tableId).setLayoutX(10.0);
                }else if (event.getSceneX() > 769.00){
                     tableImageFrames.get(tableId).setLayoutX(769.0);
                }else if (event.getSceneX() < 489.00 && event.getSceneX() > 221 && event.getSceneY() < 180){
                     tableImageFrames.get(tableId).setLayoutX(489.0);
                }else if (event.getSceneX() > 221.00 && event.getSceneX() < 300.00 && event.getSceneY() < 181){
                     tableImageFrames.get(tableId).setLayoutX(221.0);
                }else if (event.getSceneX() > 313.00 && event.getSceneX() < 386.00 && event.getSceneY() > 182 && event.getSceneY() < 282 ){
                    tableImageFrames.get(tableId).setLayoutX(313.0);
                }else if (event.getSceneX() > 600.00 && event.getSceneY() < 107 ){
                    tableImageFrames.get(tableId).setLayoutX(600.0);
                }else{    
                     tableImageFrames.get(tableId).setLayoutX(event.getSceneX());
                    }
    
                if (event.getSceneY() > 515.00){
                     tableImageFrames.get(tableId).setLayoutY(515.0);
                }else if (event.getSceneY() < 141.00 && event.getSceneX() < 221){
                     tableImageFrames.get(tableId).setLayoutY(141.0);
                }else if (event.getSceneY() < 8.00){
                     tableImageFrames.get(tableId).setLayoutY(8.0);
                }else if (event.getSceneY() < 181.00 && event.getSceneX() > 250 && event.getSceneX() < 460){
                     tableImageFrames.get(tableId).setLayoutY(181.0);
                }else if (event.getSceneY() < 107.00 && event.getSceneX() > 629){
                    tableImageFrames.get(tableId).setLayoutY(107.0);
                    
                }else{    
                    tableImageFrames.get(tableId).setLayoutY(event.getSceneY());
                }
            }
        });

    }


    public int getTableId() {
        return tableId;
    }
    public int getTableXcords() {
        return tableXcords;
    }
    public int getTableYcords() {
        return tableYcords;
    }
    public boolean getTableStatus() {
        return tableStatus;
    }
    public void setTableId(int tableId) {
        this.tableId = tableId;
    }
    public void setTableXcords(int tableXcords) {
        this.tableXcords = tableXcords;
    }
    public void setTableYcords(int tableYcords) {
        this.tableYcords = tableYcords;
    }
    public void setTableStatus(boolean tableStatus) {
        this.tableStatus = tableStatus;
    }


    @FXML
    private Label MenuLabel1;

    @FXML
    private Label MenuLabel2;

    @FXML
    private Label MenuLabel3;

    @FXML
    private Label MenuLabel4;

    @FXML
    private Label Desk_feedback;

    @FXML
    private Label MenuLabel5;

    @FXML
    private Label MenuLabel6;

    @FXML
    private Label MenuLabel7;

    @FXML
    private Pane PaneId;

    @FXML
    private Button DeleteTableButton;

    @FXML
    private Button addTableButton;

    @FXML
    private Button editTableButton;

    @FXML Button saveButton;

    public static String Xtablecords = "";
    public static String Ytablecords = "";
    public static String StoredTableStatus = "";
    @FXML
    public void exitApplication(ActionEvent event) {
    //     try {
    //     for (ImageView tableImage : tableImageFrames) {
    //         // XCordsTablelist.add((int) tableImage.getX());
    //         // YCordsTablelist.add((int) tableImage.getY());
    //         boolean isVisible = tableImage.isVisible();
    //         // StatusCordsTablelist.add(String.valueOf(isVisible));
    //         FileWriter myObj = new FileWriter("tables.txt", true);
    //         myObj.write((int)tableImage.getX() + " " + (int)tableImage.getY() + " " + isVisible);
    //         myObj.close();
            
            
    //     }
        
    //     System.out.println("z");
    //     Platform.exit();
    //     } catch (IOException e) {
    //     e.printStackTrace();
    // }
    }
    // Save file

    // Stage mainPage = (Stage) MenuLabel1.getScene().getWindow();

    @FXML
    void save_button(ActionEvent event){
        try {
            FileWriter myObj1 = new FileWriter("tables.txt", false);
            myObj1.write("");
            myObj1.close();
            FileWriter myObj = new FileWriter("tables.txt", true);
            for (ImageView tableImage : tableImageFrames) {
                // XCordsTablelist.add((int) tableImage.getX());
                // YCordsTablelist.add((int) tableImage.getY());
                boolean isVisible = tableImage.isVisible();
                // StatusCordsTablelist.add(String.valueOf(isVisible));
                
                myObj.write((int)tableImage.getLayoutX() + " " + (int)tableImage.getLayoutY() + " " + isVisible);
                myObj.write("\n");
                
            } 
            myObj.close();
            Platform.exit();
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void EditButtonClicked(ActionEvent event) {
        if (free){
            edit_mode = true;
            changeTableImage("table3.png");
            free = false;
            moves = true;
        }else{
            edit_mode = false;
            changeTableImage("table.png");
            free = true;
            moves = false;
        }
    }

    public void changeTableImage(String image) {
        for (ImageView frame : tableImageFrames) {
            frame.setImage(new Image(image));
        }
    }

    @FXML
    void add_table(ActionEvent event) {
        if (tableXcords + 50 > 769){
            Table(tableYcords + 40, 30, id, tableStatus);

        }else{
            if (tableXcords == 0){
                Table(tableYcords, tableXcords + 30, id, tableStatus);
            }else{
                Table(tableYcords, tableXcords + 50, id, tableStatus);
            }  
        }
        id += 1;
        
        tableImageFrames.add(tableImageFrame);
        System.out.println(id);
    }
    
    @FXML
    void egg(MouseEvent event){
        if (!edit_mode){
            if (event.getButton() == MouseButton.SECONDARY){
                if (free){
                    free = false;
                }else{
                    free = true;
                    
                }
            }
        }
        Reservation_pane(PaneId);
    }
    @FXML
    void drag(MouseEvent event) {
        
        
    }
    @FXML
    void delete_table(ActionEvent event) {
        tableImageFrames.get(lastTableId).setVisible(false);
         
    }


    boolean Desk_feedbackBoleean(Label Desk_feedback){
        Boolean Deskstatus = false;
        return Deskstatus; 
    }

    void Reservation_pane(Pane Reservation_pane){
        if(!free){
            Reservation_pane.setVisible(true);
        }
        else if (free){
            Desk_feedback.setVisible(true);
        }
    }
    

    @FXML
    public void initialize(){
        System.out.println("On the initialize");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login_window.java"));
        Login_controller login_controller = loader.getController();
        String UserStatus = Login_controller.storedStatus;
            
        if (UserStatus.equals("client")) {
            editTableButton.setVisible(false);
            editTableButton.setDisable(true);
            DeleteTableButton.setVisible(false);
            DeleteTableButton.setDisable(true);
            addTableButton.setVisible(false);
            addTableButton.setDisable(true);
            saveButton.setVisible(false);
            saveButton.setDisable(true);
        }
            try {
                File myObj = new File("tables.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String tabledata = myReader.nextLine();
                    String[] tableTokens = tabledata.split(" ");
                    int xCords = Integer.parseInt(tableTokens[0]);
                    int yCords = Integer.parseInt(tableTokens[1]);
                    boolean status = Boolean.parseBoolean(tableTokens[2]);
                    if (status) {
                        Table(xCords, yCords, id, status);
                        id += 1;
                        tableImageFrame.setLayoutX(xCords);
                        tableImageFrame.setLayoutY(yCords);
                        tableImageFrames.add(tableImageFrame);
                    }
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        // }
        // else{
            
        // }
    }
}
