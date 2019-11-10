/*----------------------------------------------------------------------------*/
/* -------------------KIKSOFT: Kik Mobile Uygulaması--------------------------*/
/* ===========================================================================*/
/*Copyright (c) 2019 yılında Kik Soft Yazılım Departmanı tarafından geliştirilmiştir */
/*----------------------------------------------------------------------------*/

package com.kiksoft.yanmenu.islemler.ihale;

import android.view.*;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.kiksoft.kikmobil.R;
import java.util.ArrayList;

import com.kiksoft.kikservice.NLQDTEMIN_IHALE_BILGISI;
import com.kiksoft.kikservice.NLQDTEMIN_IHALE_LISTESI_GETIRRETURN;
import com.kiksoft.kikservice.NLQDominoSoapBinding;



public class IhaleListeAdapter extends RecyclerView.Adapter<IhaleListeAdapter.IhaleListeArayuzTutucu>{

        public ArrayList<NLQDTEMIN_IHALE_BILGISI> arraylistIhale =new ArrayList<NLQDTEMIN_IHALE_BILGISI >();
        public NLQDTEMIN_IHALE_LISTESI_GETIRRETURN wsDosyaIhaleListesiGetirReturn;


        public void WSIhaleListeGetir() {

            try
              {
                NLQDominoSoapBinding wsIhaleListe = new NLQDominoSoapBinding();
                wsDosyaIhaleListesiGetirReturn = wsIhaleListe.DTEMIN_IHALE_LISTESI_GETIR("field form contains hizli_ihale");
                arraylistIhale=wsDosyaIhaleListesiGetirReturn.DTEMIN_IHALE_LISTESI;
              }

             catch (Exception exception)   { }

        }




        public IhaleListeAdapter()
        {
            WSIhaleListeGetir();
        }

        public int getItemCount()
        {
            return   arraylistIhale.size();
        }








public void onBindViewHolder(IhaleListeAdapter.IhaleListeArayuzTutucu anIhaleListeArayuzTutucu, int sayac)
        {

            NLQDTEMIN_IHALE_BILGISI wsIhaleBilgisi= arraylistIhale.get(sayac);

            anIhaleListeArayuzTutucu.vIhaleDosyaNo.setText("Dosya No:"+ wsIhaleBilgisi.DOSYA_NUMARASI);
            anIhaleListeArayuzTutucu.vIhaleIsinTanimi.setText("İşin Tanımı:"+ wsIhaleBilgisi.ISIN_TANIMI);
            anIhaleListeArayuzTutucu.vIhaleIsinTuru.setText("İşin Türü"+ wsIhaleBilgisi.ISIN_TURU);
            anIhaleListeArayuzTutucu.vIhaleKayitNo2.setText("İhale Kayıt Numarası:"+ wsIhaleBilgisi.IHALE_KAYIT_NUMARASI);
            anIhaleListeArayuzTutucu.vIhaleTalepEdenBirim2.setText("Talep Eden Birim"+wsIhaleBilgisi.TALEP_EDEN_BIRIM);
            anIhaleListeArayuzTutucu.vIhaleTalepEvrakNo.setText("Talep Evrak No:"+wsIhaleBilgisi.TALEP_EVRAK_NO);
            anIhaleListeArayuzTutucu.vIhaleTalepEvrakTarihi.setText("Talep Evrak Tarihi:"+wsIhaleBilgisi.TALEP_EVRAK_TARIHI);
            anIhaleListeArayuzTutucu.vIhaleAlimZamani2.setText("Alım Zamanı:"+wsIhaleBilgisi.ALIM_ZAMANI);
            anIhaleListeArayuzTutucu.vIhaleIdareAdi.setText("İdare Adı:"+wsIhaleBilgisi.IDARENIN_ADI);
            anIhaleListeArayuzTutucu.vIhaleDurumu.setText("Durumu"+wsIhaleBilgisi.DURUMU);
            anIhaleListeArayuzTutucu.vIhaleGorevli.setText("Görevli:"+ wsIhaleBilgisi.GOREVLI);

        }


@Override
public IhaleListeArayuzTutucu onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater. from(parent.getContext()).inflate(R.layout.direct_supply_and_tender_card_layout, parent, false);
        return new IhaleListeArayuzTutucu(itemView);
        }



public static class IhaleListeArayuzTutucu extends RecyclerView.ViewHolder {

    protected TextView vIhaleDosyaNo;
    protected TextView vIhaleIsinTanimi;
    protected TextView vIhaleIsinTuru;
    protected TextView vIhaleKayitNo2;
    protected TextView vIhaleTalepEdenBirim2;
    protected TextView vIhaleTalepEvrakNo;
    protected TextView vIhaleTalepEvrakTarihi;
    protected TextView vIhaleAlimZamani2;
    protected TextView vIhaleIdareAdi;
    protected TextView vIhaleDurumu;
    protected TextView vIhaleGorevli;



    public IhaleListeArayuzTutucu(View v) {
        super(v);
        vIhaleDosyaNo = (TextView) v.findViewById(R.id.txtIhaleDosyano);
        vIhaleIsinTanimi =(TextView) v.findViewById(R.id.txtIhaleIsinTanimi);
        vIhaleIsinTuru=(TextView) v.findViewById(R.id.txtIhaleIsınTuru);
        vIhaleKayitNo2=(TextView) v.findViewById(R.id.txtIhalekayitno);
        vIhaleTalepEdenBirim2=(TextView) v.findViewById(R.id.txtIhaleBirim);
        vIhaleTalepEvrakNo= (TextView) v.findViewById(R.id.txtIhaleTalepEvrakno);
        vIhaleTalepEvrakTarihi= (TextView)v.findViewById(R.id.txtIhaleTalepEvraktarihi);
        vIhaleAlimZamani2= (TextView) v.findViewById(R.id.txtIhaleDosyano);
        vIhaleIdareAdi= (TextView) v.findViewById(R.id.txtIhaleIdareadı);
        vIhaleDurumu= (TextView) v.findViewById(R.id.txtIhaleAsama);
        vIhaleGorevli= (TextView) v.findViewById(R.id.txtIhaleGorevli);
    }

}





}
