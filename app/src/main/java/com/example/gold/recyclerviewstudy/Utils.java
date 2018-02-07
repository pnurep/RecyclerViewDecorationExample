package com.example.gold.recyclerviewstudy;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by gold on 2018. 2. 7..
 */

public class Utils {

    static float dpToPixel(float dp, Resources resources) {
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return metrics.density * dp;
    }

}
