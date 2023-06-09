package in.doctorbooking.ust.exceptions;

public class RatingNotFoundException extends RuntimeException {
    private String uri;
    public RatingNotFoundException(){}

    public RatingNotFoundException(String movieNotFound, String toUriString) {
        super(movieNotFound);
        this.uri = uri;
    }

    public String getUri(){
        return uri;
    }
}
