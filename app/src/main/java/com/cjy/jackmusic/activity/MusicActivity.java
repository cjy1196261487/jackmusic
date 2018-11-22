package com.cjy.jackmusic.activity;

import android.content.Context;
import android.content.Intent;
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
import com.cjy.jackmusic.adapter.RadiodetailAdapter;
import com.cjy.jackmusic.adapter.RankdetailAdapter;
import com.cjy.jackmusic.utils.OkHttpUtil;
import com.cjy.jackmusic.utils.RadioDetail;
import com.cjy.jackmusic.utils.RadioUtil;
import com.cjy.jackmusic.utils.RankUtil;
import com.cjy.jackmusic.utils.SearchUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MusicActivity extends AppCompatActivity {
    private ImageView backbutton,serachbutton;
    private EditText songname;
    private  SearchUtil searchUtil ;
    private ListView searchlist;
    private RankUtil rankUtil;
    private RadioDetail radioDetail;
    private List<RankUtil.ResultBean>rankutilList;
   private List<RadioDetail.ResultBean.SonglistBean>radiodetaillist;
   private ArrayList<SearchUtil.ResultBean>searchUtilList;
   private int type;
   private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.musiclist_layout);
        Intent intent=getIntent();
        type= intent.getIntExtra("type",0);
        name=intent.getStringExtra("name");
        Log.e("tpye is",""+type);
        if (name.equals("0")){

        }else if (name.equals("2")){
            String url="http://api.apiopen.top/musicRankingsDetails?type="+type;
            OkHttpUtil.sendOkhttpResquest(url, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String re=response.body().string();
                    rankUtil=new Gson().fromJson(re,RankUtil.class);
                    rankutilList=rankUtil.getResult();
                    if (rankUtil.getCode()==200){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                RankdetailAdapter rankdetailAdapter=new RankdetailAdapter(MusicActivity.this,rankutilList);
                                searchlist.setAdapter(rankdetailAdapter);
                                rankdetailAdapter.notifyDataSetChanged();

                            }
                        });
                    }


                }
            });

       }else if (name.equals("3")){
           String url="http://tingapi.ting.baidu.com/v1/restserver/ting?from=qianqian&version=2.1.0&method=baidu.ting.radio.getChannelSong&format=json&pn=0&rn=20&channelname="+intent.getStringExtra("radioanme");
            Log.e("_+++++_url",url);
           OkHttpUtil.sendOkhttpResquest(url, new Callback() {
               @Override
               public void onFailure(Call call, IOException e) {

               }

               @Override
               public void onResponse(Call call, Response response) throws IOException {
                   String re=response.body().string();
                   Log.e("_+++++_",re);
                   radioDetail=new Gson().fromJson(re,RadioDetail.class);
                   radiodetaillist=radioDetail.getResult().getSonglist();
                   if (radioDetail.getError_code()==22000){
                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               RadiodetailAdapter radiodetailAdapter=new RadiodetailAdapter(MusicActivity.this,radiodetaillist);
                               searchlist.setAdapter(radiodetailAdapter);
                               radiodetailAdapter.notifyDataSetChanged();

                           }
                       });
                   }



               }
           });
       }

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
                Intent intent=new Intent(MusicActivity.this,PlayActivity.class);
                if (name.equals("2")){
                    intent.putExtra("songs_id",rankutilList.get(i).getSong_id());
                }else if (name.equals("3")){
                    intent.putExtra("songs_id",radiodetaillist.get(i).getSongid());
                }else if (name.equals("0")){
                    intent.putExtra("songsarry",searchUtilList.get(i));
                }
                startActivity(intent);




//                        MediaPlayer mediaPlayer=null;
//                        mediaPlayer=new MediaPlayer();
//                        try {
//                            mediaPlayer.reset();
//                            mediaPlayer.setDataSource("http://zhangmenshiting.qianqian.com/data2/music/4569de4b5c9c90f99b8d04c6e74fd433/596995258/596995258.mp3?xcode=01f7d66077515486180b9e6dd2675aac");
//                            mediaPlayer.prepare();
//                            mediaPlayer.start();
//                            Log.e("歌曲时长",mediaPlayer.getDuration()+"");
//
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }



//                Intent intent=new Intent(MusicActivity.this,PlayActivity.class);
//                intent.putExtra("url",radiodetaillist.get(i).getThumb());
//                startActivity(intent);

            }
       });
  }






    }
