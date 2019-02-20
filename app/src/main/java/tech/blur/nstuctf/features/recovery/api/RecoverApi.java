package tech.blur.nstuctf.features.recovery.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import tech.blur.nstuctf.core.model.RecoveryKey;
import tech.blur.nstuctf.core.model.User;
import tech.blur.nstuctf.core.network.Wrapper;

public interface RecoverApi {

    @POST ("/users/recover/{id}")
    Call<Wrapper<User>> recoverUser(@Body RecoveryKey key,
                                    @Path("id") String id,
                                    @Header("token") String token);

}
