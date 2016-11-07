package br.sp.japaround.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import br.sp.japaround.models.Region;

public class JsonUtils {

    public String convertJsonFileToString(Context context, String filename) {

        try {

            InputStream stream = context.getAssets().open(filename);

            int size = stream.available();
            byte[] buffer = new byte[size];

            stream.read(buffer);
            stream.close();

            return new String(buffer);
        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }

    public List<Region> convertJsonStringToModel(String str) {

        Gson gson = new GsonBuilder().create();

        try {

            return Arrays.asList(gson.fromJson(str, Region[].class));
        } catch (Exception e) {

            e.getStackTrace();
        }

        return null;
    }
}
