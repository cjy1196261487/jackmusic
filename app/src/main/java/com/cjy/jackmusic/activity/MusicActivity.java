package com.cjy.jackmusic.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.cjy.jackmusic.R;
import com.cjy.jackmusic.utils.OkHttpUtil;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MusicActivity extends AppCompatActivity {
    private ImageView backbutton,serachbutton;
    private EditText songname;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.musiclist_layout);
        initView();

        initListen();


    }

    private void initListen() {
        serachbutton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String songorsing=songname.getText().toString();
                String requestUrl="http://api.apiopen.top/searchMusic?name="+songorsing;
                OkHttpUtil.sendOkhttpResquest(requestUrl, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.e("歌曲详情",response.body().string());

                    }
                });

            }
        });


    }

    private void initView() {
        backbutton=findViewById(R.id.backbutton);
        songname=findViewById(R.id.music_search);
        serachbutton= findViewById(R.id.button_search);


    }


}
