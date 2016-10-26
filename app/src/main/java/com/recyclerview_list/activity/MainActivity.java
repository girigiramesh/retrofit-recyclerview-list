package com.recyclerview_list.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.recyclerview_list.R;
import com.recyclerview_list.adapter.ListAdapter;
import com.recyclerview_list.model.Response;
import com.recyclerview_list.network.RetrofitHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView rv_lists;
    private ListAdapter listAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_lists = (RecyclerView) findViewById(R.id.rv_lists);

        showProgressDialog("please wait...!");
        RetrofitHandler.getInstance().getMessageList().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                dismissProgressDialog();
                if (response.isSuccessful()) {
                    JSONObject jsonRootObject = new JSONObject();
                    JSONArray jsonArray = jsonRootObject.optJSONArray("response");
                    List<Response> responseList = new ArrayList<>();
                    buildList(responseList);
                } else {
                    Log.e(TAG, "onResponse: " + response.raw());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                dismissProgressDialog();
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    private void buildList(List<Response> lists) {
        if (rv_lists.getAdapter() == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rv_lists.setLayoutManager(linearLayoutManager);
            listAdapter = new ListAdapter(lists, this);
            rv_lists.setAdapter(listAdapter);
        } else {
            listAdapter.notifyData(lists);
        }
    }
}
