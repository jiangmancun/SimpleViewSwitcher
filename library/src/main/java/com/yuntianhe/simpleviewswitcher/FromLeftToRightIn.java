package com.yuntianhe.simpleviewswitcher;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;

/**
 * @author dwj  2017/9/18 18:57
 */

public class FromLeftToRightIn implements IAnimationFactory {

    private Animation createAnim(float xStart, float xEnd) {
        final TranslateAnimation rotation = new TranslateAnimation(1, xStart, 1, xEnd, 1, 0f, 1, 0f);
        rotation.setDuration(500);
        rotation.setFillAfter(false);
        rotation.setInterpolator(new LinearInterpolator());
        return rotation;
    }

    @Override
    public Animation in() {
        return createAnim(-1f, 0f);
    }

    @Override
    public Animation out() {
        return createAnim(0f, 1f);
    }
}
