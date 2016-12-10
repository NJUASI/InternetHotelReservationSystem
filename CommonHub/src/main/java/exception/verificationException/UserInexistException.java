package exception.verificationException;

public class UserInexistException extends Exception{

	@Override
	public void printStackTrace() {
		System.out.println("查找的用户不存在");
	}
	
	
}
