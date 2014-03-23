package step01.exam03.test02;

public class StudentTest{

	public static void main(String[] args){
		Student6 s1 = new Student6("홍길동",90,100,90);
		s1 = null;
		System.out.println("안녕");
	}
	
	public static void main05(String[] args) {
		//toString 및 hashCode() 재정의 하기 전
		
		Student s1 = new Student("홍길동",90,100,90);
		Student5 s2 = new Student5("홍길동",90,100,90);
	
		Class c1 = s1.getClass(); //인스턴스를 생성할 때 사용한 클래스 정보를 리턴
		Class c2 = s2.getClass();//인스턴스를 생성할 때 사용한 클래스 정보를 리턴
		
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		
		// 클래스 정보를 바로 꺼내기, class = getClass()는 같은 class 참조
		// - 클래스 정보를 가리키는 특별한 static 변수 'class'
		Class c3 = Student.class;
		Class c4 = Student5.class;
		System.out.println(c3.getName());
		System.out.println(c4.getName());
		
		if(c1 == c3){
			System.out.println("c1 == c3");
		}
		
		if(c2 == c4){
			System.out.println("c2 == c4");
		}
		
	}
	
	public static void main04(String[] args) {
		//toString 및 hashCode() 재정의 하기 전
		
		Student s1 = new Student("홍길동",90,100,90);
		Student s2 = new Student("홍길동",90,100,90);
		
		System.out.println(Integer.toHexString(s1.hashCode()));
		System.out.println(s1);
		System.out.println(Integer.toHexString(s2.hashCode()));
		System.out.println(s2);
		
		// hashCode()와 toString() 재정의
		Student4 s3 = new Student4("홍길동",90,100,90);
		Student4 s4 = new Student4("홍길동",90,100,90);
		
		System.out.println(Integer.toHexString(s3.hashCode()));
		System.out.println(s3);
		System.out.println(Integer.toHexString(s4.hashCode()));
		System.out.println(s4);
		
	}
	
	public static void main03(String[] args) {
		//testString() 사용하기	
		Student2  s1 = new Student2("홍길동",90,100,90);
		
		//println() 함수는 파라미터로 날라온 인스턴스에 대해 toString메서드를 호출한다.
		// 그리고, toString()이 리턴한 문자열을 출력한다.
		//toString()은 Object 클래스의 메서드이다.
		// 출력형식: fully qualified class name(Qname) @hash code
		// - hash code: 인스턴스 식별 번호이다.
		System.out.println(s1); //
		
		Student3  s2 = new Student3("홍길동",90,100,90);
		System.out.println(s2);
	}
	
	public static void main02(String[] args) {
		//student에서 재정의 한 equal()사용하기
		
		Student2  s1 = new Student2("홍길동",90,100,90);
		Student2  s2 = new Student2("홍길동",90,100,90);
		
		if(s1 == s2) System.out.println("s1 == s2");
		if(s1.equals(s2)) System.out.println("s1.equals(s2)");
		//원래는 출력되지 않으니 equals가 재정의되서 두 오브젝트를 비교 가능
	}

	public static void main01(String[] args) {
		//Object로 부터 상속받은 equals는 == 연산자와 동일하게 쓰인다. 인스턴스가
		// 같은지 비교하는데 사용
		Student  s1 = new Student("홍길동",90,100,90);
		Student  s2 = new Student("홍길동",90,100,90);
		
		if(s1 == s2) System.out.println("s1 == s2");
		if(s1.equals(s2)) System.out.println("s1.equals(s2)");
	}

}
