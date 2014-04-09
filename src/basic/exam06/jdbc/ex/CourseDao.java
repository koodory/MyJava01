package basic.exam06.jdbc.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import basic.exam06.jdbc.up2.SubjectVo;

public class CourseDao {
	Connection con = null;
	PreparedStatement stmt = null;		
	ResultSet rs = null;
	
	public void insert(CourseVo course) throws Throwable{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studydb","study","study");

			stmt = con.prepareStatement(
					"insert SE_COURS(TITLE, DEST, HOURS) values(?,?,?)");
			stmt.setString(1, course.title);
			stmt.setString(2, course.description);
			stmt.setInt(3, course.hours);

			stmt.executeUpdate();

		}catch(Throwable e){
			throw e;
		}finally{
			try{stmt.close();} catch(Throwable e2){}
			try{con.close();} catch(Throwable e2){}
		}
	}

	public List<CourseVo> list(int pageNo, int pageSize) throws Throwable{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studydb","study","study");
			stmt = con.prepareStatement("select CNO, TITLE, HOURS from SE_COURS"
					+ " order by CNO desc" + " limit ?, ?");

			stmt.setInt(1, (pageNo - 1) * pageSize);
			stmt.setInt(2,  pageSize);

			ArrayList<CourseVo> list = new ArrayList<CourseVo>();
			CourseVo course = null;
			rs = stmt.executeQuery();
			
			while(rs.next()){
				course = new CourseVo();
				course.no = rs.getInt("CNO");
				course.title = rs.getString("TITLE");
				course.hours = rs.getInt("HOURS");

				list.add(course);
			}
			return list;
		}catch(Throwable e){
			throw e;
		}finally{
			try{rs.close();} catch(Throwable e2){}
			try{stmt.close();} catch(Throwable e2){}
			try{con.close();} catch(Throwable e2){}
		}
	}

	public void update(CourseVo course) throws Throwable{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studydb","study","study");
			stmt = con.prepareStatement(
					"update SE_COURS set" + " TITLE=?" + " DEST=?" + " HOURS=?" 
							+ " where CNO=?");

			stmt.setString(1, course.title);
			stmt.setString(2, course.description);
			stmt.setInt(3, course.hours);
			stmt.setInt(4, course.no);

			stmt.executeUpdate();
		} catch(Throwable e){
			throw e;
		}finally{
			try{stmt.close();} catch(Throwable e2){}
			try{con.close();} catch(Throwable e2){}
		}
	}

	public void delete(int no) throws Throwable{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studydb","study","study");
			stmt = con.prepareStatement(
					"delete from SE_COURS where CNO=?");
			
			stmt.setInt(1, no);
			stmt.executeUpdate();
		}catch(Throwable e){
			throw e;
		}finally{
			try{stmt.close();} catch(Throwable e2){}
			try{con.close();} catch(Throwable e2){}
		}
	}
	
	public CourseVo detail(int no) throws Throwable{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studydb","study","study");
			stmt = con.prepareStatement("select CNO, TITLE, DEST, HOURS from SE_COURS"
					+ " where CNO=?");
			
			stmt.setInt(1, no);
			rs = stmt.executeQuery();

			ArrayList<CourseVo> list = new ArrayList<CourseVo>();
			CourseVo course = null;
			
			while(rs.next()){
				course = new CourseVo();
				course.no = rs.getInt("CNO");
				course.title = rs.getString("TITLE");
				course.hours = rs.getInt("HOURS");

				list.add(course);
			}

			return course;
		}catch(Throwable e){
			throw e;
		}finally{
			try{stmt.close();} catch(Throwable e2){}
			try{con.close();} catch(Throwable e2){}
		}
	}
}

