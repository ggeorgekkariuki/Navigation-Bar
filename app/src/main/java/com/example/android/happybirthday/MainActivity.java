package com.example.android.happybirthday;

import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Menu navigationMenu;
    private Toolbar mToolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        //Setting the drawer layout with the action bar toggle
        mDrawerLayout.addDrawerListener(mToggle);
        //Allows the drawer layout to interact with the toggle button
        mToggle.syncState();
        //sets up the menu icon and the back button icon on the app
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_menu_layout);

        //This NavigationView, placed inside the parent View (Drawer layout), is placed at the
        //"back" of the xml ie z-order = 1. Click events will not register until the view is
        // brought to the front eg z-order = 5.
        navigationView.bringToFront();
        navigationMenu  =  navigationView.getMenu();


        final MenuItem menu_item = navigationMenu.findItem(R.id.happy);
        menu_item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(menu_item.isChecked()) menu_item.setChecked(false);
                else menu_item.setChecked(true);
                mDrawerLayout.closeDrawers();
                Toast.makeText(getApplicationContext(), menu_item+" clicked",
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });

//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = item.getItemId();
//
//
//                switch (item.getItemId()) {
//                    case R.id.happy:
//                        if(item.isChecked())item.setChecked(false);
//                        else item.setChecked(true);
//                        //closes the drawer layout after an item has been clicked
//                        mDrawerLayout.closeDrawers();
//                        Toast.makeText(getApplicationContext(), item.getTitle()+" clicked",
//                            Toast.LENGTH_SHORT).show();
//                        return true;
//                    case R.id.birthday:
//                        if(item.isChecked())item.setChecked(false);
//                        else item.setChecked(true);
//                        mDrawerLayout.closeDrawers();
//                        Toast.makeText(getApplicationContext(), item.getTitle()+" clicked",
//                            Toast.LENGTH_SHORT).show();
//                        return true;
//                    case R.id.dear:
//                        if(item.isChecked())item.setChecked(false);
//                        else item.setChecked(true);
//                        mDrawerLayout.closeDrawers();
//                        Toast.makeText(getApplicationContext(), item.getTitle()+" clicked",
//                            Toast.LENGTH_SHORT).show();
//                        return true;
//                    case R.id.joan:
//                        if(item.isChecked())item.setChecked(false);
//                        else item.setChecked(true);
//                        mDrawerLayout.closeDrawers();
//                        Toast.makeText(getApplicationContext(), item.getTitle()+" clicked",
//                            Toast.LENGTH_SHORT).show();
//                        return true;
//                }
//                return true;
//            }
//        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            //Any item clicked will not do anything here
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
