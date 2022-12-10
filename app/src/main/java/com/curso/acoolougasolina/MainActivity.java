package com.curso.acoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private Button calcular;
   private EditText alcool,gasolina;
   private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcular = findViewById(R.id.butcalcular);
        gasolina = findViewById(R.id.editgasolina);
        alcool   = findViewById(R.id.editalcool);
        resultado= findViewById(R.id.textView2);

        //recuperando numeros
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringalcool = alcool.getText().toString();
                String stringgasolina = gasolina.getText().toString();

               Boolean res = validarcampo(stringalcool,stringgasolina);
               if (res){
                Double valoralcool = Double.parseDouble(stringalcool);
                Double valorgasolina = Double.parseDouble(stringgasolina);

                Double resul = valorgasolina / valoralcool;
                if (resul >= 0.7){
                    resultado.setText("Melhor utilizar gasolina");
                }else{
                    resultado.setText("Melhor utilizar alcool");
                }

               }else{
                   resultado.setText("Preencha os campos primeiro");
               }


            }
        });
}
        public boolean validarcampo(String precoalcool,String precogasolina){

        Boolean validado = true;

        if (precoalcool == null || precoalcool.equals("")){
            validado = false;
        } else if (precogasolina == null || precogasolina.equals("")){
            validado = false;
        }
        return validado;


        }

}