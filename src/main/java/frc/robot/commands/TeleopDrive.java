package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.lib.DriveMotion;
import frc.robot.subsystems.DriveTrain;

public class TeleopDrive extends CommandBase {
    private DriveTrain driveTrain;
    private Joystick joystick;
    
    public TeleopDrive(Subsystem[] drive, Joystick joy) {
        this.addRequirements(drive);
    }

    public void execute() {
        // Get the joystick to drive forward and turn the robot
        double drive = -DriveMotion.add(this.joystick.getRawAxis(4), 0.05);
        double steer = DriveMotion.add(this.joystick.getRawAxis(1), 0.05);

        this.driveTrain.driveCartesian(steer, drive, steer);
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