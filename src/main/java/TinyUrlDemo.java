import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;


public class TinyUrlDemo {
    public static void main(String[] args) throws IOException {

        final TinyUrlService service = new Retrofit.Builder()
                .baseUrl("http://tiny-url.info/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TinyUrlService.class);


        try {
            Response<TinyUrlResponse> response;
            response = service.random("json", "http://kino-live2.org/").execute();
            if (response.isSuccessful()) {
                System.out.println("State " + response.body().getState());
                System.out.println("LongUrl " + response.body().getLongUrl());
                System.out.println("ShortUrl " + response.body().getShortUrl());
            } else {
                try (ResponseBody errorBody = response.errorBody()) {
                    String errorContent = errorBody.string();
                    System.out.println(errorContent);
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
