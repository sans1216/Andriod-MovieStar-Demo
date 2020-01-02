package com.example.finalhomework.ui.notifications;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalhomework.R;
import com.example.finalhomework.ui.dashboard.MyDataBaseHelper_Movie;
import com.example.finalhomework.ui.dashboard.bean.movie;

import java.util.List;

import static android.view.View.GONE;

public class ListViewAdapter_movie extends BaseAdapter {
    private MyViewHolder holder;
    private LayoutInflater mLayoutInflater;
    private List<movie> movieList;
    public ListViewAdapter_movie(Context context, List<movie> movieList) {

        this.mLayoutInflater = LayoutInflater.from(context);
        this.movieList = movieList;
    }

    @Override
    public int getCount() {

      return movieList.size();
    }

    @Override
    public Object getItem(int position) {

        return  movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(final int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        holder = null;
        movie movie = movieList.get(position);
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.listview_item_movie, null);
            holder = new ListViewAdapter_movie.MyViewHolder(convertView);
            convertView.setTag(holder);
            if (movie != null){

              holder.title.setText(movie.getName());
              holder.intro.setText(movie.getIntro());
              holder.score.setText(String.valueOf(movie.getScore()));

                if (movie.getPoster()==0){
                    holder.poster.setVisibility(GONE);
                }else{
                    holder.poster.setImageResource(movie.getPoster());
                }

                View finalConvertView = convertView;
                holder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MyDataBaseHelper_Movie dbHelper = new MyDataBaseHelper_Movie(finalConvertView.getContext(), "movie_info.db", null, 1);
                        SQLiteDatabase db = dbHelper.getReadableDatabase();
                        String sql3 = "DELETE  FROM movie_info WHERE m_name ="+"'"+movie.getName()+"'";
                        db.execSQL(sql3);
                        Toast.makeText(finalConvertView.getContext(),"删除成功",Toast.LENGTH_SHORT).show();
                    }
                });
            }

        } else {
            holder = (MyViewHolder) convertView.getTag();
        }



        return convertView;
    }
    class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView poster;
        TextView title;
        TextView intro;
        TextView score;
        TextView delete;
        public MyViewHolder(View view)
        {
            super(view);
            poster = view.findViewById(R.id.m_poster);
            title = view.findViewById(R.id.m_title);
            intro = view.findViewById(R.id.m_intro);
            score = view.findViewById(R.id.m_score);
            delete = view.findViewById(R.id.delete);
        }
    }
}
