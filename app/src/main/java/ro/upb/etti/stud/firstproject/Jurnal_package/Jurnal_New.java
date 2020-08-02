package ro.upb.etti.stud.firstproject.Jurnal_package;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

import ro.upb.etti.stud.firstproject.R;

public class Jurnal_New extends AppCompatActivity {

    EditText edittitle, editdesc, editdate;
    Button btnSaveEntry, btnCancelEntry;
    DatabaseReference reference;
    Integer entryNum = new Random().nextInt(); //folosim un numar random drept ID al fiecarui task.
    String keyentry = Integer.toString(entryNum);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //buton de intoarcere <- din toolbar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jurnal_newentry);

        edittitle = findViewById(R.id.id_edittitle);
        editdesc = findViewById(R.id.id_editdesc);
        editdate = findViewById(R.id.id_editdate);

        btnSaveEntry = findViewById(R.id.btnSaveEntry);
        btnCancelEntry = findViewById(R.id.btnCancelEntry);

        btnSaveEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //inserare data in baza de date Firebase
                if(!edittitle.getText().toString().matches("") &&
                        !editdate.getText().toString().matches("") &&
                        !editdesc.getText().toString().matches("")) {

                    reference = FirebaseDatabase.getInstance().getReference().child("FirstProject").
                            child("Entry" + entryNum); //creem un subdirectoriu (child directory)+numarul ID
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            dataSnapshot.getRef().child("titleentry").setValue(edittitle.getText().toString());
                            dataSnapshot.getRef().child("descentry").setValue(editdesc.getText().toString());
                            dataSnapshot.getRef().child("dateentry").setValue(editdate.getText().toString());
                            dataSnapshot.getRef().child("keyentry").setValue(keyentry);

                            Intent a = new Intent(Jurnal_New.this,Jurnal.class);
                            startActivity(a);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });

                } else {
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, "Completati toate campurile", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        btnCancelEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Jurnal_New.this, Jurnal.class);
                startActivity(i);
            }
        });
    }
}
