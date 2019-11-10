/*----------------------------------------------------------------------------*/
/* -------------------KIKSOFT: Kik Mobile Uygulaması--------------------------*/
/* ===========================================================================*/
/*Copyright (c) 2019 yılında Kik Soft Yazılım Departmanı tarafından geliştirilmiştir */
/*----------------------------------------------------------------------------*/

package com.kiksoft.yanmenu.islemler.talep;

import android.os.Bundle;
import android.view.*;
import com.kiksoft.kikmobil.R;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;
import android.widget.TextView;

import com.kiksoft.kikservice.NLQTALEP_BILGISI;


/*------------------------------------------------------------------------------------------------------------------------------------------*/
/* TalepFragment class: Talep dosyalarının detay bilgilerini görüntülemek için oluşturulan fragment class */
/* "1-constructor"  */
/* "on createviewHolder metodu":  Bu method fragment oluşturulduğunda oluşturduğumuz TalepAdapter class ının başlatılması için çağrılır. */

/*-----------------------------------------------------------------------------------------------------------------------------------------*/

public class TalepFragment extends Fragment {

    private RecyclerView recviewTalep;
    private LinearLayoutManager linlayoutTalep;
    private NLQTALEP_BILGISI wsTalep;


    public TalepFragment(NLQTALEP_BILGISI awsTalep)
    {
        wsTalep=awsTalep;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {


        View viewTalepDetay = inflater.inflate(R.layout.demand_files_details_fragment, container, false);
        TalepAdapter adapterTalep=new TalepAdapter(wsTalep.DOKUMANID);

        recviewTalep = (RecyclerView) viewTalepDetay.findViewById(R.id.demandrowcardList);
        recviewTalep.setHasFixedSize(true);
        recviewTalep.setAdapter(adapterTalep);
        linlayoutTalep = new LinearLayoutManager(viewTalepDetay.getContext());
        recviewTalep.setLayoutManager(linlayoutTalep);

        TextView vTalepDetayDosyaNo = (TextView) viewTalepDetay.findViewById(R.id.txtTalepDetayDosyaNo);
        vTalepDetayDosyaNo.setText(wsTalep.DOSYA_NUMARASI);

        TextView vTalepDetayIsinTanimi = (TextView) viewTalepDetay.findViewById(R.id.txtTalepDetayIsinTanimi);
        vTalepDetayIsinTanimi.setText(wsTalep.ISIN_TANIMI);

        TextView vTalepDetayIsinTuru = (TextView) viewTalepDetay.findViewById(R.id.txtTalepDetayIsTuru);
        vTalepDetayIsinTuru.setText(wsTalep.ISIN_TURU);

        TextView vTalepDetayBirim = (TextView) viewTalepDetay.findViewById(R.id.txtTalepDetayBirim);
        vTalepDetayBirim.setText(wsTalep.TALEP_EDEN_BIRIM);

        TextView vTalepDetayEvrakNo = (TextView) viewTalepDetay.findViewById(R.id.txtTalepDetayEvrakno);
        vTalepDetayEvrakNo.setText(wsTalep.TALEP_EVRAK_NO);

        TextView vTalepDetayEvrakTarih = (TextView) viewTalepDetay.findViewById(R.id.txtTalepDetayEvraktarihi);
        vTalepDetayEvrakTarih.setText(wsTalep.TALEP_EVRAK_TARIHI);

        TextView vDetayIdare = (TextView) viewTalepDetay.findViewById(R.id.txtTalepDetayIdareadı);
        vDetayIdare.setText(wsTalep.IDARENIN_ADI);

        TextView vKategori = (TextView) viewTalepDetay.findViewById(R.id.txtTalepDetayKategori);
        vKategori.setText(wsTalep.KATEGORI);

       return viewTalepDetay;


    }

}
