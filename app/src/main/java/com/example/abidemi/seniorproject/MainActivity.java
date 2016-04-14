package com.example.abidemi.seniorproject;
import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Array;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.widget.Toast;
import java.io.BufferedReader;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.util.TypedValue;
import android.view.View.OnClickListener;
import android.view.View;
import java.util.*;
import  android.graphics.Color;
import android.content.Intent;
import android.view.Gravity;
/*This Project was created by Abifoluwa Oni
* Stock App for Senior Project
* */

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>
{

    DatabaseHandler db;
    private static final String TAG = "MyActivity";
    TextView t1, t2, t3, t4, t5;
    public  List<List<String>> csvData = new ArrayList<List<String>>();

    //public static String myUrl;
    public static String date;
    public  String volume;
    public static String last_trade;
    public  String last_trade_time;
    public  String previous_close;
    public  String open;
    public  String day_high;
    public  String symbols;
    public static String change;
    public  String day_low;
    public String name;
    public  String arrayList;

    TableLayout table_layout;
    TableRow row;
    ArrayList al = new ArrayList();
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLoaderManager().initLoader(0, null, this);
      table_layout = (TableLayout) findViewById(R.id.tableLayout1);
       // BuildTable();


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


    public void onLoadFinished(Loader<String> loader, String arg1)
    {
        //Log.e("DSDS", "onLoadFinished" + arg1);
        JavaHttpUrlConnectionReader jh = new JavaHttpUrlConnectionReader();
        jh.getData();
        // TODO Auto-generated method stub
        BufferedReader br = null;
        String line = "";
        String splitBy = ",";

        try
        {
            br = new BufferedReader(new StringReader(jh.results));
            while ((line = br.readLine()) != null)
            {
                String[] splitted = line.split(",");
                List<String> dataLine = new ArrayList<String>(splitted.length);
                for (String data : splitted)
                {
                    dataLine.add(data);
                }
                csvData.add(dataLine);
            }
            JSONObject json = new JSONObject();
            for(int i = 0; i < csvData.size(); i++)
            {
                try
                {
                //
                    json.put("Symbols", new JSONArray(Arrays.asList(csvData.get(i).get(0))));
                    json.put("Last_trade", new JSONArray(Arrays.asList(csvData.get(i).get(1))));
                    json.put("date", new JSONArray(Arrays.asList(csvData.get(i).get(2))));
                    json.put("last_trade_time", new JSONArray(Arrays.asList(csvData.get(i).get(3))));
                    json.put("Change", new JSONArray(Arrays.asList(csvData.get(i).get(4))));
                    json.put("open", new JSONArray(Arrays.asList(csvData.get(i).get(5))));
                    json.put("day_high", new JSONArray(Arrays.asList(csvData.get(i).get(6))));
                    json.put("day_low", new JSONArray(Arrays.asList(csvData.get(i).get(7))));
                    json.put("volume", new JSONArray(Arrays.asList(csvData.get(i).get(8))));
                    json.put("previous_close", new JSONArray(Arrays.asList(csvData.get(i).get(9))));
                    json.put("Name", new JSONArray(Arrays.asList(csvData.get(i).get(10))));
                    arrayList = json.toString();
                }
                catch (JSONException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try
                {
                    JSONArray jsonarr11 = json.getJSONArray("Name");
                    JSONArray jsonarr = json.getJSONArray("Symbols");
                    JSONArray jsonarr2 = json.getJSONArray("Last_trade");
                    JSONArray jsonarr3 = json.getJSONArray("date");
                    JSONArray jsonarr4 = json.getJSONArray("last_trade_time");
                    JSONArray jsonarr5 = json.getJSONArray("Change");
                    JSONArray jsonarr6 = json.getJSONArray("open");
                    JSONArray jsonarr7 = json.getJSONArray("day_high");
                    JSONArray jsonarr10 = json.getJSONArray("day_low");
                    JSONArray jsonarr8 = json.getJSONArray("volume");
                    JSONArray jsonarr9 = json.getJSONArray("previous_close");

                    name = (String) jsonarr11.get(0);
                    name = name.replace("\"", "");
                    StringTokenizer st = new StringTokenizer(name);
                    name = name.substring(0, Math.min(name.length(), 11));

                    date = (String) jsonarr3.get(0);
                    date = date.replace("\"", "");

                    symbols = (String) jsonarr.get(0);
                    symbols = symbols.replace("\"", "");

                    last_trade_time = (String) jsonarr4.get(0);
                    last_trade_time = last_trade_time.replace("\"", "");

                    last_trade = (String) jsonarr2.get(0);
                    last_trade = last_trade.replace("\"", "");

                    change = (String) jsonarr5.get(0);
                    change = change.replace("\"", "");

                    day_high = (String) jsonarr7.get(0);
                    day_high = day_high.replace("\"", "");

                    open = (String) jsonarr6.get(0);
                    open = open.replace("\"", "");

                    volume = (String) jsonarr8.get(0);
                    volume = volume.replace("\"", "");

                    previous_close = (String) jsonarr9.get(0);
                    previous_close = previous_close.replace("\"", "");

                    day_low = (String) jsonarr10.get(0);
                    day_low = day_low.replace("\"", "");
                }
                catch (JSONException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

               // db = new DatabaseHandler(this);
               // db.addStock(new Stock(symbols, date, last_trade, last_trade_time, change, open, day_high, day_low, volume, previous_close));


                row = new TableRow(this);
                    row.setId(i);
                row.setClickable(true);

                    t1 = new TextView(this);
                    t2 = new TextView(this);
                    t3 = new TextView(this);

                    t1.setText(name + " ("+symbols+")");
                    //t1.setText(name);
                    t2.setText("$" + last_trade);
                    t3.setText(change);

                    t1.setPadding(5, 5, 5, 5);
                    t2.setPadding(5, 5, 5, 5);
                    t3.setPadding(5, 5, 5, 5);

                    t1.setBackgroundResource(R.drawable.cell_shape);
                    t2.setBackgroundResource(R.drawable.cell_shape);
                    t3.setBackgroundResource(R.drawable.cell_shape);

                    row.addView(t1);
                    row.addView(t2);
                    row.addView(t3);

                    table_layout.addView(row, new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

                row.setOnClickListener(new OnClickListener()
                {
                    public void onClick(View v)
                    {
                        row =(TableRow)v;

                        TextView tv1= (TextView)row.getChildAt(0);

                        TextView tv2= (TextView)row.getChildAt(1);

                        TextView tv3= (TextView)row.getChildAt(2);

                        String sym_String = tv1.getText().toString();

                        String sym_String2 = tv2.getText().toString();

                        String sym_String3 = tv3.getText().toString();

                        //Toast toast = Toast.makeText(getApplicationContext(), "Table row clicked "+ Integer.toString(v.getId()) , Toast.LENGTH_LONG);
                        //toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        //toast.show();

                        Intent intent = new Intent(MainActivity.this, ShowDataFromStock.class);

                        intent.putExtra(Intent.EXTRA_TEXT, sym_String);
                        intent.putExtra("change", sym_String3);
                        intent.putExtra("last_trade", sym_String2);
                        intent.setType("text/plain");

                        Toast.makeText(getApplicationContext(),tv1.getText().toString(), Toast.LENGTH_SHORT).show();

                        if (intent.resolveActivity(getPackageManager()) != null)
                        {
                            startActivity(intent);
                        }
                    }
                });
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException a)
                {
                    a.printStackTrace();
                }
            }
        }
    }

    public void onLoaderReset(Loader<String> arg0)
    {
        // TODO Auto-generated method stub

    }
}