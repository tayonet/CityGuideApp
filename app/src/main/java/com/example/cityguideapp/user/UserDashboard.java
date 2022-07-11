package com.example.cityguideapp.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cityguideapp.R;
import com.example.cityguideapp.helperClasses.HomeAdapter.CategoryAdapter;
import com.example.cityguideapp.helperClasses.HomeAdapter.CategoryHelperClass;
import com.example.cityguideapp.helperClasses.HomeAdapter.FeaturedAdapter;
import com.example.cityguideapp.helperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.cityguideapp.helperClasses.HomeAdapter.MostViewedAdapter;
import com.example.cityguideapp.helperClasses.HomeAdapter.MostViewedClass;
import com.google.android.material.navigation.NavigationView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView featuredRecycler, mostviewed_recycler, category_recycler;
    RecyclerView.Adapter adapter, adapter2, adapter3;
    ImageView menuIcon;

    // variables

    static final float END_SCALE = 0.7f;
    // Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    LinearLayout contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        // hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostviewed_recycler = findViewById(R.id.mostviewed_recycler);
        category_recycler = findViewById(R.id.category_recycler);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);


        // Menu hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);


        navigationDrawerToggle();


        featuredRecyclerMethod();
        mostViewedRecyclerMethod();
        categoryRecyclerMethod();
    }


    private void navigationDrawerToggle() {
        // Navigation drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.card4));

       drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
           @Override
           public void onDrawerSlide(View drawerView, float slideOffset) {
               super.onDrawerSlide(drawerView, slideOffset);
               // scale the view based on current slide offset
               final float diffScaledOffset = slideOffset * (1 - END_SCALE);
               final float offsetScale = 1- diffScaledOffset;
               contentView.setScaleX(offsetScale);
               contentView.setScaleY(offsetScale);

               // translate the view, accounting for the scaled width
               final float xOffset = drawerView.getWidth() * slideOffset;
               final float xOffsetDiff = contentView.getWidth() * diffScaledOffset /2;
               final float xTranslation = xOffset - xOffsetDiff;
               contentView.setTranslationX(xTranslation);
           }
       });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }


    private void featuredRecyclerMethod() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.bg1, "High Way", "Lorem Ipsum dummy text from Lorem Ipsum"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.bg2, "Nice Environ", "Lorem Ipsum dummy text from Lorem Ipsum"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.landocean, "Beautiful Greece", "Lorem Ipsum dummy text from Lorem Ipsum"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);


    }

    private void mostViewedRecyclerMethod() {
        mostviewed_recycler.setHasFixedSize(true);
        mostviewed_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedClass(R.drawable.bridge2, "Nice Bridge", "lorem ipsum tirum desum curem nista ba"));
        mostViewedLocations.add(new MostViewedClass(R.drawable.mansion, "Nice Mansion", "lorem ipsum tirum desum curem nista ba"));
        mostViewedLocations.add(new MostViewedClass(R.drawable.statueliberty, "Statue of Liberty", "lorem ipsum tirum desum curem nista ba"));

        adapter2 = new MostViewedAdapter(mostViewedLocations);
        mostviewed_recycler.setAdapter(adapter2);

    }

    private void categoryRecyclerMethod() {
        category_recycler.setHasFixedSize(true);
        category_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<CategoryHelperClass> categoryLocations = new ArrayList<>();
        categoryLocations.add(new CategoryHelperClass(R.drawable.park, "Amazing Park View"));
        categoryLocations.add(new CategoryHelperClass(R.drawable.city, "Nice City View"));
        categoryLocations.add(new CategoryHelperClass(R.drawable.landocean, "Land on Ocean"));

        adapter3 = new CategoryAdapter(categoryLocations);
        category_recycler.setAdapter(adapter3);
    }


}