import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utilities.Detector;

public class DetectorTest {
	
	Detector detector = null;
	
	@Before
	public void setUp() throws Exception {
		this.detector =  new Detector();
		
	}

	@Test
	public void testIdDetector() {
		assertEquals(true,this.detector.idDetector("123456789012", 12));
		assertEquals(true,this.detector.idDetector("1234567890", 10));
		assertEquals(true,this.detector.idDetector("12345678", 8));
		assertEquals(true,this.detector.idDetector("123456", 6));
		assertEquals(true,this.detector.idDetector("1234", 4));
		assertEquals(false,this.detector.idDetector("12345678*012", 12));
		assertEquals(false,this.detector.idDetector("123456AS90", 10));
	}
	
	@Test
	public void testPasswordDetector() {
		assertEquals(true,this.detector.passwordDetector("1234567890DJY"));
		assertEquals(false,this.detector.passwordDetector("12345678*012"));
		assertEquals(false,this.detector.passwordDetector("AS"));
		assertEquals(false,this.detector.passwordDetector("123456789"));
	}
	
	@Test
	public void testPhoneDetector() {
		assertEquals(true,this.detector.phoneDetector("13589183321"));
		assertEquals(false,this.detector.phoneDetector("12345678"));
		assertEquals(false,this.detector.phoneDetector("AS"));
		assertEquals(false,this.detector.phoneDetector("12345*****"));
	}
	
	@Test
	public void testInfoDetector() {
		assertEquals(true,this.detector.infoDetector("rujiadon"));
		assertEquals(true,this.detector.infoDetector("如家"));
		assertEquals(true,this.detector.infoDetector("AS"));
		assertEquals(false,this.detector.infoDetector("12345*****"));
	}
	
	@Test
	public void testDiscoutDetector() {
		assertEquals(true,this.detector.discoutDetector("9"));
		assertEquals(false,this.detector.discoutDetector("*"));
		assertEquals(true,this.detector.discoutDetector("6"));
		assertEquals(false,this.detector.discoutDetector("12345*****"));
	}

}
