package tech.blur.nstuctf.features.auth.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import tech.blur.nstuctf.core.model.User;
import tech.blur.nstuctf.core.model.UserAuth;
import tech.blur.nstuctf.core.network.Wrapper;

public interface AuthApi {
    @POST("users/auth")
    Call<Wrapper<User>> CheckUser(@Body UserAuth userAuth);

}
