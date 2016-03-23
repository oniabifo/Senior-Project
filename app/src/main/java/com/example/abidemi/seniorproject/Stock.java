package com.example.abidemi.seniorproject;

/**
 * Created by Abidemi on 3/22/2016.
 */
public class Stock
{
    private int id;
    private String symbol;
    private String last_trade;
    private String date;
    private String last_trade_time;
    private String change;
    private String open;
    private String day_high;
    private String day_low;
    private String volume;
    private String previous_close;

    public Stock(){}

    public Stock(String symbol, String last_trade, String last_trade_time, String change, String open, String day_high, String day_low, String volume, String previous_close)
    {
        super();

        this.symbol = symbol;
        this.last_trade = last_trade;
        this.date = date;
        this.last_trade_time = last_trade_time;
        this.change = change;
        this.open = open;
        this.day_high = day_high;
        this.day_low = day_low;
        this.volume = volume;
        this.previous_close = previous_close;
    }

    public String getSymbol()
    {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public int getId() {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getLast_trade()
    {
        return last_trade;
    }
    public void setLast_trade(String title)
    {
        this.last_trade = last_trade;
    }
    public String getDate()
    {
        return date;
    }

    public String setDate(String date)
    {
        return this.date = date;
    }
    public String getLast_trade_time()
    {
        return last_trade_time;
    }
    public void setLast_trade_time(String last_trade_time)
    {
        this.last_trade_time = last_trade_time;
    }
    public String getChange()
    {
        return change;
    }
    public void setChange(String change)
    {
        this.change = change;
    }
    public String getOpen()

    {
        return open;
    }
    public void setOpen(String open)
    {
        this.open = open;
    }
    public String getDay_high()

    {
        return day_high;
    }
    public void setDay_high(String day_high)
    {
        this.day_high = day_high;
    }
    public String getDay_low()
    {
        return day_low;
    }
    public void setDay_low(String day_low)
    {
        this.day_low = day_low;
    }
    public String getVolume()
    {
        return volume;
    }
    public void setVolume(String volume)
    {
        this.volume = volume;
    }

    public String getPrevious_close()
    {
        return previous_close;
    }
    public void setPrevious_close(String previous_close)
    {
        this.previous_close = previous_close;
    }
    public String toString()
    {
        return "Stock [id= " + id +", symbol=" + symbol + ", last_trade=" + last_trade + ", last trade time=" +last_trade_time
                + ", change="+ change + ", open=" + open + ", day high=" +day_high + ", day_low=" + day_low + ", volume =" + volume +
                ", previous_close=" + previous_close + "]";
    }
}