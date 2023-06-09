package in.doctorbooking.ust.exceptions;

public class DoctorNotFoundException extends RuntimeException {
    private String uri;
    public DoctorNotFoundException(){}

    public DoctorNotFoundException(String movieNotFound, String toUriString) {
        super(movieNotFound);
        this.uri = uri;
    }

    public String getUri(){
        return uri;
    }
}
