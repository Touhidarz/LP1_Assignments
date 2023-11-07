import java.util.*;
class firstFit{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of Blocks: ");
        int nBlocks = sc.nextInt();
        int Blocks[] = new int[nBlocks];
        for(int i=0; i<nBlocks; i++){
            Blocks[i] = sc.nextInt();
        }

        System.out.println("Enter number of Process:");
        int nProcess = sc.nextInt();
        int Process[] = new int[nProcess];
        System.out.println("Enter size of Process:");
        for(int i=0; i<nProcess; i++){
            Process[i] = sc.nextInt();
        }

        int finish[] = new int[nBlocks];

        for(int i=0; i<nProcess; i++){
            int k = -1;

            for(int j=0; j<nBlocks; j++){
                if(Blocks[j] >= Process[i]){
                    if(finish[j] != 1){
                        k=j;
                        finish[k] = 1;
                        break;
                    }
                }
            }

            if(k != -1){
                
                System.out.println("Fit for Process "+Process[i]+" is : "+Blocks[k]+" and holes created are "+ (Blocks[k] - Process[i]));
            }
            
        }
        sc.close();
    
    }
}