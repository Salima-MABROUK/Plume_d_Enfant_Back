import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.web.context.WebApplicationContext;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlumedenfantTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	void testMailValidity() {
		System.out.println("testMailValidity");
		String email = "absc356@provider.com";
	    assertTrue(email.matches(".+@.+\\.[a-z]+"));
	}
	
	@Test
	void testMotDePasse() {
		System.out.println("testMotDePasse");
		String motDePasse = "absc35#r.com";
	    assertTrue(motDePasse.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"));
	}
}
