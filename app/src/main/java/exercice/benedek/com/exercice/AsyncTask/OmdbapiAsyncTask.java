package exercice.benedek.com.exercice.AsyncTask;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import exercice.benedek.com.exercice.Adapters.MovieAdapter;
import exercice.benedek.com.exercice.Movie;

/**
 * Created by Benedek on 2016.07.28..
 */
public class OmdbapiAsyncTask extends AsyncTask<String, List<Movie>, List<Movie>> {


    private MovieAdapter adapter;

    public OmdbapiAsyncTask(MovieAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected List<Movie> doInBackground(String... params) {
        List<Movie> movies = null;
        try {
            movies = sendHttp(params[0]);
        } catch (IOException e) {
            Log.e("",""+e);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movies;
    }

    @Override
    protected void onPostExecute(List<Movie> movies) {

        if (movies != null) {
            adapter.addMovies(movies);
        }

    }

    private List<Movie> sendHttp(String t) throws IOException, JSONException {
        URL url = new URL("http://www.omdbapi.com/?apikey=9283bf7a&t="+t);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        int i;

        StringBuffer buffer = new StringBuffer();
        while((i=in.read())!=-1) {
            // converts integer to character
            char c = (char) i;
            buffer.append(c);
        }

        JSONObject jsonMovie = new JSONObject(buffer.toString());
        String title = jsonMovie.getString("Title");
        String year = jsonMovie.getString("Year");
        String actors = jsonMovie.getString("Actors");
        String director = jsonMovie.getString("Director");
        String genre = jsonMovie.getString("Genre");

        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setYear(year);
        movie.setActors(actors);
        movie.setDirector(director);
        movie.setGenre(genre);

        List<Movie> result = new ArrayList<Movie>();
        result.add(movie);

        return result;
    }
}

