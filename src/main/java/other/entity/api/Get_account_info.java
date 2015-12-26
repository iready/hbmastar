package other.entity.api;

public class Get_account_info implements Result {
    public String total;// 总资产折合
    public String net_asset;// 净资产折合
    public String available_cny_display;// 可用人民币（美元交易市场返回available_usd_display）
    public String available_btc_display;// 可用比特币
    public String available_ltc_display;// 可用莱特币（只有人民币交易市场才会返回）
    public String frozen_cny_display;// 冻结人民币（美元交易市场返回frozen_usd_display）
    public String frozen_btc_display;// 冻结比特币
    public String frozen_ltc_display;// 冻结莱特币（只有人民币交易市场才会返回）
    public String loan_cny_display;// 申请人民币数量（美元交易市场返回loan_usd_display）
    public String loan_btc_display;// 申请比特币数量
    public String loan_ltc_display;// 申请莱特币数量（只有人民币交易市场才会返回）

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getNet_asset() {
        return net_asset;
    }

    public void setNet_asset(String net_asset) {
        this.net_asset = net_asset;
    }

    public String getAvailable_cny_display() {
        return available_cny_display;
    }

    public void setAvailable_cny_display(String available_cny_display) {
        this.available_cny_display = available_cny_display;
    }

    public String getAvailable_btc_display() {
        return available_btc_display;
    }

    public void setAvailable_btc_display(String available_btc_display) {
        this.available_btc_display = available_btc_display;
    }

    public String getAvailable_ltc_display() {
        return available_ltc_display;
    }

    public void setAvailable_ltc_display(String available_ltc_display) {
        this.available_ltc_display = available_ltc_display;
    }

    public String getFrozen_cny_display() {
        return frozen_cny_display;
    }

    public void setFrozen_cny_display(String frozen_cny_display) {
        this.frozen_cny_display = frozen_cny_display;
    }

    public String getFrozen_btc_display() {
        return frozen_btc_display;
    }

    public void setFrozen_btc_display(String frozen_btc_display) {
        this.frozen_btc_display = frozen_btc_display;
    }

    public String getFrozen_ltc_display() {
        return frozen_ltc_display;
    }

    public void setFrozen_ltc_display(String frozen_ltc_display) {
        this.frozen_ltc_display = frozen_ltc_display;
    }

    public String getLoan_cny_display() {
        return loan_cny_display;
    }

    public void setLoan_cny_display(String loan_cny_display) {
        this.loan_cny_display = loan_cny_display;
    }

    public String getLoan_btc_display() {
        return loan_btc_display;
    }

    public void setLoan_btc_display(String loan_btc_display) {
        this.loan_btc_display = loan_btc_display;
    }

    public String getLoan_ltc_display() {
        return loan_ltc_display;
    }

    public void setLoan_ltc_display(String loan_ltc_display) {
        this.loan_ltc_display = loan_ltc_display;
    }

}