package com.jesseryan_dev.uxfilterprototype;

import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jesseryan_dev.uxfilterprototype.bottomsheets.RefineFilterBottomSheetFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BottomSheetDialogFragment mBottomSheetDialogFragment;

    private final int android_image_res[] = {
            R.drawable.one, R.drawable.two, R.drawable.three,
            R.drawable.four, R.drawable.five, R.drawable.six,
            R.drawable.seven, R.drawable.eight, R.drawable.nine,
            R.drawable.ten,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initViews();

        mBottomSheetDialogFragment = new RefineFilterBottomSheetFragment();

    }

    protected void showBottomSheet(){
        mBottomSheetDialogFragment.show(getSupportFragmentManager(), mBottomSheetDialogFragment.getTag());
    }


    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<ResultImages> resultImages = prepareData();
        DataAdapter adapter = new DataAdapter(resultImages);
        recyclerView.setAdapter(adapter);

        TextView b1 = (TextView)findViewById(R.id.similar);
        TextView b2 = (TextView)findViewById(R.id.new_vehicles);
        TextView b3 = (TextView)findViewById(R.id.recommendations);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet();
            }
        });


    }

    private ArrayList<ResultImages> prepareData() {

        ArrayList<ResultImages> android_version = new ArrayList<>();
        for (int i = 0; i < android_image_res.length; i++) {
            ResultImages resultImages = new ResultImages();
            resultImages.setAndroid_image_res(android_image_res[i]);
            android_version.add(resultImages);
        }
        return android_version;
    }
}
