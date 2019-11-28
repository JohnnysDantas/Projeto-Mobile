package com.example.projetoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {


    static Random random = new Random();
    static int x = random.nextInt(5);
    static int contador = x;
    TextView pergunta;
    RadioButton rbResposta1, rbResposta2, rbResposta3, rbResposta4;
    int respostaCerta = R.id.rbResposta1;
    RadioGroup rgRespostas;
    int pontos = 0;

    List<Questao> questoes = new ArrayList<Questao>(){
        {
            add(new Questao("Quem descobriu o Brasil?", R.id.rbResposta1, "Pedro Álvares Cabral", "Cristóvão Colombo", "Donald Trump", "xurupita"));
            add(new Questao("Normalmente, quantos litros de sangue uma pessoa tem?", R.id.rbResposta2, "2 a 4 litros", "4 a 6 litros", "7 litros ", "10 litros"));
            add(new Questao("De onde é a invenção do chuveiro elétrico?", R.id.rbResposta3, "França", "Inglaterra", "Brasil", "Itália"));
            add(new Questao("Normalmente, quantos litros de sangue uma pessoa tem?",R.id.rbResposta1, "Tem entre 4 a 6 litros.","Tem entre 2 a 4 litros.","Tem 10 litros.","Tem 7 litros."));
            add(new Questao("De quem é a famosa frase Penso, logo existo?" ,R.id.rbResposta3,"Platão","Galileu Galilei","Descartes","Sócrates"));
            add(new Questao("Qual o menor país do mundo?",R.id.rbResposta2, "Nauru","Vaticano","Mônaco","Malta"));
            add(new Questao("Qual o maior país do mundo?" ,R.id.rbResposta4, "China","Canadá","Estados Unidos","Russia"));
            add(new Questao("Qual o nome do presidente do Brasil que ficou conhecido como Jango?", R.id.rbResposta4, "Jânio Quadros","Getúlio Vargas","João Figueiredo","João Goulart"));
            add(new Questao("Atualmente, quantos elementos químicos a tabela periódica possui?" ,R.id.rbResposta3, "111","115","118","108"));
            add(new Questao("O que a palavra legend significa em português?",R.id.rbResposta3, "Legenda","História","Lenda","Legendário"));
            add(new Questao("Quais as duas datas que são comemoradas em novembro?" ,R.id.rbResposta2, "Independência do Brasil e Dia da Bandeira","Proclamação da República e Dia Nacional da Consciência Negra","Dia do Médico e Dia de São Lucas","Dia de Finados e Dia Nacional do Livro"));
            add(new Questao("Em que período da pré-história o fogo foi descoberto?" ,R.id.rbResposta1, "Paleolítico","Neolítico","Idade dos Metais","Idade Média"));
            add(new Questao("Qual a montanha mais alta do Brasil?" ,R.id.rbResposta1, "Pico da Neblina","Pico Paraná","Monte Roraima","Pico da Bandeira"));
            add(new Questao("Que horas são em inglês? It is six twenty\" ou \"twenty past six\".", R.id.rbResposta2 , "12:06","6:20","6:02","12:20"));
            add(new Questao("Qual destes países é transcontinental?" ,R.id.rbResposta3,"Filipinas","Groenlândia","Rússia","Tanzânia"));
            add(new Questao("Quem foi o primeiro homem a pisar na Lua?", R.id.rbResposta4, "Yuri Gagarin","Buzz Aldrin","Charles Conrad","Neils Armstrong"));
            add(new Questao("As pessoas de qual tipo sanguíneo são consideradas doadores universais?", R.id.rbResposta2, "Tipo A","Tipo B","Tipo O","Tipo AB"));
            add(new Questao("Qual é o maior oceano do mundo?", R.id.rbResposta1, "Oceano Pacífico","Oceano Atlântico","Oceano Ártico","Oceano Índico"));
            add(new Questao("Qual é o menor númnero primo?", R.id.rbResposta3, "0","1","2","3"));
            add(new Questao("Qual operação contrária a potenciação?" ,R.id.rbResposta2, "Adição","Radiciação","Subtração","Divisão"));
            add(new Questao("O Brasil foi colônia de qual país?" ,R.id.rbResposta4, "Itália","Inglaterra","Espanha","Portugal"));
            add(new Questao("Qual destes países NÃO se localiza na América do Sul?", R.id.rbResposta3,"Bolívia","Guiana","Angola","Suriname"));
            add(new Questao("Comer é um:" ,R.id.rbResposta1, "Verbo","Adjetivo","Pronome","Subjetivo"));
            add(new Questao("Qual o pintor produziu a obra Monalisa?" ,R.id.rbResposta2, "Vicent Van Gogh","Leonardo da Vinci","Seven Screw","Cândido do Amaral"));
            add(new Questao("A palavra Angry em português equivale à?", R.id.rbResposta3, "Alegria","Fome","Raiva","Medo"));
            add(new Questao("O ser humano pertence a qual reino?" ,R.id.rbResposta4, "Fungi","Monera","Plantae","Animalia"));
            add(new Questao("Quantos estados há no Brasil?" ,R.id.rbResposta4, "24","25","26","27"));
            add(new Questao("Onde é produzido o suco gástrico usado na digestão do nosso corpo?" ,R.id.rbResposta4, "Fígado","Pâncreas","Esôfago","Estômago"));
            add(new Questao("Um ângulo de 90° é considerado uma ângulo:", R.id.rbResposta3, "Agudo","Raso","Reto","Obtuso"));
            add(new Questao("Onde fica Machu Picchu, também chamada cidade perdida dos Incas?" ,R.id.rbResposta1, "Peru","Bolívia","Equador","Chile"));
            add(new Questao("Qual o maior planeta do sistema solar?", R.id.rbResposta3, "Mercúrio","Netuno","Júpiter","Urano"));
            add(new Questao("Em que país se localizava Auschwitz, o maior campo de concentração nazista?", R.id.rbResposta2,"Japão","Polônia","Itália","Alemanha"));
            add(new Questao("Qual o número é representado pelos números romanos XL?" ,R.id.rbResposta1, "40","15","60","90"));
            add(new Questao("Qual é o segundo maior país da América do Sul?", R.id.rbResposta3, "Chile","Peru","Argentina","Uruguai"));
            add(new Questao("Qual o menor planeta do sistema solar?" ,R.id.rbResposta1, "Mercúrio","Netuno","Júpiter","Urano"));
            add(new Questao("Qual o nome da princesa que assinou a Lei que acabou a escravidão, dos negros, no Brasil?" ,R.id.rbResposta4, "Princesa Vitória","Princesa Leopoldina","Princesa Diana","Princesa Isabel"));
            add(new Questao("Quais são os países fundadores do Mercosul?" ,R.id.rbResposta1, "Brasil, Argentina, Uruguai e Paraguai","Brasil, Bolívia, Venezuela","Argentina, Peru e Bolívia","Brasil, Argentina, Chile e Colômbia"));
            add(new Questao("Quanto é um quarto de 1.000.000?" ,R.id.rbResposta2, "25.000","250.000","300.000","2.500"));
            add(new Questao("Quanto é o segundo menor número primo, ×7?", R.id.rbResposta3, "14","28","21","35"));
            add(new Questao("No corpo humano, quem é que produz a saliva?" ,R.id.rbResposta4,"Organetos salivares","Tecidos salivares","Papas salivares","Glândulas salivares"));



        }
    };

    private void carregarQuestao(int fff){
            rgRespostas.clearCheck();

            if (questoes.size() > 35) {
                    Questao q = questoes.remove(fff);
                    pergunta.setText(q.getPergunta());
                    List<String> resposta = q.getRespostas();
                    rbResposta1.setText(resposta.get(0));
                    rbResposta2.setText(resposta.get(1));
                    rbResposta3.setText(resposta.get(2));
                    rbResposta4.setText(resposta.get(3));
                    respostaCerta = q.getRespostaCerta();
                    contador++;
                }
            else { //acabaram as questões
                Intent intent = new Intent(this, RespostaActivity.class);
                intent.putExtra("pontos", pontos);
                startActivity(intent);
                finish();

            }
        }






        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().hide();

        pergunta = (TextView)findViewById(R.id.pergunta);
        rbResposta1 = (RadioButton)findViewById(R.id.rbResposta1);
        rbResposta2 = (RadioButton)findViewById(R.id.rbResposta2);
        rbResposta3 = (RadioButton)findViewById(R.id.rbResposta3);
        rbResposta4 = (RadioButton)findViewById(R.id.rbResposta4);
        rgRespostas = (RadioGroup)findViewById(R.id.rgRespostas);

        carregarQuestao(contador);
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        carregarQuestao(contador);
    }

    public void btnResponderOnClick(View v) {
        RadioGroup rg = (RadioGroup) findViewById(R.id.rgRespostas);
        RadioButton rb = (RadioButton) findViewById(rgRespostas.getCheckedRadioButtonId());
        Intent intent = new Intent(this, RespostaActivity.class);


            if (rgRespostas.getCheckedRadioButtonId() == respostaCerta) {
                intent.putExtra("acertou", true);
                intent.putExtra("pontos", pontos);
                pontos++;
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Resposta errada/não selecionada!", Toast.LENGTH_SHORT).show();
                intent.putExtra("acertou", false);
                intent.putExtra("pontos", pontos);
                startActivity(intent);
            }
        }
    }

