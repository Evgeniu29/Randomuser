package com.paad.randomuser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.paad.randomuser.API.User;
import com.paad.randomuser.Adapter.ResultAdapter;
import com.paad.randomuser.Retrofit.RetrofitClient;
import com.paad.randomuser.Retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String baseUrl = "https://randomuser.me/";

    RecyclerView recyclerViewler;

    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);

        recyclerViewler = findViewById(R.id.rv);

        final LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recyclerViewler.setLayoutManager(llm);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(recyclerViewler.getContext(), llm.getOrientation());
        recyclerViewler.addItemDecoration(itemDecoration);

        RetrofitService retrofitService = RetrofitClient.getClient(baseUrl).create(RetrofitService.class);

        Call<User> call = retrofitService.getResult();

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                Singlton.getInstance().characterList = response.body().results;

                ResultAdapter adapter = new ResultAdapter(Singlton.getInstance().characterList, getApplicationContext());

                recyclerViewler.setAdapter(adapter);



            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
            }
    });
}
}