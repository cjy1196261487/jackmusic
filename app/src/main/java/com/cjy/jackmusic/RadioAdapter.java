package com.cjy.jackmusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cjy.jackmusic.utils.RadioUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

class RadioAdapter extends BaseAdapter{
    private Context context;
    private List<RadioUtil.ChannellistBean>channellist;

    public RadioAdapter(MainActivity mainActivity, List<RadioUtil.ChannellistBean> channellistBeans) {
        this.context=mainActivity;
        channellist=channellistBeans;
    }

    @Override
    public int getCount() {
        return channellist.size();
    }

    @Override
    public Object getItem(int i) {
        return channellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.radio_item,viewGroup,false);
        SimpleDraweeView simpleDraweeView=view.findViewById(R.id.radio_pic);
        TextView textView=view.findViewById(R.id.radio_name);
        simpleDraweeView.setImageURI(channellist.get(i).getThumb());
        textView.setText(channellist.get(i).getName());

        return view;
    }
}
