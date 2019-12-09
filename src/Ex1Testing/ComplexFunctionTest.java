package Ex1Testing;
import Ex1.*;
/**
 * 

 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Ex1.ComplexFunction;
import Ex1.Monom;
import Ex1.Polynom;

class ComplexFunctionTest {
	public static final double EPS = 0.00001;
	@Test
	void test() {
		Monom m1 = new Monom(2,2);
		Monom m2 = new Monom(3,3);
		ComplexFunction cf = new ComplexFunction("plus", m1,m2);
		//	System.out.println(cf);
		cf.mul(m2);
		//System.out.println(cf);
		Polynom p = new Polynom();
		p.add(m1);
		p.add(m2);
		p.multiply(m2);
		double v = 4.0;
		double dp = p.f(v);
		double dcf = cf.f(v);
		double dd = Math.abs(dp-dcf);
		if(dd>EPS) {
			//System.out.println(p+" at "+v+" = "+dp);
			//System.out.println(cf+" at "+v+" = "+dcf);
			fail("ERR: should got the same value from: "+p+"should be: "+dp+"  and "+cf+"should be "+dcf);

		}
	}

	@Test
	void testOfString() {
		Polynom p1 = new Polynom();
		p1.add( new Monom(2,2));
		Polynom p2 = new Polynom();
		p2.add(new Monom(3,3));
		Monom m1 = new Monom(2,2);
		Monom m2 = new Monom(3,3);
		ComplexFunction cf = new ComplexFunction("plus", m1,m2);
		ComplexFunction cf3 = new ComplexFunction("plus", p1,p2);
		//System.out.println(cf);
		cf.mul(m2);
		cf3.mul(m2);
		String s = cf.toString();
		function cf2 = cf.initFromString(s);
		if(!cf.equals(cf2)) {
			fail("ERR: "+cf+" should be equals to "+cf2);
		}
		if(!cf.equals(cf3)) {
			fail("ERR: "+cf+" should be equals to "+cf3);
		}
	}
	@Test
	void testComplexFunction() {
		String s1 = "3.1+2.4x^2-x^4";
		String s2 = "5+2x-3.3x+0.1x^5";
		String[] s3 = {"x-1","x-2", "x-3", "x-4"};
		Polynom p1 = new Polynom(s1);
		Polynom p2 = new Polynom(s2);
		Polynom p3 = new Polynom(s3[0]);
		for(int i=1;i<s3.length;i++) {
			p3.multiply(new Polynom(s3[i]));
		}

		ComplexFunction cf = new ComplexFunction("plus", p1,p2);
		ComplexFunction cf4 = new ComplexFunction("div", new Monom("x"),p3);
		cf.div(p1);
		String s = cf.toString();
		function cf5 = cf4.initFromString(s);
		if(!cf.equals(cf5)) {
			fail("ERR: "+cf+" should be equals to "+cf5);
		}
		int size=10;
		for(int i=0;i<size;i++) {
			double x = Math.random();
			double d = cf.f(x);
			double d5 = cf5.f(x);
			assertEquals(d,d5,EPS);
		}
	//	System.out.println(cf4);
	//	System.out.println(cf5);
	}
	@Test
	void equalsTest()
	{
		ComplexFunction a = new ComplexFunction("2x");
		function f1 = a.initFromString("Plus(x,x)");
		function f2 = a.initFromString("2x");
		assertEquals(f1, f2);
		function f3 = a.initFromString("plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)");
		function f4 = a.initFromString("Plus(div(x+1,x^3 - 3 x^2 -10x+24),2)");
		assertEquals(f3, f4);
	}
	@Test
	void ComplexFunctionString()
	{
		ComplexFunction cf = new ComplexFunction("Plus(div(x+1,x^3 - 3 x^2 -10x+24),2)");
		Polynom p1 = new Polynom("x+1");
		Polynom p2 = new Polynom("x^3 - 3 x^2 -10x+24");
		ComplexFunction cf2 = new ComplexFunction("div",p1,p2);
		ComplexFunction cf3= new ComplexFunction(Operation.Divid,p1,p2);
		cf3.plus(new Monom("2"));
		Monom m = new Monom("1");
		Monom m2 = new Monom("1");
		cf2.plus(m);
		cf2.plus(m2);
		assertEquals(cf, cf2);
		assertEquals(cf, cf3);
		assertEquals(cf3, cf2);
	}
	@Test
	void ComplexFunction_f()
	{
		double[] ansArr = {49.0/24.0,13.0/6.0,Double.POSITIVE_INFINITY,4.0/3.0,Double.POSITIVE_INFINITY,9.0/4.0};
		ComplexFunction cf = new ComplexFunction("Plus(div(x+1,x^3 - 3 x^2 -10x+24),2)");
		for (int i = 0; i < 6; i++) {
			assertEquals(ansArr[i], cf.f(i),Monom.EPSILON);
		}
	}
	@Test 
	void ComplexFunction_copy()
	{
		ComplexFunction cf = new ComplexFunction("Plus(div(x+1,x^3 - 3 x^2 -10x+24),2)");
		function f2 = cf.copy();
		assertEquals(cf, f2);
		cf.plus(new Monom("1"));
		cf.mul(new Monom("2"));
		if(cf.equals(f2))
		{
			fail("Should'nt be equals");
		}
		cf.div(new Monom("2"));
		cf.plus(new Monom("-1"));
		assertEquals(cf, f2);
	}
	@Test
	void ComplexFunction_plus()
	{
		ComplexFunction cf = new ComplexFunction("Plus(x+3,x^2)");
		Polynom p1 = new Polynom("x^2+x+3");
		assertEquals(p1, cf);
	}
	@Test
	void ComplexFunction_mul() 
	{
		ComplexFunction cf = new ComplexFunction("mul(x+3,x^2)");
		Polynom p1 = new Polynom("x^3+3x^2");
		assertEquals(cf, p1);
	}
	@Test
	void ComplexFunction_div() 
	{
		ComplexFunction cf = new ComplexFunction("div(x^5,x)");
		Polynom p1 = new Polynom("x^4");
		assertEquals(cf, p1);
	}
	@Test
	void ComplexFunction_max() 
	{
		ComplexFunction cf = new ComplexFunction("max(x,x^2)");
		Polynom p1 = new Polynom("x^2");
		for (int i = 1; i < 10; i++) {
			assertEquals(cf.f(i), p1.f(i));
		}
	}
	@Test
	void ComplexFunction_min() 
	{
		ComplexFunction cf = new ComplexFunction("min(x,x^2)");
		Polynom p1 = new Polynom("x");
		for (int i = 1; i < 10; i++) {
			assertEquals(cf.f(i), p1.f(i));
		}
	}
	@Test
	void ComplexFunction_comp() 
	{
		ComplexFunction cf = new ComplexFunction("plus(x^5-3x,x^2)");
		Polynom p1 = new Polynom("x");
		cf.comp(p1);
		Polynom p2 = new Polynom("x^5-3x+x^2");
		for (int i = 1; i < 10; i++) {
			assertEquals(p1.f(p2.f(i)), cf.f(i));
		}
	}
	@Test
	void ComplexFunction_equals() {
		Monom m1 = new Monom(2,2);
		Monom m2 = new Monom(3,3);
		ComplexFunction cf = new ComplexFunction("plus",m1,m2);
		cf.mul(m1);
		cf.div(m1);
		cf.max(m1);
		cf.min(m1);
		function x =cf.initFromString(cf.toString());

		//ComplexFunction c3 = new ComplexFunction();

		//System.out.println("x   : "+x);



		ComplexFunction cf2 = new ComplexFunction("plus",m1,m2);
		cf2.mul(m1);
		cf2.div(m1);
		cf2.max(m1);
		cf2.min(m1);
//		System.out.println("cf2 : "+cf2.toString() );
//		System.out.println(x.equals(cf2));
		assertEquals(x, cf2);

		}

}
