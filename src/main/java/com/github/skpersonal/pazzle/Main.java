package com.github.skpersonal.pazzle;

import java.util.Scanner;

public class Main {
    private static int[][] maze;
    private static int[] playerVec = {1, 1};
    private final static int mazeSize = 16;
    private static int num = 0;

    public static void main(String[] args) {
        MapList mapList = new MapList();
        maze = mapList.getMap();
        showMap();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            if (str.equalsIgnoreCase("d")) {
                moveRight();
            } else if (str.equalsIgnoreCase("a")) {
                moveLeft();
            } else if (str.equalsIgnoreCase("w")) {
                moveUp();
            } else if (str.equalsIgnoreCase("s")) {
                moveDown();
            } else if (str.equalsIgnoreCase("e")) {
                break;
            }
        }
        System.out.println("test");
    }

    private static void showMap() {
        for (int a = 0; a < mazeSize; a++) {
            for (int b = 0; b < mazeSize; b++) {
                if (playerVec[0] == b && playerVec[1] == a) {
                    System.out.print(3);
                } else {
                    System.out.print(maze[a][b]);
                }
                if (b == mazeSize - 1) {
                    System.out.println();
                }
            }
        }
        if (checkGoal()) {
            System.out.println("ゲーム終了");
            System.out.println("かかった手順の回数は" + num + "回です");
            System.exit(0);
        }
        num++;
        System.out.print(">");
    }

    private static boolean checkGoal() {
        return maze[playerVec[1]][playerVec[0]] == 2;
    }

    private static void moveRight() {
        while (maze[playerVec[1]][playerVec[0] + 1] != 1) {
            playerVec[0]++;
            if (maze[playerVec[1]][playerVec[0]] == 2) {
                break;
            }
        }
        showMap();
    }

    private static void moveLeft() {
        while (maze[playerVec[1]][playerVec[0] - 1] != 1) {
            playerVec[0]--;
            if (maze[playerVec[1]][playerVec[0]] == 2) {
                break;
            }
        }
        showMap();
    }

    private static void moveUp() {
        while (maze[playerVec[1] - 1][playerVec[0]] != 1) {
            playerVec[1]--;
            if (maze[playerVec[1]][playerVec[0]] == 2) {
                break;
            }
        }
        showMap();
    }

    private static void moveDown() {
        while (maze[playerVec[1] + 1][playerVec[0]] != 1) {
            playerVec[1]++;
            if (maze[playerVec[1]][playerVec[0]] == 2) {
                break;
            }
        }
        showMap();
    }
}