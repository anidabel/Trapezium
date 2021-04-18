import java.util.*;

public class main {
	public static void Sort_Print(Trapezium[] Tr) {
		System.out.print("\nотсортировать массив трапеций можно ");
		for(int i = 0; i < Trapezium.names.length; i++) {
			System.out.print(Trapezium.names[i] + ", ");
		}
		//Trapezium.setSortBy(2);
		System.out.println("\n\nотсортированно " + Trapezium.getSortByName());
		Arrays.sort(Tr);
		for(Trapezium i : Tr) {
			System.out.println(i.toString());
		}
	}
	public static void main(String[] args) {
		//демонстрация конструкторов класса Point
		System.out.println("демонстрация конструкторов класса Point");
		Point[] Demo = new Point [3];
		Demo [0] = new Point();
		Demo [1] = new Point(10, -3);
		Demo [2] = new Point(1, 3, "A");

		for(int i = 0; i < 3; i++)
			System.out.println(Demo[i].toString());
		System.out.println();

		final int n = 4;
		Point[] P = new Point [n];

		//пример инициализации и методов вычислени¤ площади и периметра
		System.out.println("пример инициализации и методов вычислени¤ площади и периметра");
		P[0] = new Point(0, 0, "A");
		P[1] = new Point(8, 7, "B");
		P[2] = new Point(8, -7, "C");
		P[3] = new Point(0, -3, "D");

		Trapezium Trap = new Trapezium(P);
		double S1 = Trap.Area();
		double P1 = Trap.Perimeter();
		System.out.println("площадь трапеции Trap = " + S1);
		System.out.println("периметр трапеции Trap = " + P1 + '\n');
		System.out.println(Trap.toString());

		//проверка перехода к строке
    for(int i = 0; i < 4; i++)
      P[i] = null;

    Trapezium Trapezia = new Trapezium(P);
    System.out.println(Trapezia.toString());

		//массив трапеций и сортировка
		System.out.println("\nмассив трапеций и сортировка");
		Trapezium[] Trapez = new Trapezium[5];
		Trapez[0] = new Trapezium("ABCD|A|0|0|B|8|7|C|8|-7|D|0|-3");
		Trapez[1] = new Trapezium("A1B1C1D1|A1|3|5|B1|7|5|C1|5|1|D1|-1|1");
		Trapez[2] = new Trapezium("A5B5C5D5|A5|-1|3|B5|6|3|C5|5|5|D5|2|5");
		Trapez[3] = new Trapezium("A9B7C0D6|A9|1|5|B7|7|5|C0|5|-3|D6|-4|-3");
		Trapez[4] = new Trapezium("A2B4C8D4|A2|-4|4|B4|4|9|C8|4|1|D4|-4|-1");

		for(int i = 0; i < 5; i++) {
			System.out.println(Trapez[i].toString());
      System.out.println("площадь трапеции Trap = " + Trapez[i].Area() + "\n");
      System.out.println("периметр трапеции Trap = " + Trapez[i].Perimeter() + '\n');
		}
		Sort_Print(Trapez);
	}
}