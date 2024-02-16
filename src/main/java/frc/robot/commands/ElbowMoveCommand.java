// Copyright (c) FIRST and other WPILib contrebutors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElbowSubsystem;

public class ElbowMoveCommand extends CommandBase {
private final ElbowSubsystem elbowSubsystem;


  /** Creates a new ElbowMoveCommand. */
  public ElbowMoveCommand( ElbowSubsystem elbowSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.elbowSubsystem = elbowSubsystem;
 

    addRequirements(elbowSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }
  int pov;
  boolean aButton;
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    pov = RobotContainer.joystick.getPOV();
    aButton = RobotContainer.joystick.getRawButtonPressed(2);
    if (90<pov && pov<270){
      elbowSubsystem.setMotorSpeed(-1);
    } else if ((pov<90 && pov>=0  )|| (pov>270 && pov<=360) ) {
      elbowSubsystem.setMotorSpeed(1);
    }  else {
      elbowSubsystem.setMotorSpeed(0);
    }

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
