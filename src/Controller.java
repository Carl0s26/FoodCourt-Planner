import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;



public class Controller {

    ArrayList<Object> listaDeMesas = new ArrayList<>();

    static int id = 1;
    int tableId;
    int tableXcords;
    int tableYcords;
    boolean tableStatus;
    javafx.scene.image.ImageView tableImageFrame;
    Image tableImage;
    
    public void Table(int tableYcords, int tableXcords, int tableId, boolean tableStatus) {
        this.tableId = tableId;
        this.tableXcords = tableXcords;
        this.tableYcords = tableYcords;
        this.tableStatus = tableStatus;
        tableImage = new Image("table.png");
        tableImageFrame = new javafx.scene.image.ImageView(tableImage);
        tableImageFrame.setFitHeight(25);
        tableImageFrame.setFitWidth(25);
        tableImageFrame.setLayoutX(tableXcords);
        tableImageFrame.setLayoutY(tableYcords);
        PaneId.getChildren().add(tableImageFrame);
        
    }
    // public void setTAbleImage(){
    //     this.tableImage = tableImage;
    // }

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
    private Label MenuLabel5;

    @FXML
    private Label MenuLabel6;

    @FXML
    private Label MenuLabel7;

    @FXML
    private Pane PaneId;

    @FXML
    private ImageView si;

    @FXML
    void EditButtonClicked(ActionEvent event) {
        if (free){
            editmode = true;
            si.setImage(new Image("table3.png"));
            free = false;
            moves = true;
        }else{
            editmode = false;
            si.setImage(new Image("table.png"));
            free = true;
            moves = false;
        }
    }

    @FXML
    void add_table(ActionEvent event) {
        Table(tableYcords, tableXcords + 50, id, tableStatus);
        id += 1;
        System.out.println(id);
    }

    Boolean free = true;
    Boolean moves = false;
    Boolean editmode = false;
    
    @FXML
    void egg(MouseEvent event){
        if (!editmode){
            if (event.getButton() == MouseButton.SECONDARY){
                if (free){
                    si.setImage(new Image("table1.png"));
                    free = false;
                }else{
                    si.setImage(new Image("table2.png"));
                    free = true;
                }
            }
        }
        
    }
    @FXML
    void drag(MouseEvent event) {
        if(moves){

            if (event.getSceneX() < 10.00){
                si.setLayoutX(10.0);
            }else if (event.getSceneX() > 769.00){
                si.setLayoutX(769.0);



            
            }else{    
                si.setLayoutX(event.getSceneX());
            }



            if (event.getSceneY() > 515.00){
                si.setLayoutY(515.0);
            }else if (event.getSceneY() < 8.00){
                si.setLayoutY(8.0);
            }else if (event.getSceneY() < 41.00){
                si.setLayoutY(41.0);

            }else{    
                si.setLayoutY(event.getSceneY());
            }

            System.out.println(event.getSceneY());
        }
         
    }

}
