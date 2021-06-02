package br.com.example.appjogoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNumero = findViewById(R.id.etNumero);
        etNumero.setGravity(Gravity.CENTER);

        EditText etTentativa = findViewById(R.id.etTentativa);
        etTentativa.setGravity(Gravity.CENTER);
        etTentativa.setInputType(View.LAYER_TYPE_NONE);

        Button btnTentar = findViewById(R.id.btnTentar);

        //Gerar numero aleatorio de 1 a 100
        int numeroGerado = (int) ((Math.random() * 100) + 1);

        //Ação no botão de tentativa de acerto
//        btnTentar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                jogar(etNumero, etTentativa, numeroGerado);
//            }
//        });

        btnTentar.setOnClickListener(v -> jogar(etNumero, etTentativa, numeroGerado));
    }

    private void jogar(EditText etNumero, EditText etTentativa, int numeroGerado) {
        String num = etNumero.getText().toString();
        int numeroDigitado = Integer.parseInt(num);

        if (numeroDigitado > numeroGerado) {
            etTentativa.setText("O número é inferior a "+numeroDigitado);
        }
        if (numeroDigitado < numeroGerado) {
            etTentativa.setText("O número é superior a "+numeroDigitado);
        }
        if (numeroDigitado == numeroGerado) {
            vitoria(numeroGerado);
        }
        etNumero.setText("");
    }

    private void vitoria(int numeroGerado) {
        Bundle bundle = new Bundle();
        bundle.putInt("numeroGerado", numeroGerado);

        Intent intent = new Intent(this, RetornoActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();
    }
}