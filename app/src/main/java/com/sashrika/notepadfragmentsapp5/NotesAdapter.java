package com.sashrika.notepadfragmentsapp5;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.Holder> {

    private ArrayList<Notes> list;
    private Context context;

    public NotesAdapter(ArrayList<Notes> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View inflatedView = li.inflate(R.layout.item_row,parent,false);

        return new Holder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        Notes current = list.get(position);
        holder.TextHolder.setText(current.getMessage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView TextHolder;
        FrameLayout fl;

        public Holder(@NonNull final View itemView) {
            super(itemView);
            TextHolder = itemView.findViewById(R.id.tvName);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    LinearLayout ll = itemView.findViewById(R.id.linear);
//                    Notes notes = list.get(getAdapterPosition());
//                    ll.setBackgroundColor(view.getContext().getColor(R.color.green));
//                }
//            });
//            itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View view) {
//
//                    Notes s = list.get(getAdapterPosition());
//                    list.remove(getAdapterPosition());  //Alternate way to get the current position
//                    list.add(s);
//
//                    notifyItemRemoved(getAdapterPosition());
//                    return false;
//                }
//            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Notes s = list.get(getAdapterPosition());
                    list.remove(getAdapterPosition());
                    Intent i = new Intent(context,FragmentsB.class);
                    i.putExtra("mynote",s.getMessage());
                    context.startActivity(i);
                }
            });
        }
    }
}
