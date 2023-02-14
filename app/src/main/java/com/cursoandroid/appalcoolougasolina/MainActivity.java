package com.cursoandroid.appalcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view) {

        // recuperar os dados digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //valiadar os campos digitados
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        if (camposValidados) {
            // convertendo string para numeros
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            /*
             * Fazer o calculo de menor preço
             * Se(valorAlcool / valorGasolina)>=0.7 é melhor utilizar gasolina
             *   senão é melhor utilizar álcool
             */
            Double res = valorAlcool / valorGasolina;

            if (res >= 0.7) {
                textResultado.setText("E melhor usar Gasolina!");
            } else {
                textResultado.setText("E melhor usar Álcool!");
            }

        } else {
            textResultado.setText("Preencha os preços primeiro!");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina) {
        Boolean camposValidados = true;
        if (pAlcool.equals("") || pAlcool == null) {
            camposValidados = false;
        } else if (pGasolina.equals("") || pGasolina == null) {
            camposValidados = false;
        }
        return camposValidados;
    }

}