package com.sashrika.notepadfragmentsapp5;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class FragmentsA extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,container,false);
    }

    EditText et;
    Button bt;
    Notes note;
    ArrayList<Notes> list = new ArrayList<>();
    NotesAdapter adapter;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         bt = view.findViewById(R.id.button);
         et = view.findViewById(R.id.ettext);

         bt.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String s = et.getText().toString();
                 note.setMessage(s);
                 String t = Calendar.getInstance().getTime().toString();
                 note.setTime(t);
                 list.add(note);
                adapter.notifyItemInserted(adapter.getItemCount()-1);
             }
         });
        adapter = new NotesAdapter(list,getContext());
        RecyclerView rv = view.findViewById(R.id.recyclerViewA);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
    }
}
