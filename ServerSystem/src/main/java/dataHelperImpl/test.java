package dataHelperImpl;

public class test {

	public static void main(String[] args) {
		String aString = "fhuidscgh哈哈哈哈哈结婚噶付敬文倒海翻江收到你们不是不   hsgdfhd //hbbfdshj";
		char[] b = aString.toCharArray();
		String result = "";
		for (int i = 0; i < b.length; i++) {
			b[i] -= 11;
			result += b[i];
		}
		System.out.println(result);
		
		char[] cs= result.toCharArray();
		String kk = "";
		for (int i = 0; i < cs.length; i++) {
			cs[i] += 11;
			kk += cs[i];
		}
		System.out.println(kk);
		
		System.out.println(String.valueOf(false));
	}
}
