package practise;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Thirdtestcase {
	@Test
	public void run() {
		Assert.assertEquals(5, 5);
	}
	@DataProvider(name="somedata")
	public String[][] getdata(){
		return new String[][] {
			{"user1","user2"},
			{"password1","password2"}
		};
	}
	@Test(dataProvider="somedata")
	public void run1(String username,String password) {
		System.out.println(username+" "+password);
	}
	@Test
	public void run2() {
		System.out.println("hello");	
	}
}
