package tech.blur.nstuctf.features.objective;

import com.arellomobile.mvp.MvpView;

import tech.blur.nstuctf.core.model.Objective;

public interface ObjectiveView extends MvpView {
    void loadObjective(Objective objective);
    void showMessage(String s);
}
