package isp.lab7.safehome;

public class TooManyAttemptsException extends Exception {
    public TooManyAttemptsException(String s) {
        super(s);
    }
}
