package exception.inputException;

/**
 * @Description:输入非法抛出该异常
 * @author:Harvey Gong
 * @lastChangedBy:Harvey Gong
 * @time:2016年12月6日 下午4:38:40
 */
public class InvalidInputException extends Exception {

	@Override
	public void printStackTrace() {
		System.out.println("非法输入");
	}
}
