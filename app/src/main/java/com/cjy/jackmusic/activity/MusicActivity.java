package com.cjy.jackmusic.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.cjy.jackmusic.R;
import com.cjy.jackmusic.adapter.MusicAdapter;
import com.cjy.jackmusic.utils.OkHttpUtil;
import com.cjy.jackmusic.utils.SearchUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MusicActivity extends AppCompatActivity {
    private ImageView backbutton,serachbutton;
    private EditText songname;
    private  SearchUtil searchUtil ;
    private ListView searchlist;
    private MediaPlayer mediaPlayer=new MediaPlayer();
     private List<SearchUtil.ResultBean>searchUtilList;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.musiclist_layout);
        initView();

        initListen();


    }

    private void initView() {
        backbutton = findViewById(R.id.backbutton);
        songname = findViewById(R.id.music_search);
        serachbutton = findViewById(R.id.button_search);
        searchlist = findViewById(R.id.music_list);

    }

    private void initListen() {
        serachbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=songname.getText().toString();
                String url="http://api.apiopen.top/searchMusic?name="+name;
                OkHttpUtil.sendOkhttpResquest(url, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String strrespone=response.body().string();
                        searchUtil=new Gson().fromJson(strrespone,SearchUtil.class);
                        searchUtilList=searchUtil.getResult();
                        if (searchUtil.getCode()==200){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    MusicAdapter musicAdapter=new MusicAdapter(MusicActivity.this,searchUtilList);
                                    searchlist.setAdapter(musicAdapter);
                                    musicAdapter.notifyDataSetChanged();
                                }
                            });
                        }


                    }
                });
            }
        });
        searchlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                mediaPlayer.reset();

                try {
                    mediaPlayer.setDataSource(searchUtilList.get(i).getUrl());
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }






    }
