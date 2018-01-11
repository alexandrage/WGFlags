package wgflags;

import com.sk89q.worldguard.protection.flags.StringFlag;

public class CustomStringFlag extends StringFlag {
	private static CustomStringFlag instance;

	public static CustomStringFlag getInstance() {
		return instance;
	}

	public static void assignInstance() {
		instance = new CustomStringFlag("custom-string-flags");
	}

	protected CustomStringFlag(String name) {
		super(name);
	}
}