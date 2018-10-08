import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.*;
public class Liste
{
    Knoten erster;

    public Liste()
    {

    }

    public void hintenEinfuegen(Person p)
    {
        {
            if (erster == null){
                erster = new Knoten(p);
            }
            else
            {
                erster.hintenEinfuegen(p);
            }
        }
    }
    
    public void vorneEntnehmen()
    {
        
    }
    
    public void zeichnen(GraphicsContext gc)
    {
        gc.clearRect(0,0,450,150);
        gc.setFont(new Font(10));
        gc.setLineWidth(0.5);
        
        //Rechteck mit Text
        gc.strokeRoundRect(0,10,70,30,5,5);
        gc.strokeText(" : LISTE ",5,30);
        
        //Pfeil
        gc.strokeLine(70,25,90,25);
        gc.strokeLine(85,20,90,25);
        gc.strokeLine(85,30,90,25);
        
        
        if (erster != null)
        {
            erster.zeichnen(gc,90);
        }
    }
}
