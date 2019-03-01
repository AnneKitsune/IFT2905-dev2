package com.ift2905.ift2905dev2.utils;

import com.ift2905.ift2905dev2.model.RegressionData;
import com.ift2905.ift2905dev2.model.TestData;

public final class Regression {
    public static RegressionData regression(TestData[] data) {
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

        return new RegressionData(0,0,0);
    }
}
