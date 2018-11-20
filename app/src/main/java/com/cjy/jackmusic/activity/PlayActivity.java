package com.cjy.jackmusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

import com.cjy.jackmusic.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class PlayActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);

//        Intent intent=getIntent();
//        Log.e("123",intent.getStringExtra("url"));

        //intent.getStringExtra("url");
        SimpleDraweeView simpleDraweeView=findViewById(R.id.music_pic);
        simpleDraweeView.setImageURI("http://qukufile2.qianqian.com/data2/pic/70883433240509d03e93342800d86b5d/166527/166527.jpg@s_1,w_90,h_90");
        /*实现动画的旋转*/
//        Animation animation= AnimationUtils.loadAnimation(this,R.anim.image_animaltion);
//        LinearInterpolator linearInterpolator=new LinearInterpolator();//设置动画匀速运动
//        animation.setInterpolator(linearInterpolator);
//        simpleDraweeView.startAnimation(animation);

    }
}
