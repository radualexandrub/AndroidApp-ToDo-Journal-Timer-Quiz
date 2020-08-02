package ro.upb.etti.stud.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import ro.upb.etti.stud.firstproject.Carti_package.Carti;
import ro.upb.etti.stud.firstproject.Jurnal_package.Jurnal;
import ro.upb.etti.stud.firstproject.Organizator_package.Organizator;
import ro.upb.etti.stud.firstproject.Productivitate_package.Productivitate;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //Declar 5 obiecte cardview - PENTRU BUTOANELE/ACTIVITATILE MENIULUI PRINCIPAL CU CARE URMEAZA SA INTERACTIONEZ
    private CardView OrganizCard, JurnalCard, ProdCard, CartiCard, HobbyCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //AICI initializez obiectele Card si le setez metoda OnClickListener !
        OrganizCard = (CardView) findViewById(R.id.idOrganizator);
        JurnalCard = (CardView) findViewById(R.id.idJurnal);
        ProdCard = (CardView) findViewById(R.id.idProductivitate);
        CartiCard = (CardView) findViewById(R.id.idCarti);
        HobbyCard = (CardView) findViewById(R.id.idHobby);
        //adaug metoda click listener la fiecare din carduri:
        OrganizCard.setOnClickListener(this);
        JurnalCard.setOnClickListener(this);
        ProdCard.setOnClickListener(this);
        CartiCard.setOnClickListener(this);
        HobbyCard.setOnClickListener(this);
    }

    //PORNIRE ACTIVITATI (butoanele din meniu) de fiecare data cand apasam:
    //suprascriu metoda onClick
    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) { //testam de fiecare data ce card a fost apasat(click)
            case R.id.idOrganizator:
                i = new Intent(this, Organizator.class);
                startActivity(i); break;
            case R.id.idJurnal :
                i = new Intent(this, Jurnal.class);
                startActivity(i); break;
            case R.id.idProductivitate :
                i = new Intent(this, Productivitate.class);
                startActivity(i); break;
            case R.id.idCarti :
                i = new Intent(this, Carti.class);
                startActivity(i); break;
            case R.id.idHobby :
                i = new Intent(this, Hobby.class);
                startActivity(i); break;
            default: break;
        }
    }
}
