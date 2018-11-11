package com.car.parking.impl;

import com.car.parking.ICarArriveController;
import com.car.parking.IParkingRulesController;

public class CarArriveControllerImpl implements ICarArriveController {

    private int carId=1;
    private int countOfCarInParking = 0;
    private long timeForParking = 100_000;
    private IParkingRulesController controller;

    public CarArriveControllerImpl() {
        this.carId = countOfCarInParking++;
    }

    public CarArriveControllerImpl(long timeForParking) {
        this.timeForParking = timeForParking;
    }

    @Override
    public int carParkedByTheRules() {
        try {
            Thread.sleep(timeForParking);
        } catch (InterruptedException e) {
            return -1;
        }
        if (controller.isCarParkingByTheRules(this.carId)) {
            return this.carId;
        } else {
            return 0;
        }
    }

    @Override
    public int newCarIsArrived() {
        controller = new ParkingRulesControllerImpl();
        this.incrementCountOfCarOnParking();
        carParkedByTheRules();
        return this.carId;
    }


    private int incrementCountOfCarOnParking() {
        ++countOfCarInParking;
        return countOfCarInParking;
    }

    @Override
    public int getCountOfCarInParking() {
        return countOfCarInParking;
    }

    public long getTimeForParking() {
        return timeForParking;
    }

    public void setTimeForParking(long timeForParking) {
        this.timeForParking = timeForParking;
    }

    @Override
    public int getCarId() {
        return carId;
    }
}
