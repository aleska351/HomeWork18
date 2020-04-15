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
    public String state;
    @SerializedName("longurl")
    public String longUrl;

    public String getState() {
        return state;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    @SerializedName("shorturl")
    public String shortUrl;
}