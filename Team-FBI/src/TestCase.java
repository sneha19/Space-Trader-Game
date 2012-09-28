import org.junit.Test;

import edu.gatech.oad.antlab.person.Person1;


public class TestCase {

	@Test
	public void test() {
		Person1 p = new Person1("Haytham");
		System.out.println(p.toString("gtg123b"));
	}

}
