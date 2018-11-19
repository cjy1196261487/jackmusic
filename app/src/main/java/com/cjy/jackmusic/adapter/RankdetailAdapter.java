package com.cjy.jackmusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cjy.jackmusic.R;
import com.cjy.jackmusic.utils.RankUtil;
import com.cjy.jackmusic.utils.SearchUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RankdetailAdapter extends BaseAdapter{
    private Context context;
    private List<RankUtil.ResultBean>resultBeans;

    public RankdetailAdapter(Context context, List<RankUtil.ResultBean> rankUtilList) {
        this.context=context;
        resultBeans=rankUtilList;
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
        view= LayoutInflater.from(context).inflate(R.layout.musiclist_item,viewGroup,false);
        SimpleDraweeView simpleDraweeView=view.findViewById(R.id.musiclist_pic);
        TextView songname=view.findViewById(R.id.songname);
        TextView singname=view.findViewById(R.id.sing_name);
        simpleDraweeView.setImageURI(resultBeans.get(i).getAlbum_500_500());
        songname.setText(resultBeans.get(i).getTitle());

        if (resultBeans.get(i).getAuthor().length()>20){
            singname.setText(resultBeans.get(i).getAuthor().substring(0,9)+".....");
        }else {
            singname.setText(resultBeans.get(i).getAuthor());
        }



        return view;
    }
}
