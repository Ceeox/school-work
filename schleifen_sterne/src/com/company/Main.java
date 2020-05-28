package com.company;

public class Main {

    public static void main(String[] args) {

        // Aufgabe 1
        print_one_star(0);
        System.out.println();

        // Aufgabe 2
        print_stars_horz(10, true);
        System.out.println("\n");

        // Aufgabe 3
        print_stars_vert(10, true);
        System.out.println();

        // Aufgabe 4
        print_stars_cube(10, true);

        // Aufgabe 5, 5a, 5b
        print_stars_cube(10, false);
        System.out.println();
        print_stars_z(10, true);
        System.out.println();
        print_stars_z(10, false);
        System.out.println();

        // Aufgabe 6
        print_stars_triangle(3, false);
        System.out.println();

        // Aufgabe 7
        print_stars_triangle(3, false);
        print_stars_triangle(2, true);
        System.out.println();

        // Aufgabe 8
        print_stars_pyramid(5, 5, false);
        System.out.println();

        // Aufgabe 9
        print_stars_pyramid(5, 5, false);
        print_stars_pyramid(5, 3, true);

    }

    public static void print_one_star(int pos) {
        for (int i = 0; i < pos && i >= 0; i++)
            System.out.print(" ");
        System.out.println("*");
    }

    public static void print_stars_horz(int count, boolean filled) {
        for(int i = 0; i < count && i >= 0; i++) {
            if (filled) {
                System.out.print("*");
            }
            else {
                if ((i == 0) || i == count - 1) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
        }
    }

    public static void print_stars_vert(int count, boolean filled) {
        for(int i = 0; i < count && i >= 0; i++) {
            if (filled) {
                System.out.println("*");
            }
            else {
                if (i == 0 || i == count) {
                    System.out.println("*");
                }
            }
        }
    }

    public static void print_stars_cube(int size, boolean filled) {
        if (!filled) {
            print_stars_horz(size, true);
            System.out.println();
            for(int i = 1; i < size - 1 && i >= 0; i++) {
                print_stars_horz(size, false);
                System.out.println();
            }
            print_stars_horz(size, true);
        }
        else {
            for(int i = 0; i < size && i >= 0; i++) {
                print_stars_horz(size, true);
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void print_stars_diag(int count, int start_at, boolean falling, boolean filled) {
        int start = start_at, end = count;
        boolean running = true;
        if (!falling) {
            start = count;
            end = start_at;
        }
        while (running) {
            if (!filled)
                print_one_star(start);
            else
                print_stars_horz(start, true);

            if (!falling) {
                start--;
                running = start > end;
            }
            else {
                start++;
                running = start < end;
            }
        }
    }

    public static void print_stars_z(int size, boolean reverse) {
        print_stars_horz(size, true);
        System.out.println();
        if (!reverse) {
            print_stars_diag(size - 2,  0, false, false);
        }
        else {
            print_stars_diag(size - 1, 1, true, false);
        }
        print_stars_horz(size, true);
        System.out.println();
    }

    public static void print_stars_triangle(int size, boolean falling) {
        int start = 1, end = size;
        boolean running = true;
        if (falling) {
            start = size;
            end = 1;
        }
        while(running) {
            print_stars_horz(start, true);
            System.out.println();

            if (falling) {
                start--;
                running = start >= end;
            }
            else {
                start++;
                running = start <= end;
            }
        }
    }

    public static void print_stars_pyramid(int size, int stars, boolean reverse) {
        if (stars > size)
            return;
        boolean running = true;
        int current_stars = stars % 2;
        if (reverse)
            current_stars = stars;

        while(running) {
            int white_spaces = (size - current_stars) / 2;
            for (int i = 0; i < white_spaces && i >= 0; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i <  current_stars && i >= 0; i++) {
                System.out.print("*");
            }
            System.out.println();

            if (reverse) {
                current_stars = current_stars - 2;
                running = current_stars > 0;
            }
            else {
                current_stars = current_stars + 2;
                running = current_stars <= stars;
            }
        }
    }
}
