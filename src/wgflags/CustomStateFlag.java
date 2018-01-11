package wgflags;

import com.sk89q.worldguard.protection.flags.StateFlag;

public class CustomStateFlag extends StateFlag {
	private static CustomStateFlag instance;

	public static CustomStateFlag getInstance() {
		return instance;
	}

	public static void assignInstance() {
		instance = new CustomStateFlag();
	}

	protected CustomStateFlag() {
		super("custom-state-flag", true);
	}
}