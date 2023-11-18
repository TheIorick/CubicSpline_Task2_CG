package com.example.task2;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class CubicSplineController {
    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;
    List<Point2D> points = new ArrayList<Point2D>();
    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        canvas.setOnMouseClicked(event -> {
            switch (event.getButton()) {
                case PRIMARY -> handlePrimaryClick(canvas.getGraphicsContext2D(), event);
            }
        });
    }

    private void handlePrimaryClick(GraphicsContext graphicsContext, MouseEvent event) {
        final Point2D clickPoint = new Point2D(event.getX(), event.getY());

        final int POINT_RADIUS = 0;
        graphicsContext.fillOval(
                clickPoint.getX() - POINT_RADIUS, clickPoint.getY() - POINT_RADIUS,
                2 * POINT_RADIUS, 2 * POINT_RADIUS);
        //если больше нуля, то
        if (points.size() > 0) {
            final Point2D lastPoint = points.get(points.size() - 1);
            graphicsContext.strokeLine(lastPoint.getX(), lastPoint.getY(), clickPoint.getX(), clickPoint.getY());
        }
        points.add(clickPoint);
    }
    /**
     * первая точка - ничего не происходит
     * вторая точка - добавили в лист, посчитали коэф-фы, занесли коэф-фы в матрицу,
     * построили пор коэф-фам кривую
     * Новая точка - добавили в лист, посчитали коэф-фы, с учетом старых (обновили в радиусе двух(?)), построили прямую.
     *
     *
     * метод для того чтобы построить расширенную матрицу, что нужно для сi
     * метод для метода прогонки
     * методы для нахождения di, bi, ai
     *
     * находим все коэффициенты для матрицы, далее мы через коэф-фы выражаем 3n неизвестных
     *  метод который принимает все коэф-фы и сторит линию на отрезке
     *
     *
     *  *Спросить у Лизы/Нелли - как точно находить сi. То есть у нас есть матрица,
     *  мы находим для неё коэф-фы.. а сi, ci+1, ci+2.. как.. не понятно
     *  что такое f(xi) = y?
     *
     *  причем наша линия она же по идее
     */

}