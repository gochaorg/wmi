package xyz.cofe.win.activex;

import com.jacob.com.ComThread;

import java.util.function.Supplier;

public class Apartment {
    private static class IntThreadLocal extends ThreadLocal<Integer>
    {
        protected Integer initialValue()
        {
            return Integer.valueOf(0);
        }
    }

    private static ThreadLocal<Integer> countMTA = new IntThreadLocal();
    private static ThreadLocal<Integer> countSTA = new IntThreadLocal();

    /**
     * Call the closure in the context of the current apartment model, defaulting
     * to MTA (the more universally applicable threading model)if no apartment
     * model has been defined.<p>
     *
     * This is the preferred way to wrap your code in an apartment context, since
     * it works with either STA or MTA models. If you need to specifically use
     * MTA or STA models, use the {@link #withMTA} or {@link #withSTA} methods.
     * Note that MTA and STA methods do not nest and may not be used together
     * in the same thread.
     *
     * @param closure The closure to call.
     * @return The result of the closure.
     * @see #withMTA
     * @see #withSTA
     */
    public static Object inApartment(Supplier closure)
    {
        if(((Number)countSTA.get()).intValue() > 0)
            return withSTA(closure);
        else
            return withMTA(closure);
    }

    /**
     * Call the closure in the context of an STA. Supports nesting
     * {@code withSTA()} calls, but not {@link #withMTA}. The use of {@code withSTA()}
     * is discouraged, since it appears to cause JVM crashes in testing.
     * @param closure The closure to call.
     * @return The result of the closure.
     * @see #inApartment
     */
    public static Object withSTA(Supplier closure)
    {
        initSTA();
        try
        {
            return closure.get();
        }
        finally
        {
            releaseSTA();
        }
    }

    /**
     * Initialize thread as an STA (for compatibility with Java).  Calling multiple times nests the call - call
     * the release method matching multiple times.  Cannot be used in conjunction with
     * MTA thread.
     */
    public synchronized static void initSTA()
    {
        if(((Integer)countMTA.get()).intValue() > 0)
            throw new ApartmentStateException("Can't initialize STA thread; current thread is MTA.");

        if(((Integer)countSTA.get()).intValue() == 0)
            ComThread.InitSTA();

        countSTA.set(Integer.valueOf(((Integer)countSTA.get()).intValue() + 1));
    }

    /**
     * Releases the STA thread (for compatibility with Java).  Called in conjunction with {@link #initSTA}.
     */
    public synchronized static void releaseSTA()
    {
        if(((Integer)countSTA.get()).intValue() == 0)
            throw new ApartmentStateException("Current thread is not STA.");

        countSTA.set(Integer.valueOf(((Integer)countSTA.get()).intValue() - 1));

        if(((Integer)countSTA.get()).intValue() == 0)
            ComThread.Release();
    }

    /**
     * Call the closure in the context of an MTA.  Supports nesting
     * {@code withMTA()} calls, but not {@link #withSTA}.
     * @param closure The closure to call.
     * @return The result of the closure.
     * @see #inApartment
     */
    public static Object withMTA(Supplier closure)
    {
        initMTA();
        try
        {
            return closure.get();
        }
        finally
        {
            releaseMTA();
        }
    }

    /**
     * Initialize thread as an MTA (for compatibility with Java).  Calling multiple times nests the call - call
     * the release method matching multiple times.  Cannot be used in conjunction with
     * STA thread.
     */
    public synchronized static void initMTA()
    {
        if(((Integer)countSTA.get()).intValue() > 0)
            throw new ApartmentStateException("Can't initialize MTA thread; current thread is STA.");

        if(((Integer)countMTA.get()).intValue() == 0)
            ComThread.InitMTA();

        countMTA.set(Integer.valueOf(((Integer)countMTA.get()).intValue() + 1));
    }

    /**
     * Releases the MTA thread (for compatibility with Java).  Called in conjunction with {@link #initMTA}.
     */
    public synchronized static void releaseMTA()
    {
        if(((Integer)countMTA.get()).intValue() == 0)
            throw new ApartmentStateException("Current thread is not MTA.");

        countMTA.set(Integer.valueOf(((Integer)countMTA.get()).intValue() - 1));

        if(((Integer)countMTA.get()).intValue() == 0)
            ComThread.Release();
    }
}
