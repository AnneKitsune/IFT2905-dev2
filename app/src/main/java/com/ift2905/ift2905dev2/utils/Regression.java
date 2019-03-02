package com.ift2905.ift2905dev2.utils;

import android.content.Context;

import com.ift2905.ift2905dev2.R;
import com.ift2905.ift2905dev2.model.RegressionData;
import com.ift2905.ift2905dev2.model.TestData;

public final class Regression {
    public static RegressionData regression(Context ctx, TestData[] data) {
        int n = ctx.getResources().getInteger(R.integer.tries);
        float x = 0;
        for (TestData d : data) {
            x += d.difficulty();
        }

        float y = 0;
        for (TestData d : data) {
            y += d.getDeltaTime();
        }

        float xx = 0;
        for (TestData d : data) {
            xx += d.difficulty() * d.difficulty();
        }

        float yy = 0;
        for (TestData d : data) {
            yy += d.getDeltaTime() * d.getDeltaTime();
        }

        float xy = 0;
        for (TestData d : data) {
            xy += d.difficulty() * d.getDeltaTime();
        }

        float b = (n*xy-x*y) / (n*xx - x * x);
        float ninv = 1f / n;
        float a = (ninv * y - b * ninv * x);

        float r = (n*xy - x*y) / (float)(Math.sqrt((n*xx - x*x) * (n*yy - y * y)));

        return new RegressionData(a,b,r);
    }
}
