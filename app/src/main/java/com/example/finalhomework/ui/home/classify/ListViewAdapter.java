package com.example.finalhomework.ui.home.classify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalhomework.R;

import java.util.List;

import static android.view.View.GONE;

public class ListViewAdapter extends BaseAdapter {


    private MyViewHolder holder;
    private LayoutInflater mLayoutInflater;
    private List<recommend> recommendList;
    public ListViewAdapter(Context context, List<recommend> recommendList) {

        this.mLayoutInflater = LayoutInflater.from(context);
        this.recommendList = recommendList;
    }

    @Override
    public int getCount() {
        return recommendList.size();
    }

    @Override
    public Object getItem(int position) {
        return recommendList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(final int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        holder = null;
        recommend recommend = recommendList.get(position);
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.recommend_recycle_item, null);
            holder = new MyViewHolder(convertView);
            convertView.setTag(holder);
            if (recommend != null){

                holder.nickname.setText(recommend.getNickname());
                holder.content.setText(recommend.getContent());
                holder.date.setText(recommend.getDate());
                holder.tag.setText(recommend.getTag());
                if (recommend.getIcon()==0){
                    holder.icon.setVisibility(GONE);
                }else{
                    holder.icon.setImageResource(recommend.getIcon());
                }

                if (recommend.getImg()==null){
                    holder.img.setVisibility(GONE);
                }else{
                    holder.img.setImageURI(recommend.getImg());
                }

            }

        } else {
            holder = (MyViewHolder) convertView.getTag();
        }



        return convertView;
    }
    class MyViewHolder extends RecyclerView.ViewHolder
    {

        ImageView icon;
        ImageView img;
        TextView nickname;
        TextView tag;
        TextView content;
        TextView date;

        public MyViewHolder(View view)
        {
            super(view);

            icon = view.findViewById(R.id.rc_icon);
            img = view.findViewById(R.id.rc_img);
            nickname = view.findViewById(R.id.rc_nickname);
            tag = view.findViewById(R.id.rm_tag);
            content = view.findViewById(R.id.rc_content);
            date = view.findViewById(R.id.rc_date);

        }
    }
}
