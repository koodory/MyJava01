package step01.exam03;

public class Test01 {
/*문자열 다루기
 *  - C에서는 char[] 배열로 다룬다
 *  - 자바에서도 char[] 배열로 다룬다. 
 *  - 내부의 복잡한 명령어를 감추고(캡슐화)
 *  - java.lang.String 클래스 제공
 */
	
	public static void main09(String[] args){
		//스트링의 비교
		StringBuffer s1 = new StringBuffer("나는 홍길동이다.");
    StringBuffer s2 = new StringBuffer("나는 홍길동이다.");
  
		// 만약 s3의 문자열 s1과 같지 않으면 상수 풀의 다른 주소로 생성
		 if(s1 == s2) System.out.println("s1 == s2, 같은 주소 사용");
		 
		 //주소로 비교
		 if(s1.equals(s2)) System.out.println("s1 is equals to s2");
	}
	
	public static void main08(String[] args){
		//스트링의 비교 <= 스트링 클래스에서 상속받은 equals()를 재정의
		String s1 = new String("나는 홍길동이다.");
    String s2 = new String("나는 홍길동이다.");
//	String s2 = s1;
	
		// 만약 s3의 문자열 s1과 같지 않으면 상수 풀의 다른 주소로 생성
		 if(s1 == s2) System.out.println("s1 == s2, 같은 주소 사용");
		 
		 //내용물이 같은 지 비교
		 if(s1.equals(s2)) System.out.println("s1 is equals to s2");
	}
	
	public static void main07(String[] args){
		//Heap에 있는 스트링 인스턴스를 Constant Pool에 복제하기
		String s1 = new String("나는 홍길동이다.");
		String s2 = s1.intern();
		String s3 = "나는 홍길동이다.";
		// 만약 s3의 문자열 s1과 같지 않으면 상수 풀의 다른 주소로 생성
		 if(s2 == s3) System.out.println("s2 == s3");
	}

	public static void main06(String[] args){
		//상수 스트림의 substring() 리턴값, substring의 instance는 heap에 생성
		String s1 = new String("나는 홍길동이다.");
		String s2 = s1.substring(3);
		String s3 = s1.substring(3);

		 if(s2 == s3) System.out.println("s2 == s3"); 
	}
	
	public static void main05(String[] args){
		//상수 스트림
		// - new String() 의 단축 명령이다.
		// - 상수 스트림으로 만든 인스턴스는 Constant Pool에 존재한다.
		// - 중복해서 생성되지 않는다. --> 메모리의 절약을 위함
		String s1 = new String("나는 홍길동이다.");
		String s2 = "나는 홍길동이다."; // --> new String("문자열"); 단축
		String s3 = "나는 홍길동이다.";
		// 이러한 형태를 상수 Stream이라 함
		
		System.out.println(s1);
		System.out.println(s2);
	   
		 if(s1 == s2 ) System.out.println("s1 == s2");
		 if(s1 == s3 ) System.out.println("s1 == s3");
		 if(s2 == s3 ) System.out.println("s2 == s3");
	}
	public static void main04(String[] args){
		//mutable vs immutable 메소드(변경 vs 고정)
		// String 인스턴스의 값은 한번 결정되면 변경되지 않는다.
		String s1 = new String("나는 홍길동이다.");
		String s2 = s1.replace("홍길동", "임꺽정"); // 새 String instance 생성후 리턴
		
		System.out.println(s1);
		System.out.println(s2);
		
		// StringBuffer Class : mutable Object, 인스턴스의 값 변경 가능
		StringBuffer s3 = new StringBuffer("나는 홍길동이다.");
		s3.replace(3, 6, "임꺽정"); //마지막 인데스는 변경 안된 다음 문자열 출력될 첫주소
		System.out.println(s3);
	}

	public static void main03(String[] args) {
	  String s1 = new String("나는 홍길동이다.");
	  System.out.println(s1.charAt(3)); // 특정 index의 문자 추출
	  System.out.println(s1.indexOf('홍')); // 특정 문자가 속한 index 추출
	  String s2 = s1.substring(3); //새 String instance를 생성하여 리턴
	  String s3 = s1.substring(3); //새 String instance를 생성하여 리턴
	  System.out.println(s2);
	  System.out.println(s3);
	  if(s2 == s3){
	  		System.out.println("s2 == s3");
	  	}else{
	  		System.out.println("s2 != s3");
	  }
	  // String class의 indexOf 메소드를 호출하고, 
	  // s1 인스턴스의 주소값을 indexOf 메소드의 this 히든 변수에 넣어서
	  // this가 가리키는 인스턴스로 이동하여
	  // parameter로 넘어온 '홍'과 일치하는 Unicode를 가지는 배열주소를 찾아서 리턴
	  // java는 영문 한글 모두 2byte.. index가 동일
	  /* C로 구현한 내부 알고리즘
	  
	  #include <stdio.h>	   
		#include <string.h>

		int indexOf(char* s1 , char str){
		int i;
		char* txt = s1; //this의 주소를 담음
		int length = strlen(s1);
		for(i=0; i<= length; i++){ // 배열 주소 찾는 알고리즘
			if( txt[i] == str){
				return i;
			  }
		  }
	  }

	  void main(void){
	  char str = '홍';
	  char buf[22]= {"홍길동 입니다."}; //this의 instance
	  int var = indexOf(buf, str);
	  rintf("홍 is found at the %2dth index in [%s]\n", var , buf);
	  };
	  
	 */
	}
	
	// s1과 s2는 주소가 다르다
	public static void main02(String[] args) {
	  String s1 = new String("나는 홍길동이다.");
	  String s2 = new String("나는 홍길동이다.");
	  
	  if(s1 == s2){
	  	System.out.println("s1 == s2");
	  }else{
	  	System.out.println("s1 != s2"); 
	}
	}
	public static void main01(String[] args) {
	  String s1 = new String("나는 홍길동이다.");
	  String s2 = s1;
	  String s3 = s2;
	  System.out.println(s3);
	}
}
