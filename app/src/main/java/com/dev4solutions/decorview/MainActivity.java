package com.dev4solutions.decorview;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String DATA = "data";
    ImageView mainImageView, blueImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainImageView = findViewById(R.id.imageView);

        blueImageView = findViewById(R.id.iconBlue);
        blueImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(DATA, getLaminateData());
                LaminateFragment laminateFragment = new LaminateFragment();
                laminateFragment.setCallback(new Callback() {
                    @Override
                    public void onCallback(Object data) {
                        LaminateData laminateData = (LaminateData) data;
                        mainImageView.setImageResource(laminateData.img);
                    }
                });
                laminateFragment.setArguments(bundle);
                getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(LaminateFragment.TAG)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.fragmentLaminate, laminateFragment, LaminateFragment.TAG)
                        .commit();
            }
        });

        mainImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = getSupportFragmentManager().getBackStackEntryCount();
                if (count > 0) {
                    MainActivity.super.onBackPressed();
                }
            }
        });
    }


    /**
     * @return
     */
    ArrayList<LaminateData> getLaminateData() {
        ArrayList<LaminateData> list = new ArrayList<>();

        list.add(new LaminateData("14586 SF",
                R.drawable.kitchen_1_14586,
                R.drawable.kitchen05_thumb04,
                R.drawable.img14586));

        list.add(new LaminateData("14551 SF",
                R.drawable.kitchen_2_14551,
                R.drawable.kitchen05_thumb02,
                R.drawable.img14551));
        list.add(new LaminateData("14585 SF",
                R.drawable.kitchen_3_14585,
                R.drawable.kitchen05_thumb03,
                R.drawable.img14585));
        list.add(new LaminateData("14531 VNR",
                R.drawable.kitchen_4_14531,
                R.drawable.kitchen05_thumb01,
                R.drawable.img14531));

        return list;
    }
}
