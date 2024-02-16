// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LimeLightSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;

public class LImeLightAutoDriveCommand extends CommandBase {

  private final LimeLightSubsystem limeLightSubsystem;
  private final DrivetrainSubsystem drivetrainSubsystem;

  public LImeLightAutoDriveCommand(LimeLightSubsystem limelightSubsystem, DrivetrainSubsystem drivetrainSubsystem) {
   
    this.limeLightSubsystem = limelightSubsystem;
    this.drivetrainSubsystem = drivetrainSubsystem;

    addRequirements(limeLightSubsystem, drivetrainSubsystem);
  }

  @Override
  public void initialize() {}


  @Override
  public void execute() {
     if (limeLightSubsystem.doesTheLimeLightHaveATarget()) {
      drivetrainSubsystem.setMotorSpeed(.7);
     }



  }


  @Override
  public void end(boolean interrupted) {}


  @Override
  public boolean isFinished() {
    return false;
  }
}
