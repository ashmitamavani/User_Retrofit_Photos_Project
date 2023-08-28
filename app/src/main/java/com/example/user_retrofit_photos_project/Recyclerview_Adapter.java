package com.example.user_retrofit_photos_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recyclerview_Adapter extends RecyclerView.Adapter<Recyclerview_Adapter.Holder> {

    MainActivity mainActivity;
    ArrayList<Model_Class> productList;
    public Recyclerview_Adapter(MainActivity mainActivity, ArrayList<Model_Class> productList) {
        this.mainActivity=mainActivity;
        this.productList=productList;
    }

    @NonNull
    @Override
    public Recyclerview_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mainActivity).inflate(R.layout.recyclerview_item_file,parent,false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerview_Adapter.Holder holder, int position) {
        holder.t1.setText(""+productList.get(position).getId());
        holder.t2.setText(""+productList.get(position).getTitle());
        holder.t3.setText(""+productList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3;
        public Holder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.t1);
            t2=itemView.findViewById(R.id.t2);
            t3=itemView.findViewById(R.id.t3);
        }
    }
}
