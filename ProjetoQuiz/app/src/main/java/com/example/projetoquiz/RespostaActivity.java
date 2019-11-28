package com.example.projetoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RespostaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);
        getSupportActionBar().hide();

        ImageView imgResposta = (ImageView)findViewById(R.id.imgResposta);
        TextView resposta = (TextView)findViewById(R.id.resposta);
        Button btnMenu = (Button)findViewById(R.id.btnMenu);
        TextView txtNome = (TextView)findViewById(R.id.txtNome);
        Button btnSalvar = (Button)findViewById(R.id.btnSalvar);

        Intent intent = getIntent();
        Integer pontos = intent.getIntExtra("pontos", 0);

        if(intent.hasExtra("acertou")) {
            txtNome.setVisibility(View.INVISIBLE);
            btnSalvar.setVisibility(View.INVISIBLE);
            btnMenu.setVisibility(View.INVISIBLE);
            boolean acertou = intent.getBooleanExtra("acertou", false);
            if (acertou) {
                imgResposta.setImageResource(R.drawable.acertou);
                resposta.setText("Acertou!");
            } else {
                imgResposta.setImageResource(R.drawable.errou);
                resposta.setText("Errou!");
            }

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                }
            });
            thread.start();
        }
        else{
            txtNome.setVisibility(View.VISIBLE);
            btnSalvar.setVisibility(View.VISIBLE);
            btnMenu.setVisibility(View.VISIBLE);
            resposta.setText("Fez " + pontos + " pontos!");


            if(pontos >= 3)
                imgResposta.setImageResource(R.drawable.happy);
            else
                imgResposta.setImageResource(R.drawable.sad);
        }

    }

    public void salvarRanking(View v) {
        Intent intent = getIntent();
        Integer pontos = intent.getIntExtra("pontos", 0);

        EditText txtRanking = findViewById(R.id.txtNome);

        if (txtRanking.getText().toString().equals("")) {

            Toast.makeText(this, "Preencha o seu Nome!", Toast.LENGTH_SHORT).show();

        } else {

            SharedPreferences po = getSharedPreferences("point", MODE_PRIVATE);
            po.edit().putString("point", pontos.toString().valueOf(pontos)).apply();
            SharedPreferences sh = getSharedPreferences("ranking", MODE_PRIVATE);
            sh.edit().putString("ranking", txtRanking.getText().toString()).apply();

            Toast.makeText(this, "Salvo!", Toast.LENGTH_SHORT).show();
            txtRanking.setText("");

        }
    }

    public void btnMenu(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}