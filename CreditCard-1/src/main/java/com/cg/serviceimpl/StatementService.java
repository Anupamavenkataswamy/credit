package com.cg.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Statement;
import com.cg.repositories.IStatementRepository;
import com.cg.service.IStatementService;

@Service
public class StatementService implements IStatementService{
	@Autowired
	IStatementRepository statementrepository;

	@Override
	public Statement addStatement(Statement statement) {
		statementrepository.save(statement);
		return statement; 
	}

	@Override
	public Statement removeStatement(long id) {
		Optional<Statement> optionalStatement = statementrepository.findById(id);
		if (optionalStatement.isPresent()) {
			Statement s = optionalStatement.get();
			statementrepository.deleteById(id);
			return s;
		} else {
			throw new RuntimeException("Statement not found for id " + id);
		}
	}

	@Override
	public Statement updateStatement(long id, Statement statement) {
		Optional<Statement> optionalStatement = statementrepository.findById(id);
		if (optionalStatement.isPresent()) {
			Statement s = optionalStatement.get();
			s.setStatementId(statement.getStatementId());
			s.setDueAmount(statement.getDueAmount());
			s.setBillingDate(statement.getBillingDate());
			s.setDueDate(statement.getDueDate());
			statementrepository.save(s);
			return s;
		} else {
			throw new RuntimeException("Statement not found for id " + id);
		}
	}

	@Override
	public Statement getStatement(long id) {
		Optional<Statement> optionalStatement = statementrepository.findById(id);
		if (optionalStatement.isPresent()) {
			return optionalStatement.get();
		} else {
			throw new RuntimeException("Statement not found for id " + id);
		}
	}

	@Override
	public List<Statement> getAllStatement() {
		return statementrepository.findAll();
	}

	@Override
	public Statement getBilledStatement(long id) {
		Optional<Statement> optionalStatement = statementrepository.findById(id);
		if (optionalStatement.isPresent()) {
			Statement billedStatement = optionalStatement.get();
			if (billedStatement.getDueAmount() > 0) {
				Statement statement = new Statement();
				statement.setStatementId(billedStatement.getStatementId());
				statement.setDueAmount(billedStatement.getDueAmount());
				statement.setBillingDate(billedStatement.getBillingDate());
				statement.setDueDate(billedStatement.getDueDate());
				return statement;
			} else {
				throw new RuntimeException("Statement has no due amount.");
			}
		} else {
			throw new RuntimeException("Statement not found for id " + id);
		}
	}

	@Override
	public Statement getUnbilledStatement(long id) {
		Optional<Statement> optionalStatement = statementrepository.findById(id);
		if (!optionalStatement.isPresent()) {
			throw new RuntimeException("Statement not found with the given id");
		} else {
			Statement unbilledStatement = optionalStatement.get();
			Statement statement = new Statement();
			statement.setStatementId(unbilledStatement.getStatementId());
			statement.setDueAmount(unbilledStatement.getDueAmount());
			statement.setBillingDate(unbilledStatement.getBillingDate());
			statement.setDueDate(unbilledStatement.getDueDate());
			// statement.setCustomer(unbilledStatement.getCustomer());
			return statement;
		}
	}

}
