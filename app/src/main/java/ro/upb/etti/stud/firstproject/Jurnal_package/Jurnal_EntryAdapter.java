package ro.upb.etti.stud.firstproject.Jurnal_package;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ro.upb.etti.stud.firstproject.R;

public class Jurnal_EntryAdapter extends RecyclerView.Adapter<Jurnal_EntryAdapter.MyViewHolder> {

    Context context; //context of current state of the application/object
                    // Typically you call it to get information regarding another part of your program (activity and package/application).
    ArrayList<Jurnal_MyEntries> myEntries;

    public Jurnal_EntryAdapter(Context c, ArrayList<Jurnal_MyEntries> p) {
        context = c;
        myEntries = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_jurnal_item_entries, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.titleentry.setText(myEntries.get(i).getTitleentry());
        myViewHolder.descentry.setText(myEntries.get(i).getDescentry());
        myViewHolder.dateentry.setText(myEntries.get(i).getDateentry());

        final String getTitleEntry = myEntries.get(i).getTitleentry();
        final String getDescEntry = myEntries.get(i).getDescentry();
        final String getDateEntry = myEntries.get(i).getDateentry();
        final String getKeyEntry = myEntries.get(i).getKeyentry();

        // fiecare card cu intrarea in jurnal poate fi apasat/click, la apasarea unui card dintre ele se va deschide o noua activitate
        // (Jurnal_edit) la care transmitem si informatiile cu campurile deja completate
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() { //pentru editarea unei intrari -> creem metoda OnClickListener pentru a apasa pe o intrare:
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Jurnal_Edit.class);
                i.putExtra("titleentry", getTitleEntry); //Transferam continutul celulelor (subiect, descriere, data intrarii) in activitatea de editare (Jurnal_edit)
                i.putExtra("descentry", getDescEntry);
                i.putExtra("dateentry", getDateEntry);
                i.putExtra("keyentry", getKeyEntry);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myEntries.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleentry, descentry, dateentry;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleentry = (TextView) itemView.findViewById(R.id.titleentry);
            descentry = (TextView) itemView.findViewById(R.id.descentry);
            dateentry = (TextView) itemView.findViewById(R.id.dateentry);
        }
    }
}
