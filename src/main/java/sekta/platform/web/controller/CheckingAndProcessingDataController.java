package sekta.platform.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import sekta.platform.core.entity.Base;
import sekta.platform.core.entity.Webpage;
import sekta.platform.core.entity.Website;
import sekta.platform.core.service.WebpageService;
import sekta.platform.core.service.WebsiteService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CheckingAndProcessingDataController /*<T>*/{//цей клас потрібно буде використовувати з дженералізацією, типу як List і похідні від List, Map ...

    public boolean checkOnExistEmptyData(String page,String tag){
        if(page.equals("")||tag.equals("")){
            return true;
        }
        return false;
    }

    public String trimDomen(String webpageName){
        String domen="";
        char[] chArray = webpageName.toCharArray();//part code for cut domen
        int j = 0;
        for (int i = 0; i < 3; ) {
            domen += chArray[j++];
            if (chArray[j] == '/') i++;
        }
        int slesh=domen.indexOf("//");
        domen=domen.substring(slesh+2);//need trim to the "//" symbols
        System.out.println("DOMEN - "+domen);
        return domen;
    }
    //public Base checkOnExistRepeatedData(Base base,String someVar){//its temprorary variant
    public Website checkOnExistRepeatedData(String someVar,WebsiteService websiteService){//i think in this method need knowledge about reflection, for using instanceof
       // if(base instanceof Website){
            List<Website>websites=websiteService.findAll();
            List<String> websitesNames=new ArrayList<>();

            for(Website websiteSingle:websites){
                websitesNames.add(websiteSingle.getWebsiteName());
            }
            System.out.println("Check websites: "+websitesNames.contains(someVar));

            Website website;
            int indexWebsite=websitesNames.indexOf(someVar);
            if(indexWebsite==-1){
                website=new Website();//need create new webpage using webpageService
                website.setWebsiteName(someVar);
                websiteService.save(website);
            }else{
                website=websites.get(indexWebsite);//index array or index on DB? In this field need index array, no DB
            }
            System.out.println(website.getWebsiteName());
        //}
        return website;
    }
    // public Base checkOnExistRepeatedData(Base base, String someVar, Website website){
    public Webpage checkOnExistRepeatedData(String someVar, Website website,WebpageService webpageService){//its temprorary variant
        //if(base instanceof Webpage){
            List<Webpage>webpages=webpageService.findAll();
            List<String>webpagesNames=new ArrayList<>();

            for(Webpage webpage1:webpages){
                webpagesNames.add(webpage1.getName());
            }
            System.out.println("Check webpages: "+webpagesNames.contains(someVar));

            Webpage webpage;
            int indexWebpage=webpagesNames.indexOf(someVar);
            if(indexWebpage==-1){
                webpage=new Webpage();//need create new webpage using webpageService
                webpage.setName(someVar);
                webpage.setWebsite(website);
                webpageService.save(webpage);
            }else{
                webpage=webpages.get(indexWebpage);//index array or index on DB? In this field need index array, no DB
            }
            System.out.println(webpage.getName());
            //base=webpage;
        //}
        return webpage;
    }

    /*public <E> void test(Collection<E> collection){//Перед нами джерералізований тип даних, він здатний приймати будь-яку колекцію,
        List<String> arrayList=new ArrayList<>();

        for(E e:collection){//тобто колекцію об'єктів, рядків та інші. Нюансом даного типу є те що для екземпляру класу необхідно
            System.out.println("First method "+e);//вказати тип даних який буде передано в даний метод, якщо ж створити екземпляр класу
            arrayList.add(String.valueOf(collection.getName()));
        }//raw то буде помилка в run-time.
    }*/
}
