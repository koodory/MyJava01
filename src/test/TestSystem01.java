package test;

import java.util.Scanner;

public class TestSystem01 {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		do{
		System.out.print("명령>>");

		String input = scanner.nextLine();
		
		String[] values = input.split(" ");
		if("add".equals(values[0])){
			String[] data = values[1].split(",");
			System.out.println("이름 : " + data[0]);
			System.out.println("국어 : " + data[1]);
			System.out.println("영어 : " + data[2]);
			System.out.println("수학: " + data[3]);
			System.out.print("등록하시겠습니까?(y/n) : " );
			input = scanner.nextLine();
			if("y".equals(input.toLowerCase())){
				System.out.println("등록되었습니다.");
			}else{
				System.out.println("등록 취소되었습니다.");
			}
		}else if("quit".equals(values[0])){
			System.out.println("프로그램을 종료합니다.");
			break;
		}else{
			System.out.println("사용할 수 없는 명령어 입니다.");
		}
	}while(true);
		scanner.close();
	}
}
