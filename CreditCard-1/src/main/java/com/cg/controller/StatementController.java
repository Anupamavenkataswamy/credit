package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Statement;
import com.cg.service.IStatementService;

@RestController
@RequestMapping("/statement")
public class StatementController {
	
	@Autowired
	IStatementService statementservice;
	
    //http://localhost:8085/statement/addstatement
	@PostMapping("/addstatement")
	public Statement addStatement(@RequestBody Statement statement) {
		return statementservice.addStatement(statement);
	}

	@GetMapping("/removestatement/{id}")
	public Statement removeStatement(@PathVariable("id") long pid) {
		return statementservice.removeStatement(pid);
	}

	@PutMapping("/updatestatement/{id}")
	public Statement updateStatement(@PathVariable("id") long id, @RequestBody Statement statement) {
		return statementservice.updateStatement(id, statement);
	}

	@GetMapping("/getstatement/{id}")
	public Statement getStatement(@PathVariable("id") long id) {
		return statementservice.getStatement(id);
	}

	@GetMapping("/getallstatements")
	public List<Statement> getAllStatements() {
		return statementservice.getAllStatement();
	}
	
	

}
