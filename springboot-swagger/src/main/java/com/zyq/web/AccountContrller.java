package com.zyq.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyq.bean.Account;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 用户创建某本账号 POST /account/ 
 * 用户修改对某本账号 PUT /account/:id/ 
 * 用户删除对某本账号 DELETE /account/:id/ 
 * 用户获取所有的账号 GET /account 
 * 用户获取某一账号 GET /account/:id
 * 官方文档：http://swagger.io/docs/specification/api-host-and-base-path/
 */

@RestController
@RequestMapping(value = "/account")
public class AccountContrller {

	Map<Integer, Account> accounts = Collections.synchronizedMap(new HashMap<Integer, Account>());

	@ApiOperation(value = "获取账号列表", notes = "获取账号列表")
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public List<Account> getAccount() {
		List<Account> Account = new ArrayList<>(accounts.values());
		return Account;
	}

	@ApiOperation(value = "创建账号", notes = "创建账号")
	@ApiImplicitParam(name = "account", value = "账号详细实体", required = true, dataType = "Account")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String postAccount(@RequestBody Account account) {
		accounts.put(account.getId(), account);
		return "success";
	}

	@ApiOperation(value = "获账号细信息", notes = "根据url的id来获取详细信息")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Integer", paramType = "path")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Account getAccount(@PathVariable Integer id) {
		return accounts.get(id);
	}

	@ApiOperation(value = "更新信息", notes = "根据url的id来指定更新账号信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "账号ID", required = true, dataType = "Integer", paramType = "path"),
			@ApiImplicitParam(name = "account", value = "账号实体Account", required = true, dataType = "Account") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putAccount(@PathVariable Integer id, @RequestBody Account account) {
		Account account1 = accounts.get(id);
		account1.setName(account.getName());
		account1.setMoney(account.getMoney());
		accounts.put(id, account1);
		return "success";
	}

	@ApiOperation(value = "删除账号", notes = "根据url的id来指定删除账号")
	@ApiImplicitParam(name = "id", value = "账号ID", required = true, dataType = "Integer", paramType = "path")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteAccount(@PathVariable Integer id) {
		accounts.remove(id);
		return "success";
	}

	@ApiIgnore // 使用该注解忽略这个API
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String jsonTest() {
		return " hi you!";
	}
}
