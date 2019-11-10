/*----------------------------------------------------------------------------*/
/* -------------------KIKSOFT: Kik Mobile Uygulaması--------------------------*/
/* ===========================================================================*/
/*Copyright (c) 2019 yılında Kik Soft Yazılım Departmanı tarafından geliştirilmiştir */
/*----------------------------------------------------------------------------*/

package com.kiksoft.yanmenu.islemler.talep;

import com.kiksoft.kikmobil.R;
import androidx.fragment.app.*;
import android.view.*;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import java.util.ArrayList;

import com.kiksoft.kikservice.NLQDominoSoapBinding;
import com.kiksoft.kikservice.NLQTALEP_BILGISI;
import com.kiksoft.kikservice.NLQTALEP_LISTESI_GETIRRETURN;

/*------------------------------------------------------------------------------------------------------------------------------------------*/
/* TalepListeAdapter class: Talep listesini alabilmek için oluşturulan adapter class */
/* "1-constructor"  */
/* "on createviewHolder metodu":  Bu method adaptör oluşturulduğunda oluşturduğumuz TalepArayuzTutucu'nun başlatılması için çağrılır. */
/* "onBindViewHolder metodu":  onCreateViewHolder’dan dönen verileri bağlama işlemini gerçekleştirildiği metotdur. */
/* WSTalepGetir metodu: Talep listelerini web servisten alan metottur.*/
/*-----------------------------------------------------------------------------------------------------------------------------------------*/

public class TalepListeAdapter extends RecyclerView.Adapter<TalepListeAdapter.TalepArayuzTutucu> {

    Fragment fTalepListe;
    static FragmentManager fmTalepListe;
    Context cTalepListe;

    public ArrayList<NLQTALEP_BILGISI > arraylistTalepler =new ArrayList<NLQTALEP_BILGISI >();
    public NLQTALEP_LISTESI_GETIRRETURN wsDosyaTalepListesiGetirReturn;



    public void WSTalepGetir()

    {
        try
        {
            NLQDominoSoapBinding wsTalepListe = new NLQDominoSoapBinding();
            wsDosyaTalepListesiGetirReturn = wsTalepListe.TALEP_LISTESI_GETIR("");
            arraylistTalepler =wsDosyaTalepListesiGetirReturn.TALEP_LISTESI;

        }
        catch (Exception e)   { }

    }

    public TalepListeAdapter(FragmentManager afmTalepListe, Fragment afTalepListe )
    {
        fmTalepListe=afmTalepListe;
        this.fTalepListe=afTalepListe;
      //  loadDemanddata();
    }


    public int getItemCount()
    {
       return   arraylistTalepler.size();
    }


    @Override
    public TalepArayuzTutucu onCreateViewHolder( ViewGroup vgKok, int intArayuzTipi) {
        View viewTalepListeArayuz = LayoutInflater. from(vgKok.getContext()).inflate(R.layout.demand_card_layout, vgKok, false);
        return new TalepArayuzTutucu(viewTalepListeArayuz,arraylistTalepler,fTalepListe,fmTalepListe,cTalepListe);
    }

    public void onBindViewHolder(TalepArayuzTutucu aTalepArayuzu, int sayac)
    {

        NLQTALEP_BILGISI wsTalepDosya= arraylistTalepler.get(sayac);

        aTalepArayuzu.vTalepDosyaNo.setText("Dosya No: "+wsTalepDosya.DOSYA_NUMARASI);
        aTalepArayuzu.vTalepIsinTanimi.setText(wsTalepDosya.ISIN_TANIMI);
        aTalepArayuzu.vTalepAsama.setText(wsTalepDosya.ASAMA);
        aTalepArayuzu.vTalepBirim.setText(wsTalepDosya.TALEP_EDEN_BIRIM);
        aTalepArayuzu.vTalepEvrakNo.setText(wsTalepDosya.TALEP_EVRAK_NO);
        aTalepArayuzu.vTalepEvrakTarihi.setText(wsTalepDosya.TALEP_EVRAK_TARIHI);
        aTalepArayuzu.vTalepIdareAdi.setText(wsTalepDosya.IDARENIN_ADI);
        aTalepArayuzu.vTalepGorevli.setText(wsTalepDosya.GOREVLI);

    }

    /*--------------------------------------------------------------------------------------------------*/
    /* TalepArayuzTutucu class: oluşturulan arayüz interface ile değişkenlerin bağlanması sağlanır */
    /* "1-constructor"  */
    /*  "1-setOnClickListener" */
    /*--------------------------------------------------------------------------------------------------*/

    public static class TalepArayuzTutucu extends RecyclerView.ViewHolder {

       private ArrayList<NLQTALEP_BILGISI> arraylistTalep;
       Context cTalepArayuzTutucu;

        protected TextView vTalepDosyaNo;
        protected TextView vTalepIsinTanimi;
        protected TextView vTalepAsama;
        protected TextView vTalepBirim;
        protected TextView vTalepEvrakNo;
        protected TextView vTalepEvrakTarihi;
        protected TextView vTalepIdareAdi;
        protected TextView vTalepGorevli;


        public TalepArayuzTutucu(View v, ArrayList<NLQTALEP_BILGISI> anarraylistTalep, final Fragment afTalepArayuzTutucu,  final FragmentManager afmTalepArayuzTutucu, final Context acTalepArayuzTutucu) {

            super(v);
            this.arraylistTalep=anarraylistTalep;
            this.cTalepArayuzTutucu=acTalepArayuzTutucu;


            vTalepDosyaNo = (TextView) v.findViewById(R.id.txtTalepDosyano);
            vTalepIsinTanimi=(TextView) v.findViewById(R.id.txtTalepIsinTanimi);
            vTalepAsama=(TextView) v.findViewById(R.id.txtTalepAsama);
            vTalepBirim=(TextView) v.findViewById(R.id.txtTalepBirim);
            vTalepEvrakNo=(TextView) v.findViewById(R.id.txtTalepEvrakno);
            vTalepEvrakTarihi=(TextView) v.findViewById(R.id.txtTalepEvraktarihi);
            vTalepIdareAdi=(TextView) v.findViewById(R.id.txtTalepIdareadı);
            vTalepGorevli=(TextView) v.findViewById(R.id.txtTalepGorevli);


            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
               {
                   NLQTALEP_BILGISI wsTalepDosyaBilgisi= arraylistTalep.get(getLayoutPosition());
                   //Toast.makeText(v.getContext(), wbotalepdosya.DOSYA_NUMARASI , Toast.LENGTH_SHORT).show();

                   Fragment fTalepArayuzTutucu = new TalepFragment(wsTalepDosyaBilgisi);
                   FragmentTransaction tTalepDetayAc=  ((FragmentActivity)v.getContext()).getSupportFragmentManager().beginTransaction();
                   tTalepDetayAc.replace(R.id.id_container, fTalepArayuzTutucu);
                   tTalepDetayAc.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                   tTalepDetayAc.addToBackStack(null);
                   tTalepDetayAc.commit(); }
            });

        }
    }

    }
