package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich;

        try {
            //Create JSONObject
            JSONObject sandwichObject = new JSONObject(json);

            //Get name
            JSONObject object = sandwichObject.getJSONObject("name");

            //Get MainName
            String mainName = object.getString("mainName");

            //Get array
            JSONArray aka = object.getJSONArray("alsoKnownAs");

            //Get place of origin
            String placeOfOrigin = sandwichObject.getString("placeOfOrigin");

            //Get Description
            String description = sandwichObject.getString("description");

            //Get image
            String image = sandwichObject.getString("image");

            //Get Ingredients array
            JSONArray ingredients = sandwichObject.getJSONArray("ingredients");

            //Put arrays into Lists
            List<String> ingredientsList = new ArrayList<>();
            for (int i = 0; i < ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i));
            }

            List<String> akaList = new ArrayList<>();
            for (int i = 0; i < aka.length(); i++) {
                akaList.add(aka.getString(i));
            }

            sandwich = new Sandwich(mainName, akaList, placeOfOrigin, description, image, ingredientsList);
            return sandwich;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
