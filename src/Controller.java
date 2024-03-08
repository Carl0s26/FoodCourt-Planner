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
    ArrayList<ImageView> tableImageFrames = new ArrayList<>();

    Boolean free = true;
    Boolean moves = false;
    Boolean edit_mode = false;
    static int id = 1;
    int tableId;
    int tableXcords;
    int tableYcords;
    boolean tableStatus;
    javafx.scene.image.ImageView tableImageFrame;
    Image tableImage;
    
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
            
            if (!edit_mode){
                if (event.getButton() == MouseButton.SECONDARY){
                    if (free){
                        tableImageFrame.setImage(new Image("table1.png"));
                        free = false;
                    }else{
                        tableImageFrame.setImage(new Image("table2.png"));
                        free = true;
                    }
                }
            }

        });

        tableImageFrame.setOnMouseDragged(event -> {
            System.out.println("YEY");
            if(moves){
                if (event.getSceneX() < 10.00){
                    tableImageFrame.setLayoutX(10.0);
                    
                }else if (event.getSceneX() > 769.00){
                    tableImageFrame.setLayoutX(769.0);
                
                }else if (event.getSceneX() < 489.00 && event.getSceneX() > 221 && event.getSceneY() < 180){
                    tableImageFrame.setLayoutX(489.0);
                }else if (event.getSceneX() > 221.00 && event.getSceneX() < 300.00 && event.getSceneY() < 181){
                    tableImageFrame.setLayoutX(221.0);
    
                }else{    
                    tableImageFrame.setLayoutX(event.getSceneX());
                }
    
                if (event.getSceneY() > 515.00){
                    tableImageFrame.setLayoutY(515.0);
                }else if (event.getSceneY() < 141.00 && event.getSceneX() < 221){
                    tableImageFrame.setLayoutY(141.0);
                
                }else if (event.getSceneY() < 8.00){
                    tableImageFrame.setLayoutY(8.0);
    
                }else if (event.getSceneY() < 181.00 && event.getSceneX() > 250 && event.getSceneX() < 460){
                    tableImageFrame.setLayoutY(181.0);
    
                }else{    
                    tableImageFrame.setLayoutY(event.getSceneY());
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
            edit_mode = true;
            si.setImage(new Image("table3.png"));
            changeTableImage("table3.png");
            free = false;
            moves = true;
        }else{
            edit_mode = false;
            si.setImage(new Image("table.png"));
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
        Table(tableYcords, tableXcords + 50, id, tableStatus);
        id += 1;
        tableImageFrames.add(tableImageFrame);
        System.out.println(id);
    }

    
    
    @FXML
    void egg(MouseEvent event){
        if (!edit_mode){
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
            
            }else if (event.getSceneX() < 489.00 && event.getSceneX() > 221 && event.getSceneY() < 180){
                si.setLayoutX(489.0);
            }else if (event.getSceneX() > 221.00 && event.getSceneX() < 300.00 && event.getSceneY() < 181){
                si.setLayoutX(221.0);

            }else{    
                si.setLayoutX(event.getSceneX());
            }

            if (event.getSceneY() > 515.00){
                si.setLayoutY(515.0);
            }else if (event.getSceneY() < 141.00 && event.getSceneX() < 221){
                si.setLayoutY(141.0);
            
            }else if (event.getSceneY() < 8.00){
                si.setLayoutY(8.0);

            }else if (event.getSceneY() < 181.00 && event.getSceneX() > 250 && event.getSceneX() < 460){
                si.setLayoutY(181.0);

            }else{    
                si.setLayoutY(event.getSceneY());
            }

            if (event.getSceneY() < 141.00 && event.getSceneX() < 221){
                
            }

            //System.out.println("X: " + event.getSceneX());
            //System.out.println("Y: " + event.getSceneY());
        }
         
    }

}
