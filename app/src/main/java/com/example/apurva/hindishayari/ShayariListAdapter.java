package com.example.apurva.hindishayari;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ShayariListAdapter extends RecyclerView.Adapter<ShayariListAdapter.ShayariListViewHolder>{

    private String[] data;
    public ShayariListAdapter(String[] data){
        this.data=data;
    }
    @Override
    public ShayariListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_item,parent,false);

        return new ShayariListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShayariListViewHolder holder, int position) {
        holder.txtTitle.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ShayariListViewHolder extends RecyclerView.ViewHolder{

        TextView txtTitle;
        public ShayariListViewHolder(View itemView) {
            super(itemView);
            txtTitle=itemView.findViewById(R.id.shayari_item);
        }
    }
}
