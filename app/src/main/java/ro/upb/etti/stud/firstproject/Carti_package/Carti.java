package ro.upb.etti.stud.firstproject.Carti_package;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import ro.upb.etti.stud.firstproject.R;

public class Carti extends AppCompatActivity implements View.OnClickListener{

    private CardView Carti_rezultat;
    private CardView Carti_afisare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //buton de intoarcere <- din toolbar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carti);

        //definesc obiectele Card
        Carti_rezultat = (CardView) findViewById(R.id.id_carti_rezultat);
        Carti_rezultat.setOnClickListener(this);
        Carti_afisare = (CardView) findViewById(R.id.id_carti_afisare);
        Carti_afisare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) { //testam de fiecare data ce card a fost apasat(click)
            case R.id.id_carti_rezultat:
                i = new Intent(this, ro.upb.etti.stud.firstproject.Carti_package.Carti_rezultat.class);
                startActivity(i); break;
            case R.id.id_carti_afisare:
                i = new Intent(this, ro.upb.etti.stud.firstproject.Carti_package.Carti_afisare.class);
                startActivity(i); break;
            default: break;
        }
    }
}
