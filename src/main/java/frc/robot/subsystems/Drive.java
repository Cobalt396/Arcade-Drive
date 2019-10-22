package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Driving;

public class Drive extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new Driving());

	}

	VictorSPX rf_motor;
	VictorSPX lf_motor;

	public Drive() {
		rf_motor = new VictorSPX(5);
		rf_motor.setInverted(true);

		lf_motor = new VictorSPX(6);
		lf_motor.setInverted(true);
	}

	public void set(double v) {
		set(v, v);
	}

	public void set(double l_v, double r_v) {
		rf_motor.set(ControlMode.PercentOutput, Math.max(-1, Math.min(1, r_v)));
		lf_motor.set(ControlMode.PercentOutput, Math.max(-1, Math.min(1, l_v)));
	}

	public void arcadeDrive(double throttle, double rotation) {
		final double epsilon = 0.0001;

		double maxInput = Math.copySign(Math.max(Math.abs(throttle), Math.abs(rotation)), throttle);

		if (throttle * rotation >= 0.0) {
			set(maxInput, throttle - rotation);
		} else {
			set(throttle + rotation, maxInput);
		}

	}
}
