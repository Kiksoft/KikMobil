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

public class NLQIS_ARTIS_LISTESI_GETIRRETURN extends AttributeContainer implements KvmSerializable
{
    
    public ArrayList< NLQIS_ARTIS> IS_ARTIS_LISTESI =new ArrayList<NLQIS_ARTIS >();
    
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
        if (info.name.equals("IS_ARTIS_LISTESI"))
        {
            if(obj!=null)
            {
if(this.IS_ARTIS_LISTESI==null)
                {
                    this.IS_ARTIS_LISTESI = new java.util.ArrayList< NLQIS_ARTIS>();
                }
                java.lang.Object j =obj;
                NLQIS_ARTIS j1= (NLQIS_ARTIS)__envelope.get(j,NLQIS_ARTIS.class,false);
                this.IS_ARTIS_LISTESI.add(j1);            }
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
        if(propertyIndex>=0 && propertyIndex < 0+this.IS_ARTIS_LISTESI.size())
        {
                java.lang.Object IS_ARTIS_LISTESI = this.IS_ARTIS_LISTESI.get(propertyIndex-(0));
                return IS_ARTIS_LISTESI!=null?IS_ARTIS_LISTESI:SoapPrimitive.NullNilElement;
        }
        if(propertyIndex==0+this.IS_ARTIS_LISTESI.size())
        {
            return this.HATAMSG!=null?this.HATAMSG:SoapPrimitive.NullNilElement;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 1+IS_ARTIS_LISTESI.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex>=0 && propertyIndex < 0+this.IS_ARTIS_LISTESI.size())
        {
            info.type = NLQIS_ARTIS.class;
            info.name = "IS_ARTIS_LISTESI";
            info.namespace= "";
        }
        if(propertyIndex==0+this.IS_ARTIS_LISTESI.size())
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
