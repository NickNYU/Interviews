package lesson16Reflection;

public class ReflectPoint {
	public int x;
	private int y;
	
	private String str1 = "ball";
	private String str2 = "pass the ball";
	
	public ReflectPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}

	public String getStr2() {
		return str2;
	}

	public void setStr2(String str2) {
		this.str2 = str2;
	}

	public ReflectPoint(int x, int y, String str1, String str2) {
		super();
		this.x = x;
		this.y = y;
		this.str1 = str1;
		this.str2 = str2;
	}

	
	
}
