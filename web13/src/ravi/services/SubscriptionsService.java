package ravi.services;

import java.sql.SQLException;

import com.appdirect.beans.RootBean;
import com.appdirect.dao.CreateDao;

import java.sql.Connection;

public class SubscriptionsService {

	private CreateDao c;

	public SubscriptionsService() {
		c=new CreateDao();
	}
	
	public boolean checkifExists(RootBean parentBeans, Connection con){
		String accountIdentifier=c.checkifAlreadyExists(parentBeans, con);
		if(accountIdentifier !=null && !accountIdentifier.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean cancelSubscription(RootBean parentBeans, Connection con) throws SQLException{

		String accountIdentifier=c.checkifAlreadyExists(parentBeans, con);
		if(checkifExists(parentBeans, con)){
			System.out.println("Inside if");
			c.removeSubscription(parentBeans.getPayload().getAccount().getAccountIdentifier(), con);
			return true;
		}else{
			return false;
		}
	}

	public void save(RootBean parentBeans, Connection con) throws SQLException{
		c.saveOrder(parentBeans, con);
	}
	
	public String getAccountIdentifierforExisting(RootBean parentBeans, Connection con){
		return c.checkifAlreadyExists(parentBeans, con);
	}
	
	
	
}
