package com.ift2905.ift2905dev2.utils;

import android.content.Context;
import android.util.TypedValue;

public final class Accessor {
    public static float floatFromConf(Context ctx, int id) {
        TypedValue outValue = new TypedValue();
        ctx.getResources().getValue(id, outValue, true);
        float value = outValue.getFloat();
        return value;
    }
}
