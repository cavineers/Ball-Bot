// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static class CANIds {
        public static int ShooterAngle          = 11;  // ShooterAngle(neo)
        public static int ShooterFeeder         = 12;  // FeederWheel (minineo)
        public static int ShooterMotor          = 13;  // FlyWheel (neo)
    }

    public static class DriveTrain {
        public static int kFrontLeftChannel;
        public static int kFrontRightChannel;
        public static int kBackLeftChannel;
        public static int kBackRightChannel;
    }

    public static class getChannel{

    }
    

    public static class Shooter {
        public static double shooterVelocityConstant = 0;
        public static int ShooterMotor = CANIds.ShooterMotor;
        public static int ShooterAngle = CANIds.ShooterAngle;
        public static int ShooterFeeder = CANIds.ShooterFeeder;

        // Angles
        public static double shooterAngleLow = 67;
        public static double shooterAngleMedium = 69;
        public static double shooterAngleHigh = 78;

        public static double shooterHeight = Units.inchesToMeters(38); // 12.4

        public static double degreesPerRevolution = 3.327; // 1.625 on 100:1 with 2:1 increase
        public static double flywheelRotationsPerRevolution = .2;

        public static double flywheelRadius = .0508; //checked with shooter, 2 in = .0508 m

        public static double kP = 0.00072; // 0.0008; Proportional
        public static double kI = 0.0; // 0.0; Integral
        public static double kD = 0.0204; // 0.009; Derivative
        public static double kF = 0.000204; // 0.000206; Feed Forward

        public static double angleSpeed = 0.25; // Angle motor speed 0-1 bounds 0.1
        public static double feederSpeed = 1.00; // Angle motor speed 0-1 bounds
        
        // Feederwheel distances - Right to wall => 1.68 inches
        // Left to wall => 1.51 inches
        // Distance between => 5.07 inches
    }
    public static class Targeting {
        public static double kFieldGoalHeightFromGroundIn = 103; // Math constants 104
        public static double kLimelightHeightFromGroundIn = 23.6; // vertical distance from limelight to ground
    
        public static double kFieldGoalHeightFromGround = Units.inchesToMeters(kFieldGoalHeightFromGroundIn); // Math constants
        public static double kLimelightHeightFromGround = Units.inchesToMeters(kLimelightHeightFromGroundIn); // vertical distance from limelight to ground
        public static double kLimelightMountingAngle    = 32.8;
    }
    
    public static class DIO {
        public static int IntakeSensor = 0;
        public static int ElevatorSwitchRight = 1;
        public static int ElevatorSwitchLeft = 6;
        public static int ClimberAngleSwitchRight = 2;
        public static int ClimberAngleSwitchLeft = 4;
        public static int BallSensorShooter = 9;
    }
}
