package com.example.projetoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.StringTokenizer;

public class RankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        SharedPreferences po = getSharedPreferences("point", MODE_PRIVATE);
        SharedPreferences sh = getSharedPreferences("ranking", MODE_PRIVATE);
        TextView lblRanking = findViewById(R.id.lblNomeJogador);
        TextView lblPontos = findViewById(R.id.lblPontosJogador);

        String nome = sh.getString("ranking", "teste");
        String ponto = po.getString("point", "0");

        lblRanking.setText(nome);
        lblPontos.setText(ponto);
    }

    public void btnMenu(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
