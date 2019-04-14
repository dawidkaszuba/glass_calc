package pl.dawidkaszuba.glasscalc.errors;

public class ErrorGlass {
    private String message;

    public ErrorGlass(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
