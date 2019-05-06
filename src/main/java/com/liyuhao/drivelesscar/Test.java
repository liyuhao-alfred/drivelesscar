package com.liyuhao.drivelesscar;


import com.liyuhao.drivelesscar.constant.CommandConstant;
import com.liyuhao.drivelesscar.constant.OrientationConstant;
import com.liyuhao.drivelesscar.exception.DefaultException;
import com.liyuhao.drivelesscar.service.Car;
import com.liyuhao.drivelesscar.service.CarImpl;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class Test {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Test
    public void test1() {
        final String desc1 = "Given the Car is in position X = 1 and Y = 1 and facing North, when the Car turns clockwise, then the Car is still in the same position but is now facing East";
        System.out.println("desc:" + desc1);

        Car car = new CarImpl(4, 1, 1, OrientationConstant.North);
        System.out.println("desc before:" + car.toString());

        car.move(CommandConstant.clockwise.getCode());
        System.out.println("desc after:" + car.toString());

        Assert.assertEquals(car.getPositionX(), 1);
        Assert.assertEquals(car.getPositionY(), 1);
        Assert.assertEquals(car.getOrientation(), OrientationConstant.East.getCode());
        System.out.println();
    }

    @org.junit.Test
    public void test2() {
        final String desc2 = "Given the Car is in position X = 1 and Y = 1 and facing North, when the Car moves forward, then the Car is still facing North but is now in position X = 1 and Y = 2";
        System.out.println("desc:" + desc2);

        Car car = new CarImpl(4, 1, 1, OrientationConstant.North);
        System.out.println("desc before:" + car.toString());

        car.move(CommandConstant.forward.getCode());
        System.out.println("desc after:" + car.toString());

        Assert.assertEquals(car.getPositionX(), 1);
        Assert.assertEquals(car.getPositionY(), 2);
        Assert.assertEquals(car.getOrientation(), OrientationConstant.North.getCode());
        System.out.println();
    }

    @org.junit.Test
    public void test3() {
        final String desc3 = "Given the Car is in position X = 1 and Y = 1 and facing East, when the Car moves forward, then the Car is still facing East but is now in position X = 2 and Y = 1";
        System.out.println("desc:" + desc3);

        Car car = new CarImpl(4, 1, 1, OrientationConstant.East);
        System.out.println("desc before:" + car.toString());

        car.move(CommandConstant.forward.getCode());
        System.out.println("desc after:" + car.toString());

        Assert.assertEquals(car.getPositionX(), 2);
        Assert.assertEquals(car.getPositionY(), 1);
        Assert.assertEquals(car.getOrientation(), OrientationConstant.East.getCode());
        System.out.println();
    }

    @org.junit.Test
    public void test4() {
        final String desc4 = "Given the Car is in position X = 1 and Y = 1 and facing West, when the Car moves forward, then an exception is thrown";

        thrown.expect(DefaultException.class);
        thrown.expectMessage("illeagl command");

        System.out.println("desc:" + desc4);

        Car car = new CarImpl(4, 1, 1, OrientationConstant.West);
        System.out.println("desc before:" + car.toString());

        car.move(CommandConstant.forward.getCode());
        System.out.println("desc after:" + car.toString());
        System.out.println();
    }

    @org.junit.Test
    public void test5() {
        final String desc5 = "Given the Car is in position X = 1 and Y = 1 and facing East, when the Car moves forward twice, then the Car is still facing East but is now in position X = 3 and Y = 1";
        System.out.println("desc:" + desc5);

        Car car = new CarImpl(4, 1, 1, OrientationConstant.East);
        System.out.println("desc before:" + car.toString());

        car.move(CommandConstant.forward.getCode() + "," + CommandConstant.forward.getCode());
        System.out.println("desc after:" + car.toString());

        Assert.assertEquals(car.getPositionX(), 3);
        Assert.assertEquals(car.getPositionY(), 1);
        Assert.assertEquals(car.getOrientation(), OrientationConstant.East.getCode());
        System.out.println();
    }

}
