package com.rapigo.truoraclient.client;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.rapigo.truoraclient.models.Domain;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class TruoraService {

    private static String URL = "https://truora.juliantoro.co";

    private Context context;

    public TruoraService(Context context){
        this.context = context;
    }

    public void scannDomain(String domain, final CallbackHttp <Domain> callback){ //, FutureCallback<Domain> callback){
        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams params = new RequestParams();

        String url = this.URL + "/domains/" + domain ;

        client.get(url, params, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    Domain d = new Domain();
                    Gson gson = new Gson();
                    d = gson.fromJson(response.toString(),Domain.class);
                    callback.success(d);
                } catch (Exception e) { }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(context,"on Failure", Toast.LENGTH_SHORT).show();
                callback.error(responseString);
            }
        });
    }

    public void getDomains(final CallbackHttp <List<Domain>> callback) {
        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams params = new RequestParams();

        String url = this.URL + "/domains" ;

        client.get(url, params, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    ArrayList<Domain> list = new ArrayList<Domain>();
                    JSONArray jsonArray = response.getJSONArray("items");
                    for( int i=0; i<jsonArray.length(); i++ ){
                        JSONObject jo = jsonArray.getJSONObject(i);
                        Gson gson = new Gson();
                        Domain d = gson.fromJson(jo.toString(),Domain.class);
                        list.add(d);
                    }
                    callback.success(list);
                } catch (Exception e) { }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(context,"on Failure", Toast.LENGTH_SHORT).show();
                callback.error(responseString);
            }
        });
    }
}
