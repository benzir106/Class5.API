package com.shovo.class5api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView  recyclerView;
    private profile_adapter profile_adapter;
    private ArrayList<profileModel> profileModelArrayList;


    private RequestQueue mQueue;

    String url ="https://reqres.in/api/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQueue= Volley.newRequestQueue(this);
        profileModelArrayList = new ArrayList<>();

        recyclerView=findViewById(R.id.recyclerViewId);
        recyclerView.setHasFixedSize(true);

         LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
         recyclerView.setLayoutManager(linearLayoutManager);

        ApiResult();
    }

    private void ApiResult() {

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {
                    JSONArray jsonArray=response.getJSONArray("data");

                    for (int i =0; i< jsonArray.length();i++){
                        JSONObject data =jsonArray.getJSONObject(i);

                        String id =data.getString("id");
                        String email =data.getString("email");
                        String first_name =data.getString("first_name");
                        String last_name =data.getString("last_name");
                        String avatar =data.getString("avatar");



            profileModelArrayList.add(new profileModel(email,first_name,last_name,avatar));

                    }


                    profile_adapter = new profile_adapter(MainActivity.this, profileModelArrayList);
                    recyclerView.setAdapter(profile_adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


//                resultText.setText(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mQueue.add(jsonObjectRequest);
    }
}
