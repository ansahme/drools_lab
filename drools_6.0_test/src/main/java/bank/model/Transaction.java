package bank.model;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
	private Account fromAccount;
	private Account toAccount;
	private String status;
	private BigDecimal amount;
	private String description;
	private String currency;
	private Date date;
	private long uuid;

}
