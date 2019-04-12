package com.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnCalculate;
    private EditText etSalary;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalculate = findViewById(R.id.btnCalculate);
        etSalary= findViewById(R.id.etSalary);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalculate){
            if (validate()){
                Tax_Bikram tax = new Tax_Bikram();
                tax.setSalary(Double.parseDouble(etSalary.getText().toString()));
                Double taxAmount = tax.getTaxAmount();
                tvResult.setText(Double.toString(taxAmount));
            }
        }
    }
    public Boolean validate(){
        boolean validation = true;
        if (TextUtils.isEmpty(etSalary.getText().toString())){
            etSalary.setError("Please enter the salary");
            etSalary.requestFocus();
            validation = false;
        }
        return validation;
    }
}