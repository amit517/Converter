package com.example.amitkundu.converter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.MessageFormat;
import java.util.Currency;
import java.util.List;

import vas.com.currencyconverter.CurrencyConverter;

public class currency extends AppCompatActivity {
    Spinner mSpinner;
    EditText mEditText;
    Button mButton;
    TextView mResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        mEditText = (EditText) findViewById(R.id.currencyEntry);
        mSpinner = (Spinner) findViewById(R.id.currency_spinner);
        mButton = (Button) findViewById(R.id.result);
        mResult = (TextView) findViewById(R.id.show);


        final ArrayAdapter<Currency> List =
                new ArrayAdapter<Currency>(this, android.R.layout.simple_spinner_item, CurrencyConverter.getCurrencyList()) {
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        return getV(position, convertView, parent);
                    }

                    @Override
                    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        return getV(position, convertView, parent);
                    }

                    View getV(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        TextView view = (TextView) super.getView(position, convertView, parent);
                        Currency currency = getItem(position);
                        if (currency != null)
                            view.setText(MessageFormat.format("{0} ({1})",
                                    currency.getCurrencyCode(), CurrencyConverter.getCurrencyLocale(currency).get(0).getDisplayCountry()));
                        return view;
                    }
                };

        mSpinner.setSelection(List.getPosition(Currency.getInstance("BRL")));


        mSpinner.setAdapter(List);



        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String from = "USD";
                final String to = mSpinner.getSelectedItem().toString();
                if (mEditText.getText().toString().length() > 0) {
                    double value = Double.parseDouble(mEditText.getText().toString());
                    CurrencyConverter.calculate(value, from, to, new CurrencyConverter.Callback() {
                        @Override
                        public void onValueCalculated(Double value, Exception e) {
                            if (e != null) {
                                mResult.setText(e.getMessage());
                                CurrencyConverter.reset();
                            } else {
                                // Do someting with value.
                                mResult.setText(CurrencyConverter.formatCurrencyValue(to, value));
                                CurrencyConverter.reset();
                            }
                        }
                    });
                }
            }
        });




    }
}
