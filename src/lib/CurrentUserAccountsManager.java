package lib;
import java.io.*;
//import java.util.*;


class CurrentUserAccountsManager {
	String newUserAccount;
	String mainUserAccount;
	
	CurrentUserAccountsManager(String newAcc, String mainAcc){
		newUserAccount = newAcc;
		mainUserAccount = mainAcc;
	}
	
	int addUser(String user, String pass, String accType, float credits){
		
		try{
			FileInputStream in = new FileInputStream(mainUserAccount);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			// iterate through file
			String line = reader.readLine();
			while(line != null){
				String []accData = new String[3];
				
				// get data
				accData[0] = line.substring(0, 15);
				accData[1] = line.substring(16, 18);
				accData[2] = line.substring(19, 28);
				
				// if user found, return user found error
				if(accData[0].equals(user)){
					System.out.println("ERROR: User already exists");
					reader.close();
					return(-1);
				}
				line = reader.readLine();
			}
			reader.close();
			
			FileWriter fw = new FileWriter(new File(mainUserAccount), true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			// write user info into account file
			bw.write(user + " " + accType + " " + credits +"\n");
			bw.close();
		} catch (Exception e){
			System.out.println(e.getStackTrace());
			return(-1);
		}
		return(0);
	}
	
	int deleteUser(String user){
		try{
			FileInputStream in = new FileInputStream(mainUserAccount);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			FileWriter fw = new FileWriter(new File(mainUserAccount), false);
			BufferedWriter bw = new BufferedWriter(fw);
			
			// iterate through file
			String line = reader.readLine();
			while(line != null){
				String []accData = new String[3];
				
				// get data
				accData[0] = line.substring(0, 15);
				accData[1] = line.substring(16, 18);
				accData[2] = line.substring(19, 28);
				
				// if not user, write the line back into file
				if(!accData[0].equals(user)){
					fw.write(accData[0] + " " + accData[1] + " " + accData[2] +"\n");
				}
				line = reader.readLine();
			}
			reader.close();
			bw.close();
		} catch (Exception e){
			System.out.println(e.getStackTrace());
			return(-1);
		}
		return(0);
	}
	
	int addCredit(String user,float amount){
		try{
			FileInputStream in = new FileInputStream(mainUserAccount);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			FileWriter fw = new FileWriter(new File(mainUserAccount), false);
			BufferedWriter bw = new BufferedWriter(fw);
			
			// iterate through file
			String line = reader.readLine();
			while(line != null){
				String []accData = new String[3];
				
				// get data
				accData[0] = line.substring(0, 15);
				accData[1] = line.substring(16, 18);
				accData[2] = line.substring(19, 28);
				
				// if user is found, add the credits to his account
				if(accData[0].equals(user)){
					accData[2] = "" + (Float.valueOf(accData[2]) + amount);
					bw.write(accData[0] + " " + accData[1] + " " + accData[2] +"\n");
					reader.close();
					bw.close();
					return(0);
				}
				line = reader.readLine();
			}
			bw.close();
			reader.close();
			return(-1);
		} catch (Exception e){
			System.out.println(e.getStackTrace());
			return(-1);
		}
	}
	
	int refund(String seller, String buyer, float amount){
		try{
			FileInputStream in = new FileInputStream(mainUserAccount);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			FileWriter fw = new FileWriter(new File(mainUserAccount), false);
			BufferedWriter bw = new BufferedWriter(fw);
			
			// iterate through file
			String line = reader.readLine();
			while(line != null){
				String []accData = new String[3];
				
				// get data
				accData[0] = line.substring(0, 15);
				accData[1] = line.substring(16, 18);
				accData[2] = line.substring(19, 28);
				
				// if buyer found, add amount into his account
				if(accData[0].equals(buyer)){
					accData[2] = "" + (Float.valueOf(accData[2]) + amount);
					fw.write(accData[0] + " " + accData[1] + " " + accData[2] +"\n");
				}
				
				// if seller found, subtract amount from his account
				if(accData[0].equals(seller)){
					accData[2] = "" + (Float.valueOf(accData[2]) - amount);
					fw.write(accData[0] + " " + accData[1] + " " + accData[2] +"\n");
				}
				line = reader.readLine();
			}
			
			reader.close();
			bw.close();
		} catch (Exception e){
			System.out.println(e.getStackTrace());
			return(-1);
		}
		return(0);
	}
}
