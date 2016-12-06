package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Detector {

	private String expression; //存放正则表达式
	
	public static void main(String []args){
		Detector a= new Detector();
		System.out.println(a.infoDetector("董金玉gigudg123456"));
	} 
	
	public  boolean idDetector(String express, int length){
		
		expression = "[0-9]{"+String.valueOf(length)+"}";
		
		return this.getResultOfDetector(express); //得到与指定长度匹配的数字
	}
	
	public  boolean passwordDetector(String express){
		
		expression = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
		
		return this.getResultOfDetector(express); //密码必须是数字与字母的组合
	}
	
	public boolean phoneDetector(String express){
		expression = "[0-9]{11}";
		
		return this.getResultOfDetector(express);
	}
	
	public boolean infoDetector(String express){ //统一检测填写信息内容中的不合法标识符
		expression = "^[\u4e00-\u9fa5_a-zA-Z0-9]+$";
		
		return this.getResultOfDetector(express);
	}
	
	public boolean discoutDetector(String express){ //折扣只允许单数字
		expression = "[0-9]{1}";
		
		return this.getResultOfDetector(express);
	}
	
	private boolean getResultOfDetector(String express){
		
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(express);
		boolean result = matcher.matches(); 
		
		return result; //得到匹配正则表达式的结果
	}
	
}
