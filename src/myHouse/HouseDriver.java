/* Dale Kim
 * DocuSign Interview Assignment
 * 7/5/2017
 */

package myHouse;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HouseDriver {

	public static void main(String[] args) {
		//Another way could be done using a HashSet.
		//HashSet hs = new HashSet();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Input the Temperature Type and the comma separated list of numeric commands:");
		
		//splitting the commands into two
		String input = sc.nextLine();
		String[] s = input.split(" ");	

		//storing whether it is a hot or cold and storing the numerical commands list
		String temperatureType = s[0];
		ArrayList<String> commandsList = new ArrayList<String>();
		
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(input);
		while (m.find()) {
			commandsList.add(m.group());
		}

		HumanCommands hc = null;

		//be it hot or cold, letting hc represent whether or not I will be implementing hot or cold methods for the house
		if (temperatureType.equalsIgnoreCase("HOT")) {
			hc = new HotTemperature();
		} else if (temperatureType.equalsIgnoreCase("COLD")) {
			hc = new ColdTemperature();
		}

		int x = 0;
		
		//continue the while loop unless it runs out of commands
		//based on the guidelines if we are fully dressed we will leave the house.
		//program will stop no matter what though depending on how many commands are given.
		while (x < commandsList.size()) {
			if (commandsList.get(x).equals("1")) {
				hc.putOnFootwear();
			} else if (commandsList.get(x).equals("2")) {
				hc.putOnHeadwear();
			} else if (commandsList.get(x).equals("3")) {
				hc.putOnSocks();
			} else if (commandsList.get(x).equals("4")) {
				hc.putOnShirt();
			} else if (commandsList.get(x).equals("5")) {
				hc.putOnJacket();
			} else if (commandsList.get(x).equals("6")) {
				hc.putOnPants();
			} else if (commandsList.get(x).equals("7")) {
				hc.leaveHouse();
			} else if (commandsList.get(x).equals("8")) {
				hc.removePJs();
			} else {
				hc.defaultMessage();
			}
			x++;
		}
	}
}