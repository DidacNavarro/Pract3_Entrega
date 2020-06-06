package cat.urv.deim.asm.p2.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import cat.urv.deim.asm.p3.shared.Faqs;


public class MainActivity extends AppCompatActivity  {

    private AppBarConfiguration mAppBarConfiguration;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_news, R.id.nav_articles, R.id.nav_events,R.id.nav_calendar,R.id.nav_settings)
                .setDrawerLayout(drawer)
                .build();
         navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        drawer.closeDrawers();
                switch (menuItem.getItemId()) {

                    case R.id.nav_profile:
                        Toast.makeText(getApplicationContext(), "Profile Selected", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_news:
                        Toast.makeText(getApplicationContext(), "News Selected", Toast.LENGTH_LONG).show();
                        navController.popBackStack(R.id.mobile_navigation,true);
                        Navigation.findNavController(MainActivity.this,R.id.nav_host_fragment).navigate(R.id.nav_news);

                        break;

                    case R.id.nav_gallery:
                        Toast.makeText(getApplicationContext(), "gallery Selected", Toast.LENGTH_LONG).show();
                        navController.popBackStack(R.id.mobile_navigation,true);
                        Navigation.findNavController(MainActivity.this,R.id.nav_host_fragment).navigate(R.id.nav_gallery);

                        break;
                    case R.id.nav_faqs:
                        Toast.makeText(getApplicationContext(), "FAQS Selected", Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent(MainActivity.this, Faqs.class);
                        startActivity(intent2);
                        break;



                }

                drawer.closeDrawers();

                return false;

            }

        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }




}
