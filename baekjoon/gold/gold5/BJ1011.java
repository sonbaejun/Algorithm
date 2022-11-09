//baekjoon 1011번 Fly me to the Alpha Centauri(골드5)

package gold.gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BJ1011 {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int[] array = new int[T];

        for(int i=0; i<T; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            int distance = y-x;
            int max = (int) Math.sqrt(distance);

            if(max == Math.sqrt(distance)) {
                array[i] = 2*max-1;
            }
            else if(distance <= max*max+max) {
                array[i] = 2*max;
            }
            else {
                array[i] = 2*max+1;
            }
        }

        for(int i =0; i<T; i++) {
            System.out.println(array[i]);
        }
    }
}

