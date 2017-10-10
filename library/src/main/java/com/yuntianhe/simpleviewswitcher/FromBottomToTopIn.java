package com.yuntianhe.simpleviewswitcher;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;

/**
 * @author dwj  2017/9/18 18:57
 */

public class FromBottomToTopIn implements IAnimationFactory {

    private Animation createAnim(float yStart, float yEnd) {
        final TranslateAnimation rotation = new TranslateAnimation(1, 0f, 1, 0f, 1, yStart, 1, yEnd);
        rotation.setDuration(800);
        rotation.setFillAfter(false);
        rotation.setInterpolator(new LinearInterpolator());
        return rotation;
    }

    @Override
    public Animation in() {
        return createAnim(1f, 0f);
    }

    @Override
    public Animation out() {
        return createAnim(0f, -1f);
    }
}
