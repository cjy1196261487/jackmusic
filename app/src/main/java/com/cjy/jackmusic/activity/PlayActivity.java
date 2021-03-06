package com.cjy.jackmusic.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.cjy.jackmusic.R;
import com.cjy.jackmusic.service.NetPlayService;
import com.cjy.jackmusic.utils.SearchUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class PlayActivity extends AppCompatActivity{
   private SearchUtil.ResultBean searchresult;
    private  SimpleDraweeView simpleDraweeView;
    private  Animation animation;
    private Button btnPause, btnPlayUrl, btnStop,btnReplay;
    private SeekBar skbProgress;
    private NetPlayService player;
    private EditText file_name_text;
    private TextView tipsView;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);
        Intent intent=getIntent();
        Log.e("123",intent.getSerializableExtra("songsarry").toString());
        searchresult=(SearchUtil.ResultBean)intent.getSerializableExtra("songsarry");
        initView();
//        TextView stop=findViewById(R.id.stop);




        animation= AnimationUtils.loadAnimation(this,R.anim.image_animaltion);
        LinearInterpolator linearInterpolator=new LinearInterpolator();//设置动画匀速运动
        animation.setInterpolator(linearInterpolator);

//        stop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                simpleDraweeView.startAnimation(animation);
//            }
//        });




    }

    private void initView() {
        simpleDraweeView=findViewById(R.id.music_pic);
        simpleDraweeView.setImageURI(searchresult.getPic());



        btnPlayUrl = (Button) this.findViewById(R.id.btnPlayUrl);
        btnPlayUrl.setOnClickListener(new ClickEvent());

        btnPause = (Button) this.findViewById(R.id.btnPause);
        btnPause.setOnClickListener(new ClickEvent());

        btnStop = (Button) this.findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new ClickEvent());

        btnReplay = (Button) this.findViewById(R.id.btnReplay);
        btnReplay.setOnClickListener(new ClickEvent());



        skbProgress = (SeekBar) this.findViewById(R.id.skbProgress);
        skbProgress.setOnSeekBarChangeListener(new SeekBarChangeEvent());

        String url=searchresult.getUrl();
        player = new NetPlayService(url,skbProgress);

        TelephonyManager telephonyManager=(TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.listen(new MyPhoneListener(), PhoneStateListener.LISTEN_CALL_STATE);
    }

    /**
     * 只有电话来了之后才暂停音乐的播放
     */
    private final class MyPhoneListener extends android.telephony.PhoneStateListener{
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            switch (state) {
                case TelephonyManager.CALL_STATE_RINGING://电话来了
                    player.callIsComing();
                    break;
                case TelephonyManager.CALL_STATE_IDLE: //通话结束
                    player.callIsDown();
                    break;
            }
        }
    }

    class ClickEvent implements View.OnClickListener {
        @Override
        public void onClick(View arg0) {
            if (arg0 == btnPause) {
                boolean pause=player.pause();
                if (pause) {
                    btnPause.setText("继续");

                }else{
                    btnPause.setText("暂停");

                }
            } else if (arg0 == btnPlayUrl) {
                player.play();
//                tipsView.setText("开始播放...");
            } else if (arg0 == btnStop) {
                player.stop();
//                tipsView.setText("停止播放...");
            } else if (arg0==btnReplay) {
                player.replay();
//                tipsView.setText("重新播放...");
            }
        }
    }

    class SeekBarChangeEvent implements SeekBar.OnSeekBarChangeListener {
        int progress;
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            // 原本是(progress/seekBar.getMax())*player.mediaPlayer.getDuration()
            this.progress = progress * player.mediaPlayer.getDuration()
                    / seekBar.getMax();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // seekTo()的参数是相对与影片时间的数字，而不是与seekBar.getMax()相对的数字
            player.mediaPlayer.seekTo(progress);
        }
    }

    }

