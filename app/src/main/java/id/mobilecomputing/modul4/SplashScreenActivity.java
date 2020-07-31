package id.mobilecomputing.modul4;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent( SplashScreenActivity.this, ImplisitIntentActivity.class));
                finish();
            }
        }, 2000);
    }
}