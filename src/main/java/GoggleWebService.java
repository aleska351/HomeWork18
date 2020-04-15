import retrofit2.Call;
import retrofit2.http.GET;

public interface GoggleWebService {
    @GET("/")
    Call<String> index();
}
