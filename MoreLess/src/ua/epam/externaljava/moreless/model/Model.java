package ua.epam.externaljava.moreless.model;

import java.util.ArrayList;
import java.util.List;


public class Model{
    private final int PRIMARY_MIN_BARRIER = 0;
    private final int PRIMARY_MAX_BARRIER = 100;
    private int minBarrier=PRIMARY_MIN_BARRIER;
    private int maxBarrier=PRIMARY_MAX_BARRIER;
    private int secretValue;
    /**
     *
     */
    private List<Integer> yourWay = new ArrayList<Integer>();

    public boolean checkValue (int value){
        yourWay.add(value);
        if (value == secretValue){
            return true;
        } else if (value > secretValue){
            maxBarrier = value;
        } else {
            minBarrier = value;
        }
      return false;
    }

    public void setPrimaryBarrier(int minBarrier, int maxBarrier){
        this.minBarrier = minBarrier; // check
        this.maxBarrier = maxBarrier;
    }

    public void setSecretValue() {
        secretValue = (int)Math.ceil(Math.random() *
                (maxBarrier - minBarrier - 1) + minBarrier);
    }

    public int getSecretValue() {
        return secretValue;
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public List<Integer> getYourWay() {
        return yourWay;
    }
}
