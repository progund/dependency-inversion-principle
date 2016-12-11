package org.inversion.sensor;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
public class MotionSensor extends MouseAdapter implements Sensor{
  private SensorClient client;
  private JComponent area;
  public MotionSensor(JComponent area){
    this.area = area;
    //System.out.println(area);
    area.addMouseListener(this);
    // Cool if it detects also movement while inside
    area.addMouseMotionListener(this);
    
  }
  public void setClient(SensorClient client){
    this.client = client;
  }
  public void sendDetected(){
    client.inside();
    Timer t = new Timer();
    t.schedule(new TimerTask(){
        public void run(){
          sendUndetected();
        }
      }, 2000);
  }
  public void sendUndetected(){
    client.outside();    
  }
  public void mouseEntered(MouseEvent me){
    sendDetected();
  }
  public void mouseExited(MouseEvent me){
    sendUndetected();
  }
  @Override
  public void mouseMoved(MouseEvent me){
    Point mousePos = MouseInfo.getPointerInfo().getLocation();
    Rectangle bounds = area.getBounds();
    bounds.setLocation(area.getLocationOnScreen());
    //System.out.println(bounds);
    if(bounds.contains(mousePos)){
      sendDetected();
    }
  }
}
