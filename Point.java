public class Point{

	double x;
	double y;
	String Name;

	Point(double k1, double k2, String str){
		assert(validNameOfPoint(str)) : "Неправильное имя точки! Оно может состоять из одной буквы латинского алфавита в начале и последующих цифр";
		this.x = k1;
		this.y = k2;
		this.Name = str;
	}

	protected boolean validNameOfPoint(String str) {
		boolean f = true;
		int kol = 0;
		for(int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i)) && kol == 0 || Character.isDigit(str.charAt(i)))
				kol++;
			else
				f = false;
		}
		return f;
	}

	Point(){
		x = 0;
		y = 0;
		Name = "Not exist";
	}

	Point(double k1, double k2){
		x = k1;
		y = k2;
		Name = "Undefined Name";
	}

	public String toString() { //к строке
		String str = null;
		if (this.Name == null){
			str = "Undefined Name"+ "(" + this.x + ", " + this.y + ")";
		}
		else
			str = this.Name + "(" + this.x + ", " + this.y + ")";
		return str;
	}
}