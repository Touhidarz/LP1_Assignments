import java.util.*;

public class nextFit {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of Blocks: ");
        int nBlocks = sc.nextInt();
        int Blocks[] = new int[nBlocks];
        System.out.println("Enter size of Blocks: ");
        for(int i=0; i<nBlocks; i++){
            Blocks[i] = sc.nextInt();
        }

        System.out.print("Enter number of Process: ");
        int nProcess = sc.nextInt();
        int Process[] = new int[nProcess];
        System.out.println("Enter size of Process: ");
        for(int i=0; i<nProcess; i++){
            Process[i] = sc.nextInt();
        }

        int finish[] = new int[nBlocks];
        int k = 0; 
        int flag = 0;

        for(int i=0; i<nProcess; i++){
            int j=k;
            do{
                if(Blocks[j] >= Process[i]){
                    if(finish[j] != 1){
                        k = j;
                        finish[j] = 1;
                        flag = 1;
                        break;
                    }
            }
            j++;
            if(j == nBlocks){
                j=0;
            }

            }while(j != k);

            if(flag == 0){
                System.out.println("Fit not found for Process");
            }
            else{
                System.out.println("Fit for process "+Process[i]+" is : "+Blocks[k]+" with holes created are "+ (Blocks[k] - Process[i]));
            }
        }
        sc.close();
    }
}
