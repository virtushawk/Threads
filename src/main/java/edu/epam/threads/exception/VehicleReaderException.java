package edu.epam.threads.exception;

public class VehicleReaderException extends Exception {
    public VehicleReaderException() {
    }

    public VehicleReaderException(String message) {
        super(message);
    }

    public VehicleReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleReaderException(Throwable cause) {
        super(cause);
    }
}
