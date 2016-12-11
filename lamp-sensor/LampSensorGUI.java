import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Lamp{
  private JPanel area;
  private boolean isOn;
  public Lamp(JPanel area){
    this.area = area;
  }
  public boolean isOn(){ return isOn; }
  public void turnOn(){
    isOn=true;
    area.setBackground(Color.RED);
  }
  public void turnOff(){
    area.setBackground(Color.GREEN);
    isOn=false;
  }
}
class LampSensor extends MouseAdapter{
  private Lamp lamp;
  public LampSensor(Lamp lamp){ this.lamp = lamp; }
  public void mouseEntered(MouseEvent me){
    //if(!lamp.isOn()){
      lamp.turnOn();
      //}
  }
  public void mouseExited(MouseEvent me){
    //if(lamp.isOn()){
      lamp.turnOff();
      //}
  }
}
public class LampSensorGUI{
  private LampSensor lampSensor;
  private JPanel sensorArea;
  private JPanel west;
  private JPanel east;
  private JPanel north;
  private JPanel south;
  private JFrame frame;
  private JLabel outsideS, outsideW, outsideE,outsideN;
  private JLabel detection;
  Lamp lamp;
  public LampSensorGUI(){
    initComponents();
    layoutComponents();
    frame.setVisible(true);
  }
  private void initComponents(){
    frame = new JFrame("Layout changer");
    frame.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(500,500));
    sensorArea = new JPanel();
    west = new JPanel();
    east = new JPanel();
    north = new JPanel();
    south = new JPanel();
    sensorArea = new JPanel();
    outsideW = new JLabel("Outside detection");
    outsideE = new JLabel("Outside detection");
    outsideS = new JLabel("Outside detection");
    outsideN = new JLabel("Outside detection");
    detection = new JLabel("Detection area");
    sensorArea.setBackground(Color.GREEN);
    lamp=new Lamp(sensorArea);
    lampSensor = new LampSensor(lamp);
    sensorArea.addMouseListener(lampSensor);
  }
  private void layoutComponents(){
    west.add(outsideW);
    east.add(outsideE);
    north.add(outsideN);
    south.add(outsideS);
    sensorArea.add(detection);
    frame.add(sensorArea, BorderLayout.CENTER);
    frame.add(west, BorderLayout.WEST);
    frame.add(east, BorderLayout.EAST);
    frame.add(south, BorderLayout.SOUTH);
    frame.add(north, BorderLayout.NORTH);
    frame.pack();
  }
  public static void main(String[] args){
    new LampSensorGUI();
  }
}
