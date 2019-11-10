package com.kiksoft.kikservice;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.6.2.0
//
// Created by Quasar Development 
//
//---------------------------------------------------



import java.util.Hashtable;
import org.ksoap2.serialization.*;

public class NLQTUM_DOSYALARI_GETIR_SORGUSU extends AttributeContainer implements KvmSerializable
{
    
    public String ARAMA_METNI;
    
    public String FORM_ADI;
    
    public String IDARENIN_ADI;
    
    public String DOSYA_NUMARASI;
    
    public String ISIN_TANIMI;
    
    public String ALIM_BASLANGIC_TARIHI;
    
    public String ALIM_BITIS_TARIHI;
    
    public String ALIM_USULU;
    
    public String SOZLESME_BASLANGIC_TARIHI;
    
    public String SOZLESME_BITIS_TARIHI;
    
    public String TALEP_EVRAK_TARIHI;
    
    public String FIRMA_ADI;
    
    public String GOREVLI;
    
    public String IHALE_KAYIT_NUMARASI;
    
    public String ISIN_TURU;
        
    private transient java.lang.Object __source;    
    

    
    
    public void loadFromSoap(java.lang.Object paramObj,NLQExtendedSoapSerializationEnvelope __envelope)
    {
        if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;
        __source=inObj; 
        
        if(inObj instanceof SoapObject)
        {
            SoapObject soapObject=(SoapObject)inObj;
            int size = soapObject.getPropertyCount();
            for (int i0=0;i0< size;i0++)
            {
                PropertyInfo info=soapObject.getPropertyInfo(i0);
                if(!loadProperty(info,soapObject,__envelope))
                {
                }
            } 
        }



    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,NLQExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("ARAMA_METNI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.ARAMA_METNI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.ARAMA_METNI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("FORM_ADI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.FORM_ADI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.FORM_ADI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("IDARENIN_ADI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.IDARENIN_ADI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.IDARENIN_ADI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("DOSYA_NUMARASI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.DOSYA_NUMARASI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.DOSYA_NUMARASI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("ISIN_TANIMI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.ISIN_TANIMI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.ISIN_TANIMI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("ALIM_BASLANGIC_TARIHI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.ALIM_BASLANGIC_TARIHI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.ALIM_BASLANGIC_TARIHI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("ALIM_BITIS_TARIHI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.ALIM_BITIS_TARIHI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.ALIM_BITIS_TARIHI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("ALIM_USULU"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.ALIM_USULU = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.ALIM_USULU = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("SOZLESME_BASLANGIC_TARIHI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.SOZLESME_BASLANGIC_TARIHI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.SOZLESME_BASLANGIC_TARIHI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("SOZLESME_BITIS_TARIHI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.SOZLESME_BITIS_TARIHI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.SOZLESME_BITIS_TARIHI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("TALEP_EVRAK_TARIHI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.TALEP_EVRAK_TARIHI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.TALEP_EVRAK_TARIHI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("FIRMA_ADI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.FIRMA_ADI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.FIRMA_ADI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("GOREVLI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.GOREVLI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.GOREVLI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("IHALE_KAYIT_NUMARASI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.IHALE_KAYIT_NUMARASI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.IHALE_KAYIT_NUMARASI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("ISIN_TURU"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.ISIN_TURU = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.ISIN_TURU = (String)obj;
                }
            }
            return true;
        }
        return false;
    }
    
    public java.lang.Object getOriginalXmlSource()
    {
        return __source;
    }    
    

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return ARAMA_METNI;
        }
        if(propertyIndex==1)
        {
            return FORM_ADI;
        }
        if(propertyIndex==2)
        {
            return IDARENIN_ADI;
        }
        if(propertyIndex==3)
        {
            return DOSYA_NUMARASI;
        }
        if(propertyIndex==4)
        {
            return ISIN_TANIMI;
        }
        if(propertyIndex==5)
        {
            return ALIM_BASLANGIC_TARIHI;
        }
        if(propertyIndex==6)
        {
            return ALIM_BITIS_TARIHI;
        }
        if(propertyIndex==7)
        {
            return ALIM_USULU;
        }
        if(propertyIndex==8)
        {
            return SOZLESME_BASLANGIC_TARIHI;
        }
        if(propertyIndex==9)
        {
            return SOZLESME_BITIS_TARIHI;
        }
        if(propertyIndex==10)
        {
            return TALEP_EVRAK_TARIHI;
        }
        if(propertyIndex==11)
        {
            return FIRMA_ADI;
        }
        if(propertyIndex==12)
        {
            return GOREVLI;
        }
        if(propertyIndex==13)
        {
            return IHALE_KAYIT_NUMARASI;
        }
        if(propertyIndex==14)
        {
            return ISIN_TURU;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 15;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "ARAMA_METNI";
            info.namespace= "";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "FORM_ADI";
            info.namespace= "";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "IDARENIN_ADI";
            info.namespace= "";
        }
        if(propertyIndex==3)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "DOSYA_NUMARASI";
            info.namespace= "";
        }
        if(propertyIndex==4)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "ISIN_TANIMI";
            info.namespace= "";
        }
        if(propertyIndex==5)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "ALIM_BASLANGIC_TARIHI";
            info.namespace= "";
        }
        if(propertyIndex==6)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "ALIM_BITIS_TARIHI";
            info.namespace= "";
        }
        if(propertyIndex==7)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "ALIM_USULU";
            info.namespace= "";
        }
        if(propertyIndex==8)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "SOZLESME_BASLANGIC_TARIHI";
            info.namespace= "";
        }
        if(propertyIndex==9)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "SOZLESME_BITIS_TARIHI";
            info.namespace= "";
        }
        if(propertyIndex==10)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "TALEP_EVRAK_TARIHI";
            info.namespace= "";
        }
        if(propertyIndex==11)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "FIRMA_ADI";
            info.namespace= "";
        }
        if(propertyIndex==12)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "GOREVLI";
            info.namespace= "";
        }
        if(propertyIndex==13)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "IHALE_KAYIT_NUMARASI";
            info.namespace= "";
        }
        if(propertyIndex==14)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "ISIN_TURU";
            info.namespace= "";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
