package ch12.sec03.exam01;

public class EqualsExample {
	public static void main(String[] args) {
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");
		System.out.println("obj1.hashcode: " + obj1.hashCode());
		System.out.println("obj2.hashcode: " + obj2.hashCode());
		System.out.println("obj3.hashcode: " + obj3.hashCode());
		
		//equals는 값만
		//hashCode()는 해시값
		if(obj1.equals(obj2)) {
			System.out.println("obj1과 obj2는 동등합니다.");
		}
		else {
			System.out.println("obj1과 obj2는 동등하지 않습니다.");
		}
		
		if(obj1.equals(obj3)) {
			System.out.println("obj1과 obj3는 동등합니다.");
		}
		else {
			System.out.println("obj1과 obj3는 동등하지 않습니다.");
		}
		System.out.println();
		
		System.out.println(obj1.equals(obj2) ? "obj1과 obj2는 동등합니다." : "obj1과 obj2는 동등하지 않습니다."); 
		System.out.println(obj1.equals(obj3) ? "obj1과 obj3는 동등합니다." : "obj1과 obj3는 동등하지 않습니다.");
	}
}
