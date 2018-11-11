package com.example.petar.lab_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExplicitActivity extends AppCompatActivity {


    private Button okBtn, cancelBtn;
    private EditText dataEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);

        okBtn = (Button) findViewById(R.id.okBtn);
        cancelBtn = (Button) findViewById(R.id.cancelBtn);
        dataEditText = (EditText) findViewById(R.id.dataEditText);

    }

    public void okBtnClick(View view) {
        Intent result = new Intent();

        result.putExtra("data", dataEditText.getText().toString());
        setResult(RESULT_OK, result);
        finish();
    }

    public void cancelBtnClick (View view)
    {
        setResult(RESULT_CANCELED);
        finish();
    }
}
