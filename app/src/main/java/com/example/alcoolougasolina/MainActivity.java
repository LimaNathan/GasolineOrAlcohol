package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText alcoholPrice, gasPrice;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        alcoholPrice = findViewById(R.id.alcoholPrice);
        gasPrice = findViewById(R.id.gasPrice);
        textResult = findViewById(R.id.textResult);
    }

    public void calculatePrice(View view) {

        //recuperar valores digitados
        String priceAlcohol = alcoholPrice.getText().toString();
        String priceGas = gasPrice.getText().toString();

        //Validar os campos digitados

        Boolean validatedFields = validate(priceAlcohol, priceGas);
        if (validatedFields) {

//            Convertendo string para numeros

            Double valueAlcohol = Double.parseDouble(priceAlcohol);
            Double valueGas = Double.parseDouble(priceGas);

            Double result = valueAlcohol / valueGas;
            if (result >= 0.7) {
                textResult.setText("E melhor utilizar gasolina");
            } else {
                textResult.setText("E melhor utilizar alcool");
            }

        } else {
            textResult.setText("Preencha os preços primeiro!");
        }
    }

    public Boolean validate(String pAlcohol, String pGas) {

        Boolean validatedFields = true;

        if (pAlcohol == null || pAlcohol.equals("")) {
            validatedFields = false;
        } else if (pGas == null || pGas.equals("")) {
            validatedFields = false;

        }
        return validatedFields;

    }
}