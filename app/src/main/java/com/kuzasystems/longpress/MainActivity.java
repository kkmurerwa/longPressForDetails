package com.kuzasystems.longpress;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {
    final String imageUrl = "https://cdn.pixabay.com/photo/2018/08/14/13/23/ocean-3605547_960_720.jpg";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomDialogLongPress customDialogLongPress = new CustomDialogLongPress(this, imageUrl);

        // Code to display custom dialog when the user long presses the image view
        ImageView imageView = findViewById(R.id.imageView);

        fetchImageToDisplayWithGlide(imageView);


        imageView.setOnLongClickListener(v -> {
            customDialogLongPress.show();
            return false;
        });

        // Add code to watch for when the user releases the touch event
        imageView.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                customDialogLongPress.dismiss();
            }
            return false;
        });
    }

    private void fetchImageToDisplayWithGlide(ImageView imageView) {
        RequestOptions requestOptions = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground);

        Glide.with(this)
                .load(imageUrl)
                .apply(requestOptions)
                .fitCenter()
                .into(imageView);
    }
}