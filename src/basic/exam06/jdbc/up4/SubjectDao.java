package basic.exam06.jdbc.up4;

import java.util.List;

public interface SubjectDao {
	public void insert(SubjectVo subject) throws Throwable;
	List<SubjectVo> list(int pageNo, int pageSize) throws Throwable;
  SubjectVo detail(int no) throws Throwable;
	public void update(SubjectVo subject) throws Throwable;
	public void delete(int no) throws Throwable;
}