package com.car.parking;


import com.car.parking.impl.CarArriveControllerImpl;
import com.car.parking.impl.ParkingRulesControllerImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.mockito.MockitoAnnotations.initMocks;


public class ControlOfParkingRulesByCarTest {
    @Mock
    private CarArriveControllerImpl arriveController;
    @Mock
    private ParkingRulesControllerImpl rulesController;

    private ICarArriveController carArriveController = spy(new CarArriveControllerImpl(1000));


    @Before
    public void before() {
        initMocks(this);

    }


    @Test
    public void isCarParkedByRulesTest() {
        rulesController.setCarParkedInTheDriveWay(0);
        rulesController.setCarParkedOnTheLine(0);
        rulesController.setCarParkedOnTheSite(0);

        arriveController.newCarIsArrived();

        Assert.assertEquals(arriveController.carParkedByTheRules(), arriveController.getCarId());
    }

    @Test
    public void isCarParkedAtLineTest() {

        rulesController.setCarParkedInTheDriveWay(0);
        rulesController.setCarParkedOnTheLine(1);
        rulesController.setCarParkedOnTheSite(0);

        arriveController.newCarIsArrived();

        Assert.assertEquals(arriveController.carParkedByTheRules(), 0);
    }

    @Test
    public void isCarParkedInTheDriveWayTest() {
        rulesController.setCarParkedInTheDriveWay(1);
        rulesController.setCarParkedOnTheLine(0);
        rulesController.setCarParkedOnTheSite(0);

        arriveController.newCarIsArrived();

        Assert.assertEquals(arriveController.carParkedByTheRules(), 0);
    }


    @Test
    public void isCarParkedOnTheSiteTest() {
        rulesController.setCarParkedInTheDriveWay(0);
        rulesController.setCarParkedOnTheLine(0);
        rulesController.setCarParkedOnTheSite(1);

        arriveController.newCarIsArrived();

        Assert.assertEquals(arriveController.carParkedByTheRules(), 0);
    }

    @Test
    public void isAllRulesAreCheckedTest() throws InterruptedException {
        rulesController.setCarParkedInTheDriveWay(0);
        rulesController.setCarParkedOnTheLine(0);
        rulesController.setCarParkedOnTheSite(0);

        for (int i = 0; i<10; i++){
            int carOnParking = carArriveController.getCountOfCarInParking();
            int carId = carArriveController.newCarIsArrived();
           Assert.assertEquals(carId, carArriveController.getCarId());
           Assert.assertEquals(carArriveController.getCountOfCarInParking(), carOnParking+1);
        }



//        verify(carArriveController, times(1)).carParkedByTheRules();
    }

    @Test
    public void isIsSomeCarArrivedTest() throws InterruptedException {
        rulesController.setCarParkedInTheDriveWay(0);
        rulesController.setCarParkedOnTheLine(0);
        rulesController.setCarParkedOnTheSite(0);



        int carId = carArriveController.newCarIsArrived();
        System.out.println(carId);


        verify(carArriveController, times(1)).carParkedByTheRules();
    }


}
