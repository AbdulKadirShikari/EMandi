package com.example.emandi;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_addjins, R.id.navigation_addmark,R.id.navigation_report,R.id.navigation_aboutus)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


        navView.setOnNavigationItemSelectedListener(navlistener);

    }



    public BottomNavigationView.OnNavigationItemSelectedListener navlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

           int  menuid = menuItem.getItemId();

            switch (menuid) {

                case R.id.navigation_home:
                    Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment).navigate(R.id.navigation_home);

                    break;

                case R.id.navigation_addjins:
                    Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment).navigate(R.id.navigation_addjins);

                    break;

                    case R.id.navigation_addmark:
                    Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment).navigate(R.id.navigation_addmark);

                    break;

                case R.id.navigation_report:
                    Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment).navigate(R.id.navigation_report);

                    break;

                    case R.id.navigation_aboutus:
                    Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment).navigate(R.id.navigation_aboutus);

                    break;


            }

            return true;
        }


    };

}
