package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Statement;

@Repository
public interface IStatementRepository extends JpaRepository<Statement, Long>{
	

}
