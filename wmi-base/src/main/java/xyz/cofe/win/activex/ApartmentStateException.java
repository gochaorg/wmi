package xyz.cofe.win.activex;

/**
 * Apartment thread is in the wrong state for this function.
 */
public class ApartmentStateException extends RuntimeException {
    private static final long serialVersionUID = -6900255369764050739L;

    public ApartmentStateException(String message)
    {
        super(message);
    }
}
