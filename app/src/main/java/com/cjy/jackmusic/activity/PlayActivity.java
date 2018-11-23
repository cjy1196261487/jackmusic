package com.cjy.jackmusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.cjy.jackmusic.R;
import com.cjy.jackmusic.utils.SearchUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class PlayActivity extends AppCompatActivity{
   private SearchUtil.ResultBean searchresult;
    private  SimpleDraweeView simpleDraweeView;
    private  Animation animation;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);
        Intent intent=getIntent();
        Log.e("123",intent.getSerializableExtra("songsarry").toString());
        searchresult=(SearchUtil.ResultBean)intent.getSerializableExtra("songsarry");
        initView();
        TextView stop=findViewById(R.id.stop);




        animation= AnimationUtils.loadAnimation(this,R.anim.image_animaltion);
        LinearInterpolator linearInterpolator=new LinearInterpolator();//设置动画匀速运动
        animation.setInterpolator(linearInterpolator);

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleDraweeView.startAnimation(animation);
            }
        });




    }

    private void initView() {
        simpleDraweeView=findViewById(R.id.music_pic);
        simpleDraweeView.setImageURI(searchresult.getPic());
    }
}
