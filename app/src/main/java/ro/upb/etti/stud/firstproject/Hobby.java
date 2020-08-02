package ro.upb.etti.stud.firstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Hobby extends AppCompatActivity {
    //Declar obiectele buton pentru a prelua raspunsurile la intrebari
    Button answer1, answer2, answer3, answer4;
    TextView question_number, question;

    private Hobby_intrebari mQuestions = new Hobby_intrebari();
    private String mAnswer;

    private int mScore = 0;
    private int mQuestionsLength = mQuestions.mQuestions.length; //dimensiune=numar de intrebari in total
    private int mQuestion_index = 0;

    private void updateQuestion() {
        question.setText(mQuestions.getQuestion(mQuestion_index));
        answer1.setText(mQuestions.getChoice1(mQuestion_index));
        answer2.setText(mQuestions.getChoice2(mQuestion_index));
        answer3.setText(mQuestions.getChoice3(mQuestion_index));
        answer4.setText(mQuestions.getChoice4(mQuestion_index));
        question_number.setText("Intrebarea " + (mQuestion_index+1) + " din " + mQuestionsLength + ":");
        mQuestion_index++;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //buton de intoarcere <- din toolbar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby);

        // Definesc obiectele folosind findViewdById
        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);
        question_number = (TextView) findViewById(R.id.question_number);
        question = (TextView) findViewById(R.id.question);

        // Afisam textul si raspunsurile primei intrebari
        updateQuestion();

        /* Actualizam textul urmatoarei intrebari de fiecare data cand raspundem la intrebarea curenta
           Fiecare raspuns va aduna un numar, iar rezultatul se va afisa in functie de plaja numerelor */
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScore = mScore + 1;
                //Verificam daca suntem la ultima intrebare astfel incat sa primim rezultatul pritn-o noua activitate (altfel aplicatia va da crash)
                if(mQuestion_index == mQuestionsLength) {
                    Intent i = new Intent(Hobby.this, Hobby_rezultat.class);

                    //Trimitem variabila cu scorul catre activitatea Hobby_rezultate
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScore);
                    i.putExtras(bundle);

                    Hobby.this.finish();
                    startActivity(i);
                }
                else {
                    updateQuestion();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScore = mScore + 2;
                //Verificam daca suntem la ultima intrebare astfel incat sa primim rezultatul (altfel aplicatia va da crash)
                if(mQuestion_index == mQuestionsLength) {
                    Intent i = new Intent(Hobby.this, Hobby_rezultat.class);

                    //Transferam variabila cu scorul catre activitatea Hobby_rezultate
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScore);
                    i.putExtras(bundle);

                    Hobby.this.finish();
                    startActivity(i);
                }
                else {
                    updateQuestion();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScore = mScore + 3;
                //Verificam daca suntem la ultima intrebare astfel incat sa primim rezultatul (altfel aplicatia va da crash)
                if(mQuestion_index == mQuestionsLength) {
                    Intent i = new Intent(Hobby.this, Hobby_rezultat.class);
                    //Trimitem variabila cu scorul catre activitatea Hobby_rezultate
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScore);
                    i.putExtras(bundle);

                    Hobby.this.finish();
                    startActivity(i);
                }
                else {
                    updateQuestion();
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScore = mScore + 4;
                //Verificam daca suntem la ultima intrebare astfel incat sa primim rezultatul (altfel aplicatia va da crash)
                if(mQuestion_index == mQuestionsLength) {
                    Intent i = new Intent(Hobby.this, Hobby_rezultat.class);
                    //Trimitem variabila cu scorul catre activitatea Hobby_rezultate
                    Bundle bundle = new Bundle();
                    bundle.putInt("finalScore", mScore);
                    i.putExtras(bundle);

                    Hobby.this.finish();
                    startActivity(i);
                }
                else {
                    updateQuestion();
                }
            }
        });
    }

}
