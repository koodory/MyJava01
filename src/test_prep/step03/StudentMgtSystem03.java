package test_prep.step03;

import java.util.Scanner;

public class StudentMgtSystem03 {
	private static Scanner scanner = new Scanner(System.in);
	
	private static String[] promptCommand(){		
		System.out.print("명령>");
		String input = scanner.nextLine();

		return input.split(" ");
	}
	
	private static void executeAdd(String value) {
	  String input;
	  String[] data = value.split(",");
	  
		StudentScore score = new StudentScore(data[0]);
		score.kor = Integer.parseInt(data[1]);
		score.eng = Integer.parseInt(data[2]);
		score.math = Integer.parseInt(data[3]);
		
		System.out.println("이름 : " + score.name);
		System.out.println("국어 : " + score.kor);
		System.out.println("영어 : " + score.eng);
		System.out.println("수학 : " + score.math);

	  System.out.println("등록하시겠습니까?(y/n) : ");
	  input = scanner.nextLine();
	  if("y".equals(input.toLowerCase())){
	  	System.out.println("등록되었습니다.");
	  }else{
	  	System.out.println("등록이 취소되었습니다.");
	  }
  }
	
	public static void main(String[] args) {
		do{
			String[] values = promptCommand();
			if("add".equals(values[0])){
				executeAdd(values[1]);
			}else if("q".equals(values[0])){
				System.out.println("프로그램을 종료합니다.");
				break;
			}else{
				System.out.println("해당 명령어를 찾을 수 없습니다.");
			}
		}while(true);
		scanner.close();
	}
}
