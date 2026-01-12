package java_test;

public class NoRecordFoundException extends RuntimeException{

	public NoRecordFoundException() {

	}

	public NoRecordFoundException(String msg) {
       super(msg);
	}
}
