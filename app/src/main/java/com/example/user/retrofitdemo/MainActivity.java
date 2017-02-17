package com.example.user.retrofitdemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.user.retrofitdemo.adapters.NoticeAdapter;
import com.example.user.retrofitdemo.modelDatas.ModelDataNotice;
import com.example.user.retrofitdemo.modelDatas.Noticeboard;
import com.example.user.retrofitdemo.modelDatas.SignInResponceModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private APIService apiService;
    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    NoticeAdapter noticeAdapter;
    ArrayList<Noticeboard> noticeboardList = new ArrayList<Noticeboard>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        apiService = ApiUtils.getAPIService();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(false);
        progressDialog.show();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        operationData();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

      /*  apiService.SIGN_IN_RESPONCE_MODEL_CALL("bajugali","USR16","ertreetrtrtr","12345","9884404148").enqueue(new Callback<SignInResponceModel>() {
            @Override
            public void onResponse(Call<SignInResponceModel> call, Response<SignInResponceModel> response) {
                if (response.isSuccessful()){

                    Toast.makeText(MainActivity.this,   response.body().getResponse().getUserdetails().get(0).getEmailId()+"", Toast.LENGTH_SHORT).show();

                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<SignInResponceModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, t+"", Toast.LENGTH_SHORT).show();

            }
        });*/
    }

    private void operationData() {
        progressDialog.show();

        try {
            apiService.MODEL_DATA_NOTICE_CALL("bajugali","USR16","c7Xskb9UFhGSd").enqueue(new Callback<ModelDataNotice>() {
                @Override
                public void onResponse(Call<ModelDataNotice> call, Response<ModelDataNotice> response) {
                    progressDialog.dismiss();

                    if (response.isSuccessful()){
                        if (response.body().getResponseCode()==1){
                            Toast.makeText(MainActivity.this, response.body().getResponseCode()+"", Toast.LENGTH_SHORT).show();
                            noticeboardList = (ArrayList<Noticeboard>) response.body().getResponse().getNoticeboard();
                            if (noticeboardList.size()>0){
                                Toast.makeText(MainActivity.this, noticeboardList.get(0).getNoticeName()+"", Toast.LENGTH_SHORT).show();
                                noticeAdapter = new NoticeAdapter(noticeboardList,MainActivity.this);
                                recyclerView.setAdapter(noticeAdapter);
                            }
                        }
                    }
                    noticeAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<ModelDataNotice> call, Throwable t) {
                    progressDialog.dismiss();

                    Log.v("Error",t.toString());
                }
            });

        }catch (Exception e){
            Toast.makeText(this, e+"", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
