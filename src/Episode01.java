/* 다형적 변수
 * - superclass의 참조 변수는 subclass의 인스턴스 주소를 저장할 수 있다.
 * - superclass의 참조 변수는 subclass의 인스턴스를 가리킬 수 있다.
 * - superclass 참조 변수는 subclass 객체를 가리킬수 있다.
 */
class Animal/*extends Object*/{
	
}

class Car/*extends Object*/{
	public void move (){}
	public void stop (){}
	public void start (){}

}

class Truck extends Car{
	int capacity;
	public void dump (){}
	public void load (){}
}

class Sedan extends Car{
	boolean sunroof;
	int trunkSize;
	public void changeAutoGear(){}
}

class Bongo extends Truck{
	boolean isABS;
	public void loadPassenger(){}
}

class Tico extends Sedan{
	
}

public class Episode01 {

	public static void main03(String[] args) {
		
		Car c = new Truck();
		c.start();
		c.move();
		c.stop();
		//c.load(); // 컴파일가 허락하지 않는다. 컴파일러는 융통성이 없다. 글자 그대로 해석하여 판단.
		//c.dump(); // 컴파일가 허락하지 않는다. 컴파일러는 융통성이 없다. 글자 그대로 해석하여 판단.
		
		// 형변환을 통해 원래 클래스의 메서드를 호출할 수 있다.
		// - 임시 주소 변수를 만들어 저장한다. 
		((Truck)c).load();	//ok
		((Truck)c).dump();	//ok
		
		Car c2 = new Car();
		c2.start();
		c2.stop();
		c2.move();
		
		((Truck)c2).load(); // SF 프로그래밍
		((Truck)c2).dump(); // SF 프로그래밍
		
		Car 허태량 = new Car ();
		Truck t = (Truck)허태량; 
		t.start();
		t.move();
		t.stop();
		t.load();
		t.dump();
	}
	
	public static void main02(String[] args) {
		//어떤 참조변수가 subclass의 인스턴스는 가리킬 수 있어도 superclass의 인스턴스를 못 가리키는 이유?
		Car c = new Car();
		c.start();
		c.move();
		c.stop();
		
		// subclass는 superclass의 모든 기능을 갖고 있기 때문에
		// superclass는 참조변수를 통해 subclass의 
		Car c2 = new Truck();
		c2.start();
		c2.move();
		c2.stop();
		
		Car c3 = new Tico();
		c3.start();
		c3.move();
		c3.stop();
		
		Truck c4 = new Truck();
		c4.start(); //car
		c4.move(); //car
		c4.stop(); //car
		c4.dump(); //truck
		c4.load(); //truck
		
		Truck c5 = new Bongo();
		c5.start(); //car
		c5.move(); //car
		c5.stop(); //car
		c5.dump(); //truck
		c5.load(); //truck
		
		// 만약 상위 클래스의 인스턴스를 가리키는 것이 허용된다면?
		// 존재하지 않는 메서드를 호출 할 가능성이 있기 때문에
		// 아래의 문법을 허락하지 않는다.
		/*Truck c6 = new Car();
		c6.start(); //car
		c6.move(); //car
		c6.stop(); //car
		c6.dump(); //truck 메서드로 Car에 존재하지 않는다.
		c6.load(); //truck 메서드로 Car에 존재하지 않는다.
		*/	
}
	
	public static void main01(String[] args) {
		//1. 어떤 자바 객체라도 가리키기
		Object obj;
		obj = new Animal();
		obj = new Car(); 
		obj = new Tico();
		
		//2. 모든 동물을 가리킨다.
		Animal a;
		
		//3. 모든 자동차를 가리킨다.
		Car c;
		c = new Car();
		c = new Truck();
		c = new Sedan();
		c = new Bongo();
		c = new Tico();
		
		//4. 승용차만 가리킨다.
		Sedan c2;
		c2 = new Sedan();
		c2 = new Tico();
		//c2 = new bongo(); // 오류
	}

}
