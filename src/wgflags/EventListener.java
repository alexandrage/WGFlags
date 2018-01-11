package wgflags;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventListener implements Listener {

	@EventHandler
	public void on(PlayerInteractEvent e) {
		System.out.println(WGRegionUtils.isFlagAllows(e.getPlayer(), e.getPlayer().getLocation(), CustomStateFlag.getInstance()));
		System.out.println(WGRegionUtils.getSetFlags(e.getPlayer(), e.getPlayer().getLocation(), CustomSetFlag.getInstance()));
		System.out.println(WGRegionUtils.getStringFlags(e.getPlayer(), e.getPlayer().getLocation(), CustomStringFlag.getInstance()));
		System.out.println(WGRegionUtils.getIntFlags(e.getPlayer(), e.getPlayer().getLocation(), CustomIntFlag.getInstance()));
	}
}