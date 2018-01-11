package wgflags;

import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.SetFlag;

public class CustomSetFlag extends SetFlag<Object> {

	private static CustomSetFlag instance;

	public static CustomSetFlag getInstance() {
		return instance;
	}

	public static void assignInstance() {
		instance = new CustomSetFlag("custom-set-flags", new SFlag(null));
	}

	public CustomSetFlag(String name, Flag<Object> subFlag) {
		super(name, subFlag);
	}
}