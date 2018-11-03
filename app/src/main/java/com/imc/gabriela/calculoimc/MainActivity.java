package com.imc.gabriela.calculoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private float imc = 0;
    private Button  btnCalcular;
    private EditText edtPeso,edtAltura;
    private TextView txtValorResult;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        edtPeso = (EditText) findViewById(R.id.edtPeso);
        edtAltura = (EditText) findViewById(R.id.edtAltura);
        txtValorResult = (TextView) findViewById(R.id.txtValorResul);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int peso = Integer.parseInt(edtPeso.getText().toString());
                float altura = Float.parseFloat(edtAltura.getText().toString());

                imc = peso / (altura * altura);
                txtValorResult.setText(imc+"");
                if (imc < 18.5) {
                    Toast.makeText(getApplicationContext(), "Baixo",Toast.LENGTH_SHORT).show();
                } else {
                    if (imc < 25) {
                        Toast.makeText(getApplicationContext(), "Normal",Toast.LENGTH_SHORT).show();
                    } else {
                        if (imc < 30) {
                            Toast.makeText(getApplicationContext(), "Sobrepreso",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Obesidade",Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            }
         });
    }
}