package com.kiksoft.kikservice;
//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.6.2.0
//
// Created by Quasar Development
//
//---------------------------------------------------

import java.util.ArrayList;
import java.util.Hashtable;
import org.ksoap2.serialization.*;

public class NLQDTEMIN_IHALE_LISTESI_GETIRRETURN extends AttributeContainer implements KvmSerializable
{

    public ArrayList<NLQDTEMIN_IHALE_BILGISI > DTEMIN_IHALE_LISTESI=new ArrayList<NLQDTEMIN_IHALE_BILGISI>();

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
        if (info.name.equals("DTEMIN_IHALE_LISTESI"))
        {
            if(obj!=null)
            {
                {
                    if(this.DTEMIN_IHALE_LISTESI==null)
                    {
                        this.DTEMIN_IHALE_LISTESI=new java.util.ArrayList<NLQDTEMIN_IHALE_BILGISI>();
                    }
                    java.lang.Object j = obj;
                    NLQDTEMIN_IHALE_BILGISI nl= (NLQDTEMIN_IHALE_BILGISI)__envelope.get(j,NLQDTEMIN_IHALE_BILGISI.class,false);
                    this.DTEMIN_IHALE_LISTESI.add(nl);

                    return true;
                }



              //  this.DTEMIN_IHALE_LISTESI = (NLQDTEMIN_IHALE_BILGISI)__envelope.get(j,NLQDTEMIN_IHALE_BILGISI.class,false);
            }
            //return true;
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
        if(propertyIndex>=0 && propertyIndex < 0+this.DTEMIN_IHALE_LISTESI.size())
        {
            java.lang.Object DTEMINIHALELISTE = this.DTEMIN_IHALE_LISTESI.get(propertyIndex-(0));
            return DTEMINIHALELISTE!=null?DTEMINIHALELISTE:SoapPrimitive.NullNilElement;
        }
        if(propertyIndex==0+this.DTEMIN_IHALE_LISTESI.size())
        {
            return this.HATAMSG!=null?this.HATAMSG:SoapPrimitive.NullNilElement;
        }
        return null;
    }

//    @Override
//    public java.lang.Object getProperty(int propertyIndex) {
//        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
//        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
//        if(propertyIndex==0)
//        {
//            return this.DTEMIN_IHALE_LISTESI!=null?this.DTEMIN_IHALE_LISTESI:SoapPrimitive.NullNilElement;
//        }
//        if(propertyIndex==1)
//        {
//            return this.HATAMSG!=null?this.HATAMSG:SoapPrimitive.NullNilElement;
//        }
//        return null;
//    }


    @Override
    public int getPropertyCount() {
        return 1+DTEMIN_IHALE_LISTESI.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = NLQDTEMIN_IHALE_BILGISI.class;
            info.name = "DTEMIN_IHALE_LISTESI";
            info.namespace= "";
        }
        if(propertyIndex==1)
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
