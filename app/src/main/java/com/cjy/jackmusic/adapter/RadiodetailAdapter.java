package com.cjy.jackmusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cjy.jackmusic.R;
import com.cjy.jackmusic.utils.RadioDetail;
import com.cjy.jackmusic.utils.RankUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RadiodetailAdapter extends BaseAdapter{
    private Context context;
    private List<RadioDetail.ResultBean.SonglistBean>resultBeans;

    public RadiodetailAdapter(Context context, List<RadioDetail.ResultBean.SonglistBean> rankUtilList) {
        this.context=context;
        resultBeans=rankUtilList;
    }

    @Override
    public int getCount() {
        return resultBeans.size()-1;
    }

    @Override
    public Object getItem(int i) {
        return resultBeans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.musiclist_item,viewGroup,false);
        SimpleDraweeView simpleDraweeView=view.findViewById(R.id.musiclist_pic);
        TextView songname=view.findViewById(R.id.songname);
        TextView singname=view.findViewById(R.id.sing_name);
        simpleDraweeView.setImageURI(resultBeans.get(i).getThumb());
        songname.setText(resultBeans.get(i).getTitle());
        singname.setText(resultBeans.get(i).getArtist());




        return view;
    }
}
