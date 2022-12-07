package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;


public class DriveTrain {

  private MecanumDrive mecanumDrive;

  public void Joystick(){
    
  }
  public enum modes{
    CARTESIAN,
    POLAR
  }
  public void driveCartesian(double ySpeed, double xSpeed, double zRotation) {
    this.mecanumDrive.driveCartesian(ySpeed, xSpeed, zRotation);
  }
  public void drivePolar(double magnitude, double angle, double zRotation) {
    this.mecanumDrive.drivePolar(magnitude, angle, zRotation);
  }

  public void robotInit() {
          PWMSparkMax frontLeft = new PWMSparkMax(0);
          PWMSparkMax backLeft = new PWMSparkMax(1);
          PWMSparkMax frontRight = new PWMSparkMax(2);
          PWMSparkMax backRight = new PWMSparkMax(2);
      
          // Invert the right side motors.
          // You may need to change or remove this to match your robot.
          frontRight.setInverted(true);
          backRight.setInverted(true);
      
          DriveTrain m_robotDrive = new DriveTrain(frontLeft, backLeft, frontRight, backRight);
      
          Joystick m_stick = new Joystick(0);
        }
  
  
  public DriveTrain(Joystick joy) {
  }

  public DriveTrain(PWMSparkMax frontLeft, PWMSparkMax backLeft, PWMSparkMax frontRight, PWMSparkMax backRight) {
  }

}
