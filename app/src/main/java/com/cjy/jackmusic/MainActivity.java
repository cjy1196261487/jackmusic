package com.cjy.jackmusic;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuWrapperFactory;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;

import com.cjy.jackmusic.utils.MusicRank;
import com.cjy.jackmusic.utils.OkHttpUtil;
import com.cjy.jackmusic.utils.RadioUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private  SimpleDraweeView simpleDraweeView;
    private GridView Leaderboard,radiolist;
    private RadioButton localmusic,heartmusic,downloadmusic,playhistory;
    final String musicrankurl="http://api.apiopen.top/musicRankings";
    final String musicradiourl="http://api.apiopen.top/musicBroadcasting";
    private MusicRank musicRank;
    private RadioUtil radioUtil;
    private List<MusicRank.ResultBean>resultBeans;
    private List<RadioUtil.ChannellistBean>channellistBeans;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        initView();
        requestRanks(musicrankurl);
        requestRadio(musicradiourl);
    }

    private void requestRadio(String musicradiourl) {
        OkHttpUtil.sendOkhttpResquest(musicradiourl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final  String StrRadio=response.body().string();
                Log.e("电台列表",StrRadio);
                try {
                    JSONObject jsonObject= new JSONObject(StrRadio);
                    JSONArray jsonArray=jsonObject.getJSONArray("result");
                    Log.i("josn ----",jsonArray.getJSONObject(0).toString());
                    radioUtil= new Gson().fromJson(jsonArray.getJSONObject(0).toString(), RadioUtil.class);

                    channellistBeans=radioUtil.getChannellist();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            RadioAdapter adapter= new  RadioAdapter(MainActivity.this,channellistBeans);
                            radiolist.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        }
                    });



                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    private void requestRanks(String url) {
        OkHttpUtil.sendOkhttpResquest(url, new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String Strmusicranks=response.body().string();
              Log.e("歌曲排行榜",Strmusicranks);
              Gson gson=new Gson();
              musicRank=gson.fromJson(Strmusicranks,MusicRank.class);
              resultBeans=musicRank.getResult();
              if (musicRank.getCode()==200){
                  runOnUiThread(new Runnable() {
                      @Override
                      public void run() {
                          Myadapter myadapter=new Myadapter(MainActivity.this,resultBeans);
                          Leaderboard.setAdapter(myadapter);
                          myadapter.notifyDataSetChanged();
                      }
                  });
              }

          }
        });

    }

    private void initView() {
        Leaderboard=findViewById(R.id.Leader_board);
        radiolist=findViewById(R.id.radiolist);
        simpleDraweeView=findViewById(R.id.music_pic);
        localmusic=findViewById(R.id.local_music);
        heartmusic=findViewById(R.id.collection_music);
        downloadmusic=findViewById(R.id.download_music);
        playhistory=findViewById(R.id.music_history);


    }



}
