package com.example.labexercise;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;



public class DetailFragment extends Fragment {

    public Coin mCoin;
    public TextView mName;
    public TextView mSymbol;
    public TextView mValue;
    public TextView mChange1h;
    public TextView mChange24h;
    public TextView mChange7d;
    public TextView mMarketcap;
    public TextView mVolume;
    public ImageView mSearch;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);


        TextView textView = v.findViewById(R.id.imageView);
        TextView mName = v.findViewById(R.id.tvName);
        mSymbol = v.findViewById(R.id.tvSymbol);
        mValue = v.findViewById(R.id.tvValueField);
        mChange1h = v.findViewById(R.id.tvChange1hField);
        mChange24h = v.findViewById(R.id.tvChange24hField);
        mChange7d = v.findViewById(R.id.tvChange7dField);
        mMarketcap = v.findViewById(R.id.tvMarketcapField);
        mVolume = v.findViewById(R.id.tvVolumeField);
        mSearch = v.findViewById(R.id.ivSearch);



        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        
        mName.setText(mCoin.getName());
        mSymbol.setText(mCoin.getSymbol());
        mValue.setText(formatter.format(mCoin.getValue()));
        mChange1h.setText(String.valueOf(mCoin.getChange1h()) + " %");
        mChange24h.setText(String.valueOf(mCoin.getChange24h()) + " %");
        mChange7d.setText(String.valueOf(mCoin.getChange7d()) + " %");
        mMarketcap.setText(formatter.format(mCoin.getMarketcap()));
        mVolume.setText(formatter.format(mCoin.getVolume()));
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchCoin(mCoin.getName());
            }

            private void searchCoin(String name) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name));
                startActivity(intent);
            }
        });





        if (getArguments().getBoolean("inWide")) {
            String message = getArguments().getString("message");
            textView.setText(message);

        }

        return v;
    }
}