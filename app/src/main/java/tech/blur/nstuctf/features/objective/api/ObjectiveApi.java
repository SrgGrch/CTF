package tech.blur.nstuctf.features.objective.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import tech.blur.nstuctf.core.model.Objective;
import tech.blur.nstuctf.core.network.Wrapper;

public interface ObjectiveApi {

    @GET("objective")
    Call<Wrapper<Objective>> getObjective(@Header("token") String token);

}
