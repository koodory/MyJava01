package basic.exam06.jdbc.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CourseMgt02 {
	private static Scanner scan = new Scanner(System.in);

	public static void insert() throws Throwable{
		CourseVo course = new CourseVo();
		CourseDao dao = new CourseDao();
		course.title = "오호라";
		course.description  = "오호라 통제로다~내용입력";
		course.hours = 10;
		dao.insert(course);
		System.out.println("입력성공");
	}

	public static void list() throws Throwable{
		CourseDao dao = new CourseDao();
		int pageNo = 1, pageSize = 10;
		do{
			List<CourseVo> list = dao.list(pageNo, pageSize); 
			
			System.out.println("["+pageNo+"]------------------------------------");
			for(CourseVo course: list){
				System.out.print(course.no +",");
				System.out.print(course.title +",");
				System.out.println(course.hours);
			}
			pageNo = Integer.parseInt(scan.nextLine());
		}while(pageNo > 0);
		scan.close();
	}

	public static void update() throws Throwable{
		CourseDao dao = new CourseDao();
		
		CourseVo course = new CourseVo();
		course.no = 122;
		course.title = "오호라..변경";
		course.description = "이제 내용도 변경하자!";
		course.hours = 2;
		
		dao.update(course);
		
		System.out.println("변경성공");
	}

	public static void delete() throws Throwable{
		CourseDao dao = new CourseDao();
		
		dao.delete(Integer.parseInt(scan.nextLine()));
				
		System.out.println("삭제성공");
		scan.close();
	}

	public static void menu() throws Throwable{
		do{
			System.out.println("\n\n--- 교육과정 --- ");
			System.out.printf("    1. 삽입");
			System.out.printf("\n    2. 출력");
			System.out.printf("\n    3. 변경");
			System.out.printf("\n    4. 삭제");
			System.out.printf("\n    Q. 종료\n");
			System.out.println("----------------");
			System.out.printf(">> 메뉴 입력 : ");
			String input = scan.nextLine();

			if("q".equals(input.toLowerCase())){
				System.out.println("프로그램 종료");
				return;
			}else if("1".equals(input)){
				insert();
			}else if("2".equals(input)){
				list();
			}else if("3".equals(input)){
				update();
			}else if("4".equals(input)){
				delete();
			}else{
				System.out.println("다시 입력하세요");
			}
		}while(true);
	};


	public static void main(String[] args){
		try{
			System.out.println("오호라..연결되었다!");
			menu();
		}catch(Throwable ex){
			ex.printStackTrace();
		}
	}
}
