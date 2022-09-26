import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<int[]> timeList = new ArrayList<>();
        int maxValue = 0;                    //add
        for(int i=0;i<n;i++){
            int start = in.nextInt();
            int end = in.nextInt()+sta  rt;
            maxValue = Math.max(maxValue, end); // add
            timeList.add(new int[]{start,1});
            timeList.add(new int[]{end,-1});
        }
        int[] map = new int[maxValue+1];    //add
        for(int[] item:timeList) {          //add
            map[item[0]] = item[1];
        }

        int ans = 0;

        int taskNum = 0;
        for(int time:map){                 //update
            taskNum +=time;
            if(taskNum <0){
                System.out.println(-1);
                return;
            }
            ans = Math.max(taskNum,ans);
        }
        System.out.println(ans);
    }

}