package com.example.basic1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Phone(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+"0930811606"));
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    1);
        } else {
            try {
                startActivity(intent);
            } catch(SecurityException e) {
                e.printStackTrace();
            }
        }
    }

    public void Map(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:47.4925,19.0513"));
        startActivity(intent);
    }

    public void Chrome(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com.tw"));
        startActivity(intent);
    }
}