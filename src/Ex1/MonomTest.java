package Ex1;
import java.util.ArrayList;
/**
 * This class represents a simple (naive) tester for the Monom class,
 * Note: <br>
 * (i) The class is NOT a JUNIT - (i.e., educational reasons) - should be changed to a proper JUnit in Ex1. <br>
 * (ii) This tester should be extend in order to test ALL the methods and functionality of the Monom class.  <br>
 * (iii) Expected output:  <br>
 * *****  testBuilder1:  *****  <br>
 * *****  Test building from String *****
0) 2.0     isZero: false f(0) = 2.0  <br>
1) -1.0x     isZero: false f(1) = -1.0  <br>
2) -3.2x^2     isZero: false f(2) = -12.8  <br>
3) 0     isZero: true f(3) = 0.0  <br>
4) -2.0x^2 isZero:false f(4) = -32.0
5) -3.2x     isZero: false f(5) = -16.0
 *****  testBuilder2:  *****  <br>
 *****  Test building from Monoms array list *****
0) 0     isZero: true   eq: true  <br>
1) -1.0     isZero: false   eq: true  <br>
2) -1.3x     isZero: false   eq: true  <br>
3) -2.2x^2     isZero: false   eq: true  <br>
 *****  testAdd:  *****
0) 3.0x + 4.0x     isZero: false f(0) before = 0.0 f(0) after = 0.0
1) -1.0x + -5.0x     isZero: false f(1) before = -6.0 f(1) after = -6.0
2) -3.2x^2 + 6.0x^2     isZero: false f(2) before = 11.2 f(2) after = 11.2
3) 5.0x^3 + 8.0x^3     isZero: false f(3) before = 351.0 f(3) after = 351.0
4) 2.0 + 5.0     isZero: false f(4) before = 7.0 f(4) after = 7.0
5) 0 + 0     isZero: true f(5) before = 0.0 f(5) after = 0.0
 *****  testMul:  *****
0) 2.0 * 5.0=10.0     isZero: false f(0) before = 10.0 f(0) after = 10.0
1) -1.0x * -5.0x=5.0x^2     isZero: false f(1) before = 5.0 f(1) after = 5.0
2) -3.2x^2 * 6.0x^2=-19.200000000000003x^4     isZero: false f(2) before = -307.20000000000005 f(2) after = -307.20000000000005
3) 0 * 0=0     isZero: true f(3) before = 0.0 f(3) after = 0.0
4) 5.0x^3 * 8.0x^3=40.0x^6     isZero: false f(4) before = 163840.0 f(4) after = 163840.0
 
 
 *****  testBadExamples:  *****
 *****  Should Print errors:  *****
 *****  Every Monom should be aX^b  *****
0) x5 : is a bad monom
1) -5x^ : is a bad monom
2) 6x2 : is a bad monom
3) -0^1 : is a bad monom
4) ..8x^3 : is a bad monom
5) 5x^3.5 : is a bad monom

 *****  testDerivative:  *****
0) Original :3.0x after derivative 3.0
1) Original :-1.0x after derivative -1.0
2) Original :-3.2x^2 after derivative -6.4x
3) Original :5.0x^3 after derivative 15.0x^2
4) Original :2.0 after derivative 0
5) Original :0 after derivative 0
 *
 *
 *
 *
 */

public class MonomTest {
	public static void main(String[] args)
	{
		testBuilder1();
		testBuilder2();
		testAdd();
		testMul();
		testBadExamples();
	}
	private static void testBuilder1()
	{
		System.out.println("*****  testBuilder1:  *****");
		System.out.println("*****  Test building from String *****");
		String[] monoms = {"2", "-x","-3.2x^2","0","-2x^2","-3.2x^1"};
		for(int i=0;i<monoms.length;i++)
		{
			Monom m = new Monom(monoms[i]);
			String s = m.toString();
			m = new Monom(s);
			double fx = m.f(i);
			System.out.println(i+") "+m +"    \tisZero: "+m.isZero()+"\t f("+i+") = "+fx);
		}
	}
	private static void testBuilder2()
	{
		System.out.println("*****  testBuilder2:  *****");
		System.out.println("*****  Test building from Monoms array list *****");
		ArrayList<Monom> monoms = new ArrayList<Monom>();
		monoms.add(new Monom(0,5));
		monoms.add(new Monom(-1,0));
		monoms.add(new Monom(-1.3,1));
		monoms.add(new Monom(-2.2,2));

		for(int i=0;i<monoms.size();i++)
		{
			Monom m = new Monom(monoms.get(i));
			String s = m.toString();
			Monom m1 = new Monom(s);
			boolean e = m.equals(m1);
			System.out.println(i+") "+m +"    \tisZero: "+m.isZero()+"  \teq: "+e);
		}
	}
	private static void testAdd()
	{
		System.out.println("*****  testAdd:  *****");
		String[] monoms1 = {"3x","-x","-3.2x^2","5x^3","2","0"};
		String[] monoms2 = {"4x","-5x","6x^2","8x^3","5","0"};
		for (int i = 0; i < monoms2.length; i++)
		{
			Monom m1 = new Monom(monoms1[i]);
			Monom m2 = new Monom(monoms2[i]);
			Monom m1ORg = new Monom(m1);
			double fxBeforeAdd = m1.f(i) + m2.f(i);
			m1.add(m2);
			double fxAfterAdd = m1.f(i);
			System.out.println(i+") "+m1ORg+" + "+m2 +"    \tisZero: "+m1.isZero()+"\t f("+i+") before = "+fxBeforeAdd +"\t f("+i+") after = "+fxAfterAdd);
		}
	}
	private static void testMul()
	{
		System.out.println("*****  testMul:  *****");
		String[] monoms1 = {"2","-x","-3.2x^2","0","5x^3"};
		String[] monoms2 = {"5","-5x","6x^2","0","8x^3"};
		for (int i = 0; i < monoms2.length; i++)
		{
			Monom m1 = new Monom(monoms1[i]);
			Monom m2 = new Monom(monoms2[i]);
			Monom m1ORg = new Monom(m1);
			double fxBeforeAdd = m1.f(i) * m2.f(i);
			m1.multipy(m2);
			double fxAfterAdd = m1.f(i);
			System.out.println(i+") "+m1ORg+" * "+m2 +"="+m1+"    \tisZero: "+m1.isZero()+"\t f("+i+") before = "+fxBeforeAdd +"\t f("+i+") after = "+fxAfterAdd);
		}
	}
	private static void testBadExamples()
	{
		System.out.println("*****  testBadExamples:  *****");
		System.out.println("*****  Should Print errors:  *****");
		System.out.println("*****  Every Monom should be aX^b  *****");
		String[] monoms = {"x5","-5x^","6x2","-0^","..8x^3","5x^3.5"};
		for (int i = 0; i < monoms.length; i++)
		{
			try
			{
				Monom m1 = new Monom(monoms[i]);
				System.out.println(m1);
			}
			catch (Exception e) {
				System.err.println(i+") "+monoms[i] + " : is a bad monom");
				
			
			}
		}
	}





}