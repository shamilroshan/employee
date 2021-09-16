package com.spring.leave.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.leave.model.Leave;
import com.spring.leave.service.LeaveService;


@RestController
@RequestMapping("/leave")
public class LeaveController {
	
	@Autowired
	public LeaveService service;
	
	@RequestMapping(value ="/getleavedata",method=RequestMethod.GET)
	public List<Leave> getLeaveInfo() {
		
		List<Leave> li = service.getLeaveData();
		return li;
		
		
	}
	
	@RequestMapping(value = "/postleavedata", method = RequestMethod.POST, consumes= org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces =org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Leave leavePostCall(@RequestBody Leave leave) {
		
		if(Objects.isNull(leave.getId()) || (leave.getId()==0)) {
			throw new IllegalArgumentException("Leave id is mandatory or invalid argument passed");
		}
		
		Leave leaveobj = service.getLeaveId(leave.getId());
		
		return leaveobj;																															
		
	}
	
	@RequestMapping(value="/putleavedata" , method = RequestMethod.PUT, consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public String leavePutCall(@RequestBody Leave lea) {
		
		boolean status = service.addleaveToDb(lea);
		if(status==true) {
			return "Leave details are added";		}
		else {
			return "Leave details are not added";
		}
		
		
		
	}
	
	@RequestMapping(value ="/delleavedata/{id}" , method=RequestMethod.DELETE)
	public String LeaveDel(@PathVariable int id) {
		
		
		boolean status =  service.delleavefromdb(id);
		if(status==true) {
			return id + "deleted";
		}
		else {
			return id + "not deleted";
		}
	}
	
	

}






