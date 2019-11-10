/*----------------------------------------------------------------------------*/
/* -------------------KIKSOFT: Kik Mobile Uygulaması--------------------------*/
/* ===========================================================================*/
/*Copyright (c) 2019 yılında  Kik Soft Yazılım Departmanı tarafından geliştirilmiştir */
/*----------------------------------------------------------------------------*/

package com.kiksoft.kikservice;

import com.kiksoft.sistemegiris.KullaniciBilgileri;

import org.ksoap2.HeaderProperty;
import org.ksoap2.serialization.*;
import java.util.ArrayList;
import java.util.List;


/*------------------------------------------------------------------------------------------------------------------------------------------*/
/*  NLQDominoSoapBindinclass: easywsdl uygulamasından üretilmiştir */
/* web servisle bağlantı kuran sınıftır.*/
/*-----------------------------------------------------------------------------------------------------------------------------------------*/

public class NLQDominoSoapBinding
{
    interface NLQIWcfMethod
    {
        NLQExtendedSoapSerializationEnvelope CreateSoapEnvelope() throws Exception;

        Object ProcessResult(NLQExtendedSoapSerializationEnvelope __envelope, Object result) throws Exception;
    }


    String strURL="http://"+ KullaniciBilgileri.getIpAdress()+"/"+ KullaniciBilgileri.getUserDb()+"/Mobile_KIK?OpenWebService";
   // String url="http://www.kikdestek.com:80/kik/kik5000.nsf/Mobile_KIK?OpenWebService";

    int timeOut=60000;
    public List< HeaderProperty> listHttpHeaders= new ArrayList< HeaderProperty>();
    public boolean enableLogging;

    NLQIServiceEvents callback;
    String login;
    String log= KullaniciBilgileri.getUserName()+":"+ KullaniciBilgileri.getPassword();

    public NLQDominoSoapBinding()
    {
        try
        {
            login= new String(log.getBytes("UTF-8"), "WINDOWS-1254");
        }
        catch (Exception exception)
        {

        }
        listHttpHeaders.add(new HeaderProperty("Authorization", "Basic " + org.kobjects.base64.Base64.encode(log.getBytes())));
        // httpHeaders.add(new HeaderProperty("Authorization", "Basic " + org.kobjects.base64.Base64.encode("hasan:@hasan1515".getBytes())));
    }

    public NLQDominoSoapBinding (NLQIServiceEvents callback)
    {
        this.callback = callback;
        listHttpHeaders.add(new HeaderProperty("Authorization", "Basic " + org.kobjects.base64.Base64.encode(login.getBytes())));
        //httpHeaders.add(new HeaderProperty("Authorization", "Basic " + org.kobjects.base64.Base64.encode("hasan:@hasan1515".getBytes())));
    }
    public NLQDominoSoapBinding(NLQIServiceEvents callback,String url)
    {
        this.callback = callback;
        this.strURL = url;
        listHttpHeaders.add(new HeaderProperty("Authorization", "Basic " + org.kobjects.base64.Base64.encode(login.getBytes())));
        //httpHeaders.add(new HeaderProperty("Authorization", "Basic " + org.kobjects.base64.Base64.encode("hasan:@hasan1515".getBytes())));
    }

    public NLQDominoSoapBinding(NLQIServiceEvents callback,String url,int timeOut)
    {
        this.callback = callback;
        this.strURL = url;
        this.timeOut=timeOut;
        listHttpHeaders.add(new HeaderProperty("Authorization", "Basic " + org.kobjects.base64.Base64.encode(login.getBytes())));
        //httpHeaders.add(new HeaderProperty("Authorization", "Basic " + org.kobjects.base64.Base64.encode("hasan:@hasan1515".getBytes())));
    }

    protected org.ksoap2.transport.Transport createTransport()
    {
        try
        {
            java.net.URI uri = new java.net.URI(strURL);
            if(uri.getScheme().equalsIgnoreCase("https"))
            {
                int port=uri.getPort()>0?uri.getPort():443;
                return new com.easywsdl.exksoap2.transport.AdvancedHttpsTransportSE(uri.getHost(), port, uri.getPath(), timeOut);
            }
            else
            {
                return new com.easywsdl.exksoap2.transport.AdvancedHttpTransportSE(strURL,timeOut);
            }

        }
        catch (java.net.URISyntaxException e)
        {
        }
        return null;
    }

    protected NLQExtendedSoapSerializationEnvelope createEnvelope()
    {
        NLQExtendedSoapSerializationEnvelope envelope= new NLQExtendedSoapSerializationEnvelope(NLQExtendedSoapSerializationEnvelope.VER11);
            return envelope;
    }

    protected java.util.List sendRequest(String methodName,NLQExtendedSoapSerializationEnvelope envelope,org.ksoap2.transport.Transport transport ,com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile profile )throws java.lang.Exception
    {
        if(transport instanceof com.easywsdl.exksoap2.transport.AdvancedHttpTransportSE )
        {
            return ((com.easywsdl.exksoap2.transport.AdvancedHttpTransportSE)transport).call(methodName, envelope,listHttpHeaders,null,profile);
        }
        else
        {
            return ((com.easywsdl.exksoap2.transport.AdvancedHttpsTransportSE)transport).call(methodName, envelope,listHttpHeaders,null,profile);
        }
    }

    java.lang.Object getResult(java.lang.Class destObj,java.lang.Object source,String resultName,NLQExtendedSoapSerializationEnvelope __envelope) throws java.lang.Exception
    {
        if(source==null)
        {
            return null;
        }
        if(source instanceof SoapPrimitive)
        {
            SoapPrimitive soap =(SoapPrimitive)source;
            if(soap.getName().equals(resultName))
            {
                java.lang.Object instance=__envelope.get(source,destObj,false);
                return instance;
            }
        }
        else
        {
            SoapObject soap = (SoapObject)source;
            if (soap.hasProperty(resultName))
            {
                java.lang.Object j=soap.getProperty(resultName);
                if(j==null)
                {
                    return null;
                }
                java.lang.Object instance=__envelope.get(j,destObj,false);
                return instance;
            }
            else if( soap.getName().equals(resultName)) 
            {
                java.lang.Object instance=__envelope.get(source,destObj,false);
                return instance;
            }
        }

        return null;
    }

    
    public NLQKULLANICI_DOGRULAMARETURN KULLANICI_DOGRULAMA(final String USERNAME ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (NLQKULLANICI_DOGRULAMARETURN)execute(new NLQIWcfMethod()
        {
            @Override
            public NLQExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                NLQExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn:DefaultNamespace", "KULLANICI_DOGRULAMA");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="USERNAME";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(USERNAME);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(NLQExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (NLQKULLANICI_DOGRULAMARETURN)getResult(NLQKULLANICI_DOGRULAMARETURN.class,__result,"KULLANICI_DOGRULAMAReturn",__envelope);
            }
        },"KULLANICI_DOGRULAMA",__profile);
    }
    
    public android.os.AsyncTask< Void, Void, NLQOperationResult< NLQKULLANICI_DOGRULAMARETURN>> KULLANICI_DOGRULAMAAsync(final String USERNAME)
    {
        return executeAsync(new NLQFunctions.IFunc< NLQKULLANICI_DOGRULAMARETURN>() {
            public NLQKULLANICI_DOGRULAMARETURN Func() throws java.lang.Exception {
                return KULLANICI_DOGRULAMA( USERNAME);
            }
        },"KULLANICI_DOGRULAMA");
    }
    
    public NLQTUM_DOSYA_LISTESI_GETIRRETURN TUM_DOSYA_LISTESI_GETIR(final NLQTUM_DOSYALARI_GETIR_SORGUSU REQ ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (NLQTUM_DOSYA_LISTESI_GETIRRETURN)execute(new NLQIWcfMethod()
        {
            @Override
            public NLQExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                NLQExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("","REQ",new NLQTUM_DOSYALARI_GETIR_SORGUSU().getClass());
                SoapObject __soapReq = new SoapObject("urn:DefaultNamespace", "TUM_DOSYA_LISTESI_GETIR");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="REQ";
                __info.type=NLQTUM_DOSYALARI_GETIR_SORGUSU.class;
                __info.setValue(REQ);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(NLQExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (NLQTUM_DOSYA_LISTESI_GETIRRETURN)getResult(NLQTUM_DOSYA_LISTESI_GETIRRETURN.class,__result,"TUM_DOSYA_LISTESI_GETIRReturn",__envelope);
            }
        },"TUM_DOSYA_LISTESI_GETIR",__profile);
    }
    
    public android.os.AsyncTask< Void, Void, NLQOperationResult< NLQTUM_DOSYA_LISTESI_GETIRRETURN>> TUM_DOSYA_LISTESI_GETIRAsync(final NLQTUM_DOSYALARI_GETIR_SORGUSU REQ)
    {
        return executeAsync(new NLQFunctions.IFunc< NLQTUM_DOSYA_LISTESI_GETIRRETURN>() {
            public NLQTUM_DOSYA_LISTESI_GETIRRETURN Func() throws java.lang.Exception {
                return TUM_DOSYA_LISTESI_GETIR( REQ);
            }
        },"TUM_DOSYA_LISTESI_GETIR");
    }
    
    public NLQTALEP_LISTESI_GETIRRETURN TALEP_LISTESI_GETIR(final String ARAMA_METNI ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (NLQTALEP_LISTESI_GETIRRETURN)execute(new NLQIWcfMethod()
        {
            @Override
            public NLQExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                NLQExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn:DefaultNamespace", "TALEP_LISTESI_GETIR");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="ARAMA_METNI";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(ARAMA_METNI);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(NLQExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (NLQTALEP_LISTESI_GETIRRETURN)getResult(NLQTALEP_LISTESI_GETIRRETURN.class,__result,"TALEP_LISTESI_GETIRReturn",__envelope);
            }
        },"TALEP_LISTESI_GETIR",__profile);
    }
    
    public android.os.AsyncTask< Void, Void, NLQOperationResult< NLQTALEP_LISTESI_GETIRRETURN>> TALEP_LISTESI_GETIRAsync(final String ARAMA_METNI)
    {
        return executeAsync(new NLQFunctions.IFunc< NLQTALEP_LISTESI_GETIRRETURN>() {
            public NLQTALEP_LISTESI_GETIRRETURN Func() throws java.lang.Exception {
                return TALEP_LISTESI_GETIR( ARAMA_METNI);
            }
        },"TALEP_LISTESI_GETIR");
    }
    
    public NLQTALEP_ISLEMIRETURN TALEP_BOL(final NLQTALEP_BOLREQUEST REQ ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (NLQTALEP_ISLEMIRETURN)execute(new NLQIWcfMethod()
        {
            @Override
            public NLQExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                NLQExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("","REQ",new NLQTALEP_BOLREQUEST().getClass());
                SoapObject __soapReq = new SoapObject("urn:DefaultNamespace", "TALEP_BOL");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="REQ";
                __info.type=NLQTALEP_BOLREQUEST.class;
                __info.setValue(REQ);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(NLQExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (NLQTALEP_ISLEMIRETURN)getResult(NLQTALEP_ISLEMIRETURN.class,__result,"TALEP_BOLReturn",__envelope);
            }
        },"TALEP_BOL",__profile);
    }
    
    public android.os.AsyncTask< Void, Void, NLQOperationResult< NLQTALEP_ISLEMIRETURN>> TALEP_BOLAsync(final NLQTALEP_BOLREQUEST REQ)
    {
        return executeAsync(new NLQFunctions.IFunc< NLQTALEP_ISLEMIRETURN>() {
            public NLQTALEP_ISLEMIRETURN Func() throws java.lang.Exception {
                return TALEP_BOL( REQ);
            }
        },"TALEP_BOL");
    }
    
    public NLQTALEP_ISLEMIRETURN TALEP_KALEMINI_BOL(final String BOLUNECEK_KALEM_DOKUMANID,final Integer BOLUNECEK_MIKTAR ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (NLQTALEP_ISLEMIRETURN)execute(new NLQIWcfMethod()
        {
            @Override
            public NLQExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                NLQExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn:DefaultNamespace", "TALEP_KALEMINI_BOL");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="BOLUNECEK_KALEM_DOKUMANID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(BOLUNECEK_KALEM_DOKUMANID);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="BOLUNECEK_MIKTAR";
                __info.type=PropertyInfo.INTEGER_CLASS;
                __info.setValue(BOLUNECEK_MIKTAR);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(NLQExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (NLQTALEP_ISLEMIRETURN)getResult(NLQTALEP_ISLEMIRETURN.class,__result,"TALEP_KALEMINI_BOLReturn",__envelope);
            }
        },"TALEP_KALEMINI_BOL",__profile);
    }
    
    public android.os.AsyncTask< Void, Void, NLQOperationResult< NLQTALEP_ISLEMIRETURN>> TALEP_KALEMINI_BOLAsync(final String BOLUNECEK_KALEM_DOKUMANID,final Integer BOLUNECEK_MIKTAR)
    {
        return executeAsync(new NLQFunctions.IFunc< NLQTALEP_ISLEMIRETURN>() {
            public NLQTALEP_ISLEMIRETURN Func() throws java.lang.Exception {
                return TALEP_KALEMINI_BOL( BOLUNECEK_KALEM_DOKUMANID,BOLUNECEK_MIKTAR);
            }
        },"TALEP_KALEMINI_BOL");
    }
    
    public NLQTALEP_ISLEMIRETURN TALEP_KALEM_ALIM_YAPILACAK(final NLQTALEP_KALEM_ALIM_YAPILACAKREQUEST REQ ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (NLQTALEP_ISLEMIRETURN)execute(new NLQIWcfMethod()
        {
            @Override
            public NLQExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                NLQExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("","REQ",new NLQTALEP_KALEM_ALIM_YAPILACAKREQUEST().getClass());
                SoapObject __soapReq = new SoapObject("urn:DefaultNamespace", "TALEP_KALEM_ALIM_YAPILACAK");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="REQ";
                __info.type=PropertyInfo.VECTOR_CLASS;
                __info.setValue(REQ);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(NLQExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (NLQTALEP_ISLEMIRETURN)getResult(NLQTALEP_ISLEMIRETURN.class,__result,"TALEP_KALEM_ALIM_YAPILACAKReturn",__envelope);
            }
        },"TALEP_KALEM_ALIM_YAPILACAK",__profile);
    }
    
    public android.os.AsyncTask< Void, Void, NLQOperationResult< NLQTALEP_ISLEMIRETURN>> TALEP_KALEM_ALIM_YAPILACAKAsync(final NLQTALEP_KALEM_ALIM_YAPILACAKREQUEST REQ)
    {
        return executeAsync(new NLQFunctions.IFunc< NLQTALEP_ISLEMIRETURN>() {
            public NLQTALEP_ISLEMIRETURN Func() throws java.lang.Exception {
                return TALEP_KALEM_ALIM_YAPILACAK( REQ);
            }
        },"TALEP_KALEM_ALIM_YAPILACAK");
    }
    
    public NLQTALEP_ISLEMIRETURN TALEP_KALEM_ALIM_YAPILMAYACAK(final NLQTALEP_KALEM_ALIM_YAPILMAYACAKREQUEST REQ ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (NLQTALEP_ISLEMIRETURN)execute(new NLQIWcfMethod()
        {
            @Override
            public NLQExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                NLQExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("","REQ",new NLQTALEP_KALEM_ALIM_YAPILMAYACAKREQUEST().getClass());
                SoapObject __soapReq = new SoapObject("urn:DefaultNamespace", "TALEP_KALEM_ALIM_YAPILMAYACAK");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="REQ";
                __info.type=PropertyInfo.VECTOR_CLASS;
                __info.setValue(REQ);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(NLQExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (NLQTALEP_ISLEMIRETURN)getResult(NLQTALEP_ISLEMIRETURN.class,__result,"TALEP_KALEM_ALIM_YAPILMAYACAKReturn",__envelope);
            }
        },"TALEP_KALEM_ALIM_YAPILMAYACAK",__profile);
    }
    
    public android.os.AsyncTask< Void, Void, NLQOperationResult< NLQTALEP_ISLEMIRETURN>> TALEP_KALEM_ALIM_YAPILMAYACAKAsync(final NLQTALEP_KALEM_ALIM_YAPILMAYACAKREQUEST REQ)
    {
        return executeAsync(new NLQFunctions.IFunc< NLQTALEP_ISLEMIRETURN>() {
            public NLQTALEP_ISLEMIRETURN Func() throws java.lang.Exception {
                return TALEP_KALEM_ALIM_YAPILMAYACAK( REQ);
            }
        },"TALEP_KALEM_ALIM_YAPILMAYACAK");
    }
    
    public NLQTALEP_ISLEMIRETURN TALEP_IDAREYE_IADE_ET(final String DOKUMANID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (NLQTALEP_ISLEMIRETURN)execute(new NLQIWcfMethod()
        {
            @Override
            public NLQExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                NLQExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn:DefaultNamespace", "TALEP_IDAREYE_IADE_ET");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="DOKUMANID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(DOKUMANID);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(NLQExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (NLQTALEP_ISLEMIRETURN)getResult(NLQTALEP_ISLEMIRETURN.class,__result,"TALEP_IDAREYE_IADE_ETReturn",__envelope);
            }
        },"TALEP_IDAREYE_IADE_ET",__profile);
    }
    
    public android.os.AsyncTask< Void, Void, NLQOperationResult< NLQTALEP_ISLEMIRETURN>> TALEP_IDAREYE_IADE_ETAsync(final String DOKUMANID)
    {
        return executeAsync(new NLQFunctions.IFunc< NLQTALEP_ISLEMIRETURN>() {
            public NLQTALEP_ISLEMIRETURN Func() throws java.lang.Exception {
                return TALEP_IDAREYE_IADE_ET( DOKUMANID);
            }
        },"TALEP_IDAREYE_IADE_ET");
    }
    
    public NLQDTEMIN_IHALE_LISTESI_GETIRRETURN DTEMIN_IHALE_LISTESI_GETIR(final String ARAMA_METNI ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (NLQDTEMIN_IHALE_LISTESI_GETIRRETURN)execute(new NLQIWcfMethod()
        {
            @Override
            public NLQExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                NLQExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn:DefaultNamespace", "DTEMIN_IHALE_LISTESI_GETIR");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="ARAMA_METNI";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(ARAMA_METNI);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(NLQExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (NLQDTEMIN_IHALE_LISTESI_GETIRRETURN)getResult(NLQDTEMIN_IHALE_LISTESI_GETIRRETURN.class,__result,"DTEMIN_IHALE_LISTESI_GETIRReturn",__envelope);
            }
        },"DTEMIN_IHALE_LISTESI_GETIR",__profile);
    }
    
    public android.os.AsyncTask< Void, Void, NLQOperationResult< NLQDTEMIN_IHALE_LISTESI_GETIRRETURN>> DTEMIN_IHALE_LISTESI_GETIRAsync(final String ARAMA_METNI)
    {
        return executeAsync(new NLQFunctions.IFunc< NLQDTEMIN_IHALE_LISTESI_GETIRRETURN>() {
            public NLQDTEMIN_IHALE_LISTESI_GETIRRETURN Func() throws java.lang.Exception {
                return DTEMIN_IHALE_LISTESI_GETIR( ARAMA_METNI);
            }
        },"DTEMIN_IHALE_LISTESI_GETIR");
    }
    
    public NLQDTEMIN_IHALE_DETAY_GETIRRETURN DTEMIN_IHALE_DETAY_GETIR(final String DOKUMANID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (NLQDTEMIN_IHALE_DETAY_GETIRRETURN)execute(new NLQIWcfMethod()
        {
            @Override
            public NLQExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                NLQExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn:DefaultNamespace", "DTEMIN_IHALE_DETAY_GETIR");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="DOKUMANID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(DOKUMANID);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(NLQExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (NLQDTEMIN_IHALE_DETAY_GETIRRETURN)getResult(NLQDTEMIN_IHALE_DETAY_GETIRRETURN.class,__result,"DTEMIN_IHALE_DETAY_GETIRReturn",__envelope);
            }
        },"DTEMIN_IHALE_DETAY_GETIR",__profile);
    }
    
    public android.os.AsyncTask< Void, Void, NLQOperationResult< NLQDTEMIN_IHALE_DETAY_GETIRRETURN>> DTEMIN_IHALE_DETAY_GETIRAsync(final String DOKUMANID)
    {
        return executeAsync(new NLQFunctions.IFunc< NLQDTEMIN_IHALE_DETAY_GETIRRETURN>() {
            public NLQDTEMIN_IHALE_DETAY_GETIRRETURN Func() throws java.lang.Exception {
                return DTEMIN_IHALE_DETAY_GETIR( DOKUMANID);
            }
        },"DTEMIN_IHALE_DETAY_GETIR");
    }
    
    public NLQSOZLESME_LISTESI_GETIRRETURN SOZLESME_LISTESI_GETIR(final String ARAMA_METNI ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (NLQSOZLESME_LISTESI_GETIRRETURN)execute(new NLQIWcfMethod()
        {
            @Override
            public NLQExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                NLQExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn:DefaultNamespace", "SOZLESME_LISTESI_GETIR");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="ARAMA_METNI";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(ARAMA_METNI);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(NLQExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (NLQSOZLESME_LISTESI_GETIRRETURN)getResult(NLQSOZLESME_LISTESI_GETIRRETURN.class,__result,"SOZLESME_LISTESI_GETIRReturn",__envelope);
            }
        },"SOZLESME_LISTESI_GETIR",__profile);
    }
    
    public android.os.AsyncTask< Void, Void, NLQOperationResult< NLQSOZLESME_LISTESI_GETIRRETURN>> SOZLESME_LISTESI_GETIRAsync(final String ARAMA_METNI)
    {
        return executeAsync(new NLQFunctions.IFunc< NLQSOZLESME_LISTESI_GETIRRETURN>() {
            public NLQSOZLESME_LISTESI_GETIRRETURN Func() throws java.lang.Exception {
                return SOZLESME_LISTESI_GETIR( ARAMA_METNI);
            }
        },"SOZLESME_LISTESI_GETIR");
    }
    
    public NLQSIPARIS_LISTESI_GETIRRETURN SIPARIS_LISTESI_GETIR(final String DOKUMANID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (NLQSIPARIS_LISTESI_GETIRRETURN)execute(new NLQIWcfMethod()
        {
            @Override
            public NLQExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                NLQExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn:DefaultNamespace", "SIPARIS_LISTESI_GETIR");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="DOKUMANID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(DOKUMANID);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(NLQExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (NLQSIPARIS_LISTESI_GETIRRETURN)getResult(NLQSIPARIS_LISTESI_GETIRRETURN.class,__result,"SIPARIS_LISTESI_GETIRReturn",__envelope);
            }
        },"SIPARIS_LISTESI_GETIR",__profile);
    }
    
    public android.os.AsyncTask< Void, Void, NLQOperationResult< NLQSIPARIS_LISTESI_GETIRRETURN>> SIPARIS_LISTESI_GETIRAsync(final String DOKUMANID)
    {
        return executeAsync(new NLQFunctions.IFunc< NLQSIPARIS_LISTESI_GETIRRETURN>() {
            public NLQSIPARIS_LISTESI_GETIRRETURN Func() throws java.lang.Exception {
                return SIPARIS_LISTESI_GETIR( DOKUMANID);
            }
        },"SIPARIS_LISTESI_GETIR");
    }
    
    public NLQIS_ARTIS_LISTESI_GETIRRETURN IS_ARTIS_LISTESI_GETIR(final String ARAMA_METNI ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (NLQIS_ARTIS_LISTESI_GETIRRETURN)execute(new NLQIWcfMethod()
        {
            @Override
            public NLQExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                NLQExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn:DefaultNamespace", "IS_ARTIS_LISTESI_GETIR");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="ARAMA_METNI";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(ARAMA_METNI);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(NLQExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (NLQIS_ARTIS_LISTESI_GETIRRETURN)getResult(NLQIS_ARTIS_LISTESI_GETIRRETURN.class,__result,"IS_ARTIS_LISTESI_GETIRReturn",__envelope);
            }
        },"IS_ARTIS_LISTESI_GETIR",__profile);
    }
    
    public android.os.AsyncTask< Void, Void, NLQOperationResult< NLQIS_ARTIS_LISTESI_GETIRRETURN>> IS_ARTIS_LISTESI_GETIRAsync(final String ARAMA_METNI)
    {
        return executeAsync(new NLQFunctions.IFunc< NLQIS_ARTIS_LISTESI_GETIRRETURN>() {
            public NLQIS_ARTIS_LISTESI_GETIRRETURN Func() throws java.lang.Exception {
                return IS_ARTIS_LISTESI_GETIR( ARAMA_METNI);
            }
        },"IS_ARTIS_LISTESI_GETIR");
    }
    
    public NLQIHTIYAC_LISTESI_KALEMLERI_GETIRRETURN IHTIYAC_LISTESI_KALEMLERI_GETIR(final String DOKUMANID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (NLQIHTIYAC_LISTESI_KALEMLERI_GETIRRETURN)execute(new NLQIWcfMethod()
        {
            @Override
            public NLQExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                NLQExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn:DefaultNamespace", "IHTIYAC_LISTESI_KALEMLERI_GETIR");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="DOKUMANID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(DOKUMANID);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(NLQExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (NLQIHTIYAC_LISTESI_KALEMLERI_GETIRRETURN)getResult(NLQIHTIYAC_LISTESI_KALEMLERI_GETIRRETURN.class,__result,"IHTIYAC_LISTESI_KALEMLERI_GETIRReturn",__envelope);
            }
        },"IHTIYAC_LISTESI_KALEMLERI_GETIR",__profile);
    }
    
    public android.os.AsyncTask< Void, Void, NLQOperationResult< NLQIHTIYAC_LISTESI_KALEMLERI_GETIRRETURN>> IHTIYAC_LISTESI_KALEMLERI_GETIRAsync(final String DOKUMANID)
    {
        return executeAsync(new NLQFunctions.IFunc< NLQIHTIYAC_LISTESI_KALEMLERI_GETIRRETURN>() {
            public NLQIHTIYAC_LISTESI_KALEMLERI_GETIRRETURN Func() throws java.lang.Exception {
                return IHTIYAC_LISTESI_KALEMLERI_GETIR( DOKUMANID);
            }
        },"IHTIYAC_LISTESI_KALEMLERI_GETIR");
    }
    
    public NLQEK_DOSYA_BILGISI_GETIRRETURN EK_DOSYA_BILGISI_GETIR(final String DOKUMANID ) throws java.lang.Exception
    {
        com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile __profile = new com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile();
        return (NLQEK_DOSYA_BILGISI_GETIRRETURN)execute(new NLQIWcfMethod()
        {
            @Override
            public NLQExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                NLQExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("urn:DefaultNamespace", "EK_DOSYA_BILGISI_GETIR");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="DOKUMANID";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(DOKUMANID);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public java.lang.Object ProcessResult(NLQExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return (NLQEK_DOSYA_BILGISI_GETIRRETURN)getResult(NLQEK_DOSYA_BILGISI_GETIRRETURN.class,__result,"EK_DOSYA_BILGISI_GETIRReturn",__envelope);
            }
        },"EK_DOSYA_BILGISI_GETIR",__profile);
    }
    
    public android.os.AsyncTask< Void, Void, NLQOperationResult< NLQEK_DOSYA_BILGISI_GETIRRETURN>> EK_DOSYA_BILGISI_GETIRAsync(final String DOKUMANID)
    {
        return executeAsync(new NLQFunctions.IFunc< NLQEK_DOSYA_BILGISI_GETIRRETURN>() {
            public NLQEK_DOSYA_BILGISI_GETIRRETURN Func() throws java.lang.Exception {
                return EK_DOSYA_BILGISI_GETIR( DOKUMANID);
            }
        },"EK_DOSYA_BILGISI_GETIR");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public String URUNE_GORE_ALIM_RAPORU(final String REQ ) throws java.lang.Exception
    {
                
/*This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.*/
                throw new java.lang.UnsupportedOperationException("This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public android.os.AsyncTask< Void, Void, NLQOperationResult< String>> URUNE_GORE_ALIM_RAPORUAsync(final String REQ)
    {
        return executeAsync(new NLQFunctions.IFunc< String>() {
            public String Func() throws java.lang.Exception {
                return URUNE_GORE_ALIM_RAPORU( REQ);
            }
        },"URUNE_GORE_ALIM_RAPORU");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public String IDARE_BUTCE_RAPORU( ) throws java.lang.Exception
    {
                
/*This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.*/
                throw new java.lang.UnsupportedOperationException("This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public android.os.AsyncTask< Void, Void, NLQOperationResult< String>> IDARE_BUTCE_RAPORUAsync()
    {
        return executeAsync(new NLQFunctions.IFunc< String>() {
            public String Func() throws java.lang.Exception {
                return IDARE_BUTCE_RAPORU( );
            }
        },"IDARE_BUTCE_RAPORU");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public String HATIRLATMALAR( ) throws java.lang.Exception
    {
                
/*This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.*/
                throw new java.lang.UnsupportedOperationException("This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public android.os.AsyncTask< Void, Void, NLQOperationResult< String>> HATIRLATMALARAsync()
    {
        return executeAsync(new NLQFunctions.IFunc< String>() {
            public String Func() throws java.lang.Exception {
                return HATIRLATMALAR( );
            }
        },"HATIRLATMALAR");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public String HATIRLATMA_EKLE(final String DOKUMANID,final String HATIRLATMA_ADI,final String HATIRLATMA_METNI,final String HATIRLATMA_ZAMANI ) throws java.lang.Exception
    {
                
/*This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.*/
                throw new java.lang.UnsupportedOperationException("This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public android.os.AsyncTask< Void, Void, NLQOperationResult< String>> HATIRLATMA_EKLEAsync(final String DOKUMANID,final String HATIRLATMA_ADI,final String HATIRLATMA_METNI,final String HATIRLATMA_ZAMANI)
    {
        return executeAsync(new NLQFunctions.IFunc< String>() {
            public String Func() throws java.lang.Exception {
                return HATIRLATMA_EKLE( DOKUMANID,HATIRLATMA_ADI,HATIRLATMA_METNI,HATIRLATMA_ZAMANI);
            }
        },"HATIRLATMA_EKLE");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public String HATIRLATMA_SIL(final String DOKUMANID ) throws java.lang.Exception
    {
                
/*This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.*/
                throw new java.lang.UnsupportedOperationException("This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public android.os.AsyncTask< Void, Void, NLQOperationResult< String>> HATIRLATMA_SILAsync(final String DOKUMANID)
    {
        return executeAsync(new NLQFunctions.IFunc< String>() {
            public String Func() throws java.lang.Exception {
                return HATIRLATMA_SIL( DOKUMANID);
            }
        },"HATIRLATMA_SIL");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public String DUYURULAR( ) throws java.lang.Exception
    {
                
/*This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.*/
                throw new java.lang.UnsupportedOperationException("This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public android.os.AsyncTask< Void, Void, NLQOperationResult< String>> DUYURULARAsync()
    {
        return executeAsync(new NLQFunctions.IFunc< String>() {
            public String Func() throws java.lang.Exception {
                return DUYURULAR( );
            }
        },"DUYURULAR");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public String DOSYA_YETKI_AKIS_KONTROL(final String DOKUMANID ) throws java.lang.Exception
    {
                
/*This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.*/
                throw new java.lang.UnsupportedOperationException("This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public android.os.AsyncTask< Void, Void, NLQOperationResult< String>> DOSYA_YETKI_AKIS_KONTROLAsync(final String DOKUMANID)
    {
        return executeAsync(new NLQFunctions.IFunc< String>() {
            public String Func() throws java.lang.Exception {
                return DOSYA_YETKI_AKIS_KONTROL( DOKUMANID);
            }
        },"DOSYA_YETKI_AKIS_KONTROL");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public String DOSYA_ONAYA_GONDER(final String DOKUMANID ) throws java.lang.Exception
    {
                
/*This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.*/
                throw new java.lang.UnsupportedOperationException("This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public android.os.AsyncTask< Void, Void, NLQOperationResult< String>> DOSYA_ONAYA_GONDERAsync(final String DOKUMANID)
    {
        return executeAsync(new NLQFunctions.IFunc< String>() {
            public String Func() throws java.lang.Exception {
                return DOSYA_ONAYA_GONDER( DOKUMANID);
            }
        },"DOSYA_ONAYA_GONDER");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public String DOSYA_ONAYLA(final String DOKUMANID ) throws java.lang.Exception
    {
                
/*This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.*/
                throw new java.lang.UnsupportedOperationException("This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public android.os.AsyncTask< Void, Void, NLQOperationResult< String>> DOSYA_ONAYLAAsync(final String DOKUMANID)
    {
        return executeAsync(new NLQFunctions.IFunc< String>() {
            public String Func() throws java.lang.Exception {
                return DOSYA_ONAYLA( DOKUMANID);
            }
        },"DOSYA_ONAYLA");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public String DOSYA_REDDET(final String DOKUMANID,final String RED_NEDENI ) throws java.lang.Exception
    {
                
/*This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.*/
                throw new java.lang.UnsupportedOperationException("This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public android.os.AsyncTask< Void, Void, NLQOperationResult< String>> DOSYA_REDDETAsync(final String DOKUMANID,final String RED_NEDENI)
    {
        return executeAsync(new NLQFunctions.IFunc< String>() {
            public String Func() throws java.lang.Exception {
                return DOSYA_REDDET( DOKUMANID,RED_NEDENI);
            }
        },"DOSYA_REDDET");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public String GOREVLI_DOSYALAR_GETIR(final String ARAMA_METNI,final String DOSYA_TURU,final String DOSYA_NUMARASI,final String ISIN_TANIMI,final String ALIM_BASLANGIC_TARIHI,final String ALIM_BITIS_TARIHI,final String SOZLESME_BASLANGIC,final String SOZLESME_BITIS,final String ALIM_USULU,final String TALEP_TARIHI,final String FIRMA ) throws java.lang.Exception
    {
                
/*This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.*/
                throw new java.lang.UnsupportedOperationException("This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public android.os.AsyncTask< Void, Void, NLQOperationResult< String>> GOREVLI_DOSYALAR_GETIRAsync(final String ARAMA_METNI,final String DOSYA_TURU,final String DOSYA_NUMARASI,final String ISIN_TANIMI,final String ALIM_BASLANGIC_TARIHI,final String ALIM_BITIS_TARIHI,final String SOZLESME_BASLANGIC,final String SOZLESME_BITIS,final String ALIM_USULU,final String TALEP_TARIHI,final String FIRMA)
    {
        return executeAsync(new NLQFunctions.IFunc< String>() {
            public String Func() throws java.lang.Exception {
                return GOREVLI_DOSYALAR_GETIR( ARAMA_METNI,DOSYA_TURU,DOSYA_NUMARASI,ISIN_TANIMI,ALIM_BASLANGIC_TARIHI,ALIM_BITIS_TARIHI,SOZLESME_BASLANGIC,SOZLESME_BITIS,ALIM_USULU,TALEP_TARIHI,FIRMA);
            }
        },"GOREVLI_DOSYALAR_GETIR");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public String ONAY_BEKLEYEN_DOSYALAR_GETIR(final String ARAMA_METNI ) throws java.lang.Exception
    {
                
/*This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.*/
                throw new java.lang.UnsupportedOperationException("This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public android.os.AsyncTask< Void, Void, NLQOperationResult< String>> ONAY_BEKLEYEN_DOSYALAR_GETIRAsync(final String ARAMA_METNI)
    {
        return executeAsync(new NLQFunctions.IFunc< String>() {
            public String Func() throws java.lang.Exception {
                return ONAY_BEKLEYEN_DOSYALAR_GETIR( ARAMA_METNI);
            }
        },"ONAY_BEKLEYEN_DOSYALAR_GETIR");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public String ONAYA_GONDERILMIS_DOSYALAR(final String ARAMA_METNI ) throws java.lang.Exception
    {
                
/*This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.*/
                throw new java.lang.UnsupportedOperationException("This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public android.os.AsyncTask< Void, Void, NLQOperationResult< String>> ONAYA_GONDERILMIS_DOSYALARAsync(final String ARAMA_METNI)
    {
        return executeAsync(new NLQFunctions.IFunc< String>() {
            public String Func() throws java.lang.Exception {
                return ONAYA_GONDERILMIS_DOSYALAR( ARAMA_METNI);
            }
        },"ONAYA_GONDERILMIS_DOSYALAR");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public String GUVENLIK_SORUSU_TANIMLAMA(final String GUVENLIK_SORUSU,final String GUVENLIK_CEVAP ) throws java.lang.Exception
    {
                
/*This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.*/
                throw new java.lang.UnsupportedOperationException("This feature is available in Premium account. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.");
    }
    
	/**
	* This method is available in Premium account only. To test if generated classes work correctly with your webservice, please use different method. Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
	*/
    public android.os.AsyncTask< Void, Void, NLQOperationResult< String>> GUVENLIK_SORUSU_TANIMLAMAAsync(final String GUVENLIK_SORUSU,final String GUVENLIK_CEVAP)
    {
        return executeAsync(new NLQFunctions.IFunc< String>() {
            public String Func() throws java.lang.Exception {
                return GUVENLIK_SORUSU_TANIMLAMA( GUVENLIK_SORUSU,GUVENLIK_CEVAP);
            }
        },"GUVENLIK_SORUSU_TANIMLAMA");
    }

    protected java.lang.Object execute(NLQIWcfMethod wcfMethod,String methodName,com.easywsdl.exksoap2.ws_specifications.profile.WS_Profile profile) throws java.lang.Exception
    {
        org.ksoap2.transport.Transport __httpTransport=createTransport();
        __httpTransport.debug=enableLogging;
        NLQExtendedSoapSerializationEnvelope __envelope=wcfMethod.CreateSoapEnvelope();
        try
        {
            sendRequest(methodName, __envelope, __httpTransport,profile);
        }
        finally {
            if (__httpTransport.debug) {
                if (__httpTransport.requestDump != null) {
                    android.util.Log.i("requestDump",__httpTransport.requestDump);

                }
                if (__httpTransport.responseDump != null) {
                    android.util.Log.i("responseDump",__httpTransport.responseDump);
                }
            }
        }
        java.lang.Object __retObj = __envelope.bodyIn;
        if (__retObj instanceof org.ksoap2.SoapFault){
            org.ksoap2.SoapFault __fault = (org.ksoap2.SoapFault)__retObj;
            throw convertToException(__fault,__envelope);
        }else{
            return wcfMethod.ProcessResult(__envelope,__retObj);
        }
    }

    protected < T> android.os.AsyncTask< Void, Void, NLQOperationResult< T>>  executeAsync(final NLQFunctions.IFunc< T> func, final String methodName)
    {
        return new android.os.AsyncTask< Void, Void, NLQOperationResult< T>>()
        {
            @Override
            protected void onPreExecute() {
                callback.Starting();
            };
            @Override
            protected NLQOperationResult< T> doInBackground(Void... params) {
                NLQOperationResult< T> result = new NLQOperationResult< T>();
                try
                {
                    result.MethodName=methodName;
                    result.Result= func.Func();
                }
                catch(java.lang.Exception ex)
                {
                    ex.printStackTrace();
                    result.Exception=ex;
                }
                return result;
            }
            
            @Override
            protected void onPostExecute(NLQOperationResult< T> result)
            {
                callback.Completed(result);
            }
        }.execute();
    }

    protected java.lang.Exception convertToException(org.ksoap2.SoapFault fault,NLQExtendedSoapSerializationEnvelope envelope)
    {
        org.ksoap2.SoapFault newException = fault;
                return newException;
    }
}


