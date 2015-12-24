package other.entity.api.OrderBookandTAS;

import java.util.Set;

import other.entity.api.Result;

public class BTC_CNY implements Result {
	public String amount;// 成交量
	public String level;// 涨幅
	public Set<BuysOrSells> buys;// Array[10]买10
	public Set<BuysOrSells> sells;// Array[10]卖10
	public String p_high;// 最高
	public String p_low;// 最低
	public String p_last;// 收盘价
	public String p_new;// 最新
	public String p_open;// 开盘
	public Set<Top_buyORTop_sell> top_buy;// 买5
	public Set<Top_buyORTop_sell> top_sell;// 卖5
	public String total;// 总量（人民币）
	public Set<Trades> trades;// 实时成交
	public String id12;

	public String getId12() {
		return id12;
	}
	public void setId12(String id12) {
		this.id12 = id12;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Set<BuysOrSells> getBuys() {
		return buys;
	}
	public void setBuys(Set<BuysOrSells> buys) {
		this.buys = buys;
	}
	public Set<BuysOrSells> getSells() {
		return sells;
	}
	public void setSells(Set<BuysOrSells> sells) {
		this.sells = sells;
	}
	public String getP_high() {
		return p_high;
	}
	public void setP_high(String p_high) {
		this.p_high = p_high;
	}
	public String getP_low() {
		return p_low;
	}
	public void setP_low(String p_low) {
		this.p_low = p_low;
	}
	public String getP_last() {
		return p_last;
	}
	public void setP_last(String p_last) {
		this.p_last = p_last;
	}
	public String getP_new() {
		return p_new;
	}
	public void setP_new(String p_new) {
		this.p_new = p_new;
	}
	public String getP_open() {
		return p_open;
	}
	public void setP_open(String p_open) {
		this.p_open = p_open;
	}
	public Set<Top_buyORTop_sell> getTop_buy() {
		return top_buy;
	}
	public void setTop_buy(Set<Top_buyORTop_sell> top_buy) {
		this.top_buy = top_buy;
	}
	public Set<Top_buyORTop_sell> getTop_sell() {
		return top_sell;
	}
	public void setTop_sell(Set<Top_buyORTop_sell> top_sell) {
		this.top_sell = top_sell;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public Set<Trades> getTrades() {
		return trades;
	}
	public void setTrades(Set<Trades> trades) {
		this.trades = trades;
	}
}
