package com.liyuhao.drivelesscar.service;

import com.liyuhao.drivelesscar.constant.CommandConstant;
import com.liyuhao.drivelesscar.constant.OrientationConstant;
import com.liyuhao.drivelesscar.exception.DefaultException;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CarImpl implements Car {

    int dimensions = 4;
    int x = 1;
    int y = 1;
    OrientationConstant orientation;
    List<CommandConstant> commands;

    public CarImpl(int dimensions, int x, int y, OrientationConstant orientation) {
        Assert.assertTrue(x >= 1 && x <= dimensions);
        Assert.assertTrue(y >= 1 && y <= dimensions);

        this.dimensions = dimensions;
        this.x = x;
        this.y = y;
        this.orientation = Optional.ofNullable(orientation).orElse(OrientationConstant.North);
    }

    @Override
    public void move(String command) {
        command = Optional.ofNullable(command).orElse("").trim();
        List<String> commandStrs = Arrays.asList(command.split(","));
        commands = new ArrayList<>(commandStrs.size());
        commandStrs.forEach((eachCommand) -> commands.add(CommandConstant.getByCode(eachCommand)));

        commands.forEach((commandConstant) -> {
                    switch (commandConstant) {
                        case clockwise:
                            switch (this.orientation) {
                                case North:
                                    this.orientation = OrientationConstant.East;
                                    break;
                                case East:
                                    this.orientation = OrientationConstant.South;
                                    break;
                                case South:
                                    this.orientation = OrientationConstant.West;
                                    break;
                                case West:
                                    this.orientation = OrientationConstant.North;
                                    break;
                                default:
                                    throw new DefaultException("illeagl command");
                            }
                            break;

                        case anticlockwise:
                            switch (this.orientation) {
                                case North:
                                    this.orientation = OrientationConstant.West;
                                    break;
                                case East:
                                    this.orientation = OrientationConstant.North;
                                    break;
                                case South:
                                    this.orientation = OrientationConstant.East;
                                    break;
                                case West:
                                    this.orientation = OrientationConstant.South;
                                    break;
                                default:
                                    throw new DefaultException("illeagl command");
                            }
                            break;

                        case forward:
                            switch (this.orientation) {
                                case North:
                                    if (this.y < this.dimensions) {
                                        this.y++;
                                        break;
                                    } else {
                                        throw new DefaultException("illeagl command");
                                    }
                                case East:
                                    if (this.x < this.dimensions) {
                                        this.x++;
                                        break;
                                    } else {
                                        throw new DefaultException("illeagl command");
                                    }
                                case South:
                                    if (this.y > 1) {
                                        this.y--;
                                        break;
                                    } else {
                                        throw new DefaultException("illeagl command");
                                    }
                                case West:
                                    if (this.x > 1) {
                                        this.x--;
                                        break;
                                    } else {
                                        throw new DefaultException("illeagl command");
                                    }
                                default:
                                    throw new DefaultException("illeagl command");
                            }
                            break;

                        case backward:
                            switch (this.orientation) {
                                case North:
                                    if (this.y > 1) {
                                        this.y--;
                                        break;
                                    } else {
                                        throw new DefaultException("illeagl command");
                                    }
                                case East:
                                    if (this.x > 1) {
                                        this.x--;
                                        break;
                                    } else {
                                        throw new DefaultException("illeagl command");
                                    }
                                case South:
                                    if (this.y < this.dimensions) {
                                        this.y++;
                                        break;
                                    } else {
                                        throw new DefaultException("illeagl command");
                                    }
                                case West:
                                    if (this.x < this.dimensions) {
                                        this.x++;
                                        break;
                                    } else {
                                        throw new DefaultException("illeagl command");
                                    }
                                default:
                                    throw new DefaultException("illeagl command");
                            }
                            break;

                        default:
                            throw new DefaultException("illeagl command");

                    }
                }

        );

    }

    @Override
    public int getPositionX() {
        return x;
    }

    @Override
    public int getPositionY() {
        return y;
    }

    @Override
    public String getOrientation() {
        return orientation.getCode();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CarImpl{");
        sb.append("dimensions=").append(dimensions);
        sb.append(", x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", orientation=").append(orientation);
        sb.append(", commands=").append(commands);
        sb.append('}');
        return sb.toString();
    }
}
