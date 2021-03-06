
import java.awt.*;
import java.util.*;


//////////////////////////
// Controller

/*------------------------------------------*/
class TemperatureController1 extends Button
/*------------------------------------------*/
{
  private Dimension preferredSize = new Dimension(350,40);
  private TemperatureModel tempModel;
  private int maxTempF = TemperatureModel.MAX_TEMP_F;

  public TemperatureController1()
    {
      System.out.println("--->Creating TemperatureController1");
      setForeground(Color.blue);
      setLabel("Switch temperature (0-"+maxTempF+"F)");

      tempModel = new TemperatureModel();
    }

  public Dimension preferredSize(){ return preferredSize; }

  public boolean action(Event evt, Object arg) 
  {
      tempModel.setTemperature((int)(Math.random()*maxTempF));

      return true;
    }    

  public void addObserver(Observer obs)
    {
      System.out.println("TemperatureController1: addObserver: "+obs.toString());
      tempModel.addObserver(obs);
      //Initialize the view.
      obs.update(tempModel,this); 
    }
  
  public TemperatureModel getModel() { return tempModel; }

} 

