package wgflags;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public class ReflectionUtils {
	@SuppressWarnings("unchecked")
	public static <T> T getField(Object obj, String fieldName)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		return (T) getField(obj.getClass(), fieldName).get(obj);
	}

	public static Field getField(Class<?> clazz, String fieldName) throws NoSuchFieldException, SecurityException {
		return setAccessible(clazz.getDeclaredField(fieldName));
	}

	public static <T extends AccessibleObject> T setAccessible(T object) {
		object.setAccessible(true);
		return object;
	}
}