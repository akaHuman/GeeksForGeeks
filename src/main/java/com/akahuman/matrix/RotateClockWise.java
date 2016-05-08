package com.akahuman.matrix;

import com.akahuman.util.Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by akahuman on 7/5/16.
 */
public class RotateClockWise {

    private static int[][] rotateClockwise(int[][] arr, int n) {
        int[][] newArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newArr[j][n - i - 1] = arr[i][j];
            }
        }
        return newArr;
    }

    private static void swap(int[][] arr, int x1, int y1, int x2, int y2) {
        int temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    /**
     * Swap following: arr[start][i] <-> arr[i][end] <-> arr[end][start+end-1] <-> arr[start+end-1][start]
     */
    private static void fourWaySwap(int[][] arr, int start, int end, int i) {
        swap(arr, start, i, i, end);
        swap(arr, start, i, end, start + end - i);
        swap(arr, start, i, start + end - i, start);
    }

    private static void rotateClWInPlace(int[][] arr, int n) {
        int start = 0, end = n - 1;
        while (start <= end) {
            for (int i = start; i < end; i++) {
                fourWaySwap(arr, start, end, i);
            }
            start++;
            end--;
        }
    }

    public static void main(String[] args) throws IOException {

        /*BufferedImage image = ImageIO.read(new File("/home/akahuman/Desktop/e.png"));
        int[][] imagePixels = new int[image.getWidth()][image.getHeight()];
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                imagePixels[i][j] = image.getRGB(i, j);
            }
        }

        rotateClWInPlace(imagePixels, image.getWidth());
        BufferedImage op = new BufferedImage(image.getWidth(), image.getHeight(), 1);
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                op.setRGB(i, j, imagePixels[i][j]);
            }
        }
        ImageIO.write(op, "jpg", new File("/home/akahuman/Desktop/rotE.jpg"));*/

        int n = 20;
        int[][] arr = new int[n][n];
        int ctr = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = ctr++;
            }
        }
        rotateClWInPlace(arr, n);
        Utils.printArr(arr, n);
        int[][] rotatedArr = rotateClockwise(arr, n);
        Utils.printArr(rotatedArr, n);
    }
}
