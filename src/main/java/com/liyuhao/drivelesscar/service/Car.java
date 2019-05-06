package com.liyuhao.drivelesscar.service;

/**
 *
 * (Y)
 *   +---+---+---+---+
 * 4 |   |   |   |   |
 *   +---+---+---+---+
 * 3 |   |   |   |   |     N
 *   +---+---+---+---+ W <-|-> E
 * 2 |   |   |   |   |     S
 *   +---+---+---+---+
 * 1 | C |   |   |   |
 *   +---+---+---+---+
 *     1   2   3   4 (X)
 */
public interface Car {

    void move(String command);

    int getPositionX();

    int getPositionY();

    String getOrientation();
}