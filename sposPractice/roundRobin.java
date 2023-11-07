import java.util.*;

public class roundRobin {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int temp, i, sq = 0, count = 0;

        System.out.println("Enter Number of process: ");
        int n = sc.nextInt();

        int brstTime[] = new int[n];
        int waitingTime[] = new int[n];
        int rem_brstTime[] = new int[n];
        int turnaroundTime[] = new int[n];

        System.out.println("Enter Burst time for each process :");
        for(i=0; i<n; i++){
            brstTime[i] = sc.nextInt();
            rem_brstTime[i] = brstTime[i];
        }

        System.out.println("Time Quantum :");
        int timeQuantum = sc.nextInt();

        while(true){
            for(i=0, count=0; i<n;i++){
                temp = timeQuantum;

                if(rem_brstTime[i] == 0){
                    count ++;
                    continue;
                }

                if(rem_brstTime[i] > timeQuantum){
                    rem_brstTime[i] = rem_brstTime[i] - timeQuantum;
                }

                else if(rem_brstTime[i] >= 0){
                    temp = rem_brstTime[i];
                    rem_brstTime[i] = 0;
                }

                sq = sq + temp;
                turnaroundTime[i] = sq;
            }

            if(n==count){
                break;
            }
        }
        
        System.out.println("Process"+"\tburstTime"+"\tturnAroundTime"+"\twaitingTime");
        for( i=0; i<n; i++){
            waitingTime[i] = turnaroundTime[i] - brstTime[i];
            System.out.println("\t"+(i+1)+"\t"+brstTime[i]+"\t"+turnaroundTime[i]+"\t"+waitingTime[i]);
        }
        
       sc.close();
    }
}
