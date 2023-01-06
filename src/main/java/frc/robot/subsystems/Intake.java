package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase{

    public enum IntakeDoorState{
        OPEN,
        CLOSED
    }
    
    public CANSparkMax m_intakeLeftDoor = new CANSparkMax(Constants.Intake.IntakeID, MotorType.kBrushless);
    public CANSparkMax m_intakeRightDoor = new CANSparkMax(Constants.Intake.IntakeID, MotorType.kBrushless);
    public IntakeDoorState m_intakeDoorState = IntakeDoorState.CLOSED;

    public Intake() {
        this.setDoorState(IntakeDoorState.CLOSED);
    }

    public void setDoorState (IntakeDoorState state) {
        this.m_intakeDoorState = state;
    }

    public IntakeDoorState getDoorState() {
        return this.m_intakeDoorState;
    }

}
