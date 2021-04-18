import javax.naming.Name;
import java.util.*;

public class Trapezium extends Figure implements Comparable<Trapezium>, Iterable<Object>, Iterator<Object>{

	Point[] points = new Point[4];
	String Name_Tr = null;
	public static final String[] names = {"по имени трапеции", "по площади", "по периметру"};

	Trapezium(Point[] P) {
		assert(validPointsNull(P)) : "ћассив точек пуст";
		assert(P.length == 4) : "ћассив точек дл¤ создани¤ трапеции должен содержать 4 объекта";
		assert(validPoints(P)) : "¬ массиве точек присутсвуют две(или более) точки(-ек), имеющих равные координаты.\n ѕостроить трапецию не представл¤етс¤ возможным.";
		assert(validTrap(P)) : "” трапеции имеютс¤ два основа¤, которые должны быть параллельны друг другу, с данными координатами построение трапеции невозможно";
		this.points = P;
		if (P[0] != null){
			Name_Tr = P[0].Name;
			for(int i = 1; i < 4; i++) {
				Name_Tr += P[i].Name;
			}
		}
		else{
			Name_Tr = "Undefined Name";
		}

	}

	Trapezium(String str){
		assert(str != null) : "строка дл¤ инициализации не может быть пустой";
		int num = 1, index = 0, indexBeg = 0;
		while((index = str.indexOf('|', indexBeg)) != -1) {
			indexBeg = index + 1;
			num++;
		}
		assert(num == 13) : "—трока имеет неверные данные, инициализаци¤ трапеции невозможна";
		StringTokenizer st = new StringTokenizer(str, "|");
		int i = 0;
		Point[] p = new Point[4];
		String Name_TR = "";
		int k = -1;
		double k1 = 0, k2 = 0;
		String s = null;
		while (st.hasMoreTokens()) {
			if ( k == -1) {
				Name_Tr = st.nextToken("|");
				k++;
			}
			if (k == 0) {
				s = new String(st.nextToken("|"));
				Name_TR += s;
				k++;
			}
			if ( k == 1) {
				k1 = Double.parseDouble(st.nextToken());
				k++;
			}
			if( k == 2) {
				k2 = Double.parseDouble(st.nextToken());
				p[i] = new Point(k1, k2, s);
				k = 0;
				i++;
			}
		}
		assert (Name_Tr.compareTo(Name_TR) == 0) : "»м¤ трапеции не совпало с именами точек, перепроверьте свои данные";
		points = p;
	}

	public double Area() {
		double S = 0;
		S = Math.abs((this.points[0].x - this.points[1].x)*(this.points[0].y + this.points[1].y)
				+ (this.points[1].x - this.points[2].x)*(this.points[1].y + this.points[2].y)
				+ (this.points[2].x - this.points[3].x)*(this.points[2].y + this.points[3].y)
				+ (this.points[3].x - this.points[0].x)*(this.points[3].y + this.points[0].y));
		S /= 2;
		return S;
	}

	public double Perimeter() {
		double P = 0;
		for (int i = 0; i < 3; i++)
			P += Math.sqrt(Math.pow(this.points[i].x - this.points[i+1].x, 2) + Math.pow(this.points[i].y - this.points[i+1].y, 2));
		P += Math.sqrt(Math.pow(this.points[0].x - this.points[3].x, 2) + Math.pow(this.points[0].y - this.points[3].y, 2));
		return P;
	}

	//перегрузка методов
	public Iterator<Object> iterator(){
		return this;
	}
	int iterator_index = 0;
	public void reset() {
		iterator_index = 0;
	}
	public boolean hasNext() {
		return iterator_index > 1 ? false : true;
	}
	public void remove() {
		//
	}
	public Object next() {
		if(iterator_index == 0) {
			iterator_index++;
			return Name_Tr;
		}
		else if (iterator_index == 1) {
			iterator_index++;
			return new String(Name_Tr);
		}
		else {
			reset();
			return null;
		}
	}
	public int compareTo(Trapezium Tr) {
		switch(sortBy) {
			case 0: {
				return Name_Tr.compareTo(Tr.Name_Tr);
			}
			case 1:{
				return Double.compare(Area(), Tr.Area());
			}
			case 2:{
				return Double.compare(Perimeter(), Tr.Perimeter());
			}
		}
		return 0;
	}

	//дл¤ сортировки массива данных объектов
	private static int sortBy = 0;
	public static int getSortBy() {
		return sortBy;
	}
	public static void setSortBy( int value ) {
		assert(value >= 0 && value < names.length) : "Ќеправильный номер дл¤ сортировки";
		sortBy = value;
	}
	public static String getSortByName() {
		return Trapezium.names[Trapezium.getSortBy()];
	}
	public String toString() {
		String str = Name_Tr + "(";
		if (points[0] != null){
			for(int i = 0; i < 3; i++) {
				str += points[i].toString() + ", ";
			}
			str += points[3].toString() + ")";
		}
		else{
			str += "null" +  ")";
		}

		return str;
	}

	protected boolean validTrap(Point[] p) {
		boolean f1 = false;
		boolean f2 = false;
		double A1 = (p[0].y - p[1].y);
		double A2 = (p[3].y - p[2].y);
		double B1 = (p[1].x - p[0].x);
		double B2 = (p[2].x - p[3].x);

		if(A1*B2 - A2*B1 == 0)
			f1 = true;

		A1 = (p[1].y - p[2].y);
		A2 = (p[3].y - p[0].y);
		B1 = (p[2].x - p[1].x);
		B2 = (p[0].x - p[3].x);

		if(A1*B2 - A2*B1 == 0)
			f2 = true;

		if (f1 == false && f2 == false)
			return f1;
		if (f1 == true && f2 == true)
			return false;
		if (f1 != f2)
			return true;
		return true;
	}
	protected boolean validPoints(Point[] p) {
		boolean f = true;
		for(int i = 0; i < 3; i++) {
			for(int j = i + 1; j < 4; j++)
				if (p[i] == p[j])
					f = false;
		}
		return f;
	}
	protected boolean validPointsNull(Point[] p) {
		boolean f = true;
		for(int i = 0; i < 4; i++)
			if(p[i] == null)
				f = false;
		return f;
	}
}