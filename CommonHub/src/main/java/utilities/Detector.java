package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Byron Dong lastChangedBy Byron Dong updateTime 2016/12/6
 *
 */
public class Detector {

	private String expression; //存放正则表达式
	
	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/6
	 * @param express
	 *            传入需要检查不合法符号的ID
	 * @param length
	 *            id的长度
	 * @return boolean 是否符合要求规范
	 */
	public  boolean idDetector(String express, int length){
		
		expression = "[0-9]{"+String.valueOf(length)+"}";
		
		return this.getResultOfDetector(express); //得到与指定长度匹配的数字
	}
	
	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/6
	 * @param express
	 *            传入需要检查不合法符号的密码
	 * @return boolean 是否符合要求规范
	 */
	public  boolean passwordDetector(String express){
		
		expression = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
		
		return this.getResultOfDetector(express); //密码必须是数字与字母的组合
	}
	
	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/6
	 * @param express
	 *            传入需要检查不合法符号的电话
	 * @return boolean 是否符合要求规范
	 */
	public boolean phoneDetector(String express){
		expression = "[0-9]{11}";
		
		return this.getResultOfDetector(express);
	}
	
	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/6
	 * @param express
	 *            传入需要检查不合法符号的信息内容
	 * @return boolean 是否符合要求规范
	 */
	public boolean infoDetector(String express){ //统一检测填写信息内容中的不合法标识符
		expression = "^[\u4e00-\u9fa5_a-zA-Z0-9]+$";
		
		return this.getResultOfDetector(express);
	}
	
	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/6
	 * @param express
	 *            传入需要检查不合法符号的折扣
	 * @return boolean 是否符合要求规范
	 */
	public boolean discoutDetector(String express){ //折扣只允许单数字
		expression = "[0-9]{1}";
		
		return this.getResultOfDetector(express);
	}
	
	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/6
	 * @param express
	 *            传入需要检查不合法符号的表达式
	 * @return boolean 是否符合要求规范
	 */
	private boolean getResultOfDetector(String express){
		
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(express);
		boolean result = matcher.matches(); 
		
		return result; //得到匹配正则表达式的结果
	}
	
}
