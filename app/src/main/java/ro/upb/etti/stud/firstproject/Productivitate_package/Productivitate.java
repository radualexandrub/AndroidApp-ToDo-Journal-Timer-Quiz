package ro.upb.etti.stud.firstproject.Productivitate_package;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import ro.upb.etti.stud.firstproject.R;

public class Productivitate extends AppCompatActivity implements View.OnClickListener{
    private CardView PomodoroCard;//creez obiectul Pomodoro, pentru a ma duce in fereastra activitatea Pomodoro

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //buton de intoarcere <- din toolbar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productivitate);

        //definesc obiectele Card
        PomodoroCard = (CardView) findViewById(R.id.idPomodoro);
        //adaug metoda click listener la fiecare din carduri:
        PomodoroCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) { //testam de fiecare data ce card a fost apasat(click)
            case R.id.idPomodoro:
                i = new Intent(this, Pomodoro.class);
                startActivity(i); break;
            default: break;
        }
    }
}
