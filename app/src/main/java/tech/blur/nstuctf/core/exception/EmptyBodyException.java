package tech.blur.nstuctf.core.exception;

public final class EmptyBodyException extends IllegalStateException {

    public EmptyBodyException() {
        super("Body is empty");
    }

}
