package com.kiksoft.yanmenu.ayarlar.hesapayarlarim;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kiksoft.kikmobil.R;



public class HesapAFragment extends Fragment {





    public HesapAFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragmen
        View view = inflater.inflate(R.layout.account_settings_fragment, container, false);
        return view;
    }




}
