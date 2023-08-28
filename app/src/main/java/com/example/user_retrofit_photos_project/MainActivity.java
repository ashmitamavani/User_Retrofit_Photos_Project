package com.example.user_retrofit_photos_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Recyclerview_Adapter adapter;
    List<PostsModelClas>modelList=new ArrayList<>();
    ArrayList<Model_Class>ProductList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter=new Recyclerview_Adapter(MainActivity.this, ProductList);
        recyclerView.setAdapter(adapter);
        Instance_Class.CallAPI().showProduct().enqueue(new Callback<List<PostsModelClas>>() {
            @Override
            public void onResponse(Call<List<PostsModelClas>> call, Response<List<PostsModelClas>> response) {
                Log.d("TTT", "onResponse: "+response.body().get(0).getTitle().toString());
                modelList=response.body();
                for (int i=0;i<modelList.size();i++)
                {
                    String id= String.valueOf(response.body().get(i).getId());
                    String title=response.body().get(i).getTitle();
                    String body=response.body().get(i).getBody();

                    Model_Class model=new Model_Class(id,title,body);
                    ProductList.add(model);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<List<PostsModelClas>> call, Throwable t) {
                Log.e("EEE", "onFailure:Error== "+t.getLocalizedMessage() );
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });

    }
}