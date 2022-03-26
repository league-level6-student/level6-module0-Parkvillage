package _02_cat_facts_API;

import _02_cat_facts_API.data_transfer_objects.CatWrapper;


import java.util.List;

public class CatFactsRunner {

    public static void main(String[] args) {
        CatFactsApi catFactsApi = new CatFactsApi();
        catFactsApi.testRequest();

        CatWrapper cat = catFactsApi.getCatFact();
        List<String> data = cat.getData();
        String s = "";
        for(int i = 0;i< data.size(); i++){
            s+= data.get(i);

        }
    System.out.println(s);
    }

}
