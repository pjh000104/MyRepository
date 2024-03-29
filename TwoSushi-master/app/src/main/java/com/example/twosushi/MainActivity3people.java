package com.example.twosushi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity3people extends AppCompatActivity {
    private static final String TAG = "MyActivity3people";
    private EditText etTotalPrice1;
    private EditText etItem1Person1;
    private EditText etItem1Person2;
    private EditText etItem1Person3;
    private TextView tvPerson1CurrentAmount;
    private TextView tvPerson2CurrentAmount;
    private TextView tvPerson3CurrentAmount;
    private TextView tvPerson1TotalAmount;
    private TextView tvPerson2TotalAmountl;
    private TextView tvPerson3TotalAmount;
    private Button btAdd;
    private Button btReset;
    private Double Person1Total = 0.0;
    private Double Person2Total = 0.0;
    private Double Person3Total = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3people);
        etTotalPrice1 = findViewById(R.id.etTotalPrice1);
        etItem1Person1 = findViewById(R.id.etItem1Person1);
        etItem1Person2 = findViewById(R.id.etItem1Person2);
        etItem1Person3 = findViewById(R.id.etItem1Person3);
        tvPerson1CurrentAmount = findViewById(R.id.tvPerson1CurrentAmount);
        tvPerson2CurrentAmount = findViewById(R.id.tvPerson2CurrentAmount);
        tvPerson3CurrentAmount = findViewById(R.id.tvPerson3CurrentAmount);
        tvPerson1TotalAmount = findViewById(R.id.tvPerson1TotalAmount);
        tvPerson2TotalAmountl = findViewById(R.id.tvPerson2TotalAmount);
        tvPerson3TotalAmount = findViewById(R.id.tvPerson3TotalAmount);
        btAdd = findViewById(R.id.btAdd);
        btReset = findViewById(R.id.btReset);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            //tells user to enter numbers in blank space
            public void onClick(View view) {
                if(etTotalPrice1.getText().toString().matches("")) {
                    Toast myToast = Toast.makeText(MainActivity3people.this, "Enter Item1! ", Toast.LENGTH_SHORT);
                    myToast.show();
                    return;
                }
                if(etItem1Person1.getText().toString().matches("") ||
                        etItem1Person2.getText().toString().matches("") ||
                            etItem1Person3.getText().toString().matches("")) {
                    Toast myToast = Toast.makeText(MainActivity3people.this, "Enter Amount! ", Toast.LENGTH_SHORT);
                    myToast.show();
                    return;
                }
                //Adds current amount to total amount and resets all the values except the total amount
                Person1Total += Double.parseDouble(tvPerson1CurrentAmount.getText().toString());
                Person2Total += Double.parseDouble(tvPerson2CurrentAmount.getText().toString());
                Person3Total += Double.parseDouble(tvPerson3CurrentAmount.getText().toString());
                tvPerson1TotalAmount.setText(Person1Total.toString());
                tvPerson2TotalAmountl.setText(Person2Total.toString());
                tvPerson3TotalAmount.setText(Person3Total.toString());
                etTotalPrice1.setText(null);
                etItem1Person1.setText(null);
                etItem1Person2.setText(null);
                etItem1Person3.setText(null);
                tvPerson1CurrentAmount.setText("0");
                tvPerson2CurrentAmount.setText("0");
                tvPerson3CurrentAmount.setText("0");
                Toast myToast = Toast.makeText(MainActivity3people.this, "Added to total Amount!", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

        //resets everything
        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvPerson1TotalAmount.setText("0");
                tvPerson2TotalAmountl.setText("0");
                tvPerson3TotalAmount.setText("0");
            }

        });

        etTotalPrice1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i(TAG, "afterTextChanged: " + s);
                calculatePrice();
            }
        });

        etItem1Person1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i(TAG, "afterTextChanged: " + s);
                calculatePrice();
            }
        });

        etItem1Person2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i(TAG, "afterTextChanged: " + s);
                calculatePrice();
            }
        });

        etItem1Person3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i(TAG, "afterTextChanged: " + s);
                calculatePrice();
            }
        });
    }

    //Calculates the current amount for each person.
        public void calculatePrice() {
        if(etTotalPrice1.getText().toString().matches("")) {
            tvPerson1CurrentAmount.setText(" ");
            tvPerson2CurrentAmount.setText(" ");
            tvPerson3CurrentAmount.setText(" ");
            return;
        }

        int person1Amount = 1;
        int person2Amount = 1;
        int person3Amount = 1;

        if(etItem1Person1.getText().toString().matches("")) {
            person1Amount = 0;
        }
        if(etItem1Person2.getText().toString().matches("")) {
            person2Amount = 0;
        }
        if(etItem1Person3.getText().toString().matches("")) {
            person3Amount = 0;
        }

        if(person1Amount == 0 && person2Amount == 0 && person3Amount == 0) {
            tvPerson1CurrentAmount.setText("0");
            tvPerson2CurrentAmount.setText("0");
            tvPerson3CurrentAmount.setText("0");
            return;
        }

        else {
            double totalAmount = Double.parseDouble(etTotalPrice1.getText().toString());
            if (person1Amount != 0) {
                person1Amount = Integer.parseInt(etItem1Person1.getText().toString());
            }
            if (person2Amount != 0) {
                person2Amount = Integer.parseInt(etItem1Person2.getText().toString());
            }
            if (person3Amount != 0) {
                person3Amount = Integer.parseInt(etItem1Person2.getText().toString());
            }
            int numItem = person1Amount + person2Amount + person3Amount;
            tvPerson1CurrentAmount.setText(String.format("%.2f", totalAmount / numItem * person1Amount));
            tvPerson2CurrentAmount.setText(String.format("%.2f", totalAmount / numItem * person2Amount));
            tvPerson3CurrentAmount.setText(String.format("%.2f", totalAmount / numItem * person3Amount));
        }

    }
}