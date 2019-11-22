
package myMath;

import java.util.Comparator;


/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{
	public static final Monom ZERO = new Monom(0,0);
	public static final Monom MINUS1 = new Monom(-1,0);
	public static final double EPSILON = 0.0000001;
	public static final Comparator<Monom> _Comp = new Monom_Comperator();
	public static Comparator<Monom> getComp()
	{
		return _Comp;
	}
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	public double get_coefficient() {
		return this._coefficient;
	}
	public int get_power() {
		return this._power;
	}
	/** 
	 * this method returns the derivative monom of this.
	 * @return
	 */
	public Monom derivative() {
		if(this.get_power()==0) {return getNewZeroMonom();}
		return new Monom(this.get_coefficient()*this.get_power(), this.get_power()-1);
	}
	/**
	 * f
	 * This function returns - the Function value with the given x 
	 */
	public double f(double x) { // returns the value of the monom with given X
		double ans=0;
		double p = this.get_power();
		ans = this.get_coefficient()*Math.pow(x, p);
		return ans;
	} 
	public boolean isZero() {return this.get_coefficient() == 0;}
	// ***************** add your code below **********************
	public Monom(String s)
	{
		s=s.replace('X', 'x');
		int x_index=s.indexOf('x');
		int power_index = s.indexOf('^');

		if(s.length()==0)
		{
			this._coefficient=0;
			this._power=0;
			return;
		}

		if(s.length()==1) 
		{
			if(s.charAt(0)<'0' || s.charAt(0)>'9' && s.charAt(0)!='x') 
			{
				throw new RuntimeException("The Monom: "+ s +" is not valid has to be in the format of aX^b");
			}
		}

		if(s.charAt(0)=='-' && s.charAt(1)!='-')
		{
			if(s.charAt(1)=='x' && power_index == -1)
			{
				this._coefficient = -1;
				this._power = 1;
				return;
			}
			
			if(s.charAt(1)>='0' && s.charAt(1)<='9')
			{
				x_index = s.indexOf('x');
				power_index = s.indexOf('^');
				if(power_index==-1 && x_index!=-1)
				{
					this._coefficient=Double.parseDouble(s.substring(0,x_index));
					this._power=1;
					return;
				}
				if(power_index==-1 && x_index==-1)
				{
					this._coefficient=Double.parseDouble(s.substring(0));
					this._power=0;
					return;
				}
				this._coefficient=Double.parseDouble(s.substring(0,x_index));
				this._power=Integer.parseInt(s.substring(power_index+1));
				return;
			}
			if(x_index != -1 && power_index != -1)
			{
				if(x_index != 1)
				{
				this._coefficient=Double.parseDouble(s.substring(0,x_index));
				}
				else
				{
					this._coefficient = -1;
				}
				this._power=Integer.parseInt(s.substring(power_index+1));
				return;
				
			}
		}

		if(s.charAt(0)>='0' && s.charAt(0)<='9')
		{
			x_index = s.indexOf('x');
			power_index = s.indexOf('^');
			if(power_index==-1 && x_index!=-1)
			{
				if(x_index!=s.length()-1) {
					throw new RuntimeException("The Monom: "+ s +" is not valid has to be in the format of aX^b");
				}
				this._coefficient=Double.parseDouble(s.substring(0,x_index));
				this._power=1;
				return;
			}
			if(power_index==-1 && x_index==-1)
			{
				this._coefficient=Double.parseDouble(s.substring(0));
				this._power=0;
				return;
			}
			this._coefficient=Double.parseDouble(s.substring(0,x_index));
			this._power=Integer.parseInt(s.substring(power_index+1));
			return;
		}

		else if(s.length()==1 && s.charAt(0)=='x')
		{
			this._coefficient=1;
			this._power=1;
			return;
		}
		else if(s.length()==1 && s.charAt(0)>='0' && s.charAt(0)<='9')
		{
			this._coefficient=Double.parseDouble(s);
			this._power=0;
			return;
		}
		else if(s.charAt(0)=='x' && s.charAt(1)=='^') 
		{
			this._coefficient=1;
			s=s.substring(power_index+1);
			this._power=Integer.parseInt(s);
		}
		else 
		{
			throw new RuntimeException("The Monom: "+ s +" is not valid has to be in the format of aX^b");	
		}
	}
	public void add(Monom m)
	{
		if(this._power == m._power)
		{
			this._coefficient+= m._coefficient;
		}
	}
	public void substract(Monom m)
	{
		if(this._power == m._power)
		{
			this._coefficient-= m._coefficient;
		}
	}
	public void multipy(Monom d) 
	{
		this._coefficient = d._coefficient*this._coefficient;
		this._power = d.get_power()+this._power;
	}
	/**
	 * toString
	 * this function returns visual presentation of the Monom as a String
	 */
	public String toString() {
		if(this._coefficient == 0)
		{
			return 0+"";
		}
		if(this.get_power()==0)
		{
			return  this._coefficient+"";

		}
		if(this.get_power()==1)
		{
			return this._coefficient+"x";

		}
		return this._coefficient+"x^"+this.get_power();
	}
	public boolean equals(Monom other) {

		if(this._coefficient==0 && other._coefficient==0)
			return true;
		if(Math.abs(this._coefficient - other._coefficient)<EPSILON && this._power==other._power)
		{
			return true;
		}
		return false;
	}
	// you may (always) add other methods.

	//****************** Private Methods and Data *****************


	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		if(p<0) {throw new RuntimeException("ERR the power of Monom should not be negative, got: "+p);}
		this._power = p;
	}
	private static Monom getNewZeroMonom() {return new Monom(ZERO);}
	private double _coefficient; 
	private int _power;


}
