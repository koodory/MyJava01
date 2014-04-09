package basic.exam06.jdbc.up4;

import java.lang.reflect.Method;

public class Episode01 {

	public static void main(String[] args) throws ClassNotFoundException {
	
		// c:>java hello aaa bbb ccc
		// args[0] --> "aaa"
		// args[1] --> "bbb"
		// args[2] --> "ccc"
		// 공백을 기준으로 각각의 배열에 집어넣음
		
		// c:>java SubjectMgt2 exam06.jdbc.up4.MysqlSubjectDao
		// args[0] --> "basic.exam06.jdbc.up4.MysqlSubjectDao"
		// args : 애플리케이션 파라미터
		
    //		String subjectDaoClassName = args[0];
		
		// 클래스 이름만 알면 클래스를 로딩할 수 있다.
		// Class.forName(패키지명 + 클래스 명);
		// => 로딩된 클래스 정보를 다루는 객체(java.lang.class)
	  // class를 사용할 수 없어서 clazz 사용
	  
		Class clazz = Class.forName("basic.exam06.jdbc.up4.MysqlSubjectDao");
	  for(Method method: clazz.getMethods()){
	  	System.out.println("-->"+method.getName());
	  }
	  
	}
}
