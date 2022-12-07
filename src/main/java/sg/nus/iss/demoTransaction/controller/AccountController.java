package sg.nus.iss.demoTransaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import sg.nus.iss.demoTransaction.model.Account;
import sg.nus.iss.demoTransaction.service.AccountService;

@RestController
@RequestMapping("/v1/accounts")
@Api(tags = { "Accounts Controller" }, description = "Provide APIs for account related operation")
public class AccountController {
    @Autowired
	private AccountService accountService;

	@GetMapping("/{accountId}/balances")
	@ApiOperation(value = "Get account balance by id", response = Account.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid ID supplied"),
							@ApiResponse(code = 404, message = "Account not found with ID")})
	public Account getBalance(
			@ApiParam(value = "ID related to the account", required = true) @PathVariable Long accountId) {
		return accountService.retrieveBalances(accountId);
	}
}
