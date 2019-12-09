package Ex1;


public class ComplexFunction implements complex_function {


	function left;
	function right;
	Operation OP;

	//	public ComplexFunction()
	//	{
	//		this.left= null;
	//		this.right = null;
	//		this.OP = Operation.Error;
	//	}
	public ComplexFunction(String str)
	{
		function f = initFromString(str);
		if(f instanceof ComplexFunction)
		{
			ComplexFunction cf = (ComplexFunction)f;
			this.left = cf.left.copy();
			this.right = cf.right.copy();
			this.OP = cf.getOp();
		}
		else
		{
			if(f instanceof Polynom)
			{
				Polynom p = (Polynom)f;
				this.left = p.copy();
				this.OP = Operation.None;
			}
			else
			{
				throw new RuntimeException("The string is not vaild");
			}
		}
	}
	public ComplexFunction(Operation op,function left,function right)
	{
		if(left!= null)
		{
			this.left = left.initFromString(left.toString());
			//this.left = left;
		}
		if(right != null)
		{
			this.right = right.initFromString(right.toString());
			//this.right = right;
		}
		this.OP = op;
	}
	public ComplexFunction(String op,function left,function right) 
	{
		//Divid, Max, Min, Comp , None, Error
		if(left!= null)
		{
			this.left = left.initFromString(left.toString());
			//this.left = left;
		}
		if(right != null)
		{
			this.right = right.initFromString(right.toString());
			//this.right = right;
		}
		switch(op.toLowerCase())
		{
		case "plus": OP = Operation.Plus;
		break;
		case "mul" : OP = Operation.Times;
		break;
		case "div" : OP = Operation.Divid;
		break;
		case "max" : OP = Operation.Max;
		break;
		case "min" : OP = Operation.Min;
		break;
		case "comp" : OP = Operation.Comp;
		break;
		default: throw new RuntimeException("The Operation is not vaild");
		
		}
	}
	public ComplexFunction(function left) {
		// TODO Auto-generated constructor stub
		this.left = left;
		this.OP = Operation.None;
	}


	@Override
	public double f(double x) {
		switch(OP.toString())
		{
		case "Plus":  return left.f(x)+right.f(x);
		case "Times" :  return left.f(x)*right.f(x);
		case "Divid" : return left.f(x)/right.f(x);
		case "Max" : if(left.f(x)>right.f(x))
			return left.f(x);
		else
			return right.f(x);
		case "Min" : if(left.f(x)>right.f(x))
			return right.f(x);
		else
			return left.f(x);
		case "Comp" : 
			if(right != null) 
				return left.f(right.f(x));
			else
				return left.f(x);
		case "None": return left.f(x);
		default: throw new RuntimeException("The Operation is not vaild");
		}
	}

	@Override
	public function initFromString(String s) {
		// TODO Auto-generated method stub
		int IndexFirstBracket = s.indexOf("(");
		int IndexComma = findComma(s,IndexFirstBracket);

		if((s.indexOf("(") == -1 && s.indexOf(")") == -1)) 
		{
			Polynom m = new Polynom();
			return m.initFromString(s);
		}
		String op = s.substring(0, IndexFirstBracket);
		if(op.compareToIgnoreCase("none")==0 && IndexComma == -1)
		{
			Polynom m = new Polynom();
			return  m.initFromString(s.substring(IndexFirstBracket+1, s.length()-1));

		}

		function left = initFromString(s.substring(IndexFirstBracket+1,IndexComma));
		function right = initFromString(s.substring(IndexComma+1,s.length()-1));
		function ans = new ComplexFunction(op, left, right);
		return ans;
	}
	private int findComma(String s,int indexFirstBracket)
	{
		if(s.indexOf(',')==-1)
		{
			return -1;
		}
		int counterComma=0;
		int counterOpenBracket=1;
		int index=indexFirstBracket+1;
		while(counterOpenBracket != counterComma && index<s.length())
		{
			if(s.charAt(index) == '(')
			{
				counterOpenBracket++;
			}
			if(s.charAt(index) == ',')
			{
				counterComma++;
			}
			index++;
		}
		return index-1;
	}
	@Override
	public function copy() {
		function ans = new ComplexFunction(getStringOP(),left.copy(),right.copy());
		return ans;
	}

	@Override
	public void plus(function f1) {
		if(this.right != null)
		{
			function f = new ComplexFunction(getStringOP(),this.left.copy(),this.right.copy());
			this.left = f;
		}

		this.right = f1.copy();
		this.OP = Operation.Plus;
	}

	@Override
	public void mul(function f1) {
		if(this.right != null)
		{
			function f = new ComplexFunction(getStringOP(),this.left,this.right);
			this.left = f.copy();
		}
		this.right = f1.copy();
		this.OP = Operation.Times;

	}

	@Override
	public void div(function f1) {
		if(this.right != null)
		{
			function f = new ComplexFunction(getStringOP(),this.left,this.right);
			this.left = f.copy();
		}
		this.right = f1.copy();
		this.OP = Operation.Divid;

	}

	@Override
	public void max(function f1) {
		// TODO Auto-generated method stub
		if(this.right != null)
		{
			function f = new ComplexFunction(getStringOP(),this.left,this.right);
			this.left = f.copy();
		}
		this.right = f1.copy();
		this.OP = Operation.Max;
	}

	@Override
	public void min(function f1) {
		// TODO Auto-generated method stub
		if(this.right != null)
		{
			function f = new ComplexFunction(getStringOP(),this.left,this.right);
			this.left = f.copy();
		}
		this.right = f1.copy();
		this.OP = Operation.Min;
	}

	@Override
	public void comp(function f1) {
		// TODO Auto-generated method stub
		if(this.right != null)
		{
			function f = new ComplexFunction(getStringOP(),this.left,this.right);
			this.left = f.copy();
		}
		this.right = f1.copy();
		this.OP = Operation.Comp;
	}

	@Override
	public function left() {
		return this.left;
	}

	@Override
	public function right() {
		// TODO Auto-generated method stub
		return this.right;
	}

	@Override
	public Operation getOp() {
		return this.OP;
	}
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(getStringOP()+"("+this.left.toString());
		if(this.right!= null)
		{
			sb.append(","+this.right.toString()+")");
		}
		else
		{
			sb.append(")");
		}
		return sb.toString();
	}
	@Override
	public boolean equals(Object other)
	{
		boolean ans = true;
		if(other instanceof ComplexFunction)
		{
			ComplexFunction f = (ComplexFunction) other;
			boolean check=false;
			if(this.OP.compareTo(f.OP) == 0)
			{
				check = true;
			}

			ans = ans && this.left.equals(f.left) && this.right.equals(f.right) && check ;
			if(ans)
			{
				return ans;
			}
		}
		if(other instanceof function)
		{
			// if the function isn't in the exact form then we will try to check from -10 to 10 in jumps of 0.1 to check if the functions are logically equal
			for (double i = -10; i <= 10; i+=0.1)
			{
				if(Math.abs(this.f(i)-((function)other).f(i)) > Monom.EPSILON)
				{
					return false;
				}
			}
		}
		return true;
	}
	private String getStringOP()
	{
		switch(this.OP.toString())
		{
		case "Plus": return "plus";
		case "Times" : return "mul";
		case "Divid" : return "div";
		case "Max" : return "max";
		case "Min" : return "min";
		case "Comp" :return "comp";
		case "None": return "none";
		default: return "ERROR";
		}
	}

}
