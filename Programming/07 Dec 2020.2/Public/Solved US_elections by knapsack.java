package Final;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class US_elections {


/**
 * This is a helper method to calculate the minimum votes that Biden need in order to win the state 
 * if there's no way for Biden to win return -1
 * there are situations that Biden don't need any remaining votes to win, return 0
 */
	public static int minToWin(int votes_Biden, int votes_Trump, int Undecided) {
		int minToWin = 0;
		if (votes_Biden > votes_Trump) {
			int temp = Undecided - (votes_Biden - votes_Trump -1);
			if (temp > 0) {
				minToWin = (int) Math.ceil(temp/2.0);
			}else {
				minToWin = 0;
			}
		}else if(votes_Biden < votes_Trump) {
			int temp = Undecided - (votes_Trump - votes_Biden +1);
			if (temp >= 0) {
				minToWin = (votes_Trump - votes_Biden +1) + (int) Math.ceil(temp/2.0);
			}else {
				minToWin = -1; //there's no way for Biden to win
			}
		}else {
			minToWin = 1 + (int) Math.ceil((Undecided-1)/2.0);
		}
		return minToWin; 
	}
/**
 * We want to minimize the votes for Biden and the weight(delegates) must greater than delegates/2.
 * What we can do is: create a Knapsack table that finds a subset of states such that the sum of their delegates
 * is strictly less than "total delegates - (delegates/2 +1)" and the sum of their minToWin is maximal
 * Then we exclude all the states in the Knapsack, what we left are states with minimum sum of minToWin
 * and at least "total delegates - (delegates/2 +1)" (can be equal) sum of delegates
 */
	public static int solution(int num_states, int[] delegates, int[] votes_Biden, int[] votes_Trump, int[] votes_Undecided){
		int totDelegates = 0;
		
		for(int i = 0; i<num_states; i++) {
			totDelegates += delegates[i];
		}
		
		//now we create a new array that contains minToVotes for each states
		int minToWin[]=new int [num_states];
		for (int i = 0; i < num_states; i++) {
			minToWin[i]=minToWin(votes_Biden[i],votes_Trump[i],votes_Undecided[i]);
		}
		
		
		int BalreadyWon=0;
		for (int i = 0; i < num_states; i++) {
			if (minToWin[i]==0) {
				BalreadyWon += delegates[i];
			}
		}
		
		int TalreadyWon=0;
		for (int i = 0; i < num_states; i++) {
			if (minToWin[i]==-1) {
				TalreadyWon += delegates[i];
			}
		}
		
		int solution = 0;	//final solution
		
		if (BalreadyWon >= (totDelegates/2 + 1) ) {
			return 0;
		}else if (TalreadyWon >= Math.ceil(totDelegates/2.0)) {
			return -1;
		}else {
			
			ArrayList<Integer> temp = new ArrayList<Integer>();
			ArrayList<Integer> temp2 = new ArrayList<Integer>();
			for (int i = 0; i < minToWin.length; i++) {
				if (minToWin[i]==-1 || minToWin[i]==0) {
					continue;
				}else {
					temp.add(minToWin[i]);
					temp2.add(delegates[i]);
				}
			}
			
			int [] value = new int[temp.size()]; //value
			int [] weight = new int[temp2.size()]; //weight
			int totKnap = 0;
			
			for(int i = 0; i<temp.size();i++) {
				value[i]= temp.get(i);
				weight[i]=temp2.get(i);
				totKnap += value[i];
			}

			int battleStates = totDelegates - BalreadyWon - TalreadyWon;
			int leastToWin = (totDelegates/2 + 1) - BalreadyWon;
			int kLimit = battleStates - leastToWin;
			
			int knapsack[][] = new int [value.length + 1][kLimit + 1];
			
			for (int i = 0; i <= value.length; i++) {
				for (int j = 0; j <= kLimit; j++) {
					if (i==0 || j==0) {
						knapsack[i][j]=0;
					}else if(weight [i-1] <= j) {
						knapsack[i][j]= Math.max(value[i-1]+knapsack[i - 1][j - weight[i - 1]], knapsack[i - 1][j]);
					}else {
						knapsack[i][j]=knapsack[i-1][j];
					}
				}
			}
			
			int knapMax = knapsack[value.length][kLimit];
	
			solution = totKnap - knapMax;;
			
			
			
			
			
		}
		return solution;
	}



	public static void main(String[] args) {
	 try {
			String path = args[0];
      File myFile = new File(path);
      Scanner sc = new Scanner(myFile);
      int num_states = sc.nextInt();
      int[] delegates = new int[num_states];
      int[] votes_Biden = new int[num_states];
      int[] votes_Trump = new int[num_states];
 			int[] votes_Undecided = new int[num_states];	
      for (int state = 0; state<num_states; state++){
			  delegates[state] =sc.nextInt();
				votes_Biden[state] = sc.nextInt();
				votes_Trump[state] = sc.nextInt();
				votes_Undecided[state] = sc.nextInt();
      }
      sc.close();
      int answer = solution(num_states, delegates, votes_Biden, votes_Trump, votes_Undecided);
      	System.out.println(answer);
    	} catch (FileNotFoundException e) {
      	System.out.println("An error occurred.");
      	e.printStackTrace();
    	}
  	}

}