package test_prep.step06;

import java.util.Scanner;

public class StudentMgtSystem06 {
	private static Scanner scanner = new Scanner(System.in);
	
	private static StudentScore[] scoreList;
	private static int scoreSize;
	private static final int SCORE_MAX_SIZE = 3;
	
	static{
		scoreList = new StudentScore[SCORE_MAX_SIZE];
	}
	
	private static String[] promptCommand(){		
		System.out.print("명령>");
		String input = scanner.nextLine();

		return input.split(" ");
	}

	private static void executeAdd(final String value) {

		if(scoreSize < SCORE_MAX_SIZE){
			scoreList[scoreSize++] = StudentScore.fromCSV(value);
		} else{
			System.out.println("저장할 공간이 없습니다.");
			return;
		}
	
		System.out.println("이름 : " + scoreList[scoreSize - 1].name);
		System.out.println("국어 : " + scoreList[scoreSize - 1].kor);
		System.out.println("영어 : " + scoreList[scoreSize - 1].eng);
		System.out.println("수학 : " + scoreList[scoreSize - 1].math);

	  System.out.print("등록하시겠습니까?(y/n) : ");
	  String input = scanner.nextLine();
	  if("y".equals(input.toLowerCase())){
	  	System.out.println("등록되었습니다.");
	  }else{
	  	System.out.println("등록이 취소되었습니다.");
	  }
  }
	
	private static void executeList() {
		for(StudentScore score: scoreList){
			System.out.println(score);
		}
  }
	
	public static void main(String[] args) {
		do{
			String[] values = promptCommand();
			if("add".equals(values[0])){
				executeAdd(values[1]);
			}else if("list".equals(values[0])){
				executeList();
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
