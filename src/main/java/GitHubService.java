import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface GitHubService {

    @GET("users/{username}/repos")
    Call<List<Repo>> listRepositories(@Path("username") String user);


    @GET("users/{username}")
    Call<UserProfile> userInfo(@Path("username") String user);


    class Repo {
        public String id;
        public String name;
    }

    class UserProfile {
        public String login;
    }
}
