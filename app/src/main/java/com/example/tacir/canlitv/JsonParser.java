package com.example.tacir.canlitv;

import com.example.tacir.canlitv.model.Channel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public List<Channel> extract( String response) {
        try {
            JSONObject jsonObject=new JSONObject(response);

            JSONArray items=jsonObject.getJSONArray("items");
            List<Channel> list=new ArrayList<>();

            for(int i=0; i<items.length(); i++){
                JSONObject current=items.getJSONObject(i);

                String title=current.getString("title");
                String description=current.getString("description");
                String channelTitle=current.getString("channelTitle");
                String thumbnail=current.getString("thumbnail");
                String videoId=current.getString("videoId");

            Channel converted = new Channel(title, description, channelTitle, thumbnail, videoId);
                list.add(converted);

            }
            return  list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();

}

    }

