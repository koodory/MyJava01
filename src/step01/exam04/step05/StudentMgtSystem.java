package step01.exam04.step05;

/* 클래스 변수 초기화 : static {} 블록
 *  - 인스턴스 변수는 생성자를 통해 초기화 할 수 있다.
 *  - 클래스 변수는 ? 스택틱 블록을 통해 초기화 할 수 있다.
 *  
 *  상수 변수의 사용
 *  - 상수 값이 소스 코드의 여러 곳에서 사용된다면 유지보수를 좋게 하기 위해
 *  - 클래스 변수로 정의해 두는 것이 좋다. -> 변경이 쉬워 진다.
 */
import java.util.Scanner;

import step01.exam03.test02.Student;
public class StudentMgtSystem { 
	private static Scanner scanner = new Scanner(System.in);
	
	// StudentScore 주소를 저장할 레퍼런스 배열 생성
	private static StudentScore[] scoreList;
	private static int scoreSize = 0;
	// 상수 변수의 선언 => 인스턴스 별로 값이 다르지 않다. => 클래스 변수로 만듬
	// => 참조 용(read only)이기 때문에 값을 바꿀 수 없도록 한다.
	// => final로 선언: 값을 한번만 할당 가능
	private static final int SCORE_MAX_SIZE = 3; 
	
	// static 블럭은 클래스 변수를 초기화 하는 용도로 사용한다.
	// 클래스 로딩 => 클래스 변수 생성 및 초기화 문장 수행 => static 블록 수행]
	static{
		scoreList = new StudentScore[SCORE_MAX_SIZE];
	}
	private static String[] promptCommand(){
		System.out.print("명령>");
		String input = scanner.nextLine(); // 키보드로 들어온 값을 익는다 엔터를 만날떄까지..
	
		return input.split(" ");
	}
	
	// 실무에서는 좀 더 코드의 잘못된 사용을 방지하기 위해 
	// 파라미터 변수에 final로 선언한다.
	private static void executeAdd(final String value) {
	  String input;
	  
	  // 로컬 변수에 담는 대신 클래스 변수에 저장한다
	  //StudentScore score = StudentScore.fromSCV(value);
	  if(scoreSize < SCORE_MAX_SIZE){
	  	scoreList[scoreSize++] = StudentScore.fromCSV(value);
	  } else{
	  	System.out.println("저장소가 꽉 찼습니다.");
	  	return; // 즉시를 함수를 탈출
	  }
	  
	  System.out.println("이름 : " + scoreList[scoreSize-1].name);
	  System.out.println("국어 : " + scoreList[scoreSize-1].kor);
	  System.out.println("영어 : " + scoreList[scoreSize-1].eng);
	  System.out.println("수학 : " + scoreList[scoreSize-1].math);
	  System.out.print("등록하시겠습니까?(y/n)");
	  input = scanner.nextLine();
	  if("y".equals(input.toLowerCase())){
	  	System.out.println("등록되었습니다.");
	  }else{
	  	System.out.println("등록 취소되었습니다.");
	  }
  }
	
	public static void executeList(){
		for(StudentScore score : scoreList){
			 System.out.println(score);
		}
	}
	
	public static void main(String[] args) {
		String input = null; //로컬 변수는 항상 null로 초기화 한다.
		
		do{
			String[] values = promptCommand();
			
			if("add".equals(values[0])){ 
				executeAdd(values[1]);
			}else if("list".equals(values[0])){
				executeList();
			}else if("quit".equals(values[0])){
				System.out.println("프로그램을 종료합니다.");
				break;
			}else{
				System.out.println("사용할 수 없는 명령어입니다.");
			}
		}while(true);
		scanner.close();
	}
}