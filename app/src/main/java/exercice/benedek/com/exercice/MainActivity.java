package exercice.benedek.com.exercice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import exercice.benedek.com.exercice.AsyncTask.OmdbapiAsyncTask;

public class MainActivity extends AppCompatActivity {

    private MovieApplication movieApplication = new MovieApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        switchFragmentTo(movieApplication.getMovieFragment());

    }

    public void switchFragmentTo(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    public MovieApplication getMovieApplication() {
        return movieApplication;
    }

    public void showBackButton() {
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void hideBackButton() {
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            hideBackButton();
            switchFragmentTo(movieApplication.getMovieFragment());
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
