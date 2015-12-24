package controller;

import other.entity.api.Result;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;

public interface APIOperation {
	public Result buy(String amount, String exprectPrice, String trade_password) throws ClientProtocolException, IOException;
	public Result get_account_info() throws ClientProtocolException, IOException;
	public Result get_orders();
	public Result Order_BookandTAS() throws ClientProtocolException, IOException;
	public Result sell(String amount, String exprectPrice, String trade_password) throws ClientProtocolException, IOException;
	public void setUserId(String userId);
	public Result TransactionReal() throws ClientProtocolException, IOException;

}
