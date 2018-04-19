package com.dev4solutions.decorview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created By: Manoj Singh Rawal
 * Email : manoj.rawal@svam.com
 * Project : DecorView
 * Copyright (c) 2018 North Shore Technologies Pvt. Ltd.
 * on 4/17/18.
 */
public class LaminateFragment extends Fragment {

    private Callback callback;
    public static final String TAG = "LaminateFragment";
    View view;
    RecyclerView recyclerView;

    ArrayList<LaminateData> dataList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataList = (ArrayList<LaminateData>) getArguments().getSerializable(MainActivity.DATA);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_laminate, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new Adapter());
        return view;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }


    private class Adapter extends RecyclerView.Adapter {

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new VH(getLayoutInflater().inflate(R.layout.item_laminate, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            VH vh = (VH) holder;
            final LaminateData laminateData = dataList.get(position);

            SpannableString spannableString = new SpannableString(laminateData.name);
            spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

            vh.textView.setText(spannableString);
            vh.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(MainActivity.DATA, laminateData);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

            vh.imageView.setImageResource(laminateData.thumb);
            vh.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onCallback(laminateData);
                }
            });
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }
    }

    class VH extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public VH(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.itemImageView);
            textView = itemView.findViewById(R.id.itemTextView);
        }
    }
}
