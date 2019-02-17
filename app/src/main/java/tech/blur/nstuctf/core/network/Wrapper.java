package tech.blur.nstuctf.core.network;

public class Wrapper<T> {

    private String status;
    private String message;
    private T data;

    public Wrapper(T data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
