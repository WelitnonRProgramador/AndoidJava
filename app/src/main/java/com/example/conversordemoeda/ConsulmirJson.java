package com.example.conversordemoeda;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConsulmirJson {

    public static List <Moeda>JsonDados(String conteudo){

        try {
            List<Moeda> moedaList = new ArrayList<>();
            JSONArray jsonArray = null;
            JSONObject jsonObject = null;

            jsonArray = new JSONArray(conteudo);

            for (int i = 0;i<jsonArray.length();i++){
                jsonObject = jsonArray.getJSONObject(i);

                Moeda moeda = new Moeda();
                moeda.setName(jsonObject.getString(name: "name"));
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

}
