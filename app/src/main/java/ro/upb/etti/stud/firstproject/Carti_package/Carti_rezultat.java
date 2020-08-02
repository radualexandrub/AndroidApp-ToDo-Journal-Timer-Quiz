package ro.upb.etti.stud.firstproject.Carti_package;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import ro.upb.etti.stud.firstproject.Hobby_rezultat;
import ro.upb.etti.stud.firstproject.R;

public class Carti_rezultat extends AppCompatActivity {

    TextView id_hobby, id_titlu, id_descriere;
    ImageView id_imagine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //buton de intoarcere <- din toolbar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carti_rezultat);

        id_hobby = (TextView) findViewById(R.id.id_hobby);
        id_titlu = (TextView) findViewById(R.id.id_titlu);
        id_descriere = (TextView) findViewById(R.id.id_descriere);
        id_imagine = (ImageView) findViewById(R.id.id_imagine);

        // Incarcare Score dintr-un fisier text
        FileInputStream fis = null;
        try {
            fis = openFileInput(Hobby_rezultat.FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder score_stringbuilder = new StringBuilder();
            String text;
            while((text = br.readLine()) != null){
                score_stringbuilder.append(text).append("\n");
            }

            // Afisare carte_text si carte_imagine in functie de score
            String score_string = score_stringbuilder.toString().replaceAll("\n",""); //convertesc StringBuilder -> String
            Integer score = Integer.parseInt(score_string);  //convertesc String -> int
            if (score >= 7 && score < 9) {
                id_hobby.setText("Pictat");
                id_titlu.setText("Mastering Composition");
                id_descriere.setText("This effective guide blends clear, visual instruction with 5 step-by-step demonstrations to show you how to plan and paint your best work yet.");
                id_imagine.setImageResource(R.drawable.carte_pictat);
            }else if (score >= 9 && score < 11) {
                id_hobby.setText("Jocuri video");
                id_titlu.setText("Blood, Sweat, and Pixels");
                id_descriere.setText("Developing video games: The creative and technical logistics that go into building today's hottest games can be more harrowing and complex than the games themselves.");
                id_imagine.setImageResource(R.drawable.carte_jocuri);
            }else if (score >= 11 && score < 13 ) {
                id_hobby.setText("Fotografiat");
                id_titlu.setText("Stunning Digital Photography");
                id_descriere.setText("Stunning Digital Photography is much more than a book; it’s a hands-on, self-paced photography class with over 14 hours of online training videos. ");
                id_imagine.setImageResource(R.drawable.carte_fotografiat);
            }else if (score >= 13 && score < 15 ) {
                id_hobby.setText("Alergare");
                id_titlu.setText("Bigger Leaner Stronger");
                id_descriere.setText("Building muscle and burning fat isn't as complicated as the fitness industry wants you to believe. This book is the shortcut.");
                id_imagine.setImageResource(R.drawable.carte_sport);
            }else if (score >= 15 && score < 17 ) {
                id_hobby.setText("Mers pe role");
                id_titlu.setText("Bigger Leaner Stronger");
                id_descriere.setText("Building muscle and burning fat isn't as complicated as the fitness industry wants you to believe. This book is the shortcut.");
                id_imagine.setImageResource(R.drawable.carte_sport);
            }else if (score >= 17 && score < 19 ) {
                id_hobby.setText("Ciclism");
                id_titlu.setText("The Secret Race");
                id_descriere.setText("The Secret Race is a definitive look at the world of professional cycling—and the doping issue surrounding this sport.");
                id_imagine.setImageResource(R.drawable.carte_ciclism);
            }else if (score >= 19 && score < 21 ) {
                id_hobby.setText("Meditatie");
                id_titlu.setText("The Power of Now");
                id_descriere.setText("To make the journey into The Power of Now we will need to leave our analytical mind and its false created self, the ego, behind.");
                id_imagine.setImageResource(R.drawable.carte_meditatie);
            }else if (score >= 21 && score < 23 ) {
                id_hobby.setText("Gatit");
                id_titlu.setText("Joy of cooking");
                id_descriere.setText("The book gives the most beloved recipes from past editions and includes quick, healthy recipes for the way we cook today. ");
                id_imagine.setImageResource(R.drawable.carte_gatit);
            }else if (score >= 23 && score < 26 ) {
                id_hobby.setText("Gradinarit");
                id_titlu.setText("All New Square Foot Gardening");
                id_descriere.setText("Square Foot Gardening is the most practical, foolproof way to grow a home garden, whether you're growing an urban garden, or have an entire backyard.");
                id_imagine.setImageResource(R.drawable.carte_gradinarit);
            }else if (score >= 26 && score <= 28 ) {
                id_hobby.setText("Pescuit");
                id_titlu.setText("Basic Fishing");
                id_descriere.setText("New to fishing and have no idea how to start? With Basic Fishing, you’ll be an accomplished angler in no time at all. ");
                id_imagine.setImageResource(R.drawable.carte_pescuit);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
