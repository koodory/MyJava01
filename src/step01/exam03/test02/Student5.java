package step01.exam03.test02;
public class Student5{ /*extends Object */
//* getClass()의 사용
//- 인스턴스의 클래스 정보를 리턴
//- 클래스 정보는 java.lang.Class 객체에 저장되어 있다.
//-
// 모든 클래스는 클래스 정보를 다루는 히든 변수를 가지고 있다.
/*public static Class class = Student5의 클래스 정보를 담은 인스턴스; */
	String  name;
	int 	  kor;
	int			math;
	int 		eng;

	public Student5(String name, int kor, int math, int eng){
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
	  Student5 other = (Student5) obj;
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
