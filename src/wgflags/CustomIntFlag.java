package wgflags;

import com.sk89q.worldguard.protection.flags.IntegerFlag;

public class CustomIntFlag extends IntegerFlag {
	private static CustomIntFlag instance;

	public static CustomIntFlag getInstance() {
		return instance;
	}

	public static void assignInstance() {
		instance = new CustomIntFlag("custom-int-flags");
	}

	protected CustomIntFlag(String name) {
		super(name);
	}
}