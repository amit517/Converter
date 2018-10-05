package com.example.amitkundu.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Temperature extends AppCompatActivity {

    EditText mInput;
    RadioButton mRd1,mRd2;
    Button mConvert;
    String Output;
    double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        mInput = (EditText) findViewById(R.id.editInput);
        mRd1 = (RadioButton) findViewById(R.id.r1);
        mRd2= (RadioButton) findViewById(R.id.r2);
        mConvert = (Button) findViewById(R.id.b1);

        mConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double value = new Double(mInput.getText().toString());


                if (mRd1.isChecked())
                {


                    result = new Double(TemperatureCalculate.ftoc(value));
                    Output = String.format("%.2f", result);


                    mInput.setText(Output+" °C");
                }

                else
                {
                    result = new Double(TemperatureCalculate.ctof(value));
                    Output = String.format("%.2f", result);
                    mInput.setText(Output+" °F");
                }
            }
        });
    }
}
