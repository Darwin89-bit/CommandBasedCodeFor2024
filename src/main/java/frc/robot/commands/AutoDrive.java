// Copyright (c) FIRST and other WPILib contrebutors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class AutoDrive extends CommandBase {
private final DrivetrainSubsystem drivetrainSubsystem;
private final double distance;
private double encoderSetPoint;

  /** Creates a new AutoDrive. */
  public AutoDrive(DrivetrainSubsystem drivetrainSubsystem, double distance) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrainSubsystem = drivetrainSubsystem;
    this.distance = distance;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrainSubsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    encoderSetPoint = drivetrainSubsystem.getEncoderValue() + distance;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrainSubsystem.setMotorSpeed(.2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrainSubsystem.setMotorSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (drivetrainSubsystem.getEncoderValue()<encoderSetPoint){
      return true;
    }
    else {
      return false;
    }
  }
}
