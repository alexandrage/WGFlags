package wgflags;

import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class Flags extends JavaPlugin {
	private static Flags instance;
	private static WorldGuardPlugin wg = null;

	public static WorldGuardPlugin getWorldGuard() {
		return wg;
	}

	public static Flags getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;
		wg = (WorldGuardPlugin) JavaPlugin.getPlugin(WorldGuardPlugin.class);
		CustomStateFlag.assignInstance();
		CustomSetFlag.assignInstance();
		CustomStringFlag.assignInstance();
		CustomIntFlag.assignInstance();
		try {
			FlagRegistration.registerFlag(CustomStateFlag.getInstance());
			FlagRegistration.registerFlag(CustomSetFlag.getInstance());
			FlagRegistration.registerFlag(CustomStringFlag.getInstance());
			FlagRegistration.registerFlag(CustomIntFlag.getInstance());
		} catch (Throwable t) {
			t.printStackTrace();
		}
		getServer().getPluginManager().registerEvents(new EventListener(), this);
	}
}