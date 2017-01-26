package com.example;
import java.util.*;

public class kNearestPoint {
    public static class Point {
        double x;
        double y;
        public Point(double a, double b) {
            x = a;
            y = b;
        }
    }
    public static Point[] kNP(Point[] array, Point o, int k) {
        final Point origin = o;
        PriorityQueue<Point> pq = new PriorityQueue<>(k+1, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                double distSQR1 = (p1.x-origin.x)*(p1.x-origin.x) + (p1.y - origin.y) * (p1.y - origin.y);
                double distSQR2 = (p2.x-origin.x)*(p2.x-origin.x) + (p2.y - origin.y) * (p2.y - origin.y);
                return (int)(distSQR2 - distSQR1);
            }
        });
        for (Point p : array) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        Point[] res = new Point[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        for (int i = 0; i < res.length/2; i++) {
            Point temp = res[i];
            res[i] = res[res.length - i - 1];
            res[res.length - i - 1] = temp;
        }
        return res;
    }
    public static void main(String[] args) {
        Point p1 = new Point(-1, 1);
        Point p2 = new Point(-2, 2);
        Point p3 = new Point(3, 3);
        Point p4 = new Point(4, -4);
        Point o = new Point(0, 0);
        Point[] input = {p1, p2, p3, p4};
        Point[] res = kNP(input, o, 2);
        for (Point p : res) {
            System.out.println(p.x + " " + p.y);
        }
    }
}
