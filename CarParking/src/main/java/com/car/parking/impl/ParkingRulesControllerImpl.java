package com.car.parking.impl;

import com.car.parking.IParkingRulesController;

public class ParkingRulesControllerImpl implements IParkingRulesController {

    private int carWhoParkingByTheRules = 0;

    private int carParkedOnTheLine;
    private int carParkedInTheDriveWay;
    private int carParkedOnTheSite;


    public ParkingRulesControllerImpl() {
        this.carParkedOnTheLine = 0;
        this.carParkedInTheDriveWay = 0;
        this.carParkedOnTheSite = 0;
    }


    @Override
    public boolean isCarParkingByTheRules(int carId) {
        return  carIsNotParkedOnTheLine(carId) &&
                carIsNotParkedInTheDriveWay(carId) &&
                carIsNotParkedOnTheSite(carId);
    }


    private boolean carIsNotParkedOnTheLine(int carId) {
        return carParkedOnTheLine == 0;
    }

    private boolean carIsNotParkedInTheDriveWay(int carId) {
        return carParkedInTheDriveWay == 0;
    }

    private boolean carIsNotParkedOnTheSite(int carId) {
        return carParkedOnTheSite == 0;
    }







    public int getCarParkedOnTheLine() {
        return carParkedOnTheLine;
    }
    public void setCarParkedOnTheLine(int carParkedOnTheLine) {
        this.carParkedOnTheLine = carParkedOnTheLine;
    }

    public int getCarParkedInTheDriveWay() {
        return carParkedInTheDriveWay;
    }
    public void setCarParkedInTheDriveWay(int carParkedInTheDriveWay) {
        this.carParkedInTheDriveWay = carParkedInTheDriveWay;
    }

    public int getCarParkedOnTheSite() {
        return carParkedOnTheSite;
    }
    public void setCarParkedOnTheSite(int carParkedOnTheSite) {
        this.carParkedOnTheSite = carParkedOnTheSite;
    }
}
