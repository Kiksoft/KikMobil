/*----------------------------------------------------------------------------*/
/* -------------------KIKSOFT: Kik Mobile Uygulaması--------------------------*/
/* ===========================================================================*/
/*Copyright (c) 2019 yılında Kik Soft Yazılım Departmanı tarafından geliştirilmiştir */
/*----------------------------------------------------------------------------*/

package com.kiksoft.sistemegiris;
import android.app.Application;

/*------------------------------------------------------------------------------------------------------------------------------------------*/
/* KullaniciBilgileri class: Sisteme giriş yapacak kullanıcı bilgilerinin tanımladığı class */
/* "1-constructor"  */
/* Singleton patterni kullanılmıştır*/
/*-----------------------------------------------------------------------------------------------------------------------------------------*/

public class KullaniciBilgileri extends Application {


    private static KullaniciBilgileri singleton=new KullaniciBilgileri();
    static String strKullaniciAdi;
    static String strSifre;
    static String strIpAdresi;
    static String strIpAdresi2;

    static String strVeriTabani;



    public static KullaniciBilgileri getInstance() {
        return singleton;
    }


    private KullaniciBilgileri() {};

    public static String getUserName() {
        return strKullaniciAdi;
    }

    public static void setUserName(String name) {
        strKullaniciAdi = name;
    }



     public static String getPassword() {
        return strSifre;
    }

    public static void setPassword(String pass)
    {
        strSifre=pass;
    }

    public static String getIpAdress() {
        return strIpAdresi;
    }

    public static void setIpAdress(String ip)
    {
        strIpAdresi=ip;
    }

    public static String getIpAdress2() {
        return strIpAdresi2;
    }

    public static void setIpAdress2(String ip2)
    {
        strIpAdresi2=ip2;
    }

    public static String getUserDb() {
       return strVeriTabani;
    }

    public static void setUserDb(String db)
    {
        strVeriTabani=db;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }

}
