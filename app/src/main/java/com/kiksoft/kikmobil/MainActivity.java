package com.kiksoft.kikmobil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;


import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kiksoft.kikmobil.menutasarimi.ExpandableListAdapter;
import com.kiksoft.yanmenu.ayarlar.hesapayarlarim.HesapAFragment;
import com.kiksoft.yanmenu.islemler.tumdosyalar.TumListeFragment;
import com.kiksoft.yanmenu.ayarlar.baglantiayarlarim.BaglantiAFragment;
import com.kiksoft.kikmobil.menutasarimi.MenuModel;
import com.kiksoft.yanmenu.islemler.talep.TalepListeFragment;
import com.kiksoft.yanmenu.islemler.dogrudantemin.DTeminListeFragment;
import com.kiksoft.altmenu.anasayfa.AnaSayfaFragment;


public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    public FragmentManager fragmentManager;

    private Fragment homeFragment;
    public DrawerLayout drawer;
    public ActionBarDrawerToggle toggle;

    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();



    public boolean loadSlideFragment(Fragment fragment) {
        {
            if (fragment != null) {
                fragmentManager=getSupportFragmentManager();
                FragmentTransaction transaction_slide = fragmentManager.beginTransaction();
                transaction_slide.replace(R.id.id_container, fragment);
                transaction_slide.commit();

                return true;
            }
            return false;
        }
    }
    public boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            fragmentManager=getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.id_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
            return true;
        }
        return false;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        expandableListView = findViewById(R.id.expandableListView);
        prepareMenuData();
        populateExpandableList();

        drawer = findViewById(R.id.drawer_layout2);


        homeFragment = new AnaSayfaFragment(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.id_container, homeFragment).commit();

        BottomNavigationView btm=findViewById(R.id.btmnav);

        NavigationView navigationView = findViewById(R.id.nav_view);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);



        BottomNavigationView.OnNavigationItemSelectedListener btmlist=new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id==R.id.anasayfa)
                {
                    Toast.makeText(getApplicationContext(),"ana sayfa tıklandı",Toast.LENGTH_SHORT).show();}
                else if (id==R.id.onaybekleyen)
                {Toast.makeText(getApplicationContext(),"onay bekleyen tıklandı",Toast.LENGTH_SHORT).show();}
                else if( id==R.id.dosyalarım)
                {Toast.makeText(getApplicationContext(),"dosyalarım tıklandı",Toast.LENGTH_SHORT).show();}
                else if(id==R.id.duyuru)
                {Toast.makeText(getApplicationContext(),"duyuru tıklandı",Toast.LENGTH_SHORT).show();}


                return true;
            }



        };

        btm.setOnNavigationItemSelectedListener(btmlist);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout2);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();




        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {

            Toast.makeText(getApplicationContext(),"çıkışa tıklandı",Toast.LENGTH_SHORT).show();
            return true;
        }





        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


//        if (id == R.id.nav_ıslemler) {
//
//        } else if (id == R.id.nav_dıger_ıslemler) {
//
//        } else if (id == R.id.nav_raporlar) {
//
//        } else if (id == R.id.nav_ayarlarım) {
//
//        } else if (id == R.id.nav_yardım) {
//
//        }



        DrawerLayout drawer = findViewById(R.id.drawer_layout2);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    private void prepareMenuData() {


        MenuModel menuModel=new MenuModel("İşlemler",true,true);
        headerList.add(menuModel);

        List<MenuModel> childModelsList = new ArrayList<>();
        MenuModel childModel = new MenuModel("Onaya Gönderilenler", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("Tüm Dosyalar", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("Talepler", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("Doğrudan Teminler", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("İhaleler", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("Sözleşmeler", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            Log.d("API123","here");
            childList.put(menuModel, childModelsList);
        }

        childModelsList = new ArrayList<>();
        menuModel = new MenuModel("Diğer", true, true); //Menu of Python Tutorials
        headerList.add(menuModel);
       childModel = new MenuModel("İş Artış Eksilişler", false, false );
        childModelsList.add(childModel);

        childModel = new MenuModel("Ürüne Göre Eski Alımlar", false, false);
         childModelsList.add(childModel);

        childModel = new MenuModel("ÜFE ile Tutar Güncelleme", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("Hatırlatmalar", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelsList);
       }

        childModelsList = new ArrayList<>();
        menuModel = new MenuModel("Ayarlar", true, true); //Menu of Python Tutorials
        headerList.add(menuModel);
        childModel = new MenuModel("Bağlantı Ayarlarım", false, false );
        childModelsList.add(childModel);

        childModel = new MenuModel("Bildirimler", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("Güvenlik-Şifre İşlemleri", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("Hesap Ayarları", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelsList);
        }

        menuModel = new MenuModel("Yardım", true, false); //Menu of Python Tutorials
        headerList.add(menuModel);

        if(!menuModel.hasChildren)
        {
            childList.put(menuModel, null);
        }

    }


    private void populateExpandableList() {

        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

             if (headerList.get(groupPosition).isGroup) {
                    if (!headerList.get(groupPosition).hasChildren) {
        ///not: yani artık İşlemler-Tüm Dosyalar butonuna bastık . burada fragmenti yeni pencereyi çağıracaksın!!!! fragment bak
                    }
               }

                return false;
           }
        });

       expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
          public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (childList.get(headerList.get(groupPosition)) != null) {
                    MenuModel model = childList.get(headerList.get(groupPosition)).get(childPosition);
                   switch(model.menuName)
                   {
                       case "Onaya Gönderilenler" :
                           Toast.makeText(getApplicationContext(),"onaya gönd sayfa tıklandı",Toast.LENGTH_SHORT).show();

                           break;


                       case "Bağlantı Ayarlarım" :
                           Toast.makeText(getApplicationContext(),"bağlantı ayarlarım here we go ",Toast.LENGTH_SHORT).show();
                           homeFragment = new BaglantiAFragment();
                           loadSlideFragment(homeFragment);

                               break;

                       case "Güvenlik-Şifre İşlemleri":

                           homeFragment = new HesapAFragment();
                           loadSlideFragment(homeFragment);


                           break;

                       case "Tüm Dosyalar" :
                           homeFragment = new TumListeFragment();
                           loadFragment(homeFragment);

                           break;

                       case "Talepler" :

                           homeFragment = new TalepListeFragment(fragmentManager);
                           loadFragment(homeFragment);
//                           fragmentManager = getSupportFragmentManager();
//                           fragmentTransaction3 = fragmentManager.beginTransaction();
//                           fragmentTransaction3.replace(R.id.id_container, homeFragment);
//                           fragmentTransaction3.addToBackStack(null);
//                           fragmentTransaction3.commit();


                           break;

                       case "Doğrudan Teminler" :
                           homeFragment = new DTeminListeFragment();
                           loadFragment(homeFragment);


                           break;


                   }
                }
                    //Toast.makeText(getApplicationContext(),model.menuName,Toast.LENGTH_SHORT).show();


                    onBackPressed();



               return false;
           }
        });
    }



}



//*******************************BELKİ LAZIM OLUR***************************************************////////////////////////////////////
// ----------------------------   on create metodunun içine yazılırsa menüden bir şey seçince navigation menüsünu kapatıyor--------------////
//    getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
//        @Override
//        public void onBackStackChanged() {
//            if(getSupportFragmentManager().getBackStackEntryCount() == 0){
//                drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
//                toggle.setDrawerIndicatorEnabled(true);
//            }else{
//                drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
//                toggle.setDrawerIndicatorEnabled(false);
//
//            }
//        }
//    });