import java.util.*;

public class optimal {

    static boolean search(int key, int frames[]){
        for(int i=0; i<frames.length; i++){
            if(frames[i] == key){
                return true;
            }
        }
        return false;
    }

    static int predict(int pageRef[], int frames[], int n, int index){
        int res = -1; int farthest = -1;

        for(int i=0; i<frames.length; i++){
            int nextPageIndex = -1;

            for(int j=index; j<n; j++){
                if(frames[i] == pageRef[j]){
                    nextPageIndex = j;
                    break;
                }
            }

            if(nextPageIndex == -1){
                return i;
            }
            
            if(nextPageIndex > farthest){
                farthest = nextPageIndex;
                res = i;
            }
        }

        return (res == -1) ? 0 : res;
    }
   
    static void optimal_page(int pageRef[], int fr, int n){
        int frames[] = new int[fr];

        int hit=0; int index=0;

        for(int i=0; i<n; i++){
            if(search(pageRef[i], frames)){
                hit = hit + 1;
                continue;
            }

            if(index < fr){
                frames[index ++] = pageRef[i];
            }
            else{
                int j = predict(pageRef, frames, n, (i+1));
                frames[j] = pageRef[i];
            }
        }

        System.out.println("Hit: "+ hit);

        
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of inputs: ");
        int n = sc.nextInt();
        int pageRef[] = new int[n];

        System.out.println("Enter Ref String:");
        for(int i=0; i<n; i++){
            pageRef[i] = sc.nextInt();
        }

        System.out.print("Enter number of Frames: ");
        int fr = sc.nextInt();

        optimal_page(pageRef, fr, n);
        
        sc.close();
    }
    
}
