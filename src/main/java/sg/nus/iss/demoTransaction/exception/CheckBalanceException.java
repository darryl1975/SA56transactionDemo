package sg.nus.iss.demoTransaction.exception;

public class CheckBalanceException extends SystemException {
    
    public CheckBalanceException(String message, String errorCode) {
		super(message, errorCode);
	}
}
