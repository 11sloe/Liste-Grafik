import javafx.scene.canvas.GraphicsContext;


public class Knoten
{
    // Attribute
    private Knoten naechster;
    private Person inhalt;

    public Knoten(Person inhalt_)
    {
        inhalt = inhalt_;
    }


    public void hintenEinfuegen(Person p)
    {
        if (naechster == null)
        {
            naechster = new Knoten(p);
        }
        else
        {
            naechster.hintenEinfuegen(p);
        }
    }
    
    public void setNaechster(Knoten k)
    {
        naechster = k;
    }

    public Knoten getNaechster()
    {
        return naechster;
    }

    public Person getInhalt()
    {
        return inhalt;
    }
    
    
    // Zeichnen des Knotens
    public void zeichnen(GraphicsContext gc, int x){
        // Rechteck Knoten
        gc.strokeRoundRect(x,10,70,30,5,5);
        gc.strokeText(": KNOTEN",x+5,30);
       
          //Pfeil nach rechts
        gc.strokeLine(x+70,25,x+90,25);
        gc.strokeLine(x+85,20,x+90,25);
        gc.strokeLine(x+85,30,x+90,25);
        
        // Rechteck Inhalt
         gc.strokeRoundRect(x,60,70,30,5,5);
         gc.strokeText(": PERSON",x+5,72);
        gc.strokeText("name: " + inhalt.getName(),x+5,84);
        
            //Pfeil nach unten
        gc.strokeLine(x+35,40,x+35,60);
        gc.strokeLine(x+30,55,x+35,60);
        gc.strokeLine(x+40,55,x+35,60);
        
        if (naechster != null)
        {
            naechster.zeichnen(gc,x + 90);
        }
    }
        

}