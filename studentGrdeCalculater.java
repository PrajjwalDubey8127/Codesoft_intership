import java.util. *;

public class studentGrdeCalculater {
    void calcuategrade(int per){
        if(per>=90){
            System.out.println(" A++ Grade ");
        }
        if(per>=80 && per<90 ){
            System.out.println(" A  grade");
        }
        if(per>=70 && per<=79){
            System.out.println(" B+ grade");
        }
        if(per>=60 && per<70){
            System.out.println(" c  grade");
        }
        if(per>=50 && per<60){
            System.out.println(" Fail !!!");
        }
    }
      public static  void main(String args[]){
      Scanner sc= new Scanner (System.in);
      System.out.println(" Welcome to our Parcentage && Grade  Calculater  !!");
       System.out.println(" Enter your number subjects first");
       int subjects=sc.nextInt();
       int sum=0;
       for(int i=1; i<=subjects; i++){
        System.out.printf(" Enter your %d subject of marks in between (1,100)",i);
         int userinput= sc.nextInt();
         sum+=userinput;
       }
        int per= sum/subjects;
       System.out.printf(" your Parcentage of total marks is %d \n",per);
       
       studentGrdeCalculater s= new studentGrdeCalculater();
       s.calcuategrade(per);

      }  
}
