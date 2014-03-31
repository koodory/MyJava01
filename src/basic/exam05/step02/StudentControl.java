package basic.exam05.step02;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentControl {
	static Scanner scanner;

	private static ArrayList<Student> studentList = new ArrayList<Student>();

	static{
		scanner = StudentMgtSystem.scanner;
	}

	private static void executeAdd(final String value){
		String input;

		Student student = Student.fromCSV(value);

		System.out.println("이름:" + student.name);
		System.out.println("전화번호:" + student.tel);
		System.out.println("이메일:" + student.email);
		System.out.println("주소:" + student.address);

		System.out.print("등록하시겠습니까?(y/n)");
		input = scanner.nextLine();
		if("y".equals(input.toLowerCase())){
			studentList.add(student);
			System.out.println("등록되었습니다.");
		}else{
			System.out.println("등록취소하였습니다.");
		}
	}

	private static void executeList(){
		int i = 0;
		for(Student student : studentList){
			System.out.println(i++ + " " + student);
		}
	}

	private static void executeDelete(final int no){
		if(no >= 0 && no < studentList.size()){
			System.out.println( no + "번 자료를 삭제하였습니다.");
			studentList.remove(no);
		} else {
			System.out.println("유효하지 않은 번호입니다.");
		}
	}

	private static void executeUpdate(final int no){
		if(no >= 0 && no < studentList.size()){
			Student student = studentList.get(no);
			System.out.print("이름(" + student.name + ") : ");
			String input = scanner.nextLine();
			Student temp = new Student(input);

			System.out.print("나이(" + student.age + ") : ");
			input = scanner.nextLine();
			temp.age = Integer.parseInt(input);

			System.out.print("전화번호(" + student.tel + ") : ");
			input = scanner.nextLine();
			temp.tel = input;

			System.out.print("이메일(" + student.email + ") : ");
			input = scanner.nextLine();
			temp.email = input;

			System.out.print("주소(" + student.address + ") : ");
			input = scanner.nextLine();
			temp.address = input;

			System.out.print("변경하시겠습니까?(y/n)");
			input = scanner.nextLine();
			if("y".equals(input.toLowerCase())){
				studentList.set(no, temp);
				System.out.println("변경되었습니다.");
			}else{
				System.out.println("변경 취소되었습니다.");
			}
		}else{
			System.out.println("유효하지 않은 번호입니다.");
		}
	}
	private static void executeSave(){
		try{
			FileWriter out = new FileWriter("student.dat");
			for(Student student: studentList){
				out.write(student.toString()+"\n");
			}
			out.close();
			System.out.println("저장되었습니다.");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static void executeLoad(){
		try{
			FileReader in = new FileReader("student.dat");
			Scanner scan = new Scanner(in);
			studentList.clear();
			while(true){
				try{
					studentList.add(Student.fromCSV(scan.nextLine()));
				}catch(NoSuchElementException ex){
					break;
				}
			}
			scan.close();
			in.close();
			System.out.println("로딩되었습니다.");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static void execute(){
		initMenu();
		do{
			String[] value = promptCommand();

			if("add".equals(value[0])){
				executeAdd(value[1]);
			} else if("list".equals(value[0])){
				executeList();
			} else if("delete".equals(value[0])){
				executeDelete(Integer.parseInt(value[1]));
			} else if("update".equals(value[0])){
				executeUpdate(Integer.parseInt(value[1]));
			} else if("save".equals(value[0])){
				executeSave();
			} else if("load".equals(value[0])){
				executeLoad();
			} else if("init".equals(value[0])){
				initMenu();
			} else if ("menu".equals(value[0])){
				break;
			} else {
				System.out.println("사용할 수 없는 명령어 입니다.");
			}
		}while(true);
	}

	private static void initMenu(){
		System.out.printf("\n\n< 학생관리 메뉴>\n");
		System.out.println("---------------------------------------------------------------");
		System.out.println("list. 목록출력(번호 확인가능)");
		System.out.println("add. 학생정보 추가 , 예) add 학생이름,나이,전화번호,이메일,주소");
		System.out.println("delete. 학생정보 삭제 , 예) delete 번호");
		System.out.println("update. 학생정보 갱신 , 예) update 번호");
		System.out.println("save. 학생정보 저장");
		System.out.println("load. 학생정보 불러오기");
		System.out.println("init. 학생관리 메뉴 다시보기");
		System.out.println("menu. 이전메뉴로");
		System.out.println("---------------------------------------------------------------");
	}
	
	private static String[] promptCommand(){
		System.out.printf("\n학생관리>");
		String input = scanner.nextLine();
		return input.split(" ");
	}
}
