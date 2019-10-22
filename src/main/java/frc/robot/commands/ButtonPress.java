package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ButtonPress extends Command {

	public ButtonPress() {
		setTimeout(2);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	public void execute() {
		Robot.move_sub.set(1);
	}
}
