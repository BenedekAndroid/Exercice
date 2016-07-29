package exercice.benedek.com.exercice;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import exercice.benedek.com.exercice.Fragments.DetailFragment;
import exercice.benedek.com.exercice.Fragments.MovieFragment;

/**
 * Created by Benedek on 2016.07.29..
 */
public class MovieApplication extends Application {

    private MovieFragment movieFragment = new MovieFragment();
    private DetailFragment detailFragment = new DetailFragment();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public Fragment getMovieFragment() {
        return movieFragment;
    }

    public Fragment getDetailFragment() {
        return detailFragment;
    }


}
