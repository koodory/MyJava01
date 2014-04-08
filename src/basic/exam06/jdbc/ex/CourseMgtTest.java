package basic.exam06.jdbc.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CourseMgtTest {
	private static Connection con;
	private static Statement stmt;
	private static Scanner scan = new Scanner(System.in);

	public static void insert() throws SQLException{
		String[] value1 = new String[1];
		String[] value2 = new String[1];
		int[] value3 = new int[1];
		
		for(int i=0; i<1;i++){
			value1[i] = "Anonymous";
			value2[i] = "Your computer is hacked!";
      value3[i] = i;
      
			stmt.executeUpdate(
					"insert SE_COURS(TITLE, DEST, HOURS)"
							+ " values('"+ value1[i] + "', '" + value2[i] + "', " 
							+ value3[i] + ")"
					);
		}
	}

	public static void list() throws SQLException{
		ResultSet rs = stmt.executeQuery("select CNO, TITLE, DEST, HOURS"
				+ " from SE_COURS");
		System.out.println("\n\n--------------------------------------------------------------");
		System.out.printf("번호\t과정\t\t내용\t\t\t\t시간\n");
		System.out.println("--------------------------------------------------------------");
		while(rs.next()){
			System.out.printf("%d\t%s\t%-15s\t%d\n",rs.getInt("CNO"), 
					rs.getString("TITLE"), rs.getString("DEST"), rs.getInt("HOURS"));
		}
		System.out.printf("--------------------------------------------------------------\n\n");
		rs.close();
	}

	public static void update() throws SQLException{
		stmt.executeUpdate(
				"update SE_COURS "
						+ " DEST='전략산업 전문인력 양성'" 
						+ " where CNO=1");
	}

	public static void delete() throws SQLException{
		for(int i=0; i<10;i++){
		stmt.executeUpdate("delete from SE_COURS"
				+ " where CNO="+i+"");
		}
	}

	public static void menu() throws SQLException{
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
			Class.forName("com.mysql.jdbc.Driver");	

			con = DriverManager.getConnection(
					"jdbc:mysql://192.168.200.72:3306/studydb","study","study");

			stmt = con.createStatement();
			menu();
			System.out.println("오호라..연결되었다!");
			stmt.close();
			con.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
