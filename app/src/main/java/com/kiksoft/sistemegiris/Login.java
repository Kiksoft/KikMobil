package com.kiksoft.sistemegiris;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kiksoft.kikmobil.MainActivity;
import com.kiksoft.kikmobil.R;
import com.kiksoft.kikservice.NLQDominoSoapBinding;
import com.kiksoft.kikservice.NLQKULLANICI_DOGRULAMARETURN;

public class Login extends AppCompatActivity {
    String result;
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

//        Spinner myspinner = (Spinner) findViewById(R.id.ip);
//        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(Login.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ips));
//        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        myspinner.setAdapter(myadapter);
//
//        Spinner myspinner2 = (Spinner) findViewById(R.id.database);
//        ArrayAdapter<String> myadapter2 = new ArrayAdapter<String>(Login.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.veri));
//        myadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        myspinner2.setAdapter(myadapter2);


        Button btnLogin =(Button) findViewById(R.id.loginbtn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        EditText edtUsername = (EditText) findViewById(R.id.username);
        KullaniciBilgileri.setUserName(edtUsername.getText().toString());
        String userName = KullaniciBilgileri.getUserName() ;

        EditText edtPass = (EditText) findViewById(R.id.passwrd);
        KullaniciBilgileri.setPassword(edtPass.getText().toString());
        String pass = KullaniciBilgileri.getPassword();


        AutoCompleteTextView actIp = (AutoCompleteTextView) findViewById(R.id.ipadresi);
        KullaniciBilgileri.setIpAdress(actIp.getText().toString());

        AutoCompleteTextView actDb = (AutoCompleteTextView) findViewById(R.id.uygulamayili);
        KullaniciBilgileri.setUserDb(actDb.getText().toString());


//        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocomplete_country);
//        String[] countries = getResources().getStringArray(R.array.countries_array);
//        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
//        textView.setAdapter(adapter);

        try {
            NLQDominoSoapBinding wbo = new NLQDominoSoapBinding();
            NLQKULLANICI_DOGRULAMARETURN ret= wbo.KULLANICI_DOGRULAMA(userName);

            result = ret.FULLNAME;

            if(result!=null) {

                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this, MainActivity.class);
                intent.putExtra("result", result);
                Login.this.startActivity(intent);

            }

        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

//        if (userName.equals("yagmur")) {
//            Intent intent = new Intent(Login.this, MainActivity.class);
//            intent.putExtra("result", result);
//            Login.this.startActivity(intent);
//        }


    }
});



    }
}



