package Ex1;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;






public class Functions_GUI implements functions {


	ArrayList<function> ColFunctions;
	ArrayList<Color> Colors;

	public Functions_GUI() {
		// TODO Auto-generated constructor stub
		ColFunctions = new ArrayList<function>();
		Colors = new ArrayList<Color>();
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
			line = line.strip();
			ComplexFunction cf = new ComplexFunction();
			ColFunctions.add(cf.initFromString(line));
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
		for (int i = 0; i <= resolution; i=i+10) {
			StdDraw.line(rx.get_min()+i/10, ry.get_min(), rx.get_min()+i/10, ry.get_max());
		}
		for (int i = 0; i <= resolution; i=i+10) {
			StdDraw.line(rx.get_min(), ry.get_min()+i/10, rx.get_max(), ry.get_min()+i/10);
		}
			
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(rx.get_min(), (ry.get_max()+ry.get_min())/2, rx.get_max(), (ry.get_max()+ry.get_min())/2);
		StdDraw.line((rx.get_max()+rx.get_min())/2, ry.get_min(), (rx.get_max()+rx.get_min())/2, ry.get_max());
		
		

	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub

	}

}
