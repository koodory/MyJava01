package basic.exam06.jdbc.up3;

import java.util.List;
import java.util.Scanner;

// insert, list, update, delete 기능을 하나로 합친다.

public class SubjectMgt {
	static Scanner sc = new Scanner(System.in);

	public static void testInsert() throws Throwable {
		SubjectVo subject = new SubjectVo();
		subject.title = "Java의 신";
		subject.description = "자바의 신을 존경할 수 있을 정도의 실력으로 향상시킴.";

		SubjectDao dao = new SubjectDao();
		dao.insert(subject);

		System.out.println("등록 성공!!!");
	}

	public static void testList() throws Throwable {
		SubjectDao dao = new SubjectDao();
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
		SubjectDao dao = new SubjectDao();

		SubjectVo subject = new SubjectVo();
		subject.no = 109;
		subject.title = "오호라..변경";
		subject.description = "이제 내용도 변경하자!";

		dao.update(subject);

		System.out.println("변경 성공!");
	}

	public static void testDelete() throws Throwable {
		SubjectDao dao = new SubjectDao();
		dao.delete(Integer.parseInt(sc.nextLine()));
		System.out.println("삭제 성공!");
	}

	public static void testDetail() throws Throwable {
		SubjectDao dao = new SubjectDao();
		SubjectVo subject = dao.detail(Integer.parseInt(sc.nextLine()));

		System.out.print(subject.no);
		System.out.print(subject.title);
		System.out.println(subject.description);
	}

	public static void main(String[] args){
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
