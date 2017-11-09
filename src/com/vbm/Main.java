package com.vbm;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[][] islands = new int[7][];
        islands[0] = new int[]{1, 1, 0, 0, 0, 0, 0};
        islands[1] = new int[]{1, 1, 3, 0, 2, 0, 0};
        islands[2] = new int[]{0, 3, 1, 6, 0, 1, 0};
        islands[3] = new int[]{0, 0, 6, 1, 0, 0, 1};
        islands[4] = new int[]{0, 2, 0, 0, 1, 0, 0};
        islands[5] = new int[]{0, 0, 1, 0, 0, 1, 2};
        islands[6] = new int[]{0, 0, 0, 1, 0, 2, 1};

        System.out.println("Source graph array: ");
        System.out.println();

        arrayprint(islands);

        System.out.println();
        System.out.println();

        arrayprint(mapper(islands));
    }

    private static void boardprint(int length, boolean numbers) {
        if (numbers) {
            for (int i = 0; i < length; ++i)
                System.out.print("  " + String.valueOf(i + 1) + " ");
            System.out.println();
        }
        for (int i = 0; i < length; ++i)
            System.out.print("----");
        System.out.print("-");
        System.out.println();
    }

    private static void arrayprint(int[][] islands) {
        boardprint(islands.length, true);
        for (int i = 0; i < islands.length; ++i) {
            System.out.print("| ");
            for (int j = 0; j < islands.length; ++j)
                System.out.print(islands[i][j] + " | ");
            System.out.println("  " + String.valueOf(i + 1));
            boardprint(islands.length, false);
        }

    }

    private static int[][] mapper(int[][] graph) {

        int[][] myMap = new int[graph.length][];

        // Клонируем массив чтобы не перезаписывать исходный
        for (int i = 0; i < graph.length; i++)
            myMap[i] = graph[i].clone();

        for (int i = 0; i < myMap.length; ++i) {
            for (int j = 0; j < myMap.length; ++j) {

                if (i == j || myMap[i][j] == 0) continue;

                for (int k = 0; k < myMap.length; k++) {
                    if (k == i || k == j) continue;
                    if (myMap[j][k] == 0) continue;
                    myMap[i][k] = (myMap[i][k] > (myMap[i][j] + myMap[j][k])) || myMap[i][k] == 0 ? myMap[i][j] + myMap[j][k] : myMap[i][k];
                    myMap[k][i] = myMap[i][k];
                }
            }

           /* System.out.println();
            arrayprint(myMap);
            System.out.println();*/
        }
        return myMap;
    }

}
