package com.ift2905.ift2905dev2.model;

public class TestData {
    int tryNumber;
    float deltaX;
    float deltaY;
    float deltaTime;
    float buttonSize;

    public TestData(int tryNumber, float deltaX, float deltaY, float deltaTime, float buttonSize) {
        this.tryNumber = tryNumber;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.deltaTime = deltaTime;
        this.buttonSize = buttonSize;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "tryNumber=" + tryNumber +
                ", deltaX=" + deltaX +
                ", deltaY=" + deltaY +
                ", deltaTime=" + deltaTime +
                ", buttonSize=" + buttonSize +
                '}';
    }

    public int getTryNumber() {
        return tryNumber;
    }

    public void setTryNumber(int tryNumber) {
        this.tryNumber = tryNumber;
    }

    public float getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(float deltaX) {
        this.deltaX = deltaX;
    }

    public float getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(float deltaY) {
        this.deltaY = deltaY;
    }

    public float getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(float deltaTime) {
        this.deltaTime = deltaTime;
    }

    public float getButtonSize() {
        return buttonSize;
    }

    public void setButtonSize(float buttonSize) {
        this.buttonSize = buttonSize;
    }
}