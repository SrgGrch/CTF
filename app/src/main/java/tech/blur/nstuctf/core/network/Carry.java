package tech.blur.nstuctf.core.network;



/**
 * Created: samokryl
 * Date: 01.07.18
 * Time: 23:04
 */


/**
 * Created: samokryl
 * Date: 01.07.18
 * Time: 23:04
 */

public interface Carry<T> {

    void onSuccess(T result);

    void onFailure(Throwable throwable);

}