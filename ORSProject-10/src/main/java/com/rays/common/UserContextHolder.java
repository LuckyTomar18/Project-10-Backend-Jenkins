package com.rays.common;

/**
 * UserContextHolder manages UserContext using ThreadLocal.
 * It ensures that each request/thread has its own user context.
 * 
 * This is useful in multi-threaded environments like web applications
 * where each request is handled by a separate thread.
 * 
 * @author Lucky Tomar
 *
 */
public class UserContextHolder {

	private static final ThreadLocal<UserContext> threadLocal = new ThreadLocal<>();

	/**
	 * Sets the UserContext for the current thread.
	 * 
	 * @param context UserContext object
	 */
	public static void setContext(UserContext context) {
		threadLocal.set(context);
	}

	/**
	 * Gets the UserContext of the current thread.
	 * 
	 * @return UserContext object
	 */
	public static UserContext getContext() {
		return threadLocal.get();
	}

	/**
	 * Clears the UserContext from the current thread.
	 * This should be called after request completion to avoid memory leaks.
	 */
	public static void clear() {
		threadLocal.remove();
	}
}