
public class MyException extends Exception {
	public MyException() {
		super();
	}
	public MyException(String msg) {
		super(msg);
	}
	
	// 기능 추가
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
