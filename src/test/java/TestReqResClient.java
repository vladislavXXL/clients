import client.reqres.ClientGenerator;
import model.reqres.Ad;
import model.reqres.Data;
import model.reqres.User;
import model.reqres.Users;
import org.junit.Assert;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import service.ReqResService;

import java.io.IOException;

public class TestReqResClient {
    private static final String BASE_URL = "https://reqres.in/";

    @Test
    public void testReqResClientGetUser() throws IOException {
        ReqResService client = new ClientGenerator(BASE_URL)
                .createClient(ReqResService.class);
        Call<Data> callSync = client.getUser("2");
        Response<Data> response = callSync.execute();
        Assert.assertEquals(response.code(), 200);
        User user = response.body().getData();
        System.out.printf("User:\n\tid: %s\n\temail: %s\n\tfirst_name: %s\n\tlast_name: %s\n\tavatar: %s\n",
                user.getId(), user.getEmail(), user.getFirst_name(), user.getLast_name(), user.getAvatar());
        Ad ad = response.body().getAd();
        System.out.printf("Ad:\n\tcompany: %s\n\turl: %s\n\ttext: %s\n", ad.getCompany(), ad.getUrl(), ad.getText());
        System.out.println(user);
        System.out.println(ad);
    }

    @Test
    public void testReqResClientGetUsers() throws IOException {
        ReqResService client = new ClientGenerator(BASE_URL)
                .createClient(ReqResService.class);
        Call<Users> callSync = client.getUsers(3, 1);
        Response<Users> response = callSync.execute();
        Assert.assertEquals(response.code(), 200);
        System.out.println(response.body());
    }
}
