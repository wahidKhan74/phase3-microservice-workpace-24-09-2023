package com.simplilearn.accounts.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.accounts.entity.Account;
import com.simplilearn.accounts.exception.AccountAlreadyExist;
import com.simplilearn.accounts.exception.AccountNotFound;

@RestController
public class AccountsController {

	List<Account> accounts = new ArrayList<Account>();

	// get one account by id
	@GetMapping("/account/{id}")
	public Account getOne(@PathVariable(value = "id") int id) {
		for (Account account : accounts) {
			if (account.getId() == id) {
				return account;
			}
		}
		throw new AccountNotFound("account is not found with given id "+id);
	}

	// get one account by name
	@GetMapping("/account")
	public Account getOne(@RequestParam(value = "name") String name) {
		for (Account account : accounts) {
			if (account.getUsername().equals(name)) {
				return account;
			}
		}
		throw new AccountNotFound("account is not found with given name "+name);
	}

	// get one account by name
	@GetMapping("/account/search")
	public Account searchOne(@RequestParam(value = "name") String name) {
		for (Account account : accounts) {
			if (account.getUsername().contains(name)) {
				return account;
			}
		}
		throw new AccountNotFound("account is not found with given name "+name);
	}

	// get all accounts
	@GetMapping("/accounts")
	public List<Account> getaccounts() {
		if (accounts.isEmpty()) {
			addDefaults();
		}
		return accounts;
	}

	// add account
	@PostMapping("/accounts")
	public List<Account> addOne(@RequestBody Account account) {
		for (Account pt : accounts) {
			if (pt.getId()==account.getId()) {
				throw new AccountAlreadyExist("account is already available with given id "+account.getId());
			}
		}
		accounts.add(account);
		return accounts;
	}

	// update account
	@PutMapping("/accounts")
	public Account updateOne(@RequestBody Account account) {
		for (int index = 0; index < accounts.size(); index++) {
			if (account.getId() == accounts.get(index).getId()) {
				// set : replace user account
				accounts.set(index, account);
				return account;
			}
		}
		throw new AccountNotFound("account is not found with given id "+account.getId());
	}

	// delete account
	@DeleteMapping("/accounts/{id}")
	public List<Account> deleteOne(@PathVariable(value = "id") int id) {
		for (int index = 0; index < accounts.size(); index++) {
			if (id == accounts.get(index).getId()) {
				// set : replace user account
				accounts.remove(index);
				return accounts;
			}
		}
		throw new AccountNotFound("account is not found with given id "+id);
	}

	// add default accounts
	private void addDefaults() {
		accounts.add(new Account(8001, "johnsmith", "john@123", "john@gmail.com", true, new Date()));
		accounts.add(new Account(8002, "willsmith", "will@123", "will@gmail.com", true, new Date()));
		accounts.add(new Account(8003, "ariasmith", "aria@123", "aria@gmail.com", false, new Date()));
		accounts.add(new Account(8004, "marrysmith", "marry@123", "marry@gmail.com", true, new Date()));
		accounts.add(new Account(8005, "davidmith", "david@123", "david@gmail.com", true, new Date()));
	}
}
