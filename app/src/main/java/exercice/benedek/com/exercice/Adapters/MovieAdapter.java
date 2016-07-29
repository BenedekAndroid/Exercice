package exercice.benedek.com.exercice.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import exercice.benedek.com.exercice.Movie;
import exercice.benedek.com.exercice.R;

/**
 * Created by Benedek on 2016.07.29..
 */
public class MovieAdapter extends BaseAdapter {

    private ArrayList<Movie> movies;
    private Context context;

    public MovieAdapter(ArrayList<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.movie_row, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.move_row_title);
        textView.setText(this.movies.get(position).getTitle());

        return convertView;
    }

    public void addMovies(List<Movie> movies) {
        this.movies.clear();
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }
}
