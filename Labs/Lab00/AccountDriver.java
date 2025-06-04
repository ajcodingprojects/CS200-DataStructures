import core.more.*;


public class AccountDriver {
  public static void main(String args[]){
    Account act1 = new Account();
    Account act2 = new Account("Savings", "Danny", 33200);
    act1.credit(5000);
    System.out.println("$ " + act1.getTotal()/100.0);
    act2.debt(5000);
    System.out.println("$ " + act2.getTotal()/100.0);

  }
} 