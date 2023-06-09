package in.doctorbooking.ust.exceptions;

public class AppointmentNotFoundException extends RuntimeException {
    private String uri;
    public AppointmentNotFoundException(){}

    public AppointmentNotFoundException(String movieNotFound, String toUriString) {
        super(movieNotFound);
        this.uri = uri;
    }

    public String getUri(){
        return uri;
    }
}
