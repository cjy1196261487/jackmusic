package com.cjy.jackmusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.cjy.jackmusic.R;
import com.cjy.jackmusic.utils.MusicRank;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RankAdapter extends BaseAdapter{
    private Context context;
    private List<MusicRank.ResultBean> resultBeans;


    public RankAdapter(Context context,  List<MusicRank.ResultBean> result) {
        this.context=context;
        resultBeans=result;
    }

    @Override
    public int getCount() {
        return resultBeans.size();
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

        view = LayoutInflater.from(context).inflate(R.layout.rankitem, viewGroup,false);
        SimpleDraweeView simpleDraweeView=view.findViewById(R.id.rank_pic);
        simpleDraweeView.setImageURI(resultBeans.get(i).getPic_s192());
        return view;
    }
}
