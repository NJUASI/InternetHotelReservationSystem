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
		assertEquals("奘寧妮",code.encrypt("大家好"));
	}
	
	@Test
	public void testDecode() {
		assertEquals("大家好",code.decode("奘寧妮"));
	}

}
