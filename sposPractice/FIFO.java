import java.util.*;

class FIFO{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of Frames: ");
        int fr = sc.nextInt();
        int frames[] = new int[fr];

        System.out.println("Enter number of Inputs: ");
        int n = sc.nextInt();
        int pageRef[] = new int [n];
        System.out.println("Enter page reference String: ");
        for(int i=0; i<n; i++){
            pageRef[i] = sc.nextInt();
        }

        for(int i=0; i<fr; i++){
            frames[i] = -1;
        }

        int hit=0;
        int fault=0;
        int j=0;
        boolean check;

        for(int i=0; i<n; i++){
            check = false;
            for(int k=0; k<fr; k++){
                if(frames[k] == pageRef[i]){
                    check = true;
                    hit = hit + 1;
                }
            }

            if(check == false){
                frames[j] = pageRef[i];
                j++;
                if(j>=fr){
                    j=0;
                }

                fault = fault + 1;
            }
        }

        float hitR = hit/n;
        float faultR = fault/n;

        System.out.println("Hit : "+hitR);
        System.out.println("Fault : "+faultR);

        sc.close();
    }
}