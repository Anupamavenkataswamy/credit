package com.cg.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Statement {
	@Id
	private long statementId;
	private double dueAmount;
	private LocalDate billingDate;
	private LocalDate dueDate;

}