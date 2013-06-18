package exception;

public class GeekRequestException extends Exception {

	private String message;
	
	public GeekRequestException() {
		message = "Exception g�n�r�e.";
	}
	public GeekRequestException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
