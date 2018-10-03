package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Cases;
import com.revature.data.CasesHibernate;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired 
	private CasesHibernate ch;
	private ObjectMapper om;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Cases> processViewAllCasesRequest(HttpSession s) {
		

//		SocialWorker sw = (SocialWorker) s.getAttribute("user");
		List<Cases> casesList = new ArrayList<>();
/*		if (sw.getIsadmin() == 1)
			casesList = ch.getAll();
		else if (sw.getIsadmin() == 0)
			casesList = ch.getBySocialWorkerId(sw.getId());
*/
		casesList = ch.getAll();
	    return casesList;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public List<Cases> viewSWCases(@PathVariable("id") int id){
		List<Cases> casesList = new ArrayList<>();
		casesList = ch.getBySocialWorkerId(id);
		return casesList;
	}
	
	@RequestMapping(value="/json", method = RequestMethod.GET)
	public String getCasesAsJSON(){
		List<Cases> casesList = new ArrayList<>();
		casesList = ch.getAll();
		om = new ObjectMapper();
		String result = "";
		try {
			result = om.writeValueAsString(casesList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("\n\n" + result + "\n\n");
		return result;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public @ResponseBody List<Cases> addCase(@RequestBody Cases c) {
		ch.save(c);
		return ch.getAll();
	    }
	
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody List<Cases> updateCase(@RequestBody Cases c) {
		ch.update(c);
		return ch.getAll();
	    }
}
