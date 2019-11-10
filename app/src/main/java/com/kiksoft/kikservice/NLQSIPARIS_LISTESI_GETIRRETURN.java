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
import java.util.ArrayList;
import org.ksoap2.serialization.PropertyInfo;

public class NLQSIPARIS_LISTESI_GETIRRETURN extends AttributeContainer implements KvmSerializable
{
    
    public ArrayList< NLQSIPARIS_BILGISI> SIPARIS_LISTESI =new ArrayList<NLQSIPARIS_BILGISI >();
    
    public NLQHATA HATAMSG;
        
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
        if (info.name.equals("SIPARIS_LISTESI"))
        {
            if(obj!=null)
            {
if(this.SIPARIS_LISTESI==null)
                {
                    this.SIPARIS_LISTESI = new java.util.ArrayList< NLQSIPARIS_BILGISI>();
                }
                java.lang.Object j =obj;
                NLQSIPARIS_BILGISI j1= (NLQSIPARIS_BILGISI)__envelope.get(j,NLQSIPARIS_BILGISI.class,false);
                this.SIPARIS_LISTESI.add(j1);            }
            return true;
        }
        if (info.name.equals("HATAMSG"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.HATAMSG = (NLQHATA)__envelope.get(j,NLQHATA.class,false);
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
        if(propertyIndex>=0 && propertyIndex < 0+this.SIPARIS_LISTESI.size())
        {
                java.lang.Object SIPARIS_LISTESI = this.SIPARIS_LISTESI.get(propertyIndex-(0));
                return SIPARIS_LISTESI!=null?SIPARIS_LISTESI:SoapPrimitive.NullNilElement;
        }
        if(propertyIndex==0+this.SIPARIS_LISTESI.size())
        {
            return this.HATAMSG!=null?this.HATAMSG:SoapPrimitive.NullNilElement;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 1+SIPARIS_LISTESI.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex>=0 && propertyIndex < 0+this.SIPARIS_LISTESI.size())
        {
            info.type = NLQSIPARIS_BILGISI.class;
            info.name = "SIPARIS_LISTESI";
            info.namespace= "";
        }
        if(propertyIndex==0+this.SIPARIS_LISTESI.size())
        {
            info.type = NLQHATA.class;
            info.name = "HATAMSG";
            info.namespace= "";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}