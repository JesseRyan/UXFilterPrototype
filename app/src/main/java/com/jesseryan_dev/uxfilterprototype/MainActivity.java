package com.jesseryan_dev.uxfilterprototype;

import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jesseryan_dev.uxfilterprototype.bottomsheets.RefineFilterBottomSheetFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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

        BottomSheetDialogFragment bottomSheetDialogFragment = new RefineFilterBottomSheetFragment();
        bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());

    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<ResultImages> resultImages = prepareData();
        DataAdapter adapter = new DataAdapter(resultImages);
        recyclerView.setAdapter(adapter);




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
