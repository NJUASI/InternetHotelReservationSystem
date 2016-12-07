package utilities;

public class test {

	public static void main(String[] args) {
		Ciphertext ciphertext = new Ciphertext();
//		System.out.println(ciphertext.encrypt("qwertyuiop"));
//		System.out.println(ciphertext.encrypt("董金玉冯俊杰高源龚尘淼"));
//		
//		System.out.println(ciphertext.decode("poiqwertyu"));
//		System.out.println(ciphertext.decode("淼尘龚董金玉冯俊杰高源"));
//		System.out.println("---------------------------------");
//		
		System.out.println(ciphertext.encryptChinese("qwertyuiop  45yuidgf76we28273t4gvbhwqdh  wgefwe[]s,.<>"));
		System.out.println(ciphertext.encryptChinese("DJY董金玉冯俊杰高源龚尘淼   南京大学仙林校区aaab和 v 的回复kkkkk"));
		System.out.println(ciphertext.encryptChinese("DJY董金玉冯俊杰高源龚尘淼   南京大学仙林校区aaab和 v 的回复"));
		System.out.println(ciphertext.encryptChinese("DJY"));
		
		System.out.println(ciphertext.decodeChinese("¢¨£¥ª¦ ¡QQefª¦hg¨cichd¥e§¨¢QQ¨¨¤]_mo"));
		System.out.println(ciphertext.decodeChinese("u{蒔鈂玺几俻枡鬉滁鿋屉渭QQQ厈仝奘宗伊柈桒卫咽Q§Q皵圏夾"));
		System.out.println(ciphertext.decodeChinese("u{蒔鈂玺几俻枡鬉滁鿋屉渭QQQ厈仝奘宗伊柈桒卫咽Q§Q皵圏夾"));
		System.out.println(ciphertext.decodeChinese("u{"));

		
	}
}
