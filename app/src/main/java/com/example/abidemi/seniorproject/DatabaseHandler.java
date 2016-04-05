package com.example.abidemi.seniorproject;
import java.util.LinkedList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.sql.*;

public class DatabaseHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "STOCKDB3";

    Connection c = null;

    Statement stmt = null;
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
            String CREATE_STOCK_TABLE = "CREATE TABLE table_A3 ( " +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "SYMBOL TEXT, " +
                    "DATE TEXT, " +
                    "LAST_TRADE TEXT, " +
                    "LAST_TRADE_TIME TEXT, " +
                    "CHANGE TEXT, " +
                    "OPEN TEXT, " +
                    "DAY_HIGH TEXT, " +
                    "DAY_LOW TEXT, " +
                    "VOLUME TEXT, " +
                    "PREVIOUS_CLOSE TEXT" +
                    ")";

            // create books table
            db.execSQL(CREATE_STOCK_TABLE);
        }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS table_A3");
        // create fresh books table
        this.onCreate(db);
    }
    //---------------------------------------------------------------------

    /**
     * CRUD operations (create "add", read "get", update, delete) book + get all books + delete all books
     */

    // Books table name
    private static final String TABLE_STOCKS = "table_A3";

    // Stocks Table Columns names
    private static final String KEY_ID = "id";
    private static final String SYMBOL = "symbol";
    private static final String LAST_TRADE = "last_trade";
    private static final String DATE = "date";
    private static final String LAST_TRADE_TIME = "last_trade_time";
    private static final String CHANGE = "change";
    private static final String OPEN = "open";
    private static final String DAY_HIGH = "day_high";
    private static final String DAY_LOW = "day_low";
    private static final String VOLUME = "volume";
    private static final String PREVIOUS_CLOSE = "previous_close";


    private static final String[] COLUMNS = {SYMBOL,LAST_TRADE, DATE, LAST_TRADE_TIME, CHANGE, OPEN, DAY_HIGH, DAY_LOW, VOLUME, PREVIOUS_CLOSE};



    public void addStock(Stock stock)
    {
        Log.d("addStock", stock.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values2 = new ContentValues();
        values2.put(SYMBOL, stock.getSymbol());
        values2.put(DATE, stock.getDate());
        values2.put(LAST_TRADE, stock.getLast_trade());
        values2.put(LAST_TRADE_TIME, stock.getLast_trade_time());
        values2.put(CHANGE, stock.getChange());
        values2.put(OPEN, stock.getOpen());
        values2.put(DAY_HIGH, stock.getDay_high());
        values2.put(DAY_LOW, stock.getDay_low());
        values2.put(VOLUME, stock.getVolume());
        values2.put(PREVIOUS_CLOSE, stock.getPrevious_close());
        db.insert(TABLE_STOCKS, // table
                null, //nullColumnHack
                values2); // key/value -> keys = column names/ values = column values
        db.close();
    }
}