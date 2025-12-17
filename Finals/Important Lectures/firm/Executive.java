package firm;

public class Executive {
	 private double bonus;
	 private String socialSecurityNumber;
	 private double payRate;
	 private String name;
	 private String address;
	 private String phone;
	   //-----------------------------------------------------------------
	   //  Constructor: Sets up this executive with the specified
	   //  information.
	   //-----------------------------------------------------------------
	   public Executive (String eName, String eAddress, String ePhone,
	                     String socSecNumber, double rate)
	   {
	      //super (eName, eAddress, ePhone, socSecNumber, rate);
		      name = eName;
		      address = eAddress;
		      phone = ePhone;
		      socialSecurityNumber = socSecNumber;
		      payRate = rate;
	          bonus = 0;  // bonus has yet to be awarded
	   }

	   //-----------------------------------------------------------------
	   //  Awards the specified bonus to this executive.
	   //-----------------------------------------------------------------
	   public void awardBonus (double execBonus)
	   {
	      bonus = execBonus;
	   }

	   //-----------------------------------------------------------------
	   //  Computes and returns the pay for an executive, which is the
	   //  regular employee payment plus a one-time bonus.
	   //-----------------------------------------------------------------
	   public double pay()
	   {
	      double payment = payRate + bonus;

	      bonus = 0;

	      return payment;
	   }

	   public String toString()
	   {
		   String result = "Name: " + name + "\n";

		   result += "Address: " + address + "\n";
		   result += "Phone: " + phone;
	       result += "\nSocial Security Number: " + socialSecurityNumber;

	      return result;
	   }
}
