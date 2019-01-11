package com.sashrika.notepadfragmentsapp5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Calendar;

public class FragmentsB extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b,container,false);
    }
    ArrayList<Notes> list = new ArrayList<>();
    NotesAdapter adapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        Intent i = getActivity().getIntent();
        String s = i.getDataString();
        Notes note = new Notes(s);
        note.setTime(Calendar.getInstance().getTime().toString());
        list.add(note);

        adapter = new NotesAdapter(list,getContext());
        RecyclerView rv = view.findViewById(R.id.recyclerViewB);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
        adapter.notifyItemInserted(adapter.getItemCount()-1);
    }

}
