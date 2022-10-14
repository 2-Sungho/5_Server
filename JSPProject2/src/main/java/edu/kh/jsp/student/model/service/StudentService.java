package edu.kh.jsp.student.model.service;

import static edu.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jsp.student.model.dao.StudentDAO;
import edu.kh.jsp.student.model.vo.Student;

public class StudentService {

	private StudentDAO dao=new StudentDAO();

	/** 학생 전체 조회 서비스
	 * @return stdList
	 * @throws Exception
	 */
	public List<Student> selectAll() throws Exception {
		Connection conn=getConnection();
		List<Student> stdList=dao.selectAll(conn);
		close(conn);
		return stdList;
	}

	public List<Student> selectDepartment(String inputDept) throws Exception {
		Connection conn=getConnection();
		List<Student> stdList=dao.selectDepartment(conn,inputDept);
		close(conn);
		return stdList;
	}

	
	
	
	
	
}
