package businessLogic.memberBL;

import static org.junit.Assert.*;
import java.time.LocalDate;

import org.junit.Test;

import exception.verificationException.UserInexistException;
import utilities.*;
import utilities.enums.MemberType;
import utilities.enums.ResultMessage;
import vo.MemberVO;

/**
 * 
 * @author 董金玉
 * lastChangedBy 董金玉
 * test the all method of memberBL
 * updateTime 2016/11/28
 *
 */
public class MemberTest {
	
	private Member member = new Member();
	
	@Test
	public void testAdd() {
		//test the method add
		LocalDate time = LocalDate.of(1995, 01, 01);
		MemberVO memberVO = new MemberVO("1234567890",time,"金鹰");
		
		assertEquals(member.add(memberVO), ResultMessage.SUCCESS);
	}
	
	@Test
	public void testModify() {
		//test the method modify
		LocalDate time = LocalDate.of(1995, 01, 01);
		MemberVO memberVO = new MemberVO("1234567890",time,"金鹰");
		
		assertEquals(member.modify(memberVO), ResultMessage.SUCCESS);
	}
	
	@Test
	public void testGetMemberInfo() {
		//test the method getMemberInfo
		LocalDate time = LocalDate.of(1995, 01, 01);
		MemberVO memberVO;
		try {
			memberVO = member.getMemberInfo("1234567890");
			assertEquals(memberVO.guestID, "1234567890");
			assertEquals(memberVO.birthday, time);
			assertEquals(memberVO.enterprise, "school");
		} catch (UserInexistException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testIsMember() {
		//test the method isMember 
		try {
			assertEquals(member.isMember("1234567890", MemberType.BOTH),true);
		} catch (UserInexistException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetMemberType() {
		//test the method getMemberType
		try {
			assertEquals(member.getMemberType("1234567890"),MemberType.BOTH);
		} catch (UserInexistException e) {
			e.printStackTrace();
		}
	}

}
