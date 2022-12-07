package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.DriveTrain;

public class TeleopDrive extends CommandBase {
    private DriveTrain driveTrain;
    
    @Override
    public void initialize() {
        // Put numbers on logging platform
    }
    public TeleopDrive(Subsystem[] drive, Joystick joy) {
        this.addRequirements(drive);
    }

    @Override
    public void execute() {
        // Get the joystick to drive forward and turn the robot
        this.driveTrain.driveCartesian(1.0, 0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        this.driveTrain.driveCartesian(0, 0, 0);
    }
}