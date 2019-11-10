/*----------------------------------------------------------------------------*/
/* -------------------KIKSOFT: Kik Mobile Uygulaması--------------------------*/
/* ===========================================================================*/
/*Copyright (c) 2019 yılında  Kik Soft Yazılım Departmanı tarafından geliştirilmiştir */
/*----------------------------------------------------------------------------*/

package com.kiksoft.altmenu.anasayfa;

import com.smarteist.autoimageslider.SliderViewAdapter;
import com.bumptech.glide.Glide;
import android.content.Context;
import android.graphics.Color;
import android.view.*;
import android.widget.*;
import androidx.fragment.app.*;
import com.kiksoft.kikmobil.MainActivity;
import com.kiksoft.kikmobil.R;
import com.kiksoft.altmenu.dosyalarim.DosyalarimFragment;
import com.kiksoft.altmenu.onaybekleyenler.OnayBekFragment;

/*------------------------------------------------------------------------------------------------------------------------------------------*/
/* AnaSayfaAdapter class: Ana Sayfada yer aan slayt bilgilerini alabilmek için oluşturulan adapter class */
/* "1-constructor"  */
/* "on createviewHolder metodu":  Bu method adaptör oluşturulduğunda oluşturduğumuz AnaSayfaSlaytArayuzTutucu'nun başlatılması için çağrılır. */
/* "onBindViewHolder metodu":  onCreateViewHolder’dan dönen verileri bağlama işlemini gerçekleştirildiği metottur. */
/*  viewHolder.itemView.setOnClickListener metodu slaytta yer alan textviewlere tıklanıldığında yapılacak işlemlerin tanımlandığı metottur*/
/*-----------------------------------------------------------------------------------------------------------------------------------------*/


public class AnaSayfaAdapter extends  SliderViewAdapter<AnaSayfaAdapter.AnaSayfaSlaytArayuzTutucu>  {



    private Context cAnasayfa;
    private int intCount;
    private MainActivity mainActivity;
    private FragmentManager fmAnasayfaSlayt;
    private Fragment fAnasayfaSlayt;



    public AnaSayfaAdapter(Context acAnasayfa, MainActivity amainActivity) {
        this.cAnasayfa = acAnasayfa;
        this.mainActivity=amainActivity;
    }

    @Override
    public int getCount() {
        //slider arayüzünde dimanik slayt sayısı olması sağlanır
        return intCount;
    }

    public void setCount(int aintCount)
    {
        this.intCount = aintCount;
    }



    @Override
    public AnaSayfaSlaytArayuzTutucu onCreateViewHolder(ViewGroup vgKok) {

        View viewAnaSayfa = LayoutInflater.from(vgKok.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new AnaSayfaSlaytArayuzTutucu(viewAnaSayfa);
    }


    @Override
    public void onBindViewHolder(AnaSayfaSlaytArayuzTutucu viewHolder, final int intPozisyon) {



        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cAnasayfa, "This is item in position " + intPozisyon, Toast.LENGTH_SHORT).show();
            }
        });



        switch (intPozisyon) {
            //ilk slayt "https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"


            case 0:

               viewHolder.vAciklama1.setText("Toplam Görevli Olduğum Dosya " + intPozisyon); //"\n"+"Onayımı Bekleyen Dosya 5"+"\n"+"Günlük İşlem Bekleyenler : 15");
               viewHolder.vAciklama1.setTextSize(16);
               viewHolder.vAciklama1.setTextColor(Color.WHITE);

                viewHolder.vAciklama1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                 fAnasayfaSlayt=new DosyalarimFragment();
                 mainActivity.loadSlideFragment(fAnasayfaSlayt);



                    }
                });


                viewHolder.vAciklama2.setText("Onayımı Bekleyen Dosya " + intPozisyon);
                viewHolder.vAciklama2.setTextSize(16);
                viewHolder.vAciklama2.setTextColor(Color.WHITE);

                viewHolder.vAciklama2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        fAnasayfaSlayt=new OnayBekFragment();
                        mainActivity.loadSlideFragment(fAnasayfaSlayt);

                    }
                });


                viewHolder.vAciklama3.setText("Günlük İşlem Bekleyen Dosya " + intPozisyon);
                viewHolder.vAciklama3.setTextSize(16);
                viewHolder.vAciklama3.setTextColor(Color.WHITE);

                viewHolder.vAciklama3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(cAnasayfa, "3.texte tıkladım " + intPozisyon, Toast.LENGTH_SHORT).show();
                    }
                });


                viewHolder.imageviewIcerik.setVisibility(View.GONE);
               Glide.with(viewHolder.itemView)
                        .load(R.drawable.slider_one)
                        .fitCenter()
                       .into(viewHolder.imageviewArkaplan);
                break;

            case 2:
                viewHolder.vAciklama1.setText("BİZE ULAŞIN ");
                viewHolder.vAciklama1.setClickable(false);
                viewHolder.vAciklama1.setTextSize(16);
                viewHolder.vAciklama1.setTextColor(Color.BLACK);

                viewHolder.vAciklama2.setText("Telefon : " + "+90 (0232) 344 00 05");
                viewHolder.vAciklama2.setTextSize(16);
                viewHolder.vAciklama2.setTextColor(Color.BLACK);

                viewHolder.vAciklama3.setText("Email : " + "destek@kik-soft.net");
                viewHolder.vAciklama3.setTextSize(16);
                viewHolder.vAciklama3.setTextColor(Color.BLACK);



                viewHolder.imageviewIcerik.setVisibility(View.GONE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.sliders_two)
                        .fitCenter()
                        .into(viewHolder.imageviewArkaplan);
                break;
//            case 4:
//                viewHolder.textViewDescription.setText("This is slider item " + position);
//                viewHolder.textViewDescription.setTextSize(16);
//                viewHolder.textViewDescription.setTextColor(Color.WHITE);
//                viewHolder.imageGifContainer.setVisibility(View.GONE);
//                Glide.with(viewHolder.itemView)
//                        .load("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
//                        .fitCenter()
//                        .into(viewHolder.imageViewBackground);
//                break;
            default:
                viewHolder.vAciklama1.setTextSize(16);
                viewHolder.vAciklama1.setTextColor(Color.WHITE);
                viewHolder.vAciklama1.setText("İdare Bütçe Raporu İçin Tıklayın");


                viewHolder.vAciklama1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(cAnasayfa, "İdare Bütçe raporu sayfası açılacak " + intPozisyon, Toast.LENGTH_SHORT).show();
                    }
                });

                viewHolder.imageviewIcerik.setVisibility(View.VISIBLE);
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.sliders_three)
                        .fitCenter()
                        .into(viewHolder.imageviewArkaplan);
                Glide.with(viewHolder.itemView)
                        .asGif()
                        .load(R.drawable.background)
                        .into(viewHolder.imageviewIcerik);
                break;

        }


    }




    public class AnaSayfaSlaytArayuzTutucu extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageviewArkaplan;
        ImageView imageviewIcerik;
        TextView vAciklama1;
        TextView vAciklama2;
        TextView vAciklama3;



        public AnaSayfaSlaytArayuzTutucu(View itemView) {
            super(itemView);
            imageviewArkaplan = itemView.findViewById(R.id.iv_auto_image_slider);
            imageviewIcerik = itemView.findViewById(R.id.iv_gif_container);
            vAciklama1 = itemView.findViewById(R.id.tv_auto_image_slider);
            vAciklama2=itemView.findViewById(R.id.tv_auto_image_slider2);
            vAciklama3=itemView.findViewById(R.id.tv_auto_image_slider3);
            this.itemView = itemView;

        }

    }

}
