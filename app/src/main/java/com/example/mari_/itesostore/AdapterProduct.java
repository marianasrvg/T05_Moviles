package com.example.mari_.itesostore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mari_.itesostore.beans.ItemProduct;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {
    private ArrayList<ItemProduct> products;
    private Context context;

    public AdapterProduct(Context context, ArrayList<ItemProduct> products){
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public Button mDetail;
        public ImageView imageView;
        public TextView title;
        public TextView productStore;
        public TextView productLocation;
        public TextView productPhone;
        public ImageView productThumbnail;
        public RelativeLayout mEventLayout;

        public ViewHolder(View v){
            super(v);
            imageView = v.findViewById(R.id.item_product_image);
            title = v.findViewById(R.id.item_product_title);
            productStore = v.findViewById(R.id.item_product_store);
            productLocation = v.findViewById(R.id.item_product_location);
            productPhone = v.findViewById(R.id.item_product_phone);
            mEventLayout = v.findViewById(R.id.item_product_layout);
            mDetail = v.findViewById(R.id.item_product_detail);
            productThumbnail = v.findViewById(R.id.item_product_thumbnail);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.title.setText(products.get(position).getTitle());
        switch (products.get(position).getImage()){
            case 0:
                holder.imageView.setImageResource(R.drawable.mac); break;
            case 1:
                holder.imageView.setImageResource(R.drawable.alienware); break;
        }
        holder.productStore.setText(products.get(position).getStore());
        holder.productLocation.setText(products.get(position).getLocation());
        holder.productPhone.setText(products.get(position).getPhone());
        holder.title.setText(products.get(position).getTitle());
       // Bitmap bitmap = ((BitmapDrawable)holder.productThumbnail.getDrawable()).getBitmap();
       // holder.productThumbnail.setImageBitmap(Tool.getRoundedBitmap(bitmap));

        holder.mDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, products.get(position).toString(),
                        Toast.LENGTH_LONG).show();
            }
        });

        holder.productPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity2 = new Intent(v.getContext() , ActivityProduct.class);
                context.startActivity(activity2);
            }
        });

        holder.mEventLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity2 = new Intent(v.getContext() , ActivityProduct.class);
                activity2.putExtra("ITEM", products.get(position));
                context.startActivity(activity2);
            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
