package Practice;

public class Ternary {
public static void main(String[] args) {
	int a=28;
	int b=56;
	int c=13;
	
	String results= a>b?a>c? "a is greater": "b is greater":b>c?"b is greater":"c is greater";
	
	System.out.println(results);
}
}
