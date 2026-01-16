package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    Button addButton;
    Button deleteButton;
    Button confirmButton;
    LinearLayout textConfirm;
    EditText cityName;


    private void addCity() {
        textConfirm.setVisibility(View.VISIBLE);
    }

    private void confirmCity() {
        String city = cityName.getText().toString().trim();
        dataList.add(city);
        cityAdapter.notifyDataSetChanged();
        textConfirm.setVisibility(View.INVISIBLE);
        cityName.setText("");
    }

    private void deleteCity() {
        int position = cityList.getCheckedItemPosition();
        dataList.remove(position);
        cityAdapter.notifyDataSetChanged();
    }

    private void initializeButtons() {
         addButton = findViewById(R.id.btn_add);
         deleteButton = findViewById(R.id.btn_delete);
         confirmButton = findViewById(R.id.confirm);

         addButton.setOnClickListener(v -> addCity());
         deleteButton.setOnClickListener(v -> deleteCity());
         confirmButton.setOnClickListener(v -> confirmCity());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textConfirm = findViewById(R.id.text_confirm);
        cityName = findViewById(R.id.city_name);
        initializeButtons();

        cityList = findViewById(R.id.city_list);
        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

    }
}