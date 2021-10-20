package com.cahyaa.tmdb.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.cahyaa.tmdb.R;
import com.cahyaa.tmdb.databinding.ActivityMainBinding;
import com.cahyaa.tmdb.viewmodel.MovieViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private MovieViewModel view_model;

    NavHostFragment navHostFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setSupportActionBar(binding.toolbarMainMenu);

        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_fragment_main_menu);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.nowPlayingFragment, R.id.upComingFragment).build();
        NavigationUI.setupActionBarWithNavController(this, navHostFragment.getNavController(), appBarConfiguration);
        NavigationUI.setupWithNavController(binding.bottomNavMainMenu, navHostFragment.getNavController());

        view_model = new ViewModelProvider(MainActivity.this).get(MovieViewModel.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        MenuItem searchViewItem = menu.findItem(R.id.app_bar_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //Ketika User submit query searching
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                view_model.getMovieResult(query);
                return false;
            }

            //Ketika User sedang mengetik query searching
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}