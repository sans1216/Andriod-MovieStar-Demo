package com.example.finalhomework.ui.dashboard;

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
import com.example.finalhomework.ui.dashboard.bean.comment;

import java.util.List;

import static android.view.View.GONE;

public class ListViewAdapter_comments extends BaseAdapter {
    private MyViewHolder holder;
    private LayoutInflater mLayoutInflater;
    private List<comment>  commentList;
    public ListViewAdapter_comments(Context context, List<comment> commentList) {

        this.mLayoutInflater = LayoutInflater.from(context);
        this.commentList = commentList;
    }

    @Override
    public int getCount() {

        return commentList.size();
    }

    @Override
    public Object getItem(int position) {

        return commentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(final int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        holder = null;
        comment comment =  commentList.get(position);
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_view_movie_comment, null);
            holder = new ListViewAdapter_comments.MyViewHolder(convertView);
            convertView.setTag(holder);
            if (comment != null){
                    holder.username.setText(comment.getUsername());
                    holder.content.setText(comment.getContent());
                    holder.score.setText(String.valueOf(comment.getScore()));
                   // holder.icon.setImageResource(comment.getIcon());

            }

        } else {
            holder = (ListViewAdapter_comments.MyViewHolder) convertView.getTag();
        }



        return convertView;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView icon;
        TextView content;
        TextView score;
        TextView username;
        public MyViewHolder(View view)
        {
            super(view);
           username = view.findViewById(R.id.mc_username);
           content = view.findViewById(R.id.mc_comment);
           score = view.findViewById(R.id.mc_score);
           icon = view.findViewById(R.id.mc_icon);
        }
    }
}
