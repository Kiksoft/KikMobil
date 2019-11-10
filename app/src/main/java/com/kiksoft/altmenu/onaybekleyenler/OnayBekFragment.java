package com.kiksoft.altmenu.onaybekleyenler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kiksoft.kikmobil.R;

import java.util.ArrayList;
import java.util.List;


public class OnayBekFragment extends Fragment {



    public OnayBekFragment() {

    }

    private List<ContactInfo> createList(int size) {

        List<ContactInfo> result = new ArrayList<ContactInfo>();
        for (int i=1; i <= size; i++) {
            ContactInfo ci = new ContactInfo();
            ci.name = ContactInfo.NAME_PREFIX + i;
            ci.surname = ContactInfo.SURNAME_PREFIX + i;
            ci.email = ContactInfo.EMAIL_PREFIX + i + "@test.com";

            result.add(ci);

        }

        return result;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.pending_approval_fragment, container, false);

         List <ContactInfo> contactlist=createList(10);

        ContactAdapter ca = new ContactAdapter(contactlist);

        RecyclerView recList = (RecyclerView) view.findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        recList.setAdapter(ca);

        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        recList.setLayoutManager(llm);

        return view;
    }









}
