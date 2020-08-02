package ro.upb.etti.stud.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import ro.upb.etti.stud.firstproject.Carti_package.Carti_rezultat;

public class Hobby_rezultat extends AppCompatActivity {

    TextView hobby_text_id;
    ImageView hobby_image_id;
    Button hobby_btn_retry, hobby_btn_home, hobby_btn_carti;

    public static final String FILE_NAME = "score.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby_result);

        // Initializam butoanele, textul, imaginea
        hobby_text_id = (TextView) findViewById(R.id.hobby_text_id);
        hobby_image_id = (ImageView) findViewById(R.id.hobby_image_id);
        hobby_btn_home = (Button) findViewById(R.id.hobby_btn_home);
        hobby_btn_retry = (Button) findViewById(R.id.hobby_btn_retry);
        hobby_btn_carti = (Button) findViewById(R.id.hobby_btn_carti);

        // Transferam scorul din activitatea trecuta (Hobby.java)
        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");

        // Afisare hobby_text si hobby_imagine in functie de score
        if (score >= 7 && score < 9) {
            hobby_text_id.setText("Pictatul!");
            hobby_image_id.setImageResource(R.drawable.pictat);
        }else if (score >= 9 && score < 11) {
            hobby_text_id.setText("Jocurile video!");
            hobby_image_id.setImageResource(R.drawable.jocvideo);
        }else if (score >= 11 && score < 13 ) {
            hobby_text_id.setText("Fotografiatul!");
            hobby_image_id.setImageResource(R.drawable.fotografiat);
        }else if (score >= 13 && score < 15 ) {
            hobby_text_id.setText("Alergatul!");
            hobby_image_id.setImageResource(R.drawable.alergat);
        }else if (score >= 15 && score < 17 ) {
            hobby_text_id.setText("Mersul pe role!");
            hobby_image_id.setImageResource(R.drawable.role);
        }else if (score >= 17 && score < 19 ) {
            hobby_text_id.setText("Ciclismul!");
            hobby_image_id.setImageResource(R.drawable.biciclet);
        }else if (score >= 19 && score < 21 ) {
            hobby_text_id.setText("Meditatia!");
            hobby_image_id.setImageResource(R.drawable.meditatie);
        }else if (score >= 21 && score < 23 ) {
            hobby_text_id.setText("Gatitul!");
            hobby_image_id.setImageResource(R.drawable.gatit);
        }else if (score >= 23 && score < 26 ) {
            hobby_text_id.setText("Gradinaritul!");
            hobby_image_id.setImageResource(R.drawable.gradinarit);
        }else if (score >= 26 && score <= 28 ) {
            hobby_text_id.setText("Pescuitul!");
            hobby_image_id.setImageResource(R.drawable.pescuit);
        }

        //Salveaza score intr-un fisier text
        FileOutputStream fos = null;
        try {
            String score_string = Integer.toString(score); //Convertesc int -> String pentru a putea scrie in fisier
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(score_string.getBytes()); // scrierea se face doar prin scrierea bytes-lor Stringului text..

        } catch (FileNotFoundException e) {
            e.printStackTrace(); // output pentru exceptie: numele fisierului si nr liniei la care a fost aruncata exceptia + cauza
        } catch (IOException e) { //Signals that an I/O exception of some sort has occurred. (failed or interrupted I/O operation)
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //Butoanele
        hobby_btn_retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Hobby_rezultat.this, Hobby.class));
                Hobby_rezultat.this.finish();
            }
        });

        hobby_btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hobby_rezultat.this, MainActivity.class));
                Hobby_rezultat.this.finish();
            }
        });

        hobby_btn_carti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hobby_rezultat.this, Carti_rezultat.class));
                Hobby_rezultat.this.finish();
            }
        });
    }
}
