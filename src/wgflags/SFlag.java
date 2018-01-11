package wgflags;

import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.FlagContext;
import com.sk89q.worldguard.protection.flags.InvalidFlagFormat;

public class SFlag extends Flag<Object> {

	protected SFlag(String name) {
		super(name);
	}

	@Override
	public Object marshal(Object o) {
		return (String) o;
	}

	@Override
	public Object parseInput(FlagContext context) throws InvalidFlagFormat {
		return context.getUserInput().trim();
	}

	@Override
	public Object unmarshal(Object o) {
		if (o instanceof String) {
			return (String) o;
		}
		return null;
	}
}