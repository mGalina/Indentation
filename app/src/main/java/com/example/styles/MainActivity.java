package com.example.styles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        Button ok = findViewById(R.id.bt_ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinnerLanguage = findViewById(R.id.sp_language);
                String selected1 = spinnerLanguage.getSelectedItem().toString();

                Spinner spinnerColor = findViewById(R.id.sp_colors);
                String selected2 = spinnerColor.getSelectedItem().toString();

                switch (selected1) {
                    case "Russian":
                    case "Русский":
                        switchLocale("ru");
                        break;
                    case "English":
                    case "Английский":
                        switchLocale("en");
                        break;
                }

                switch (selected2) {
                    case "Major theme":
                    case "Крупная тема":
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_MAJOR);
                        break;
                    case "Middle theme":
                    case "Средняя тема":
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_MIDDLE);
                        break;
                    case "Minor theme":
                    case "Мелкая тема":
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_MINOR);
                        break;
                }
            }
        });
    }

    private void switchLocale(String language) {
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }
}