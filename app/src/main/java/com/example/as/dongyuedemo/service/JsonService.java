package com.example.as.dongyuedemo.service;

import com.example.as.dongyuedemo.Act;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonService {
    public JsonService() {
    }

    public static List<Act> getActs(String jsonString) {
        String key = "acts";
        List<Act> list = new ArrayList<Act>();
        try {
            JSONObject jsonObject = new JSONObject(jsonString).getJSONObject("result");
            JSONArray jsonArray = jsonObject.getJSONArray(key);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                Act act = new Act();
                act.setName(jsonObject1.getString("name"));
                act.setPoster((jsonObject1.getString("poster")));
                act.setLocation(jsonObject1.getString("location"));
                act.setStart_time(jsonObject1.getString("start_time"));
                act.setEnd_time((jsonObject1.getString("end_time")));
                act.setSign_start_time(jsonObject1.getString("sign_start_time"));
                act.setSign_end_time(jsonObject1.getString("sign_end_time"));
                act.setSource(jsonObject1.getString("source"));
                act.setType(jsonObject1.getInt("type"));
                list.add(act);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
