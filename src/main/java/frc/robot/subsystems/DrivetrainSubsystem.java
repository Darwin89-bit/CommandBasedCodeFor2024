// Copyright (c) FIRST and other WPILib contrebutors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase {
  CANSparkMax leftFrontMotor = new CANSparkMax(Constants.DriveTrainConstants.leftFrontCANID, MotorType.kBrushless);
  CANSparkMax leftBackMotor = new CANSparkMax(Constants.DriveTrainConstants.leftBackCANID, MotorType.kBrushless);
  CANSparkMax rightFrontMotor = new CANSparkMax(Constants.DriveTrainConstants.rightFrontCANID, MotorType.kBrushless);
  CANSparkMax rightBackMotor = new CANSparkMax(Constants.DriveTrainConstants.rightBackCANID, MotorType.kBrushless);

  RelativeEncoder leftEncoder = leftFrontMotor.getEncoder();
  RelativeEncoder righEncoder = rightFrontMotor.getEncoder();
  

  MotorControllerGroup leftControllerGroup = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
  MotorControllerGroup rightControllerGroup = new MotorControllerGroup(rightFrontMotor, rightBackMotor);
    
  DifferentialDrive differentialDrive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);
    
  /** Creates a new ExampleSubsystem. */
  public DrivetrainSubsystem() {
    leftFrontMotor.restoreFactoryDefaults();
    leftBackMotor.restoreFactoryDefaults();
    rightFrontMotor.restoreFactoryDefaults();
    rightBackMotor.restoreFactoryDefaults();
    
    leftEncoder.setPosition(0);
    righEncoder.setPosition(0);
    
    leftBackMotor.follow(leftFrontMotor);
    rightBackMotor.follow(rightFrontMotor);
    
    rightControllerGroup.setInverted(true);
    leftControllerGroup.setInverted(true);
  }
    
  public void arcadeDrive(double fwd, double rot) {
    differentialDrive.arcadeDrive(fwd, rot);
  }

  public double getEncoderValue(){
    double x = (leftEncoder.getPosition() + righEncoder.getPosition())/2;
    return x;
  }

  public void setMotorSpeed(double Speed){
    rightControllerGroup.set(Speed);
    leftControllerGroup.set(Speed);
  }

  
  @Override
  public void periodic() {
  // This method will be called once per scheduler run
  }    
}
    
