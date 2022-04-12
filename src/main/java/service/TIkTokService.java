package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import payload.DTO.NewDTO;
import payload.ResponseDTO;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Objects;

public class TIkTokService {
    public NewDTO saveVideo(String url){
        NewDTO newDTO=new NewDTO();
        Gson gson=new Gson();
        OkHttpClient client = new OkHttpClient();

//        REQUEST

        try {
            Response response = client.newCall(request).execute();
            String jsonData= Objects.requireNonNull(response.body()).string();

            Type type = new TypeToken<NewDTO>() {
            }.getType();
            System.out.println(jsonData);
            newDTO = gson.fromJson(jsonData, type);

            return newDTO;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
