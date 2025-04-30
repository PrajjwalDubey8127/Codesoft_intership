
import java.util.*;

public class NumberGame {
   public static void main(String args[]){
   Scanner sc= new Scanner(System.in);
   int computer= (int)(Math.random()*100);
   boolean b= true;
   int Attemp=0;
   int user;
   System.out.println("Computer is aleady choosen his number in between (1,100) ");
   while(b){
   System.out.println(" choose your number");
  user= sc.nextInt();
  if(user==computer){
    Attemp++;
     System.out.println(" Congratulations  You have found exact match "+Attemp);
     b=false;
  }
  else if(user>computer){
    System.out.println(" you choose too high number");
  }
  else{
    System.out.println(" You are too low to guess current number ");
  }
  Attemp++;
}
 } 
}
