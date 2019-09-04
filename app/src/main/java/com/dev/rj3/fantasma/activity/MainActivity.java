package com.dev.rj3.fantasma.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.provider.FontRequest;
import androidx.emoji.text.EmojiCompat;
import androidx.emoji.text.FontRequestEmojiCompatConfig;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.dev.rj3.fantasma.R;
import com.dev.rj3.fantasma.fragments.AccountFragment;
import com.dev.rj3.fantasma.fragments.MessagesFragment;
import com.dev.rj3.fantasma.fragments.PostsFragment;
import com.dev.rj3.fantasma.fragments.SearchFragment;
import com.dev.rj3.fantasma.fragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpEmojiSupport();
        setContentView(R.layout.activity_main);

        currentFragment = new PostsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, currentFragment).commit();

        BottomNavigationView bottomNav = findViewById(R.id.navBar);

        bottomNav.setOnNavigationItemSelectedListener(navListener);
        bottomNav.setOnNavigationItemReselectedListener(reselectedListener);


    }

    private void setUpEmojiSupport() {
        FontRequest fontRequest = new FontRequest(
                "com.google.android.gms.fonts",
                "com.google.android.gms",
                "Noto Color Emoji Compat",
                R.array.com_google_android_gms_fonts_certs
        );

        EmojiCompat.Config config = new FontRequestEmojiCompatConfig(this, fontRequest);
        EmojiCompat.init(config);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = menu -> {


        // Fragment fragment = null;
        switch (menu.getItemId()) {
            case R.id.nav_posts:
                currentFragment = new PostsFragment();
                break;
            case R.id.nav_account:
                currentFragment = new AccountFragment();
                break;
            case R.id.nav_search:
                currentFragment = new SearchFragment();
                break;
            case R.id.nav_settings:
                currentFragment = new SettingsFragment();
                break;
            case R.id.nav_messages:
                currentFragment = new MessagesFragment();
                break;

        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, currentFragment).commit();
        return true;

    };


    private BottomNavigationView.OnNavigationItemReselectedListener reselectedListener = menu -> {

    };

}