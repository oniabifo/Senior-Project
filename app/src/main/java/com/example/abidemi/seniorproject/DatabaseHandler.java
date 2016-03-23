package com.example.abidemi.seniorproject;
import java.util.LinkedList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "STOCKDB";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // SQL statement to create book table
        String CREATE_STOCK_TABLE = "CREATE TABLE table_A ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "SYMBOL TEXT PRIMARY KEY, " +
                "LAST_TRADE TEXT, "+
                "LAST_TRADE_TIME TEXT, " +
                "CHANGE TRADE_TIME TEXT, " +
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
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS table_A");

        // create fresh books table
        this.onCreate(db);
    }
    //---------------------------------------------------------------------

    /**
     * CRUD operations (create "add", read "get", update, delete) book + get all books + delete all books
     */

    // Books table name
    private static final String TABLE_STOCKS = "table_A";

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

       // Log.d("This content", "");
        db.close();
    }
 /*   public Book getBook(int id)
    {

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_BOOKS, // a. table
                        COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build book object
        Book book = new Book();
        book.setId(Integer.parseInt(cursor.getString(0)));
        book.setTitle(cursor.getString(1));
        book.setAuthor(cursor.getString(2));

        Log.d("getBook("+id+")", book.toString());

        // 5. return book
        return book;
    }

    // Get All Books
    public List<Book> getAllBooks() {
        List<Book> books = new LinkedList<Book>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_BOOKS;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        Book book = null;
        if (cursor.moveToFirst()) {
            do {
                book = new Book();
                book.setId(Integer.parseInt(cursor.getString(0)));
                book.setTitle(cursor.getString(1));
                book.setAuthor(cursor.getString(2));

                // Add book to books
                books.add(book);
            } while (cursor.moveToNext());
        }

        Log.d("getAllBooks()", books.toString());

        // return books
        return books;
    }

    // Updating single book
    public int updateBook(Book book) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("title", book.getTitle()); // get title
        values.put("author", book.getAuthor()); // get author

        // 3. updating row
        int i = db.update(TABLE_BOOKS, //table
                values, // column/value
                KEY_ID+" = ?", // selections
                new String[] { String.valueOf(book.getId()) }); //selection args

        // 4. close
        db.close();

        return i;

    }

    // Deleting single book
    public void deleteBook(Book book) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_BOOKS,
                KEY_ID+" = ?",
                new String[] { String.valueOf(book.getId()) });

        // 3. close
        db.close();

        Log.d("deleteBook", book.toString());

    }*/
}