// Copyright (c) FIRST and other WPILib contrebutors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

  
public class ElbowSubsystem extends SubsystemBase {
  CANSparkMax elbowWindowMotor1 = new CANSparkMax(5, MotorType.kBrushed);
  CANSparkMax elbowWindowMotor2 = new CANSparkMax(6, MotorType.kBrushed);
  Encoder elbowEncoder = new Encoder(0, 1);



  /** Creates a new ElbowSubsystem. */
  public ElbowSubsystem() {
    elbowEncoder.setDistancePerPulse(360/2048);
    
  }

  public double getEncoderValueDegree (){
    return elbowEncoder.getDistance();
  }

  public void resetEncoderValue() {
    elbowEncoder.reset();
  }

  public void setMotorSpeed (double Speed){
    elbowWindowMotor1.set(Speed);
    elbowWindowMotor2.set(Speed);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("elbowEncoder.getDistance()", elbowEncoder.getDistance());
  }
}
