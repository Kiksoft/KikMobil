package com.kiksoft.yanmenu.islemler.dogrudantemin;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kiksoft.kikmobil.R;
import com.kiksoft.kikservice.NLQDominoSoapBinding;
import com.kiksoft.kikservice.NLQDTEMIN_IHALE_BILGISI;
import com.kiksoft.kikservice.NLQDTEMIN_IHALE_LISTESI_GETIRRETURN;

import java.util.ArrayList;

public class DTeminListeAdapter extends RecyclerView.Adapter<DTeminListeAdapter.DirectSupplyFilesViewHolder>

{
    public ArrayList<NLQDTEMIN_IHALE_BILGISI > DTemin =new ArrayList<NLQDTEMIN_IHALE_BILGISI >();
    public NLQDTEMIN_IHALE_LISTESI_GETIRRETURN dosyaDTeminListesiGetirreturn;


    public void loadDSupplyData()

    {
        try
        {
            NLQDominoSoapBinding wbo = new NLQDominoSoapBinding();


            dosyaDTeminListesiGetirreturn = wbo.DTEMIN_IHALE_LISTESI_GETIR("field form contains hizli_dogrudan_temin");

            DTemin=dosyaDTeminListesiGetirreturn.DTEMIN_IHALE_LISTESI;

        }
        catch (Exception exception)
        {

        }

    }




    public DTeminListeAdapter()
    {
        loadDSupplyData();
    }






    public int getItemCount()
    {

        return   DTemin.size();
    }








    public void onBindViewHolder(DTeminListeAdapter.DirectSupplyFilesViewHolder DirectSupplyTenderFilesViewHolder, int i)
    {

        NLQDTEMIN_IHALE_BILGISI wbodosya= DTemin.get(i);
        DirectSupplyTenderFilesViewHolder.vDTeminDosyaNo.setText("Dosya No:"+ wbodosya.DOSYA_NUMARASI);
        DirectSupplyTenderFilesViewHolder.vDTeminIsinTanimi.setText("İşin Tanımı:"+ wbodosya.ISIN_TANIMI);
        DirectSupplyTenderFilesViewHolder.vDTeminIsinTuru.setText("İşin Türü"+ wbodosya.ISIN_TURU);
        DirectSupplyTenderFilesViewHolder.vIhaleKayitNo.setText("İhale Kayıt Numarası:"+ wbodosya.IHALE_KAYIT_NUMARASI);
        DirectSupplyTenderFilesViewHolder.vIhaleTalepEdenBirim.setText("Talep Eden Birim"+wbodosya.TALEP_EDEN_BIRIM);
        DirectSupplyTenderFilesViewHolder.vIhaleTalepEvrakNo.setText("Talep Evrak No:"+wbodosya.TALEP_EVRAK_NO);
        DirectSupplyTenderFilesViewHolder.vIhaleTalepEvrakTarihi.setText("Talep Evrak Tarihi:"+wbodosya.TALEP_EVRAK_TARIHI);
        DirectSupplyTenderFilesViewHolder.vIhaleAlimZamani.setText("Alım Zamanı:"+wbodosya.ALIM_ZAMANI);
        DirectSupplyTenderFilesViewHolder.vDTeminIdareAdi.setText("İdare Adı:"+wbodosya.IDARENIN_ADI);
        DirectSupplyTenderFilesViewHolder.vDTeminDurumu.setText("Durumu"+wbodosya.DURUMU);
        DirectSupplyTenderFilesViewHolder.vDTeminGorevli.setText("Görevli:"+ wbodosya.GOREVLI);




    }


    @Override
    public DirectSupplyFilesViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View itemView = LayoutInflater. from(parent.getContext()).inflate(R.layout.direct_supply_and_tender_card_layout, parent, false);
        return new DirectSupplyFilesViewHolder(itemView);
    }



    public static class DirectSupplyFilesViewHolder extends RecyclerView.ViewHolder {

        protected TextView vDTeminDosyaNo;
        protected TextView vDTeminIsinTanimi;
        protected TextView vDTeminIsinTuru;
        protected TextView vIhaleKayitNo;
        protected TextView vIhaleTalepEdenBirim;
        protected TextView vIhaleTalepEvrakNo;
        protected TextView vIhaleTalepEvrakTarihi;
        protected TextView vIhaleAlimZamani;
        protected TextView vDTeminIdareAdi;
        protected TextView vDTeminDurumu;
        protected TextView vDTeminGorevli;



        public DirectSupplyFilesViewHolder(View v) {
            super(v);
            vDTeminDosyaNo = (TextView) v.findViewById(R.id.txtIhaleDosyano);
            vDTeminIsinTanimi =(TextView) v.findViewById(R.id.txtIhaleIsinTanimi);
            vDTeminIsinTuru=(TextView) v.findViewById(R.id.txtIhaleIsınTuru);
            vIhaleKayitNo=(TextView) v.findViewById(R.id.txtIhalekayitno);
            vIhaleTalepEdenBirim=(TextView) v.findViewById(R.id.txtIhaleBirim);
            vIhaleTalepEvrakNo= (TextView) v.findViewById(R.id.txtIhaleTalepEvrakno);
            vIhaleTalepEvrakTarihi= (TextView)v.findViewById(R.id.txtIhaleTalepEvraktarihi);
            vIhaleAlimZamani= (TextView) v.findViewById(R.id.txtIhaleDosyano);
            vDTeminIdareAdi= (TextView) v.findViewById(R.id.txtIhaleIdareadı);
            vDTeminDurumu= (TextView) v.findViewById(R.id.txtIhaleAsama);
            vDTeminGorevli= (TextView) v.findViewById(R.id.txtIhaleGorevli);



        }

    }
    
    
    
    
    
}
