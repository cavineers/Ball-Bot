// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.homing.HomeShooter;
import frc.robot.commands.shooter.AutoShoot;
import frc.robot.commands.shooter.ManualShoot;
import frc.robot.subsystems.DriveTrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public DriveTrain drivetrain = new DriveTrain(null, null, null, null);

  public Command m_autoCommand;
 
  public Command m_autoShoot;
  public Command m_autoShootNoDrive;
  public Command m_manualShoot;
  public Command m_intakeDropLower;
  public Command m_intakeDropRaise;
  public Command m_intake;
  public Command homeOnAngle;

  public Joystick joy = new Joystick(0);
  public JoystickButton a_button = new JoystickButton(joy, 1);
  public JoystickButton b_button = new JoystickButton(joy, 2);
  public JoystickButton x_button = new JoystickButton(joy, 3);
  public JoystickButton y_button = new JoystickButton(joy, 4);
  public JoystickButton l_bump = new JoystickButton(joy, 5);
  public JoystickButton r_bump = new JoystickButton(joy, 6);
  public JoystickButton left_menu = new JoystickButton(joy, 7);
  public JoystickButton right_menu = new JoystickButton(joy, 8);
  public JoystickButton left_stick = new JoystickButton(joy, 9);
  public JoystickButton right_stick = new JoystickButton(joy, 10);

  public POVButton povUp = new POVButton(joy, 0, 0);
  public POVButton povRight = new POVButton(joy, 90, 0);
  public POVButton povDown = new POVButton(joy, 180, 0);
  public POVButton povLeft = new POVButton(joy, 270, 0); 
  
  // The robot's subsystems and commands are defined here...
  public enum CurrentMode {DRIVE}

  public CurrentMode mode = CurrentMode.DRIVE; 
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    this.m_autoShoot = new AutoShoot(Robot.shooter, Robot.limelight).andThen(new HomeShooter());

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

    this.a_button.whenPressed(new InstantCommand() {
      @Override
      public void initialize() {
        // Test this!
        // m_autoShoot = new AutoShoot(Robot.shooter, Robot.limelight).andThen(new HomeShooter());
        if (m_autoShoot.isScheduled()) {
          m_autoShoot.cancel();
        } else {
          m_autoShoot = new AutoShoot(Robot.shooter, Robot.limelight).andThen(new HomeShooter());
          m_autoShoot.schedule(false);
        }
      }
      });
    this.y_button.whenPressed(new InstantCommand() {
      @Override
      public void initialize() {
        if (m_manualShoot.isScheduled()) {
          m_manualShoot.cancel();
        } else {
          m_manualShoot = new ManualShoot(Robot.shooter).andThen(new HomeShooter());
          m_manualShoot.schedule(false);
        }
       }
      });
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
