import java.util.*;

public class bestFit {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Blocks :");
        int nBlocks = sc.nextInt();

        int Blocks[] = new int[nBlocks];
        System.out.println("Enter size of each Block:");
        for(int i=0; i<nBlocks; i++){
            Blocks[i] = sc.nextInt();
        }

        System.out.print("Enter number of Process :");
        int nProcess = sc.nextInt();

        int Process[] = new int[nProcess];
        System.out.println("Enter size of each Block:");
        for(int i=0; i<nProcess; i++){
            Process[i] = sc.nextInt();
        }

        int filled[] = new int[nBlocks];

        for(int i=0; i<nProcess; i++){
            int k = -1;

            for(int j=0; j<nBlocks; j++){
                if(Blocks[j] >= Process[i]){
                    
                   if( (k==-1 || Blocks[j]<Blocks[k]) && filled[j] != 1){
                    k = j;
                    } 
                }   
                
            }
            if(k != -1){
                filled[k] = 1;
                System.out.println("Block for "+Process[i]+" is "+Blocks[k]);
            }
            else{
                System.out.println("Block is not allocated");
            }
        }
        sc.close();
    }
}
