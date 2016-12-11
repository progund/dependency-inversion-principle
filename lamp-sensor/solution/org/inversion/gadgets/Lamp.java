package org.inversion.gadgets;
import java.awt.*;
import javax.swing.*;
import org.inversion.sensor.SensorClient;

public class Lamp implements SensorClient{
  private JComponent component;
  private Color origColor;
  public Lamp(JComponent component){
    this.component = component;
    origColor=component.getBackground();
  }
  public void inside(){
    component.setBackground(Color.RED);
  }
  public void outside(){
    component.setBackground(origColor);
  }
}
