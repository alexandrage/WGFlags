package wgflags;

import java.util.Set;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.sk89q.worldguard.bukkit.RegionQuery;
import com.sk89q.worldguard.protection.flags.BooleanFlag;
import com.sk89q.worldguard.protection.flags.IntegerFlag;
import com.sk89q.worldguard.protection.flags.SetFlag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.flags.StringFlag;

public class WGRegionUtils {
	public static final RegionQuery REGION_QUERY = Flags.getWorldGuard().getRegionContainer().createQuery();

	public static boolean isFlagAllows(Player player, Location location, StateFlag flag) {
		return REGION_QUERY.testState(location, player, flag);
	}

	public static boolean isFlagTrue(Location location, BooleanFlag flag) {
		Boolean bool = REGION_QUERY.queryValue(location, (Player) null, flag);
		return bool != null && bool;
	}

	public static Set<Object> getSetFlags(Player player, Location location, SetFlag<Object> flag) {
		return (Set<Object>) REGION_QUERY.queryValue(location, player, flag);
	}

	public static String getStringFlags(Player player, Location location, StringFlag flag) {
		return REGION_QUERY.queryValue(location, player, flag);
	}
	
	public static Integer getIntFlags(Player player, Location location, IntegerFlag flag) {
		return REGION_QUERY.queryValue(location, player, flag);
	}
}