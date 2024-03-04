import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        Table(tableYcords, tableXcords+(id*2), id, tableStatus);
        id +=1;
        System.out.println(id);
    }
    Boolean eggs = true;
    @FXML
    void egg(MouseEvent event){
        // if (eggs){
        //     si.setImage(new Image("table1.png"));
        //     eggs = false;
        // }else{
        //     si.setImage(new Image("table2.png"));
        //     eggs = true;
        // }
        
    }

}
