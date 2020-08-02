package ro.upb.etti.stud.firstproject.Organizator_package;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ro.upb.etti.stud.firstproject.R;

public class Organizator extends AppCompatActivity {

    private static final String TAG = "Organizator";
    private Organizator_DbHelper mHelper;
    private ListView mTaskListView; //Obiectul View din interfata XML
    private ArrayAdapter<String> mAdapter; //returneaza un obiect View pentru fiecare obiect din colectia de date (ListView)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //buton de intoarcere <- din toolbar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizator);

        mHelper = new Organizator_DbHelper(this);
        mTaskListView = (ListView) findViewById(R.id.id_list_todo);

        updateUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu); //inflate a menu hierarchy from the specified XML resource
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            //creem set de actiuni atunci cand se apasa butonul + de adaugare task
            case R.id.action_add_task:
                final EditText taskEditText = new EditText(this); //obiect EditText pentru a prelua textul din campul in care scriem task
                AlertDialog dialog = new AlertDialog.Builder(this) //la apasarea butonului + va aparea o fereastra tip alerta dialog:
                        .setTitle("Task-uri")
                        .setMessage("Adaugati un nou task:")
                        .setView(taskEditText)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {

                            @Override //fereastra dialog va afisa un buton "Adauga" pe care il configuram:
                            public void onClick(DialogInterface dialogue, int which) {
                                String task = String.valueOf(taskEditText.getText()); //preluam textul din campul task-ului
                                SQLiteDatabase db = mHelper.getWritableDatabase(); /*Se deschide baza de date, aceasta ramane in memoria cache
                                                                                    se pregateste scriere in baza de date*/
                                ContentValues values = new ContentValues(); /*obiectul ContentValues este utilizat pentru a stoca
                                                                              un set de valori pe care ContentResolver le poate procesa.*/
                                values.put(Organizator_Task.TaskEntry.COL_TASK_TITLE, task); //adauga valoare catre setul de valori
                                db.insertWithOnConflict(Organizator_Task.TaskEntry.TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);
                                db.close();
                                updateUI();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateUI() {
        ArrayList<String> taskList = new ArrayList<>();
        SQLiteDatabase db = mHelper.getReadableDatabase(); /*Se deschide baza de date, aceasta ramane in memoria cache
                                                         se pregateste citirea in baza de date*/

        Cursor cursor = db.query(Organizator_Task.TaskEntry.TABLE, //Cursor interface provides random read-write access to the result set returned by a database query.
                new String[] {Organizator_Task.TaskEntry.COL_TASK_TITLE}, null, null, null, null, null);
                //SQLiteDatabase.query returneaza un Cursor pentru fiecare rand din tabela

        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex(Organizator_Task.TaskEntry.COL_TASK_TITLE);
            taskList.add(cursor.getString(index)); //preluam index-ul cursorului si il adaugam in ArrayList declarat anterior
        }

        if (mAdapter == null) { /*Daca nu exista niciun Obiect View in ListView, definim un ArrayAdapter
                            returneaza un obiect View pentru fiecare obiect din colectia de date (ListView din XML)*/
            mAdapter = new ArrayAdapter<String>(this, R.layout.activity_organizator_task, R.id.id_task_title, taskList);
            mTaskListView.setAdapter(mAdapter);

        } else {
            mAdapter.clear();
            mAdapter.addAll(taskList); //Stergem si adaugam toate obiectele (randurile) din colectia de date (ListView din XML)
            mAdapter.notifyDataSetChanged();
        }

        cursor.close();
        db.close();
    }

    public void deleteTask(View view) {
        View parent = (View) view.getParent();
        TextView taskTextView = (TextView) parent.findViewById(R.id.id_task_title);
        String task = String.valueOf(taskTextView.getText());
        SQLiteDatabase db = mHelper.getWritableDatabase();
        db.delete(Organizator_Task.TaskEntry.TABLE, Organizator_Task.TaskEntry.COL_TASK_TITLE + " = ?", new String[] {task});
        db.close();
        updateUI();

    }
}
