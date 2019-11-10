/*----------------------------------------------------------------------------*/
/* -------------------KIKSOFT: Kik Mobile Uygulaması--------------------------*/
/* ===========================================================================*/
/*Copyright (c) 2019 yılında Kik Soft Yazılım Departmanı tarafından geliştirilmiştir */
/*----------------------------------------------------------------------------*/

package com.kiksoft.yanmenu.islemler.talep;

import android.os.Bundle;
import androidx.fragment.app.*;
import androidx.recyclerview.widget.*;
import android.view.*;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kiksoft.kikmobil.R;


/*------------------------------------------------------------------------------------------------------------------------------------------*/
/* TalepListeFragment class: Talep listelerini görüntülemek için oluşturulan fragment class */
/* "1-constructor"  */
/* "on createviewHolder metodu":  Bu method fragment oluşturulduğunda oluşturduğumuz TalepListeAdapter class ının başlatılması için çağrılır. */
/* FloatingAction Button click metodu arama yapılacak sayfayı açar */


/*-----------------------------------------------------------------------------------------------------------------------------------------*/

public class TalepListeFragment extends Fragment {

    private RecyclerView recviewTalepListe;
    private LinearLayoutManager linlayoutTalepListe;
    private FragmentManager fmTalepListe;



    public TalepListeFragment(FragmentManager afmTalepListe) {

        fmTalepListe=afmTalepListe;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View viewTalepListe=inflater.inflate(R.layout.demand_files_fragment, container, false);

        TalepListeAdapter taleplisteAdapter = new TalepListeAdapter(fmTalepListe,this);
        recviewTalepListe = (RecyclerView) viewTalepListe.findViewById(R.id.demandfilescardList);
        linlayoutTalepListe = new LinearLayoutManager(viewTalepListe.getContext());

        if(taleplisteAdapter.arraylistTalepler.size()==0)
       {   taleplisteAdapter.WSTalepGetir();
           recviewTalepListe.setHasFixedSize(true);
           recviewTalepListe.setAdapter(taleplisteAdapter);
           recviewTalepListe.setLayoutManager(linlayoutTalepListe);}

        else {
            recviewTalepListe.setHasFixedSize(true);
            recviewTalepListe.setAdapter(taleplisteAdapter);
            recviewTalepListe.setLayoutManager(linlayoutTalepListe);
        }



        //adapter.notifyDataSetChanged();

        FloatingActionButton fab = viewTalepListe.findViewById(R.id.search_demand);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext()," talep arama sayfası açılacak", Toast.LENGTH_SHORT).show();
            }
        });

        return viewTalepListe;
    }

}
