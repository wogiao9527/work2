package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class Myadapter extends RecyclerView.Adapter<Myadapter.Myholder> {
    Context context1;
    List<String> list1;

    public Myadapter(Context context, List list) {
        context1 = context;
        list1 = list;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context1).inflate(R.layout.item, parent, false);

        Myholder holder = new Myholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.textView.setText(list1.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListening!=null){
                    onItemClickListening.onClickItem(list1);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return list1.size();
    }

    public static class Myholder extends RecyclerView.ViewHolder {
        TextView textView;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item);
        }
    }
    private OnItemClickListening onItemClickListening;
    public interface OnItemClickListening{
        void onClickItem(List<String> list1);
    }
    void setOnItemClickListening(OnItemClickListening myonItemClickListening){
        onItemClickListening=myonItemClickListening;
    }
}