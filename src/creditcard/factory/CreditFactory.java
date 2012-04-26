package creditcard.factory;

import creditcard.account.Bronze;
import creditcard.account.CreditAccount;
import creditcard.account.Gold;
import creditcard.account.ICreditType;
import creditcard.account.Silver;
import framework.account.IAccount;
import framework.system.ASystemFactory;

public class CreditFactory extends ASystemFactory {

	@Override
	public IAccount createAccount(String[] accountInfo) {
		// TODO Auto-generated method stub
		ICreditType type;
		if (accountInfo[1] == "Gold")
			type = new Gold();
		else if (accountInfo[1] == "Silver")
			type = new Silver();
		else
			type = new Bronze();
		return new CreditAccount(accountInfo[1], type);
	}
}
