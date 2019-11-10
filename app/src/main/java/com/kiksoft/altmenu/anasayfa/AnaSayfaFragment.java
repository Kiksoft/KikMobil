/*----------------------------------------------------------------------------*/
/* -------------------KIKSOFT: Kik Mobile Uygulaması--------------------------*/
/* ===========================================================================*/
/*Copyright (c) 2019 yılında  Kik Soft Yazılım Departmanı tarafından geliştirilmiştir */
/*----------------------------------------------------------------------------*/

package com.kiksoft.altmenu.anasayfa;

import com.kiksoft.kikmobil.R;
import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.*;
import com.smarteist.autoimageslider.*;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.kiksoft.kikmobil.MainActivity;

/*------------------------------------------------------------------------------------------------------------------------------------------*/
/* AnaSayfaFragment class: Ana Sayfa slayt tasarımını görüntülemek için oluşturulan fragment class */
/* "1-constructor"  */
/* "on createviewHolder metodu":  Bu method fragment oluşturulduğunda oluşturduğumuz AnaSayfaAdapter class ının başlatılması için çağrılır. */
/*-----------------------------------------------------------------------------------------------------------------------------------------*/

public class AnaSayfaFragment extends Fragment {

 private MainActivity mainAnasayfa;
    SliderView sliderviewAnasayfa;


    public AnaSayfaFragment(MainActivity amainAnasayfa)
    {
    this.mainAnasayfa=amainAnasayfa;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.home_slide, container, false);
        final AnaSayfaAdapter adapter = new AnaSayfaAdapter(this.getContext(),this.mainAnasayfa);
       //3 adet slayt olması sağlandı//
        adapter.setCount(3);



        sliderviewAnasayfa=view.findViewById(R.id.imageSlider);
        sliderviewAnasayfa.setSliderAdapter(adapter);
        sliderviewAnasayfa.setAutoCycle(false);
        sliderviewAnasayfa.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderviewAnasayfa.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        sliderviewAnasayfa.setIndicatorSelectedColor(Color.WHITE);
        sliderviewAnasayfa.setIndicatorUnselectedColor(Color.GRAY);
        sliderviewAnasayfa.startAutoCycle();

        sliderviewAnasayfa.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                sliderviewAnasayfa.setCurrentPagePosition(position);
            }
        });

        return view;
    }


}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//        final AnaSayfaAdapter adapter = new AnaSayfaAdapter(this,this);
//        adapter.setCount(3);
//
//
//       sliderView.setSliderAdapter(adapter);
//       sliderView.setAutoCycle(false);
//
//        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
//       sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
//      // sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
//        sliderView.setIndicatorSelectedColor(Color.WHITE);
//        sliderView.setIndicatorUnselectedColor(Color.GRAY);
//       sliderView.startAutoCycle();
//
//       sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
//           @Override
//          public void onIndicatorClicked(int position) {
//               sliderView.setCurrentPagePosition(position);
//            }
//        });