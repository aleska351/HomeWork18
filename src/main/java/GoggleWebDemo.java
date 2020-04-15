import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;

public class GoggleWebDemo {
    public static void main(String[] args) {
        GoggleWebService service = new Retrofit.Builder().baseUrl("https://www.google.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build().create(GoggleWebService.class);

        try {
            Response<String> response = service.index().execute();
            if (response.isSuccessful()) {
                System.out.println(response.body());
            } else {
                try (ResponseBody errorBody = response.errorBody();) {
                    assert errorBody != null;
                    String errorContent = errorBody.string();
                    System.out.println(errorContent);
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }

    }
}
