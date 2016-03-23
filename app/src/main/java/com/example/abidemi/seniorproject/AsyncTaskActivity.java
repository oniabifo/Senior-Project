package com.example.abidemi.seniorproject;
import java.io.IOException;
import android.content.AsyncTaskLoader;
import android.content.Context;

public class AsyncTaskActivity extends AsyncTaskLoader<String> {

    String res  = "";
    String parse = "";
    JavaHttpUrlConnectionReader javaHttpUrlConnectionReader;

    //DatabaseHandler db;
    public AsyncTaskActivity(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String loadInBackground() {
        // TODO Auto-generated method stub
        javaHttpUrlConnectionReader  = new JavaHttpUrlConnectionReader();
        //db = new DatabaseHandler();
        res = javaHttpUrlConnectionReader.getData();
        //parse = javaHttpUrlConnectionReader.addStock();
        return res;
    }

/*
    @Override
    public void deliverResult(String data) {
        // TODO Auto-generated method stub
        super.deliverResult(data);

    }
*/
    @Override
    protected void onStartLoading() {
        if (!res.equals("")) {
            deliverResult(res);
        }

        if (takeContentChanged() || res.equals("")) {
            forceLoad();
        }
    }

  /*  public void gettweets(String arg1) {
        // TODO Auto-generated method stub
        try {
            javaHttpUrlConnectionReader.doHttpUrlConnectionAction(arg1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }*/

}