package exercice.benedek.com.exercice.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import exercice.benedek.com.exercice.MainActivity;
import exercice.benedek.com.exercice.Movie;
import exercice.benedek.com.exercice.R;

/**
 * Created by Benedek on 2016.07.29..
 */
public class DetailFragment extends Fragment {

    private Movie movie;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);

        ((MainActivity) DetailFragment.this.getActivity()).showBackButton();

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(movie.getTitle());
        TextView genre = (TextView) view.findViewById(R.id.genre);
        genre.setText(movie.getGenre());
        TextView year = (TextView) view.findViewById(R.id.year);
        year.setText(movie.getYear());
        TextView actors = (TextView) view.findViewById(R.id.actors);
        actors.setText(movie.getActors());
        TextView director = (TextView) view.findViewById(R.id.director);
        director.setText(movie.getDirector());
        return view;
    }

    public void setMovie(Movie movie){
        this.movie = movie;
    }
}
