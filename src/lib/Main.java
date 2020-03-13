package lib;

public class Main {
	CurrentUserAccountsManager cu;
	AvailableItemsFileManager ai;
	public static void main(String[] args) {
		// TODO add main loop to iterate DTF and execute transactions
		while(true){
			
		}
	}
	
	public void parseLine(String line){
		// TODO
		String transactionType = line.substring(0, 2);
		switch(transactionType){
			//add	
			case "01":
				String username = line.substring(3, 18);
				String accType = line.substring(19, 22);
				float credits = Float.valueOf(line.subString(23, 32));
				
				cu.addUser(username, "placeholderPassword", accType, credits);
			//delete
			case "02":
				String username = line.substring(3, 18);
				String accType = line.substring(19, 22);
				float credits = Float.valueOf(line.subString(23, 32));
				
				cu.deleteUser(username);
				
			//advertise
			case "03":
				String itemName = line.substring(3, 22);
				String seller = line.substring(23, 38);
				int duration = Integer.parseInt(line.substring(39, 42));
				float minBid = Float.valueOf(line.substring(43, 49));
				
				ai.advertise(seller, itemName, minBid, duration);
			//bid	
			case "04":
				String itemName = line.substring(3, 22);
				String seller = line.substring(23, 38);
				String buyer = line.substring(39, 54);
				float credits = Float.valueOf(line.substring(55, 61));
				
				ai.bid(seller, itemName, buyer, credit);
			//retfund	
			case "05":
				String buyer = line.substring(3, 18);
				String seller = line.substring(19, 34);
				float credits = Float.valueOf(line.substring(35, 44));
				
				cu.refund(seller, buyer, credits);
			//addcredit
			case "06":
				String username = line.substring(3, 18);
				String accType = line.substring(19, 22);
				float credits = Float.valueOf(line.subString(23, 32));
				
				cu.addCredit(username, credits);
		}
	}

}
