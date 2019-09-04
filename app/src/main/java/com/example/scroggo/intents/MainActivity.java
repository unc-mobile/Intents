package com.example.scroggo.intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");

        ImageView img = (ImageView) findViewById(R.id.imageView);
        img.setImageBitmap(imageBitmap);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.button2) {
            Intent intent = new Intent(this, Receiver.class);
            startActivity(intent);
        } else if (view.getId() == R.id.button) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 1);
        }
    }
}
