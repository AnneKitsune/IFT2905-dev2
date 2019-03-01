package com.ift2905.ift2905dev2.model;

public class RegressionData {
    float a;
    float b;
    float coeff;

    public RegressionData(float a, float b, float coeff) {
        this.a = a;
        this.b = b;
        this.coeff = coeff;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public float getCoeff() {
        return coeff;
    }
}
