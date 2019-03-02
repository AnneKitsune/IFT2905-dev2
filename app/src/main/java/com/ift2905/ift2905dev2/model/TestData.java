package com.ift2905.ift2905dev2.model;

public class TestData {
    int tryNumber;
    float deltaX;
    float deltaY;
    long deltaTime;
    float buttonSize;

    public TestData(int tryNumber, float deltaX, float deltaY, long deltaTime, float buttonSize) {
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

    public float getDistance() {
        return (float)Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public float difficulty() {
        return (float)(Math.log(getDistance() / buttonSize + 1) / Math.log(2));
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

    public long getDeltaTime() {
        return deltaTime;
    }

    public float getDeltaTimeSeconds() {
        return deltaTime / 1000f;
    }

    public void setDeltaTime(long deltaTime) {
        this.deltaTime = deltaTime;
    }

    public float getButtonSize() {
        return buttonSize;
    }

    public void setButtonSize(float buttonSize) {
        this.buttonSize = buttonSize;
    }
}