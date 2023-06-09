package in.doctorbooking.ust.exceptions;

public class AppointmentAlreadyExistsException extends RuntimeException{

    private String uri;

    public AppointmentAlreadyExistsException(){

    }
    public AppointmentAlreadyExistsException(String message, String uri) {
        super(message);
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
