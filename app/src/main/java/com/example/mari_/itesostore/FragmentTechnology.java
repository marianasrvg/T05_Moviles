package com.example.mari_.itesostore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mari_.itesostore.beans.ItemProduct;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTechnology extends Fragment {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public FragmentTechnology() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_technology_recycler_view);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<ItemProduct> myDataSet = new ArrayList<>();
        ItemProduct itemProduct = new ItemProduct();
        itemProduct.setTitle("MacBook Pro 17");
        itemProduct.setStore("BestBuy");
        itemProduct.setLocation("Zapopan, Jalisco");
        itemProduct.setPhone("3312345678");
        itemProduct.setImage(0);
        itemProduct.setDescription("Llevate esta Mac con un 30% de descuento" +
                "para que puedas programar para XCode y Android sin tener que " +
                "batallar tanto como en Windows");

        ItemProduct itemProduct2 = new ItemProduct();

        itemProduct2.setTitle("Alienware 17");
        itemProduct2.setStore("BestBuy");
        itemProduct2.setLocation("Zapopan, Jalisco");
        itemProduct2.setPhone("3312345678");
        itemProduct2.setImage(1);
        itemProduct2.setDescription("Llevate esta Alienware con un 30% de descuento" +
                "para que puedas jugar");


        if(this.getArguments() != null) {
            ItemProduct itemProduct1 = new ItemProduct();
            itemProduct1 = this.getArguments().getParcelable("ITEM");
            switch (itemProduct2.getImage()) {
                case 0:
                    itemProduct.setTitle(itemProduct2.getTitle());
                    itemProduct.setStore(itemProduct2.getStore());
                    itemProduct.setLocation(itemProduct2.getLocation());
                    itemProduct.setPhone(itemProduct2.getPhone());
                    break;
                case 1:
                    itemProduct2.setTitle(itemProduct2.getTitle());
                    itemProduct2.setStore(itemProduct2.getStore());
                    itemProduct2.setLocation(itemProduct2.getLocation());
                    itemProduct2.setPhone(itemProduct2.getPhone());
                    break;
            }
        }

        myDataSet.add(itemProduct);
        myDataSet.add(itemProduct2);

        mAdapter = new AdapterProduct(getActivity(), myDataSet);
        recyclerView.setAdapter(mAdapter);
        return view;
    }



}
