package org.inversion.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.inversion.sensor.Sensor;
import org.inversion.sensor.SensorClient;
import org.inversion.sensor.MotionSensor;
import org.inversion.gadgets.Lamp;

public class LampSensorGUI{
  private JPanel sensorArea;
  private JPanel west;
  private JPanel east;
  private JPanel north;
  private JPanel south;
  private JFrame frame;
  private JLabel outsideS, outsideW, outsideE,outsideN;
  private JLabel detection;
  private Sensor lampSensor;
  private SensorClient lamp;
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
    lamp=new Lamp(south);
    lampSensor = new MotionSensor(north);
    lampSensor.setClient(lamp);
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
