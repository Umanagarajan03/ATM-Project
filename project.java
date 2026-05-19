import java.util.*;

class Atm{

   private long accountNumber;
   private int pin;
   private double balance;

public Atm(long accountNumber,int pin,double balance){
    this.accountNumber=accountNumber;
    this.pin=pin;
    this.balance=balance;
    
}
public boolean Acc(long acc){
    return accountNumber==acc;
       
}

public boolean VerifyPin(int pin1){
    if(pin==pin1){
        System.out.println("Your pin is correct.");
        return true;
    }else{
        System.out.println("Please! Enter Correct pin.");
        return false;
    }

}
public void Withdraw(){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter Withdraw Amount:");

    double amount = sc.nextDouble();

    if(amount <= balance){

        balance = balance - amount;

        System.out.println("Withdraw Successful");

        System.out.println("Current Balance: " + balance);
    }
    else{

        System.out.println("Insufficient Balance");
    }

}
public void Deposit(){
    Scanner sc = new Scanner(System.in);
    System.out.println("*********************");

    System.out.println("Enter Deposit Amount:");

    System.out.println("*********************");

    double amount = sc.nextDouble();

    balance = balance + amount;

    System.out.println("Deposit Successful");

    System.out.println("Current Balance: " + balance);

}
public void ChangePin(){
      Scanner sc = new Scanner(System.in);

    System.out.println("Enter Old PIN:");
    int oldPin = sc.nextInt();

    if(pin == oldPin){

        System.out.println("Enter New PIN:");
        int newPin = sc.nextInt();

        this.pin = newPin;

        System.out.println("PIN Changed Successfully");
    }
    else{
        System.out.println("Wrong Old PIN");
    }

}
public void getBalance(){
     System.out.println("Your Balance is: " + balance);
}
}
class AtmObjGen{

   

    public static void main(String[]args) throws InterruptedException{
        Scanner sc=new Scanner(System.in);
        Atm a1=new Atm(123456789L,1234,100000);
        Atm a2=new Atm(123456788L,4321,900000);
        Atm a3=new Atm(123456779L,5678,700000);

        Atm[] user={a1,a2,a3};
        Home(user);}
    
   public static void Home(Atm[] user) throws InterruptedException{

    Scanner sc = new Scanner(System.in);

    System.out.println("**********************");
    System.out.println("      Welcome      ");
    System.out.println("**********************");
   

    System.out.println("\nEnter Your Account number:");
    


    long acc = sc.nextLong();
    System.out.println("Processing.......");
     Thread.sleep(3000);

    Atm currentUser = null;

    // Search account
    for(int i=0; i<user.length; i++){

        if(user[i].Acc(acc)){

            currentUser = user[i];
            break;
        }
    }

    //Verify account
    if(currentUser != null){
    System.out.println("Your Account number correct.");
    }
    else{
    System.out.println("Please! Enter your correct Account number.");
    }


    // If account found
    if(currentUser != null){

        System.out.println("\nEnter your Pin:");

        int pin1 = sc.nextInt();
         System.out.println("Processing.......");
         Thread.sleep(3000);

        boolean fpin = currentUser.VerifyPin(pin1);

        if(fpin){

            System.out.println("\nSelect the Operation:");
            System.out.println("*************");
            System.out.println("1.WITHDRAW");
            System.out.println("2.DEPOSIT");
            System.out.println("3.BALANCE");
            System.out.println("4.CHANGE PIN");
            System.out.println("*************");


            int op = sc.nextInt();
             System.out.println("Processing.......");
             Thread.sleep(3000);

            switch(op){

                case 1 -> currentUser.Withdraw();

                case 2 -> currentUser.Deposit();

                case 3 -> currentUser.getBalance();

                case 4 -> currentUser.ChangePin();

                default -> System.out.println("Invalid Option");
            }
        }
    }

   }
}