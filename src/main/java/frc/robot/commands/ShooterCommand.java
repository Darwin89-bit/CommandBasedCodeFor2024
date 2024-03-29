// Copyright (c) FIRST and other WPILib contrebutors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends CommandBase {
  private final ShooterSubsystem shooterSubsystem;
  /** Creates a new ShooterCommand. */
  
  public ShooterCommand(ShooterSubsystem shooterSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooterSubsystem = shooterSubsystem;

    addRequirements(shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override 
  public void initialize() {}

boolean xButton;
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    xButton = RobotContainer.joystick.getRawButton(1);
    if (xButton){
      shooterSubsystem.setMotorSpeed(1);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
