package Ex1;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;







public class Functions_GUI implements functions {


	ArrayList<function> ColFunctions;
	//ArrayList<Color> Colors;
	

	public Functions_GUI() {
		// TODO Auto-generated constructor stub
		ColFunctions = new ArrayList<function>();
	//	Colors = new ArrayList<Color>();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return ColFunctions.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return ColFunctions.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return ColFunctions.contains(o);
	}

	@Override
	public Iterator<function> iterator() {
		// TODO Auto-generated method stub
		return ColFunctions.iterator();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return ColFunctions.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return this.ColFunctions.toArray(a);
	}

	@Override
	public boolean add(function e) {
		// TODO Auto-generated method stub
		return ColFunctions.add(e);
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return ColFunctions.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return ColFunctions.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends function> c) {
		// TODO Auto-generated method stub
		return ColFunctions.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return ColFunctions.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return ColFunctions.retainAll(c);
	}

	@Override
	public void clear() {
		ColFunctions.clear();

	}
	public function get(int index)
	{
		return ColFunctions.get(index);
	}

	@Override
	public void initFromFile(String file) throws IOException {
		// TODO Auto-generated method stub
		ColFunctions = new ArrayList<function>();
		//Colors = new ArrayList<Color>();
		BufferedReader reader;
		reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		while(line != null)
		{
			//			int[] rgb = new int[3]; // 0 - r , 1 - g , 2 - b
			//			int indexFX= line.indexOf("java.awt.Color");
			//			if(indexFX != -1)
			//			{
			//				String colors = line.substring(line.indexOf('[')+1, line.indexOf(']'));
			//				String[] colorArr = colors.split(",");
			//				for (int i = 0; i < colorArr.length; i++) 
			//				{
			//					String ans ="";
			//					for (int j = 0; j < colorArr[i].length(); j++) {
			//						if(colorArr[i].charAt(j) >= '0' && colorArr[i].charAt(j) <= '9')
			//						{
			//							ans=	ans.concat(""+colorArr[i].charAt(j));
			//						}
			//					}
			//					rgb[i] = Integer.parseInt(ans);
			//					ans="";
			//				}
			//			}
			line = line.substring(line.indexOf("f(x)=")+"f(x)=".length());
			line = line.replaceAll("\\s+","");
			ComplexFunction cf = new ComplexFunction(line);
			ColFunctions.add(cf);
			//Colors.add(new Color(rgb[0],rgb[1],rgb[2]));
			line = reader.readLine();
		}
		reader.close();

	}

	@Override
	public void saveToFile(String file) throws IOException {

		FileWriter fw = new FileWriter(file);
		Iterator<function> itrFunction = ColFunctions.iterator();
		//Iterator<Color> itrColor = Colors.iterator();
		int counter = 0;
		while(itrFunction.hasNext())
		{
			//	Color c = itrColor.next();
			function f = itrFunction.next();
			//	fw.write(counter+") "+c.toString()+"   f(x)= "+f.toString());
			fw.write(counter+") "+"   f(x)= "+f.toString()+'\n');
			counter++;
		}
		fw.close();


	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		//StdDraw.enableDoubleBuffering();

		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());

		StdDraw.setPenColor(Color.LIGHT_GRAY);
//		for (int i = 0; i <= resolution; i=i+10) {
//			StdDraw.line(rx.get_min()+i/10, ry.get_min(), rx.get_min()+i/10, ry.get_max());
//		}
		
		for (double i = rx.get_min(); i <= rx.get_max(); i++) {
			StdDraw.line(i, ry.get_min(), i, ry.get_max());
		}
//		for (int i = 0; i <= resolution; i=i+10) {
//			StdDraw.line(rx.get_min(), ry.get_min()+i/10, rx.get_max(), ry.get_min()+i/10);
//		}
		for (double i = ry.get_min(); i <= ry.get_max(); i++) {
			StdDraw.line(rx.get_min(), i, rx.get_max(), i);
		}

		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		//StdDraw.line(rx.get_min(), (ry.get_max()+ry.get_min())/2, rx.get_max(), (ry.get_max()+ry.get_min())/2);
		StdDraw.setFont(new Font("TimesRoman", Font.BOLD, 15));
		StdDraw.line(rx.get_min(), 0, rx.get_max(), 0);
//		for (int i = 0; i <= Math.abs(rx.get_min())+Math.abs(rx.get_max()); i++) {
//			StdDraw.text(rx.get_min()+i, -0.30, Double.toString((rx.get_min()+i)));
//		}
		for (double i = rx.get_min(); i <= rx.get_max(); i++) {
			StdDraw.text(i, -0.30, Integer.toString(Math.toIntExact((long) i)));
		}
		StdDraw.line(0, ry.get_min(), 0, ry.get_max());
//		for (int i = 0; i <= Math.abs(ry.get_min())+Math.abs(ry.get_max()); i++) {
//			StdDraw.text(-0.30,ry.get_min()+i, (Double.toString((int)(ry.get_min()+i))));
//		}
		for (double i = ry.get_min(); i <= ry.get_max(); i++) {
			StdDraw.text(-0.20,i, Integer.toString(Math.toIntExact((long) i)));
		}

		for (function function : ColFunctions) {
			double rx_step = (Math.abs(rx.get_min())+Math.abs(rx.get_max()))/resolution;
			int R = (int)(Math.random()*256);
			int G = (int)(Math.random()*256);
			int B= (int)(Math.random()*256);
			Color color = new Color(R, G, B);
			//color=color.brighter();
			StdDraw.setPenColor(color);
			for (double i = rx.get_min(); i < rx.get_max(); i+=rx_step)
			{
				StdDraw.line(i, function.f(i), i+rx_step, function.f(i+rx_step));
			}
		}
		StdDraw.setPenColor(Color.BLACK);//Remove later

	}
	@Override
	public void drawFunctions(String json_file) {
		try {
			JSONObject  obj = (JSONObject) new JSONParser().parse(new FileReader(json_file));
			int Width=1000;
			int Height=600;
			int Resolution=200;
			double[] Range_X = {-10,10};
			double[] Range_Y = {-5,15};
			JSONArray JAx;
			JSONArray JAy;
			if(obj.get("Width") != null)
			{
				Width = Math.toIntExact((long) obj.get("Width"));
			}
			if(obj.get("Height") != null)
			{
				Height = Math.toIntExact((long) obj.get("Height"));
			}
			if(obj.get("Resolution") != null)
			{
				Resolution = Math.toIntExact((long) obj.get("Resolution"));
			}
			if(obj.get("Range_X") != null)
			{
				JAx = (JSONArray) obj.get("Range_X");
				Iterator<Long> itr = JAx.iterator();
				int i=0;
				while(itr.hasNext() && i<2)
				{
					
					Range_X[i++] = (double)itr.next().doubleValue();
				}
			}
			if(obj.get("Range_Y") != null)
			{
				JAy = (JSONArray) obj.get("Range_Y");
				Iterator<Long> itr = JAy.iterator();
				int i=0;
				while(itr.hasNext() && i<2)
				{
					Range_Y[i++] = (double)itr.next().doubleValue();
				}
			}
			Range rx = new Range(Range_X[0], Range_X[1]);
			Range ry = new Range(Range_Y[0], Range_Y[1]);
			drawFunctions(Width,Height,rx,ry,Resolution);
			//obj.get
		}
		catch (Exception e) {
			// TODO: handle exception
		}


	}

}
