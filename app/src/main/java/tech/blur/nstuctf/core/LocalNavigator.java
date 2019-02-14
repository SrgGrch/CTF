package tech.blur.nstuctf.core;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import tech.blur.nstuctf.core.cicerone.AndroidxFragmentNavigator;
import tech.blur.nstuctf.features.auth.AuthFragment;

public class LocalNavigator extends AndroidxFragmentNavigator {

    private int currentContainer;

    /**
     * Creates AndroidxFragmentNavigator.
     *
     * @param fragmentManager support fragment manager
     * @param containerId     id of the fragments container layout
     */
    public LocalNavigator(FragmentManager fragmentManager, int containerId) {
        super(fragmentManager, containerId);
        currentContainer = containerId;
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        switch (currentContainer) {
            case Screens.CONTAINER_MAIN:
                return mainFragments(screenKey);
            default:
                return mainFragments(screenKey);
        }
    }



    private Fragment mainFragments(String screenKey) {
        switch (screenKey) {
            case Screens.AUTH:
                return new AuthFragment();
            default:
                return new AuthFragment();
        }
    }


    @Override
    protected void showSystemMessage(String message) {

    }

    @Override
    protected void exit() {

    }
}
