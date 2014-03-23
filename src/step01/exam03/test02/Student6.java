package step01.exam03.test02;
//* finalize() 재정의
//- 가비지 컬랙터에 의해 소멸하기 전에 호출한다.
//- 소멸되기전에 마무리 될 작업을 기술할 수 있다.
//- C++ 언어에서는 destructor(소멸자)라 부른다.
//- 자바에서는 이 메서드를 잘 사용하지 않는다. 언제 소멸될 지 모른다.
//모든 클래스는 클래스 정보를 다루는 히든 변수를 가지고 있다.
// * Garbage Collector
// 1) 메모리가 부족할 떄
// 2) CPU가 한가할 때
// - 프로그램 종료시까지 실행되지 않을 수도 있다.
/*public static Class class = Student5의 클래스 정보를 담은 인스턴스; */
public class Student6{ /*extends Object */
	String  name;
	int 	  kor;
	int			math;
	int 		eng;

	@Override
	protected void finalize() throws Throwable{
		System.out.println("finalize");
	}
	
	public Student6(String name, int kor, int math, int eng){
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}

	/*@Override 에노테이션
	 *  - 컴파일러에게 정보를 전달
	 *  - 메서드를 오버라이딩 한다는 것을 알림
	 */
	@Override
  public boolean equals(Object obj) {
	  if (this == obj)
		  return true;
	  if (obj == null)
		  return false;
	  if (getClass() != obj.getClass())
		  return false;
	  Student6 other = (Student6) obj;
	  if (eng != other.eng)
		  return false;
	  if (kor != other.kor)
		  return false;
	  if (math != other.math)
		  return false;
	  if (name == null) {
		  if (other.name != null)
			  return false;
	  } else if (!name.equals(other.name))
		  return false;
	  return true;
  }

  @Override
  public String toString() {
    return "["+ this.name + ":" + this.kor + ":" + this.eng + ":" + this.math +"]";
  }
  
	@Override
  public int hashCode() {
	  final int prime = 31; //소수
	  int result = 1;
	  result = prime * result + eng;
	  result = prime * result + kor;
	  result = prime * result + math;
	  result = prime * result + ((name == null) ? 0 : name.hashCode());
	  return result;
  }
}
