package com.example.senthil.dirver1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.senthil.dirver1.Activty.DRSList;
import com.example.senthil.dirver1.Activty.DeliveryUpdate;
import com.example.senthil.dirver1.Activty.PickupList;
import com.example.senthil.dirver1.Activty.PickupUpdate;
import com.example.senthil.dirver1.Pojo.DRSListData;
import com.example.senthil.dirver1.Pojo.PickUpArrayList;
import com.example.senthil.dirver1.R;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PickupAdapter extends RecyclerView.Adapter<PickupAdapter.MyViewHolder> {
    private ArrayList<PickUpArrayList> moviesList;
    Context mContext;
    public PickupAdapter(ArrayList<PickUpArrayList> delievery_data, PickupList drsList) {
   this.moviesList=delievery_data;
   mContext=drsList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custlist, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PickupAdapter.MyViewHolder holder, int position) {
        final PickUpArrayList movie = moviesList.get(position);
        holder.trackId.setText("Track ID :"+ movie.getTrack_id());
        holder.deliveryAddress.setText("Delivery Address :"+ movie.getReceiver_address());
        holder.deliveryDateTime.setText("Delivery Date Time :"+movie.getDate()+"/"+movie.getTime());
        holder.PaymentMode.setText("Payment Mode :"+movie.getPayment_mode());

        holder.forword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, PickupUpdate.class);
                intent.putExtra("Data", (Serializable) movie);
                mContext.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.trackId)TextView trackId;
        @BindView(R.id.deliveryAddress)TextView deliveryAddress;
        @BindView(R.id.deliveryDateTime)TextView deliveryDateTime;
        @BindView(R.id.paymentMode)TextView PaymentMode;
        @BindView(R.id.imgClick)ImageView forword;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
