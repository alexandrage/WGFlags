package wgflags;

import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.registry.FlagRegistry;
import com.sk89q.worldguard.protection.flags.registry.UnknownFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import java.util.Map;

public class FlagRegistration {

	@SuppressWarnings("unchecked")
	public static void registerFlag(Flag<?> flag)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		FlagRegistry registry = Flags.getWorldGuard().getFlagRegistry();
		Map<String, Flag<?>> flagMap = ReflectionUtils.getField(registry, "flags");
		Flag<?> prevFlag = flagMap.put(flag.getName().toLowerCase(), flag);
		if (prevFlag != null) {
			for (RegionManager rm : Flags.getWorldGuard().getRegionContainer().getLoaded()) {
				for (ProtectedRegion region : rm.getRegions().values()) {
					Map<Flag<?>, Object> flags = region.getFlags();
					Object prevValue = flags.remove(prevFlag);
					if (prevValue != null) {
						if (prevFlag instanceof UnknownFlag) {
							try {
								Object unmarshalled = flag.unmarshal(prevValue);
								if (unmarshalled != null) {
									flags.put(flag, unmarshalled);
								}
							} catch (Throwable t) {
							}
						} else {
							try {
								((Flag<Object>) flag).marshal(prevValue);
								flags.put(flag, prevValue);
							} catch (Throwable t) {
							}
						}
						region.setDirty(true);
					}
				}
			}
		}
	}
}