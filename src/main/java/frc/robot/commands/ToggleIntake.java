package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Intake;

public class ToggleIntake extends CommandBase{

    public ToggleIntake() {
        this.addRequirements(Robot.intake);
    }

    public void execute() {
        if(Robot.intake.getDoorState() == Intake.IntakeDoorState.CLOSED) {
            Robot.intake.setDoorState(Intake.IntakeDoorState.OPEN);
        } else {
            Robot.intake.setDoorState(Intake.IntakeDoorState.CLOSED);
          }
    }
}
