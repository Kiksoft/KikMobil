package com.kiksoft.yanmenu.islemler.tumdosyalar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kiksoft.kikmobil.R;


public class TumListeFragment extends Fragment {

private RecyclerView recList;
private LinearLayoutManager llm;
private TumListeAdapter adapter;



    public TumListeFragment() {


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.all_files_fragment, container, false);


        TumListeAdapter adapter = new TumListeAdapter();

        recList = (RecyclerView) view.findViewById(R.id.allfilescardList);

        //adapter.notifyDataSetChanged();

        recList.setHasFixedSize(true);
        recList.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        recList.setLayoutManager(llm);

        FloatingActionButton fab = view.findViewById(R.id.myFAB);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"arama sayfası açılacak", Toast.LENGTH_SHORT).show();
            }
        });

        return view;


    }





}
