package com.kiksoft.yanmenu.ayarlar.baglantiayarlarim;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.kiksoft.kikmobil.R;


public class BaglantiAFragment extends Fragment {

    public BaglantiAFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.connection_settings_fragment, container, false);



        Button btnConnectionSave =(Button) view.findViewById(R.id.btn_save_connectionsettings);
        btnConnectionSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EditText edtIpadress = (EditText) view.findViewById(R.id.txt_connectionsettings_ip);
                EditText edtIpadress2 = (EditText) view.findViewById(R.id.txt_connectionsettings_ip2);
                EditText edtDb = (EditText) view.findViewById(R.id.txt_connectionsettings_db);

                String userIp=edtIpadress.getText().toString();
                String userIp2=edtIpadress2.getText().toString();
                String userDb=edtDb.getText().toString();


                if(userIp==null)

                {
                    edtIpadress.requestFocus();
                    edtIpadress.setError("ip boş geçilemez..");

                    //KullaniciBilgileri.setIpAdress(edtIpadress.getText().toString());
                }





//                if (edtDb!=null)
//                {
//                    KullaniciBilgileri.setUserDb(edtDb.getText().toString());
//
//                }
//
//                 if(edtIpadress2!=null)
//                {
//                    KullaniciBilgileri.setIpAdress2(edtIpadress2.getText().toString());
//
//                }














            }
        });

        return view;

    }




}
