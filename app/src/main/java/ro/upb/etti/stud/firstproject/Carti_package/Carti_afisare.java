package ro.upb.etti.stud.firstproject.Carti_package;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ro.upb.etti.stud.firstproject.R;

public class Carti_afisare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //buton de intoarcere <- din toolbar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carti_afisare);

    }
}
