package org.inversion.sensor;
public interface Sensor{
  public void setClient(SensorClient client);
  public void sendDetected();
  public void sendUndetected();
}
