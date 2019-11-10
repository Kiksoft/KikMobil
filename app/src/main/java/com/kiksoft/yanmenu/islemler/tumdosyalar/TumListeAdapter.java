package com.kiksoft.yanmenu.islemler.tumdosyalar;



import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kiksoft.kikmobil.R;
import com.kiksoft.kikservice.NLQDOSYA_BILGISI;
import com.kiksoft.kikservice.NLQDominoSoapBinding;
import com.kiksoft.kikservice.NLQTUM_DOSYALARI_GETIR_SORGUSU;
import com.kiksoft.kikservice.NLQTUM_DOSYA_LISTESI_GETIRRETURN;

import java.util.ArrayList;

public class TumListeAdapter extends RecyclerView.Adapter<TumListeAdapter.AllFilesViewHolder> {


    public ArrayList< NLQDOSYA_BILGISI> TUM_DOSYALAR =new ArrayList<NLQDOSYA_BILGISI >();

    public  NLQTUM_DOSYALARI_GETIR_SORGUSU sorgu;
    public NLQTUM_DOSYA_LISTESI_GETIRRETURN dosyaListesiGetirreturn;

    public void loaddata()

    {
        try
        {
            NLQDominoSoapBinding wbo = new NLQDominoSoapBinding();
            sorgu = new NLQTUM_DOSYALARI_GETIR_SORGUSU();

           dosyaListesiGetirreturn = wbo.TUM_DOSYA_LISTESI_GETIR(sorgu);



                TUM_DOSYALAR =dosyaListesiGetirreturn.TUM_DOSYA_LISTESI;




        }
        catch (Exception exception)
        {

        }

    }




    public TumListeAdapter()
    {
          loaddata();
    }





     public int getItemCount()
     {

         return   TUM_DOSYALAR.size();
     }





    @Override
    public void onBindViewHolder(TumListeAdapter.AllFilesViewHolder allFilesViewHolder, int i)
    {

        NLQDOSYA_BILGISI wbodosya= TUM_DOSYALAR.get(i);

        allFilesViewHolder.vDosyaNo.setText(wbodosya.DOSYA_NUMARASI);
        allFilesViewHolder.vIhaleKayitNo.setText(wbodosya.IHALE_KAYIT_NUMARASI);
        allFilesViewHolder.vAsama.setText(wbodosya.ASAMA);
        allFilesViewHolder.vFirmaAdi.setText(wbodosya.FIRMA_ADI);
        allFilesViewHolder.vDosyaTuru.setText(wbodosya.DOSYANIN_TURU);
        allFilesViewHolder.vIsinTuru.setText(wbodosya.ISIN_TURU);
        allFilesViewHolder.vIdareAdi.setText(wbodosya.IDARENIN_ADI);
        allFilesViewHolder.vIsinTanimi.setText(wbodosya.ISIN_TANIMI);
        allFilesViewHolder.vAlimUsulu.setText(wbodosya.ALIM_USULU);
        allFilesViewHolder.vAlimZamani.setText(wbodosya.ALIM_ZAMANI.toString());
        allFilesViewHolder.vGorevli.setText(wbodosya.GOREVLI);
    }


    @Override
    public AllFilesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater. from(viewGroup.getContext()).inflate(R.layout.all_files_card_layout, viewGroup, false);
        return new AllFilesViewHolder(itemView);
    }

    public static class AllFilesViewHolder extends RecyclerView.ViewHolder {

        protected TextView vDosyaNo;
        protected TextView vAsama;
        protected TextView vFirmaAdi;
        protected TextView vDosyaTuru;
        protected TextView vIsinTuru;
        protected TextView vIdareAdi;
        protected TextView vIsinTanimi;
        protected TextView vAlimUsulu;
        protected TextView vAlimZamani;
        protected TextView vIhaleKayitNo;
        protected TextView vGorevli;


        public AllFilesViewHolder(View v) {
            super(v);
            vDosyaNo =  (TextView) v.findViewById(R.id.txtDosyano);
            vAsama = (TextView)  v.findViewById(R.id.txtAsama);
            vFirmaAdi = (TextView)  v.findViewById(R.id.txtFirmaadi);
            vDosyaTuru = (TextView) v.findViewById(R.id.txtDosyaturu);
            vIsinTuru=(TextView)v.findViewById(R.id.txtIsinturu);
            vIdareAdi=(TextView)v.findViewById(R.id.txtIdareadi);
            vIsinTanimi=(TextView)v.findViewById(R.id.txtIsintanimi);
            vAlimUsulu=(TextView)v.findViewById(R.id.txtAlimusulu);
            vAlimZamani=(TextView)v.findViewById(R.id.txtAlimzamani);
            vIhaleKayitNo=(TextView)v.findViewById(R.id.txtIhalekayitno);
            vGorevli=(TextView)v.findViewById(R.id.txtGorevli);

        }




    }


//   public void loaddata()
//   {
//       try{
//       WBODominoSoapBinding wbo = new WBODominoSoapBinding();
//       WBOTUM_DOSYALARI_GETIR_SORGUSU a = new WBOTUM_DOSYALARI_GETIR_SORGUSU();
//       WBOTUM_DOSYA_LISTESI_GETIRRETURN ret = wbo.TUM_DOSYA_LISTESI_GETIR(a);
//       TUM_DOSYALAR=ret.TUM_DOSYA_LISTESI;
//
//       }
//       catch (Exception exception)
//       {
//
//       }
//
//
//   }




}
