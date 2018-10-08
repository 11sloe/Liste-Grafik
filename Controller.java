
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Controller {
    Liste liste;
    @FXML
    private ListView listView;

    @FXML
    private TextField txtName;

    @FXML
    private Label lblMeldung;

    @FXML
    private Canvas canvas;
    
    GraphicsContext gc;

    public Controller()
    {
        liste = new Liste();
    }

    @FXML
    void initialize() {
        gc = canvas.getGraphicsContext2D();
       liste.zeichnen(gc);
    }

    // Einfügen per Button einfügen
    @FXML
    public void hintenEinfuegen(Event event) {
        hintenEinfuegen();
    }
    
    @FXML
    void vorneEntnehmen(ActionEvent event) {
       liste.vorneEntnehmen();
        liste.zeichnen(gc);

    }

    // Einfügen per Return
    @FXML
    public void handleTxtEinfuegen(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER)
        {
            hintenEinfuegen();
        }

    }

    public void hintenEinfuegen()
    {
        String name = txtName.getText();
        if (name.equals("")){
            lblMeldung.setText("Kein Name?");
        }
        else {

            Person p = new Person(name);
            liste.hintenEinfuegen(p);
            txtName.setText("");

        }

        
        liste.zeichnen(gc);
    }

}