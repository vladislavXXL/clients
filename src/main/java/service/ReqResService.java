package service;

import model.reqres.Data;
import model.reqres.Users;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ReqResService {
    @GET("/api/users/{id}")
    public Call<Data> getUser(@Path("id") String id);

    @GET("/api/users")
    public Call<Users> getUsers(
            @Query("per_page") int per_page,
            @Query("page") int page
    );
}
