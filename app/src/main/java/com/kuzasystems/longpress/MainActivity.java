package com.kuzasystems.longpress;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomDialogLongPress customDialogLongPress = new CustomDialogLongPress(this);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnLongClickListener(v -> {
            customDialogLongPress.show();
            return false;
        });

        imageView.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
//                Toast.makeText(this, "Released", Toast.LENGTH_SHORT).show();
                customDialogLongPress.dismiss();
            }
            return false;
        });
    }
}