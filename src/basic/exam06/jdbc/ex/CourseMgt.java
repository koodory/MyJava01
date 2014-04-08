package basic.exam06.jdbc.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CourseMgt {
	private static Connection con;
	private static PreparedStatement stmt;
	private static Scanner scan = new Scanner(System.in);

	public static void insert() throws SQLException{
		stmt = con.prepareStatement(
				"insert SE_COURS(TITLE, DEST, HOURS) values(?,?,?)");

		for(int i=0; i<100 ;i++){
			stmt.setString(1, "자바기초"+i);
			stmt.setString(2, "자바기초 문법을 배운다"+i);
			stmt.setInt(3, i);
			stmt.executeUpdate();
		};
		System.out.println("입력성공");
	}

	public static void list() throws SQLException{
	  stmt = con.prepareStatement("select CNO, TITLE, DEST, HOURS from SE_COURS"
	  		+ " order by CNO desc"
	  		+ " limit ?, ?");
		ResultSet rs = null;
		int pageNo = 1, pageSize = 10;
		do{
			stmt.setInt(1, (pageNo - 1) * pageSize);
			stmt.setInt(2,  pageSize);
			rs = stmt.executeQuery();
			
			System.out.println("["+pageNo+"]------------------------------------");
			while(rs.next()){
				System.out.print(rs.getInt("CNO")+",");
				System.out.print(rs.getString("TITLE")+",");
				System.out.print(rs.getString("DEST")+",");
				System.out.println(rs.getInt("HOURS"));
			}
			rs.close();
			pageNo = Integer.parseInt(scan.nextLine());
		}while(pageNo > 0);
	}

	public static void update() throws SQLException{
		stmt = con.prepareStatement(
				"update SE_COURS set"
						+ " TITLE=?"
						+ " where CNO=?");
			
		stmt.setString(1, scan.nextLine());
		stmt.setInt(2, 1);
		stmt.executeUpdate();
		System.out.println("변경성공");
	}

	public static void delete() throws SQLException{
		stmt = con.prepareStatement(
				"delete from SE_COURS where CNO=?");
		
		stmt.setInt(1, Integer.parseInt(scan.nextLine()));
		stmt.executeUpdate();
		System.out.println("삭제성공");
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
					"jdbc:mysql://localhost:3306/studydb","study","study");

			System.out.println("오호라..연결되었다!");
			menu();
			stmt.close();
			con.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
