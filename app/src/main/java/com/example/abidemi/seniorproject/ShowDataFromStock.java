package com.example.abidemi.seniorproject;

/**
 * Created by Abidemi on 3/25/2016.
 */
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.net.URL;

public class ShowDataFromStock extends Activity
{

    //Stock stc = new Stock();
    String value;
    String value2;
    String value3;
    String value4;


    public ImageView iv;
    public Bitmap bitmap;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextpage_main);
        iv = (ImageView) findViewById(R.id.imageView5);
        bitmap = getBitmapFromURL("https://openclipart.org/image/2400px/svg_to_png/196123/1407858226.png");
        iv.setImageBitmap(bitmap);
        Bundle extras = getIntent().getExtras();

        if (extras != null)
        {
            value = extras.getString(Intent.EXTRA_TEXT);
            value2 = extras.getString("change");
            value3 = extras.getString("last_trade");
        }

        TextView text = (TextView) findViewById(R.id.next_symbol);
        text.setText(value);

        TextView text1 = (TextView) findViewById(R.id.next_change);
        text1.setText(value2);

        TextView text2 = (TextView) findViewById(R.id.next_quote);
        text2.setText(value3);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public Bitmap getBitmapFromURL(String src)
    {
        try
        {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return  myBitmap;
        }
        catch (Exception e)
        {
        e.printStackTrace();return null;
        }
    }
    public void onLoadFinished()
    {

    }
}