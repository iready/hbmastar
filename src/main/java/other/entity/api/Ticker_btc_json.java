package other.entity.api;

public class Ticker_btc_json implements Result {
    private String time;
    private Ticker ticker;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

}
