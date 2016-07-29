package exercice.benedek.com.exercice.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import exercice.benedek.com.exercice.Adapters.MovieAdapter;
import exercice.benedek.com.exercice.AsyncTask.OmdbapiAsyncTask;
import exercice.benedek.com.exercice.MainActivity;
import exercice.benedek.com.exercice.Movie;
import exercice.benedek.com.exercice.R;

/**
 * Created by Benedek on 2016.07.29..
 */
public class MovieFragment extends Fragment {

    private EditText editText;

    private Button searchButton;

    private MovieAdapter adapter;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_fragment, container, false);

        editText = (EditText) view.findViewById(R.id.input);

        searchButton = (Button) view.findViewById(R.id.search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new OmdbapiAsyncTask(adapter).execute(editText.getText().toString());
            }
        });
        listView = (ListView) view.findViewById(R.id.listView);
        adapter = new MovieAdapter(new ArrayList<Movie> (), MovieFragment.this.getContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = (Movie) MovieFragment.this.adapter.getItem(position);
                Fragment detailFragment = ((MainActivity) MovieFragment.this.getActivity()).getMovieApplication().getDetailFragment();
                ((DetailFragment) detailFragment).setMovie(movie);
                ((MainActivity) MovieFragment.this.getActivity()).switchFragmentTo(detailFragment);

            }
        });
        return view;
    }
}
