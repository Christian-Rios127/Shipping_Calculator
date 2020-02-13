package edu.miracosta.cs134.shippingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import edu.miracosta.cs134.shippingcalculator.model.Bill;

public class MainActivity extends AppCompatActivity {
    //public int ;
    private Bill currentBill;

    private TextView totalCostTextView;
    private EditText weightEditText;
    private TextView baseCostTextView;
    private TextView addedCostTextView;
    private double weight;
    private double baseCost;
    private double addedCost;

    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //currentBill = new Bill();
        weightEditText = findViewById(R.id.weightEditText);
        baseCostTextView = findViewById(R.id.baseCostTextView);
        totalCostTextView = findViewById(R.id.totalCostTextView);
        addedCostTextView = findViewById(R.id.addedCostTextView);

        //wired them up currency get the number format format as currency set text for the 3 text view for the Corresponding cost

        //baseCostTextView.setText(""+currency.format(3.00));

        //math.ceil();

        weightEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String text = weightEditText.getText().toString();
                if (text.isEmpty()){
                    text = "0";
                }

                weight = Double.parseDouble(text);
                baseCost = Double.parseDouble(baseCostTextView.getText().toString().substring(1));

                if(weight <= 16){
                    addedCost = 0;
                }
                else {
                    addedCost = ((weight - 16)/4) * 0.5;



                    //addedCost = ((weight - 16 / 4) * 0.5);
                    //when 4 ounces is added 0.50 20

                }
                addedCostTextView.setText(currency.format(addedCost));
                totalCostTextView.setText(currency.format(baseCost + addedCost));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });





    }
    /*public void calcuateBill(){
        //update the tipTextView & totalTextView
        baseCostTextView.setText(currency.format(currentBill.getAmount()));
        totalCostEditText.setText(currency.format(currentBill.getTotalAmount()));
        addedCostTextView.setText(currency.format(currentBill.getAmount()));
    }*/
}
