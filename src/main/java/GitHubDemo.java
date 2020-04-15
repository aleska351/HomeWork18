import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class GitHubDemo {
    public static void main(String[] args) {
        GitHubService service = new Retrofit.Builder().baseUrl("https://api.github.com/").
                addConverterFactory(GsonConverterFactory.create())
                .build().create(GitHubService.class);


        try {
            Response<List<GitHubService.Repo>> response =
                    service.listRepositories("NordicSemiconductor").execute();
            if (response.isSuccessful()) {
                for (GitHubService.Repo repo : response.body()) {
                    System.out.println("Repo id " + repo.id);
                    System.out.println("Repo name " + repo.name);
                }
            } else {
                try (ResponseBody errorBody = response.errorBody()) {
                    String errorContent = errorBody.string();
                    System.out.println(errorContent);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
