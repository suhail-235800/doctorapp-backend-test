package in.doctorbooking.ust.exceptions;


public class DoctorAlreadyExistsException extends RuntimeException{

    private String uri;

    public DoctorAlreadyExistsException(){

    }
    public DoctorAlreadyExistsException(String message, String uri) {
        super(message);
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
