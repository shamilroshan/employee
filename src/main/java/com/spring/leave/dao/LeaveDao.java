package com.spring.leave.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.spring.leave.model.Leave;


@Component
public class LeaveDao {
	
	@Autowired
	public JdbcTemplate template;

	public List<Leave> getLeaveData() {

		String sql = "SELECT * FROM leaveservice";

		List<Leave> leavelist = template.query(sql, new ResultSetExtractor<List<Leave>>() {

			@Override
			public List<Leave> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Leave> list = new ArrayList<>();
				while (rs.next()) {
					Leave leave = new Leave();

					leave.setId(rs.getInt("id"));
					leave.setEmp_id(rs.getInt("emp_id"));
					leave.setMonth(rs.getString("month"));
					leave.setCasual_leave_available(rs.getString("casual_leave_available"));
					leave.setSick_leave_available(rs.getString("sick_leave_available"));
					leave.setPaid_leave_available(rs.getString("paid_leave_available"));

					list.add(leave);

				}
				return list;

			}

		});
		leavelist.stream().forEach(leave -> {
			System.out.println(leave.getId() + leave.getEmp_id() + leave.getMonth() + leave.getCasual_leave_available()
					+ leave.getSick_leave_available() + leave.getPaid_leave_available());
		});
		return leavelist;

	}

	public boolean addleaveToDb(Leave lea) {
		
		
		boolean status=false;
		try {
		String sql ="insert into leaveservice(id,emp_id,month,casual_leave_available,sick_leave_available,sick_leave_available,paid_leave_available) values("+lea.getId()+","+lea.getEmp_id()+","+lea.getMonth()+","+lea.getCasual_leave_available()+","+lea.getSick_leave_available()+","+lea.getPaid_leave_available()+")";
		
		template.execute(sql);
		status =true;
		}
		catch(Exception e) {
			status=false;
		}
		return status;
	}

	public boolean delleavefromDb(int id) {

		boolean status = false;
		try {
			String sql = "delete from leaveeservice where id=" + id;
			template.execute(sql);
			status = true;
		} catch (Exception e) {
			status = true;
		}

		return status;
	}


}
