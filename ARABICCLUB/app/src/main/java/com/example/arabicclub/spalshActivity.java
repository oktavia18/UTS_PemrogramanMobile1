package com.example.aplikasiarabicclub;

import androidx.appcompat.app.AppCompatActivity;

public class SplasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.SplasActivity);

        MaterialButton btnGetStarted = findViewById(R.id.btnGetStarted);
        btnGetStarted.setOnClickListener(v -> {
            startActivity(new Intent(SplasActivity.this, com.example.aplikasiarabicclub.MainActivity.class));
            finish();
        });
    }
}