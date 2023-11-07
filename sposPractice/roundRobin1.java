import java.util.*;

public class roundRobin1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int i, temp, count=0, sq=0;

        System.out.print("Enter number of Process: ");
        int n = sc.nextInt();

        int burstTime[] = new int[n];
        int wtTime[] = new int[n];
        int turnArTime[] = new int[n];
        int rem_burstTime[] = new int[n];

        System.out.print("Enter Burst Time for each Process ");
        for(i=0; i<n; i++){
            burstTime[i] = sc.nextInt();
            rem_burstTime[i] = burstTime[i];
        }

        System.out.print("Enter time Quantum: ");
        int timeQuant = sc.nextInt();

        while(true){
            for(i=0, count=0; i<n; i++){
                temp = timeQuant;

                if(rem_burstTime[i] == 0){
                    count ++;
                    continue;
                }

                if(rem_burstTime[i] > timeQuant){
                    rem_burstTime[i] = rem_burstTime[i] - timeQuant;
                }

                else if(rem_burstTime[i] >= 0){
                    temp = rem_burstTime[i];
                    rem_burstTime[i] = 0;
                }
                sq = sq + temp;
                turnArTime[i]  = sq;
            }
            if(count == n){
                break;
            }
        }

        System.out.println("Process"+"\tburstTime"+"\tturnAroundTime"+"\twaitingTime");
        for( i=0; i<n; i++){
            wtTime[i] = turnArTime[i] - burstTime[i];
            System.out.println("\t"+(i+1)+"\t"+burstTime[i]+"\t"+turnArTime[i]+"\t"+wtTime[i]);
        }

        

    }
}
