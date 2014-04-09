package basic.exam06.jdbc.up4;

import java.util.List;
import java.util.Scanner;
// SubjectDao를 인터페이스로 만든다.
// insert, list, update, delete, detail을 하나로 합친다.
// - 각 DBMS별로 구현체를 만든다.

public class SubjectMgt {
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

	public static void main(String[] args){
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
