package test_prep.step10;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class StudentMgtSystem10 {
	static Scanner scanner = new Scanner(System.in);

	private static String promptMenu(){		
		System.out.print("명령>");
		return scanner.nextLine().toLowerCase();
	}

	public static void main(String[] args) {
		do{
			String menu = promptMenu();
			if("1".equals(menu)){
				//StudentControl.execute();
			}else if("2".equals(menu)){
				StudentScoreControl10.execute();
			}else if("list".equals(menu)){
				System.out.println("1. 학생 관리");
				System.out.println("2. 점수 관리");
				System.out.println("q. 종료");
			}else if("q".equals(menu)){
				System.out.println("프로그램을 종료합니다.");
				break;
			}else{
				System.out.println("해당 명령어를 찾을 수 없습니다.");
			}
		}while(true);
		scanner.close();
	}
}
