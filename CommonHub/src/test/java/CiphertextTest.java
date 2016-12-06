import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utilities.Ciphertext;

public class CiphertextTest {

	Ciphertext code = null;
	
	@Before
	public void setUp() throws Exception {
		 code = new Ciphertext();
	}
	
	@Test
	public void testEncrypt() {
		assertEquals("54312",code.encrypt("12345"));
		
		assertEquals("owh12djgf",code.encrypt("12djgfhwo"));
	}
	
	@Test
	public void testDecode() {
		assertEquals("12345",code.decode("54312"));
		
		assertEquals("12djgfhwo",code.decode("owh12djgf"));
	}
	
	@Test
	public void testEncryptChinese() {
		assertEquals("奘寧妮",code.encryptChinese("大家好"));
	}
	
	@Test
	public void testDecodeChinese() {
		assertEquals("大家好",code.decodeChinese("奘寧妮"));
	}

}
