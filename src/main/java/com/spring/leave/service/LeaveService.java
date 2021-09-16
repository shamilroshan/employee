package com.spring.leave.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.leave.dao.LeaveDao;
import com.spring.leave.model.Leave;


@Service
public class LeaveService {
	
	@Autowired
	private LeaveDao dao;
	
	public List<Leave> getLeaveData(){
		List<Leave> lealist = dao.getLeaveData();
		return lealist;
	}

	public Leave getLeaveId(int id) {
		
		List<Leave> lealist = dao.getLeaveData();
		
		Optional<Leave> leave = lealist.stream().filter(lea->(lea.getId()==id)).findFirst();
		
		
		return leave.get();
	}
	
	public boolean addleaveToDb(Leave lea) {
		
		boolean status = dao.addleaveToDb(lea);
		return status;
	}

	public boolean delleavefromdb(int id) {
		
		boolean status = dao.delleavefromDb(id);
		return status;
	}
}





