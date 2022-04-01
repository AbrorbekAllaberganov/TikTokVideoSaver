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

        Request request = new Request.Builder()
                .url("https://tiktok-downloader-download-tiktok-videos-without-watermark.p.rapidapi.com/vid/index?url=https%3A%2F%2Fvm.tiktok.com%2FZSenJuWxH%2F")
                .get()
                .addHeader("X-RapidAPI-Host", "tiktok-downloader-download-tiktok-videos-without-watermark.p.rapidapi.com")
                .addHeader("X-RapidAPI-Key", "56cb08adf9mshdf817a9b61f9a85p140c71jsn84a0f1973239")
                .build();

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
