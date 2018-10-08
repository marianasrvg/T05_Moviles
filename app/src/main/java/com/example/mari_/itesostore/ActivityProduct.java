package com.example.mari_.itesostore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mari_.itesostore.beans.ItemProduct;

public class ActivityProduct extends Activity {
    Button save;
    Button cancel;
    EditText title;
    EditText store;
    EditText location;
    EditText phone;
    ItemProduct itemProduct = new ItemProduct();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product);

        save = findViewById(R.id.item_product_button_save);
        cancel = findViewById(R.id.item_product_button_cancel);
        title = findViewById(R.id.item_product_edit_text_brand);
        store = findViewById(R.id.item_product_edit_text_store);
        location = findViewById(R.id.item_product_edit_text_location);
        phone = findViewById(R.id.item_product_edit_text_phone);

        if(getIntent().getExtras() != null) {
            itemProduct = getIntent().getParcelableExtra("ITEM");
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemProduct.setTitle(title.getText().toString());
                itemProduct.setStore(store.getText().toString());
                itemProduct.setLocation(location.getText().toString());
                itemProduct.setPhone(phone.getText().toString());
                Intent intent = new Intent(v.getContext(), ActivityMain.class);
                intent.putExtra("ITEM", itemProduct);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityMain.class);
                startActivity(intent);
            }
        });
    }
}
