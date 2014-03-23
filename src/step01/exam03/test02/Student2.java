package step01.exam03.test02;

//* Overriding
// 슈퍼 메서드 중에서 서브 클래스에 맞지 않는 메서드 재정의 하기
// - 문법 : 슈퍼클래스의 method signature 와 동일하게 method를 선언한다
// - method Signature = method name, return type, number & type parameter
// - method Signature =  메서드 이름, 리턴 타입, 파라미터 이름은 상관없다

// * 애노테이션 *
// - 컴파일러와 JVM에 전달하는 아주 특별한 주석
public class Student2{ /*extends Object */
	String  name;
	int 	  kor;
	int			math;
	int 		eng;

	public Student2(String name, int kor, int math, int eng){
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}

	@Override
  public int hashCode() {
	  final int prime = 31;
	  int result = 1;
	  result = prime * result + eng;
	  result = prime * result + kor;
	  result = prime * result + math;
	  result = prime * result + ((name == null) ? 0 : name.hashCode());
	  return result;
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
	  Student2 other = (Student2) obj;
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

	// 수퍼 클래스의 메서드를 재정의
//	public boolean equals(Object obj){ //어떤 객체라도 담을 수 있음
//		if(obj instanceof Student2){ // instanceof : 객체의 주소를 비교하여 T/F 판단
//			Student2 other = (Student2)obj;  //다른 객체에 값을 넣음
//			if(this.kor != other.kor // 두 객체 비교
//					|| this.eng != other.eng
//					|| this.math != other.math 
//					|| !this.name.equals(other.name)){
//				return false;
//			}
//			return true; // 주소는 다르지만 같은 객체이다.
//		}
//		return false;
//	}
}
