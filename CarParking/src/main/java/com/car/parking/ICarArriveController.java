package com.car.parking;

public interface ICarArriveController {

    int carParkedByTheRules() throws InterruptedException;

    int newCarIsArrived();

    int getCountOfCarInParking();

    int getCarId();




}
