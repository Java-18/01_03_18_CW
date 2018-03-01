package com.sheygam.java_18_01_03_18;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultTxt;
    private EditText inputName;
    private Button saveBtn, loadBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTxt = findViewById(R.id.result_txt);
        inputName = findViewById(R.id.input_name);
        saveBtn = findViewById(R.id.save_btn);
        loadBtn = findViewById(R.id.load_btn);

        saveBtn.setOnClickListener(this);
        loadBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.save_btn){
            save();
        }else if(v.getId() == R.id.load_btn){
            load();
        }
    }

    private void load() {
        SharedPreferences sharedPreferences = getSharedPreferences("MY_STORE",MODE_PRIVATE);
        String name = sharedPreferences.getString("NAME","");
        resultTxt.setText(name);
    }

    private void save() {
        String name = inputName.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("MY_STORE",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME",name);
        editor.commit();

    }

    @Override
    protected void onDestroy() {
        Log.d("MY_TAG", "onDestroy: ");
        super.onDestroy();
    }
}
