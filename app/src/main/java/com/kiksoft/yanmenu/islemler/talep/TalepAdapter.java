/*----------------------------------------------------------------------------*/
/* -------------------KIKSOFT: Kik Mobile Uygulaması--------------------------*/
/* ===========================================================================*/
/*Copyright (c) 2019 yılında  Kik Soft Yazılım Departmanı tarafından geliştirilmiştir */
/*----------------------------------------------------------------------------*/

package com.kiksoft.yanmenu.islemler.talep;

import com.kiksoft.kikmobil.R;
import android.view.*;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import com.kiksoft.kikservice.NLQDominoSoapBinding;
import com.kiksoft.kikservice.NLQIHTIYAC_LISTESI_KALEMLERI_GETIRRETURN;
import com.kiksoft.kikservice.NLQKALEM;


/*------------------------------------------------------------------------------------------------------------------------------------------*/
/* TalepAdapter class: Talep dosyalarının kalem bilgilerini alabilmek için oluşturulan adapter class */
/* "1-constructor"  */
/* "on createviewHolder metodu":  Bu method adaptör oluşturulduğunda oluşturduğumuz TalepKalemArayuzTutucu'nun başlatılması için çağrılır. */
/* "onBindViewHolder metodu":  onCreateViewHolder’dan dönen verileri bağlama işlemini gerçekleştirildiği metotdur. */
/* WSTalepKalemGetir metodu: Talebe ait kalem bilgilerini web servisten alan metottur.*/
/*-----------------------------------------------------------------------------------------------------------------------------------------*/


public class TalepAdapter extends RecyclerView.Adapter<TalepAdapter.TalepKalemArayuzTutucu>

{
    private String strDokumanId;

    public NLQDominoSoapBinding wsTalepDetay = new NLQDominoSoapBinding();


    public ArrayList<NLQKALEM> arraylistTalepKalemleri =new ArrayList<NLQKALEM >();
    public NLQIHTIYAC_LISTESI_KALEMLERI_GETIRRETURN wsKalemGetirReturn;


    public void WSTalepKalemGetir()
    {
        try
        {
            wsKalemGetirReturn=wsTalepDetay.IHTIYAC_LISTESI_KALEMLERI_GETIR(strDokumanId);
            arraylistTalepKalemleri=wsKalemGetirReturn.IHTIYAC_LISTESI_KALEMLERI;
        }

        catch (Exception e)   { }


    }


     public TalepAdapter(String astrDokumanId)
     {
         strDokumanId= astrDokumanId;
         WSTalepKalemGetir();
     }


    public int getItemCount()
    {
        return   arraylistTalepKalemleri.size();
    }


    public TalepKalemArayuzTutucu onCreateViewHolder( ViewGroup vgKok, int intArayuzTipi) {
        View viewTalepKalemArayuz = LayoutInflater. from(vgKok.getContext()).inflate(R.layout.demand_row_card_layout, vgKok, false);
        return new TalepKalemArayuzTutucu(viewTalepKalemArayuz,arraylistTalepKalemleri);
    }



    public void onBindViewHolder(TalepKalemArayuzTutucu aTalepKalemArayuzu, int sayac)
    {
        NLQKALEM wsKalem= arraylistTalepKalemleri.get(sayac);

        aTalepKalemArayuzu.vStokKodu.setText("Stok Kodu: "+wsKalem.KODU);
        aTalepKalemArayuzu.vStokAdi.setText("Stok Adı: "+wsKalem.ADI);
        aTalepKalemArayuzu.vBirim.setText("Birim: "+wsKalem.BIRIMI);
        aTalepKalemArayuzu.vMiktar.setText("Miktarı: "+wsKalem.SIPARIS_MIKTARI);
        aTalepKalemArayuzu.vAciklama.setText("Açıklama: "+wsKalem.ADI);
    }


    /*--------------------------------------------------------------------------------------------------*/
    /* TalepKalemArayuzTutucu class: oluşturulan arayüz interface ile değişkenlerin bağlanması sağlanır */
    /* "1-constructor"  */
    /*--------------------------------------------------------------------------------------------------*/


    public static class TalepKalemArayuzTutucu extends RecyclerView.ViewHolder {

        private ArrayList<NLQKALEM> arraylistKalem;

        protected TextView vStokKodu;
        protected TextView vStokAdi;
        protected TextView vBirim;
        protected TextView vMiktar;
        protected TextView vAciklama;


        public TalepKalemArayuzTutucu (View view, ArrayList<NLQKALEM> anarrayListKalemler)
        {
            super(view);
            vStokKodu=(TextView) view.findViewById(R.id.txtStokKodu);
            vStokAdi=(TextView) view.findViewById(R.id.txtStokAdi);
            vBirim=(TextView) view.findViewById(R.id.txtBirimi);
            vMiktar=(TextView) view.findViewById(R.id.txtMiktari);
            vAciklama=(TextView) view.findViewById(R.id.txtAciklama);

        }
    }

}
