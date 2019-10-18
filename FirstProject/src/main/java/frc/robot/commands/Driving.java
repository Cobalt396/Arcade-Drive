package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Driving extends Command {

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	public void execute() {
		double t = Robot.m_oi.getForward();
		double r = Robot.m_oi.getTurn();
		Robot.move_sub.arcadeDrive(t, r);
	}
}
