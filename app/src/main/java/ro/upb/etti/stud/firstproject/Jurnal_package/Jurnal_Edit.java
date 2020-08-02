package ro.upb.etti.stud.firstproject.Jurnal_package;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ro.upb.etti.stud.firstproject.R;

public class Jurnal_Edit extends AppCompatActivity {

    //declar obiectele cu care putem interactiona din interfata xml
    EditText id_edittitle, id_editdate, id_editdesc;
    Button btnDelete, btnCancel;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //buton de intoarcere <- din toolbar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jurnal_edit);

        //initiez obiectele cu care putem interactiona din interfata xml
        id_edittitle = (EditText) findViewById(R.id.id_edittitle);
        id_editdate = (EditText) findViewById(R.id.id_editdate);
        id_editdesc = (EditText) findViewById(R.id.id_editdesc);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        //preia si afiseaza valorile campurilor (subiect, descriere, data) din intrarea pe care am apasat (din EntryAdapter)
        id_edittitle.setText(getIntent().getStringExtra("titleentry"));
        id_editdate.setText(getIntent().getStringExtra("dateentry"));
        id_editdesc.setText(getIntent().getStringExtra("descentry"));

        final String keyEntry_transferat = getIntent().getStringExtra("keyentry").replaceAll(" ","");

        // creem actiunea de a sterge din jurnal
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference = FirebaseDatabase.getInstance().getReference().child("FirstProject").
                        child("Entry" + keyEntry_transferat);
                reference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Intent a = new Intent(Jurnal_Edit.this, Jurnal.class);
                            startActivity(a);
                        } else {
                            Toast.makeText(getApplicationContext(),"Nu s-a putut efectua stergerea",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Jurnal_Edit.this, Jurnal.class);
                startActivity(a);
            }
        });
    }
}
