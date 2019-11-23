package Ex1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PolynomTestJunit {

	@Test
	void testPolynomString() {
		/*
0) : -24.0x^2+58.0x-5.0
1) : 0
2) : -2.0x^2-4.0x
3) : 0
4) : 26.0x^2+58.0x-5.0
5) : -24.0x^2+38.0x+5.0
6) : 9.0x^2+6.0x
7) : -2.0
		 */
		String[] ans = {"-24.0x^2+58.0x-5.0","0","-2.0x^2-4.0x","0","26.0x^2+58.0x-5.0","-24.0x^2+38.0x+5.0","9.0x^2+6.0x","-2.0"};
		String[] polynom = {"0-24x^2+35x-5+23x","2+0-4-0-0+2","-2x^2-4x","0","24x^2+35x-5+23x+2x^2"
				,"x-24x^2+35x+5+2x","3x^2+2x+3x^2-5x+3x^2+3x+5x+x","2-4"};
		for (int i = 0; i < polynom.length; i++) {
			Polynom m = new Polynom(polynom[i]);
			Polynom ansPol = new Polynom(ans[i]);
			assertEquals(ansPol, m);
			assertEquals(0, m.toString().compareTo(ansPol.toString()));
		}
	}

	@Test
	void testF() {
		fail("Not yet implemented");
	}

	@Test
	void testAddPolynom_able() {
		fail("Not yet implemented");
	}

	@Test
	void testAddMonom() {
		fail("Not yet implemented");
	}

	@Test
	void testSubstract() {
		fail("Not yet implemented");
	}

	@Test
	void testMultiplyPolynom_able() {
		fail("Not yet implemented");
	}

	@Test
	void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	void testRoot() {
		fail("Not yet implemented");
	}

	@Test
	void testCopy() {
		fail("Not yet implemented");
	}

	@Test
	void testDerivative() {
		fail("Not yet implemented");
	}

	@Test
	void testArea() {
		fail("Not yet implemented");
	}

	@Test
	void testMultiplyMonom() {
		fail("Not yet implemented");
	}

	@Test
	void testInitFromString() {
		fail("Not yet implemented");
	}

}
