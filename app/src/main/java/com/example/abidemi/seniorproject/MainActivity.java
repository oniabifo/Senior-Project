package com.example.abidemi.seniorproject;
import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.database.sqlite.SQLiteDatabase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import android.widget.TextView;


/*This Project was created by Abifoluwa Oni
* Stock App for Senior Project
* */

public class MainActivity extends Activity implements LoaderManager.LoaderCallbacks<String>
{
    DatabaseHandler db;

    private static final String TAG = "MyActivity";
    private static BufferedReader read;
    private static BufferedWriter write;

    //JavaHttpUrlConnectionReader jv;
    JavaHttpUrlConnectionReader jh = new JavaHttpUrlConnectionReader();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLoaderManager().initLoader(0, null, this);


        db = new DatabaseHandler(this);
        db.addStock(new Stock(jh.symbols, jh.last_trade, jh.last_trade_time, jh.change, jh.open, jh.day_high, jh.day_low, jh.volume, jh.previous_close));
        //db.addStock(new Stock("Agbo", " ", " ", " ", " ", " ", " ", " ", " "));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args)
    {
        // TODO Auto-generated method stub
        return (new AsyncTaskActivity(this));
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String arg1)
    {
        // TODO Auto-generated method stub
         //String sym = jh.symbols;
        Log.e("DSDS", "onLoadFinished" + arg1);
        //
        // Log.d("This is the main class ", jh.symbols);
    }

    @Override
    public void onLoaderReset(Loader<String> arg0)
    {
        // TODO Auto-generated method stub

    }
}