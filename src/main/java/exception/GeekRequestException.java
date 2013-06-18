package exception;

public class GeekRequestException extends Exception {

	private String message;
	
	public GeekRequestException() {
		message = "Exception générée.";
	}
	public GeekRequestException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
