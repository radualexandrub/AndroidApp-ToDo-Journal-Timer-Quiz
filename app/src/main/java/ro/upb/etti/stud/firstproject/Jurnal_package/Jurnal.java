package ro.upb.etti.stud.firstproject.Jurnal_package;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import ro.upb.etti.stud.firstproject.R;


public class Jurnal extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView ourentries; //lista cu scrolling elements based on large data sets that frequently changes
    ArrayList<Jurnal_MyEntries> list;
    Jurnal_EntryAdapter entryAdapter;
    Button btnAddNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //buton de intoarcere <- din toolbar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jurnal);

        FirebaseApp.initializeApp(this); //Creates and initializes a Firebase app instance.

        btnAddNew = findViewById(R.id.btnAddNew);  //buton de adaugare noua intrare in jurnal (butonul '+' din activity_jurnal)
        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Jurnal.this, Jurnal_New.class);
                startActivity(a);
            }
        });

        //lucru cu datele din baza de date:
        ourentries = findViewById(R.id.ourentries);
        ourentries.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Jurnal_MyEntries>();

        //get data from firebase (primeste datele)
        reference = FirebaseDatabase.getInstance().getReference().child("FirstProject");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Code to retrieve data and replace layout
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Jurnal_MyEntries p = dataSnapshot1.getValue(Jurnal_MyEntries.class);
                    list.add(p);
                }
                entryAdapter = new Jurnal_EntryAdapter(Jurnal.this, list);
                ourentries.setAdapter(entryAdapter);
                entryAdapter.notifyDataSetChanged();
            }

            @Override //if the data has been cancelled => set code
            public void onCancelled(DatabaseError databaseError) {
                //Code to show an error
                Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
