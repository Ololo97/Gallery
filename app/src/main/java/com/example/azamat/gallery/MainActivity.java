package com.example.azamat.gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button accept;
    EditText search;
    String request;
    RecyclerView imageRecycler;
    List <Pojo.Photo> is;
    ////////////////////////////////////////////////////////////////////////
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ////////////////////////////////////////////////////////////////////
        accept=findViewById(R.id.accept);
        search=findViewById(R.id.Search);
        Mylistener listener= new Mylistener();
        accept.setOnClickListener(listener);
    }
    public class Mylistener implements View.OnClickListener
    {
        public void onClick(View v) {
            Retrofit retrofit;
            imageRecycler = findViewById(R.id.recycler);
            imageRecycler.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
            imageRecycler.addItemDecoration( new DividerItemDecoration(MainActivity.this,R.drawable.recycle_rpace));
            is=new ArrayList<>();
            request=search.getText().toString();
            retrofit=new Retrofit.Builder()
                    .baseUrl("https://api.flickr.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Controller controller=retrofit.create(Controller.class);
            final Call <Pojo> images=controller.getData(request);
            images.enqueue(new Callback<Pojo>() {
                @Override
                public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                    Pojo pojo=response.body();
                    Pojo.Photos photos=pojo.getPhotos();
                    is.addAll(photos.getPhoto());
                    imageRecycler.getAdapter().notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<Pojo> call, Throwable t) {

                }
            });
            DataAdapter adapter=new DataAdapter(MainActivity.this,is);
            imageRecycler.setAdapter(adapter);
        }
    }
}
