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

public class NLQKALEM extends AttributeContainer implements KvmSerializable
{
    
    public String KODU;
    
    public String ADI;
    
    public String ALIM_MIKTARI;
    
    public String SIPARIS_MIKTARI;
    
    public String IS_ARTIS_MIKTARI;
    
    public String MUAYENE_MIKTARI;
    
    public String BIRIMI;
    
    public String BIRIM_FIYAT;
        
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
        if (info.name.equals("KODU"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.KODU = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.KODU = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("ADI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.ADI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.ADI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("ALIM_MIKTARI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.ALIM_MIKTARI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.ALIM_MIKTARI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("SIPARIS_MIKTARI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.SIPARIS_MIKTARI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.SIPARIS_MIKTARI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("IS_ARTIS_MIKTARI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.IS_ARTIS_MIKTARI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.IS_ARTIS_MIKTARI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("MUAYENE_MIKTARI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.MUAYENE_MIKTARI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.MUAYENE_MIKTARI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("BIRIMI"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.BIRIMI = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.BIRIMI = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("BIRIM_FIYAT"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.BIRIM_FIYAT = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.BIRIM_FIYAT = (String)obj;
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
            return KODU;
        }
        if(propertyIndex==1)
        {
            return ADI;
        }
        if(propertyIndex==2)
        {
            return ALIM_MIKTARI;
        }
        if(propertyIndex==3)
        {
            return SIPARIS_MIKTARI;
        }
        if(propertyIndex==4)
        {
            return IS_ARTIS_MIKTARI;
        }
        if(propertyIndex==5)
        {
            return MUAYENE_MIKTARI;
        }
        if(propertyIndex==6)
        {
            return BIRIMI;
        }
        if(propertyIndex==7)
        {
            return BIRIM_FIYAT;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 8;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "KODU";
            info.namespace= "";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "ADI";
            info.namespace= "";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "ALIM_MIKTARI";
            info.namespace= "";
        }
        if(propertyIndex==3)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "SIPARIS_MIKTARI";
            info.namespace= "";
        }
        if(propertyIndex==4)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "IS_ARTIS_MIKTARI";
            info.namespace= "";
        }
        if(propertyIndex==5)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "MUAYENE_MIKTARI";
            info.namespace= "";
        }
        if(propertyIndex==6)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "BIRIMI";
            info.namespace= "";
        }
        if(propertyIndex==7)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "BIRIM_FIYAT";
            info.namespace= "";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
