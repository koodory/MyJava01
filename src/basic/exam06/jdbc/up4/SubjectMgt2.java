package basic.exam06.jdbc.up4;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;
// 소스를 손대지 않고 SubjectDao 구현체 교체하기
// - 애플리케이션 파라미터로 Dao 클래스 이름을 받는다.
// c:>java hello aaa bbb ccc
// args[0] --> "aaa"
// args[1] --> "bbb"
// args[2] --> "ccc"
// 공백을 기준으로 각각의 배열에 집어넣음

// c:>java SubjectMgt2 exam06.jdbc.up4.MysqlSubjectDao
// args[0] --> "basic.exam06.jdbc.up4.MysqlSubjectDao"

/*
 *  반드시 처음 실행시 팩키지 경로명을 runconfiguration의 program arugement
 *  에 입력시켜야 함--> args[0]에 입력됨
 */
public class SubjectMgt2 {
	static Scanner sc = new Scanner(System.in);
  static SubjectDao dao;
  
	public static void testInsert() throws Throwable {
		SubjectVo subject = new SubjectVo();
		subject.title = "Java의 신";
		subject.description = "자바의 신을 존경할 수 있을 정도의 실력으로 향상시킴.";
		dao.insert(subject);

		System.out.println("등록 성공!!!");
	}

	public static void testList() throws Throwable {
		int pageNo = 1, pageSize = 10;

		do {
			List<SubjectVo> list = dao.list(pageNo, pageSize);
			System.out.println("[" + pageNo + "]----------------------------");
			for(SubjectVo subject : list) {
				System.out.print(subject.no + ",");
				System.out.println(subject.title);
			}		
			pageNo = Integer.parseInt(sc.nextLine());
		} while(pageNo > 0);
	}

	public static void testUpdate() throws Throwable{
		SubjectVo subject = new SubjectVo();
		subject.no = 109;
		subject.title = "오호라..변경";
		subject.description = "이제 내용도 변경하자!";

		dao.update(subject);

		System.out.println("변경 성공!");
	}

	public static void testDelete() throws Throwable {
		dao.delete(Integer.parseInt(sc.nextLine()));
		System.out.println("삭제 성공!");
	}

	public static void testDetail() throws Throwable {
		SubjectVo subject = dao.detail(Integer.parseInt(sc.nextLine()));

		System.out.print(subject.no);
		System.out.print(subject.title);
		System.out.println(subject.description);
	}

	public static void main(String[] args) throws Exception{
		if(args.length>0) {
		Class clazz =	Class.forName(args[0]);
		dao = (SubjectDao) clazz.newInstance(); //형변환 하여 새 인스턴스 생성
		} else{
			throw new Exception("SubjectDao 구현체를 지정하지 않았다!");
		}
	  
		dao = new MysqlSubjectDao();
		String command = null;
		do{
			try{
				System.out.print("명령>");
				command = sc.nextLine();
				switch(command){
				case "insert": testInsert(); break;
				case "list": testList(); break;
				case "update": testUpdate(); break;
				case "delete": testDelete(); break;
				case "detail" : testDetail(); break;
				}
			}catch(Throwable e){}
		}while(!"q".equals(command));
		System.out.println("시스템 종료!");
		sc.close();
	}
}
