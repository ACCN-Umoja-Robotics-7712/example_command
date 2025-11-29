// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    SparkMax coralIntakeMotor;
    DigitalInput intakeSensor = new DigitalInput(1);

    public IntakeSubsystem() {
        coralIntakeMotor = new SparkMax(1, MotorType.kBrushless);
    }

    public void setIntakeSpeed(double speed) {
        coralIntakeMotor.set(speed);
    }

    public boolean isGamePieceDetected() {
        return !intakeSensor.get();
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Intake Sensor", isGamePieceDetected());
    }
}
