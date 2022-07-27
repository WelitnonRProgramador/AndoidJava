package com.example.conversordemoeda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editQuantidadeMoeda;
    private EditText editContacaoMoeda;
    private TextView textResultado;
    private TextView moedaOnline;
    private TextView qualMoeda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editQuantidadeMoeda = findViewById(R.id.editQuantidadeMoeda);
        editContacaoMoeda   = findViewById(R.id.editContacaoMoeda);
        textResultado       = findViewById(R.id.textResultado);
        moedaOnline         = findViewById(R.id.moedaOnline);
        qualMoeda           = findViewById(R.id.qualMoeda);

        qualMoeda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Tarefa tarefa = new Tarefa();
               tarefa.execute("https://economia.awesomeapi.com.br/last/USD-BRL,EUR-BRL,BTC-BRL");
            }
        });
    }



    public void converter(View view){

        double quantidadeMoeda = Double.parseDouble(editQuantidadeMoeda.getText().toString());
        double cotacaoMoeda    = Double.parseDouble(editContacaoMoeda.getText().toString());
        double resultado       = quantidadeMoeda * cotacaoMoeda;

        textResultado.setText("Valor Convertido em R$: "+resultado);
    }



    private class Tarefa extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            String retorno = conexao.getDados(strings[0]);

            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {
            moedaOnline.setText(s);
        }
    }
}