import com.google.gson.annotations.SerializedName;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface TinyUrlService {
    @POST("random")
    @FormUrlEncoded
    Call<TinyUrlResponse> random(@Field("format") String format, @Field("url") String url);
}
    class TinyUrlResponse {
    private String state;
    @SerializedName("longurl")
    private String longUrl;
    @SerializedName("shorturl")
    private String shortUrl;

    public String getState() {
        return state;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }
}