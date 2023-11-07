import java.util.*;

class SJF{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of Process: ");
        int n = sc.nextInt();
        int systemTime=0, totalCmpl = 0;

        int arrivalTime[] = new int[n];
        int burstTime[] = new int[n];
        int cmplTime[] = new int[n];
        int turnArTime[] = new int[n];
        int waitingTime[] = new int[n];

        int finish[] = new int[n];
        int k[] = new int[n];

        for(int i=0; i<n; i++){
            System.out.print("Enter Arrival Time of Process "+ (i+1)+" : ");
            arrivalTime[i] = sc.nextInt();

            System.out.print("Enter Burst Time of Process "+ (i+1)+" : ");
            burstTime[i] = sc.nextInt();
            k[i] = burstTime[i];
            finish[i]=0;

        }
        

        while(true){
            int c=n, min = 99;

            if(totalCmpl==n){
                break;
            }

            for(int i=0; i<n; i++){

                if((arrivalTime[i] <= systemTime) && (burstTime[i] < min) && (finish[i]==0)){
                    min = burstTime[i];
                    c = i;
                }

            }

            if(c == n){
                systemTime ++;
            }
            else{
                burstTime[c] --;
                systemTime ++;
                if(burstTime[c] == 0){
                    cmplTime[c] = systemTime;
                    finish[c] = 1;
                    totalCmpl ++;
                }
            }
            
        }
       

        for(int i=0; i<n; i++){
            turnArTime[i] = cmplTime[i] - arrivalTime[i];
            waitingTime[i] =  turnArTime[i] - k[i];
            
        }
        System.out.println("Process "+"ArrivalTime "+"BurstTime "+"ComplTime "+"TurnArTime "+"WaitingTime ");
        for(int i=0; i<n; i++){
           
            System.out.println("\t"+(i+1)+"\t"+arrivalTime[i]+"\t"+k[i]+"\t"+cmplTime[i]+"\t"+turnArTime[i]+"\t"+waitingTime[i]);
            
        }
        sc.close();
    }
}