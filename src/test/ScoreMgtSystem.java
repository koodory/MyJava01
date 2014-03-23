package test;

import java.util.*;

public class ScoreMgtSystem {

	static String name[] = new String[10];	
	static int[] kor = new int[10];
	static int[] eng = new int[10];
	static int[] math = new int[10];
	
	static int arr = 0;
	
	public static int Input(String[] name, int[] kor, int[] eng, int[] math, 
		int arr, String data){
		int index = 0;
		boolean flag = false;

		StringTokenizer token = new StringTokenizer(data);

		while(token.hasMoreTokens()) {
			String str = token.nextToken();
			if(str.equals("add") && index == 0){
				flag = true;
			}
			if(flag) {
				switch(index){
				case 1: name[arr] = str;  break;
				case 2: kor[arr] = Integer.parseInt(str); break;
				case 3: eng[arr] = Integer.parseInt(str); break;  
				case 4: math[arr] = Integer.parseInt(str); break;  
				}
				index++;
			} else {
				System.out.println("오류");
				return arr;
			}
		}
		return ++arr;
	}

	public static void Show(String[] name, int[] kor, int[] eng, int[] math, int arr){
		float avgKor = 0; 
		float avgEng = 0;
	    float avgMath = 0;
	    float avgTot = 0;
		System.out.println("ID\t이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("----------------------------------------------------");
		for(int i=0; i< arr; i++){
			int sum =kor[i] + eng[i] + math[i];
			float avg = sum/3;
			avgKor  += kor[i];
			avgEng  += eng[i];
			avgMath += math[i];
			avgTot += sum;
			System.out.print( i + "\t" +name[i] + "\t" + kor[i] +
					"\t" + eng[i] + "\t" + math[i] + "\t" +  sum + 
					"\t" + avg + "\n");
		}
		System.out.println("----------------------------------------------------");
		System.out.println("전체평균\t"+avgKor/arr+ "\t" + avgEng/arr + "\t"+ avgMath/arr 
				+ "\t\t" + avgTot/(arr * 3) + "\n");
	}

	public static void main(String[] args) {
		while(true){
			Scanner scan = new Scanner(System.in);
			System.out.print("명령>");
			String data = scan.nextLine();
			arr = Input(name, kor, eng, math, arr, data);
			System.out.println("arr : "+ arr);
			System.out.print("더 입력하시겠습니까(0:종료) :");
			if( scan.nextInt() == 0 ){
				break;
			}
		}
		Show(name, kor, eng, math, arr);
	}
}

