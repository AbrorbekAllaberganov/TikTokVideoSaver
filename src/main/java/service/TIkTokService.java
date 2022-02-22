package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import payload.ResponseDTO;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Objects;

public class TIkTokService {
    public ResponseDTO saveVideo(String url){
        ResponseDTO responseDTO=new ResponseDTO();
        Gson gson=new Gson();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://tiktok-downloader-download-tiktok-videos-without-watermark.p.rapidapi.com/vid/index?url="+url)
                .get()
                .addHeader("x-rapidapi-host", "tiktok-downloader-download-tiktok-videos-without-watermark.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "2b4381dffcmsh58946b3b32a692ap13ba51jsnebf7ba34d427")
                .build();

        try {
            Response response = client.newCall(request).execute();
            String jsonData= Objects.requireNonNull(response.body()).string();

            Type type = new TypeToken<ResponseDTO>() {
            }.getType();
            System.out.println(jsonData);
            responseDTO = gson.fromJson(jsonData, type);

            return responseDTO;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
