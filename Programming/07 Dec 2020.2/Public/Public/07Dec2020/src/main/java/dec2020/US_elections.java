package dec2020;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class US_elections {
    public static int solution(int num_states, int[] delegates, int[] votes_Biden, int[] votes_Trump, int[] votes_Undecided){        
        int[] delg_to_Biden = new int[num_states];
        int[] votes_to_Biden = new int[num_states];
        
        int total_delegates = Arrays.stream(delegates).sum();
        
        int temp;
   
        for (int i = 1; i < delegates.length; i++) {
            for (int j = i; j > 0; j--) {
                if (delegates[j] > delegates [j - 1]) {
                    temp = delegates[j];
                    delegates[j] = delegates[j - 1];
                    delegates[j - 1] = temp;
                    
                    temp = votes_Biden[j];
                    votes_Biden[j] = votes_Biden[j - 1];
                    votes_Biden[j - 1] = temp;
                    
                    temp = votes_Trump[j];
                    votes_Trump[j] = votes_Trump[j - 1];
                    votes_Trump[j - 1] = temp;
                    
                    temp = votes_Undecided[j];
                    votes_Undecided[j] = votes_Undecided[j - 1];
                    votes_Undecided[j - 1] = temp;
                }
            }
        }
        
        
        for(int i=0;i<num_states;i++){
            if(votes_Undecided[i]==0){
                if(votes_Biden[i]>votes_Trump[i]){
                    delg_to_Biden[i]=delegates[i];
                }else if(votes_Biden[i]<votes_Trump[i]){
                    delg_to_Biden[i]=0;
                }else if(votes_Biden[i]==votes_Trump[i]){
                    delg_to_Biden[i]=-1;
                }
            }else if(votes_Undecided[i]!=0){
                if(votes_Biden[i]>votes_Trump[i]){
                    if(votes_Biden[i]>(votes_Trump[i]+votes_Undecided[i])){
                        delg_to_Biden[i]=delegates[i];
                    }else if(votes_Biden[i]<(votes_Trump[i]+votes_Undecided[i])){
                        if((votes_Undecided[i]-(votes_Biden[i]-votes_Trump[i]))%2==0){
                            votes_to_Biden[i]=((votes_Undecided[i]-(votes_Biden[i]-votes_Trump[i]))/2)+1;
                            delg_to_Biden[i]=-1;
                        }else{
                            votes_to_Biden[i]=(int)Math.ceil((votes_Undecided[i]-(votes_Biden[i]-votes_Trump[i]))/2);
                            delg_to_Biden[i]=-1;
                        }
                    }
                }else if(votes_Biden[i]<votes_Trump[i]){
                    if((votes_Biden[i]+votes_Undecided[i])<votes_Trump[i]){
                        delg_to_Biden[i]=0;
                    }else if((votes_Biden[i]+votes_Undecided[i])>votes_Trump[i]){
                        if((votes_Undecided[i]-(votes_Trump[i]-votes_Biden[i]))%2==0){
                            votes_to_Biden[i]=(votes_Trump[i]-votes_Biden[i])+((votes_Undecided[i]-(votes_Trump[i]-votes_Biden[i]))/2)+1;
                            delg_to_Biden[i]=-1;
                        }else{ 
                            votes_to_Biden[i]=(votes_Trump[i]-votes_Biden[i])+(int)Math.ceil((votes_Undecided[i]-(votes_Trump[i]-votes_Biden[i]))/2);
                            delg_to_Biden[i]=-1;
                        }
                    }
                }else if(votes_Biden[i]==votes_Trump[i]){
                    if((votes_Undecided[i])%2==0){
                        votes_to_Biden[i]=(votes_Undecided[i]/2)+1;
                        delg_to_Biden[i]=-1;
                    }else {
                        votes_to_Biden[i]=(int)Math.ceil(Double.valueOf(votes_Undecided[i])/2);
                        delg_to_Biden[i]=-1;
                        
                    }
                    
                }
            }
        }
        for(int i=0;i<num_states;i++){
            //System.out.println(i+" delg_to_Biden = "+delg_to_Biden[i]+" votes_to_Biden = "+votes_to_Biden[i]);
        }
        int delg_won=0,delg_lost=0,delg_undecided=0;
        for (int i = 0; i<num_states; i++){
             if(delg_to_Biden[i]==0){
                delg_lost+=delegates[i];
            }else if(delg_to_Biden[i]>0){
                delg_won+=delegates[i];
            }
        }
        
        int votes_req=0, delg_maybe=0;
        for (int i =0; i<num_states; i++){
            if(delg_to_Biden[i]==-1){
                delg_undecided+=delegates[i];
                if(votes_to_Biden[i]>0){
                    votes_req+=votes_to_Biden[i];
                    delg_maybe+=delegates[i];
                    if(delg_won+delg_maybe>total_delegates/2){
                        return votes_req;
                    }
                }
            }           
        }
        
        if(delg_maybe+delg_won<=total_delegates/2){
            return -1;
        }
        
        //System.out.println("delg_won = "+delg_won+" delg_lost = "+delg_lost+" delg_undecided = "+delg_undecided);
        
        
        return 0;

    }

    public static void main(String[] args) {
        try {
            for(int i =1;i<6;i++){
                String path = "You path\open_case_"+i+".txt";
                File myFile = new File(path);
                Scanner sc = new Scanner(myFile);
                int num_states = sc.nextInt();
                System.out.println(num_states);
                int[] delegates = new int[num_states];
                int[] votes_Biden = new int[num_states];
                int[] votes_Trump = new int[num_states];
                int[] votes_Undecided = new int[num_states];	
                for (int state = 0; state<num_states; state++){
                    delegates[state] =sc.nextInt();
                    votes_Biden[state] = sc.nextInt();
                    votes_Trump[state] = sc.nextInt();
                    votes_Undecided[state] = sc.nextInt();
                    System.out.println(delegates[state]+" "+ votes_Biden[state]+" "+ votes_Trump[state]+" "+ votes_Undecided[state]);
                }
                sc.close();
                int answer = solution(num_states, delegates, votes_Biden, votes_Trump, votes_Undecided);
                System.out.println(answer);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
          	
    }
}