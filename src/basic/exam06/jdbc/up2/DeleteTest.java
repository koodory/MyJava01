package basic.exam06.jdbc.up2;

import java.util.Scanner;

/* PreparedStatement 사용
 */
public class DeleteTest {

	public static void main(String[] args) throws Throwable {
		SubjectDao dao = new SubjectDao();
		Scanner sc = new Scanner(System.in);
		
		dao.delete(Integer.parseInt(sc.nextLine()));
		
		System.out.println("삭제 성공!");
		sc.close();
	}

}












