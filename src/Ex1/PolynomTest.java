package Ex1;
import java.util.Iterator;
/**
 * This class represents a simple (naive) tester for the Polynom class, 
 * Note: <br>
 * (i) The class is NOT a JUNIT - (i.e., educational reasons) - should be changed to a proper JUnit in Ex1. <br>
 * (ii) This tester should be extend in order to test ALL the methods and functionality of the Polynom class.  <br>
 * (iii) Expected output:  <br>
  
**** test_Builders ****

0) : -24.0x^2+58.0x-5.0
1) : 0
2) : -2.0x^2-4.0x
3) : 0
4) : 26.0x^2+58.0x-5.0
5) : -24.0x^2+38.0x+5.0
6) : 9.0x^2+6.0x
7) : -2.0

**** test_Add ****

	'Polynom_1' + 'Polynom_2' = 'Expected result' 
0) 	2.0x^2+2.0 + 	1.0x^5+0 = 	1.0x^5+2.0x^2+2.0
1) 	1.0x^4-5.0x + 	1.0x+5.0 = 	1.0x^4-4.0x+5.0
2) 	-5.0x^5 + 	1.0x^3+5.0x+0 = 	-5.0x^5+1.0x^3+5.0x
3) 	6.0x^3-7.0x^2+5.0 + 	7.0x^2+1.0x+2.0 = 	6.0x^3+1.0x+7.0
4) 	Test multiple add : 20.4x^3-31.0x-5.0

**** test_Equals ****

0) 5.0x^2+6.0	is equals	0	eq: false
1) 5.0x^2+6.0	is equals	5.0x^2+6.0	eq: true
2) 5.0x^2+6.0	is equals	2.0x^3+6.0x	eq: false
3) 5.0x^2+6.0	is equals	5.0x^2+6.0	eq: true
4) 5.0x^2+6.0	is equals	5.0x^2+6.0	eq: true
5) 5.0x^2+6.0	is equals	5.0x^2-6.0	eq: false
6) 2.0x^2	is equals	2.0x^2+1.0	eq: false
7) 2.0x^2+1.0	is equals	2.0x^2	eq: false

***** testPolynomSubStruct *****
Orginial polynom: 20.4x^3-31.0x-5.0 - 10.0x^3+5.0x = 10.399999999999999x^3-36.0x-5.0
Orginial polynom: 10.399999999999999x^3-36.0x-5.0 - 10.0x^3+5.0x = 0.3999999999999986x^3-41.0x-5.0
Orginial polynom: 5.0x^2+5.0x-2.0 - 5.0x^2+5.0x-2.0 = 0
Orginial polynom: 0 - 10.0x^3+5.0x = -10.0x^3-5.0x

***** testDerivative ******

Original polynom: -3.2x^2-5.0x+5.0 after derivative -6.4x-5.0
Original polynom: -6.4x-5.0 after derivative -6.4
Original polynom: 5.0x^3-3.0x+5.0 after derivative 15.0x^2-3.0
Original polynom: 15.0x^2-3.0 after derivative 30.0x

******  testPolynomRoot  ******

For function : 4.0x^2+2.0x from point -0.1 to -1.0 the root is : -0.49999997615814207
For function : 5.0x^3+5.0x^2+5.0 from point -2.0 to 2.0 the root is : -1.4655712321400642
For function : 1.0x^2-5.0 from point 4.0 to 4.0 the root is : 2.2360679906834653

***** testArea ******

For function : 1.0x from point 0.0 to 4.0 the area is : 7.999999797380996
For function : -1.0x^3+4.0x^2 from point 0.0 to 4.0 the area is : 21.333333354561304
For function : 6.0x^5-4.0x from point -1.0 to 0.0 the area is : 0.9999999002575582

***** testCopy *****

1) true
2) false
3) true

***** testPolynomMultiply *****

Orginial polynom: 5.0x^2+6.0 * 2.0x^3+6.0x = 10.0x^5+42.0x^3+36.0x
Orginial polynom: 10.0x^5+42.0x^3+36.0x * 2.0x^3+6.0x = 20.0x^8+144.0x^6+324.0x^4+216.0x^2
Orginial polynom: 20.0x^8+144.0x^6+324.0x^4+216.0x^2 * -1.0 = -20.0x^8-144.0x^6-324.0x^4-216.0x^2

 */
public class PolynomTest {
	public static void main(String[] args) {
		test_Builders();
		test_Add();
		test_Equals();
		testPolynomSubStruct();
		testDerivative();
		testPolynomRoot();
		testArea();
		testCopy();
		testPolynomMultiply();
	}

	public static void test_Builders()
	{

		String[] polynom = {"0-24x^2+35x-5+23x","2+0-4-0-0+2","-2x^2-4x","0","24x^2+35x-5+23x+2x^2"
				,"x-24x^2+35x+5+2x","3x^2+2x+3x^2-5x+3x^2+3x+5x+x","2-4"};

		System.out.println("**** test_Builders ****\n");
		for (int i = 0; i < polynom.length; i++) {
			Polynom m = new Polynom(polynom[i]);
			System.out.println(i+") : "+m);
		}
	}

	public static void test_Add() {
		String[] polynom_1 = { "2x^2+3-1","0+x^4-5x", "2-3+1-5x^5" ,"6x^3-7x^2+5" };
		String[] polynom_2 = { "1+2-3+x^5","x+5"	 ,"5x+x^3+0"  ,"7x^2+x+2"	 };

		System.out.println("\n**** test_Add ****\n");
		System.out.println("	'Polynom_1' + 'Polynom_2' = 'Expected result' ");

		for (int i = 0; i < polynom_2.length; i++) {
			Polynom test1 = new Polynom(polynom_1[i]);
			Polynom test2 = new Polynom(polynom_2[i]);
			Polynom_able res = test1.copy();

			test1.add(test2);

			System.out.println(i+") \t"+ res.toString()+" + \t"+test2.toString()+" = \t"+test1.toString());
		}

		String[] str = {"x", "3+1.4X^3-34x", "5x^3-3+2x", "14x^3-5"};
		Polynom_able pol = new Polynom();
		for (int i = 0; i < str.length; i++) 
		{
			pol.add(new Polynom(str[i]));

		}
		System.out.println("4) \tTest multiple add : " + pol );

	}

	public static void test_Equals() 
	{
		System.out.println("\n**** test_Equals ****\n");

		String[] Polynom_1 = {"5x^2+6"};
		String[] Polynom_2 = {"0" ,"6+5x^2"};

		for (int i = 0; i < Polynom_2.length; i++) 
		{
			Polynom test1 = new Polynom(Polynom_1[0]);
			Polynom test2 = new Polynom(Polynom_2[i]);			
			boolean ans1 = test1.equals(test2);

			System.out.println(i+") "+test1.toString() +"	is equals	"+test2.toString()+"\teq: "+ans1);
		}	

		String[] Polynom_3 = {"2x^3+6x" ,"5x^2+6"};

		for (int i = 0; i < Polynom_3.length; i++) 
		{
			Polynom test1 = new Polynom(Polynom_1[0]);
			Polynom test3 = new Polynom(Polynom_3[i]);
			boolean ans2 = test1.equals(test3);
			System.out.println((i+2)+") "+test1.toString() +"	is equals	"+test3.toString()+"\teq: "+ans2);
		}

		String[] Polynom_4 = {"5x^2+6+0" ,"5x^2-6"};

		for (int i = 0; i < Polynom_4.length; i++) 
		{
			Polynom test1 = new Polynom(Polynom_1[0]);
			Polynom test4 = new Polynom(Polynom_4[i]);
			boolean ans3 = test1.equals(test4);
			System.out.println((i+4)+") "+test1.toString() +"	is equals	"+test4.toString()+"\teq: "+ans3);
		}
		
		Polynom m2 = new Polynom("2x^2");
		Polynom m3 = new Polynom("2x^2+1");
		System.out.println(6+") "+m2.toString() +"	is equals	"+m3.toString()+"\teq: "+m2.equals(m3));
		
		System.out.println(7+") "+m3.toString() +"	is equals	"+m2.toString()+"\teq: "+m3.equals(m2));
		
	}

	public static void testPolynomSubStruct()
	{
		System.out.println("\n***** testPolynomSubStruct *****");
		String[] str = {"x", "3+1.4X^3-34x", "5x^3-3+2x", "14x^3-5"};
		Polynom_able pol = new Polynom();
		for (int i = 0; i < str.length; i++) {
			pol.add(new Polynom(str[i]));
		}
		Polynom_able pol2 = pol.copy();
		Polynom pol3 = new Polynom("10x^3+5x");
		pol.substract(pol3);
		System.out.println("Orginial polynom: "+ pol2 + " - "+pol3+" = " + pol);
		pol2 = pol.copy();
		pol.substract(pol3);
		System.out.println("Orginial polynom: "+ pol2 + " - "+pol3+" = " + pol);
		pol = new Polynom("5x^2+5x-2");
		pol2 = pol.copy();
		pol.substract(pol);
		System.out.println("Orginial polynom: "+ pol2 + " - "+pol2+" = " + pol);
		pol = new Polynom();
		pol2 = pol.copy();
		pol.substract(pol3);
		System.out.println("Orginial polynom: "+ pol2 + " - "+pol3+" = " + pol);

	}
	public static void testDerivative()
	{
		System.out.println("\n***** testDerivative ******\n");
		Polynom p1 = new Polynom("-3.2x^2-5x+5");
		System.out.println("Original polynom: " + p1 + " after derivative " + p1.derivative());
		Polynom_able p2 = p1.derivative();
		System.out.println("Original polynom: " + p2 + " after derivative " + p2.derivative());
		p2 = new Polynom("5x^3-3x+5");
		System.out.println("Original polynom: " + p2 + " after derivative " + p2.derivative());
		p2 = p2.derivative();
		System.out.println("Original polynom: " + p2 + " after derivative " + p2.derivative());
	}

	public static void testPolynomRoot()
	{

		System.out.println("\n******  testPolynomRoot  ******\n");
		double eps = Monom.EPSILON;
		Polynom pol = new Polynom("2x+4x^2");
		double x1 = -0.1;
		double x2 = -1;
		double x0  = pol.root(-0.1, -1, eps);
		System.out.println("For function : "+pol+" from point "+ x1+" to "+ x2+" the root is : "+ x0);
		x1 = -1;
		x2 = 0;
		Polynom pol2 = new Polynom("5x^3+5x^2+5");
		x1=-2;
		x2=2;
		x0 = pol2.root(x1, x2, eps);
		System.out.println("For function : "+pol2 +" from point "+ x1+" to "+ x2+" the root is : "+ x0);
		Polynom pol3 = new Polynom("x^2-5");
		x1 = 4;
		x2 = 4;
		x0 = pol3.root(x0, x1, eps);
		System.out.println("For function : "+pol3 +" from point "+ x1+" to "+ x2+" the root is : "+ x0);
	}
	public static void testArea()
	{
		System.out.println("\n***** testArea ******\n");
		double eps = Monom.EPSILON;
		Polynom p1 = new Polynom("x");
		double x1 = 0;
		double x2 = 4;
		double area = p1.area(x1, x2, eps);
		System.out.println("For function : "+p1 +" from point "+ x1+" to "+ x2+" the area is : "+ area);
		Polynom p2 = new Polynom("-x^3+4x^2");
		area = p2.area(x1, x2, eps);
		System.out.println("For function : "+p2 +" from point "+ x1+" to "+ x2+" the area is : "+ area);
		Polynom p3 = new Polynom("6x^5-4x");
		x1 = -1;
		x2 = 0;
		area = p3.area(x1, x2, eps);
		System.out.println("For function : "+p3 +" from point "+ x1+" to "+ x2+" the area is : "+ area);

	}
	private static void testCopy() 
	{
		System.out.println("\n***** testCopy *****\n");
		
		Polynom m = new Polynom("2x^2");
		Polynom_able m_copied = m.copy();
		System.out.println("1) " +m_copied.equals(m));//true
		
		Polynom temp = new Polynom("1");
		m.add(temp);
		System.out.println("2) " +m_copied.equals(m));//false
		
		temp = new Polynom("-1");
		m.add(temp);
		System.out.println("3) " +m_copied.equals(m));//true
	}

	public static void testPolynomMultiply()
	{
		System.out.println("\n***** testPolynomMultiply *****\n");
		Polynom pol = new Polynom("5x^2+6");
		Polynom_able pol2 = new Polynom("2x^3+6x");
		Polynom_able polOrg = pol.copy();
		pol.multiply(pol2);
		System.out.println("Orginial polynom: "+ polOrg + " * "+pol2+" = " + pol);
		polOrg = pol.copy();
		pol.multiply(pol2);
		System.out.println("Orginial polynom: "+ polOrg + " * "+pol2+" = " + pol);
		Polynom pol3 = new Polynom("-1");
		polOrg = pol.copy();
		pol.multiply(pol3);
		System.out.println("Orginial polynom: "+ polOrg + " * "+pol3+" = " + pol);
		
	}

}
