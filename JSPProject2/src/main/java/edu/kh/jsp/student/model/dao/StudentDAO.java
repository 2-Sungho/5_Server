package edu.kh.jsp.student.model.dao;

import static edu.kh.jsp.common.JDBCTemplate.*;

import java.awt.print.Printable;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jsp.student.model.vo.Student;

public class StudentDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop;

	public StudentDAO() {
		try {
			String filePath = StudentDAO.class.getResource("/edu/kh/jsp/sql/student-sql.xml").getPath();

			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param conn
	 * @return stdList
	 * @throws Exception
	 */
	public List<Student> selectAll(Connection conn) throws Exception {
		List<Student> stdList = new ArrayList<>();
		try {
			String sql = prop.getProperty("selectAll");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				String studentNo = rs.getString("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NAME");
				String studentAddress = rs.getString("STUDENT_ADDRESS");
				String departmentName = rs.getString("DEPARTMENT_NAME");

				stdList.add(new Student(studentNo, studentName, studentAddress, departmentName));
			}
		} finally {
			close(rs);
			close(stmt);
		}

		return stdList;
	}

	public List<Student> selectDepartment(Connection conn, String inputDept) throws Exception {
		List<Student> stdList=new ArrayList<>();
		try {
			String sql=prop.getProperty("selectDepartment");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, inputDept);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Student s=new Student();
				s.setStudentNo(rs.getString("STUDENT_NO"));
				s.setStudentName(rs.getString("STUDENT_NAME"));
				s.setStudentAddress(rs.getString("STUDENT_ADDRESS"));
				s.setDepartmentName(inputDept);
				
				stdList.add(s);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return stdList;
	}


}
