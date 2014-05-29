package bank.service;

import bank.model.Account;

public interface BankingInquiryService {
	
	boolean isAccountNumberUnique(Account account);

}
