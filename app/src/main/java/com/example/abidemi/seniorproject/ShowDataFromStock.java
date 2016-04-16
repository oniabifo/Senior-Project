package com.example.abidemi.seniorproject;

/**
 * Created by Abidemi on 3/25/2016.
 */
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.SimpleHtmlSerializer;
import org.htmlcleaner.TagNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShowDataFromStock extends AppCompatActivity
{

    //Stock stc = new Stock();
    String value;
    String value2;
    String value3;
    String value4;
    WebView webView;
    public ImageView iv;

    public Bitmap bitmap;
    private WebView browser;
    private TextView txtLoading;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextpage_main);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        browser = (WebView) findViewById(R.id.webview);
        browser.getSettings().setJavaScriptEnabled(true);

        Stock stc = new Stock();
        //LoadContent("http://www.barchart.com/charts/stocks/AVHI");

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            value = extras.getString(Intent.EXTRA_TEXT);
            value2 = extras.getString("change");
            value3 = extras.getString("last_trade");
            extras.getString("","");

            int index = value.indexOf(" ");
            String fistString = value.substring(0, index);
            System.out.println("fistString = "+fistString);
            LoadContent("http://www.barchart.com/charts/stocks/" + fistString);
        }

        TextView text = (TextView) findViewById(R.id.next_symbol);
        text.setText(value);
        TextView text1 = (TextView) findViewById(R.id.next_change);
        text1.setText(value2);

        TextView text2 = (TextView) findViewById(R.id.next_quote);
        text2.setText(value3);

    }

    @SuppressLint({"ParseError", "ParserError" })
    private void LoadContent(final String url)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                final String newPage;
                try
                {
                    Document doc = Jsoup.connect(url).get();
                    Elements newsRawTag = doc.select("div#chartdiv");
                    newPage = newsRawTag.html();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run()
                        {
                            try
                            {
                                HtmlCleaner cleaner = new HtmlCleaner();
                                CleanerProperties props = cleaner.getProperties();
                                TagNode tagNode = new HtmlCleaner(props).clean(newPage);
                                SimpleHtmlSerializer htmlSerializer = new SimpleHtmlSerializer(props);
                                browser.loadDataWithBaseURL(null, htmlSerializer.getAsString(tagNode), "text/html", "charset=UTF-8", null);
                                throw new IOException();
                            }
                            catch (IOException e)
                            {

                            }
                        }
                    });
                }
                catch (IOException e)
                {

                }
            }
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}