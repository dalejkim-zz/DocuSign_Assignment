/* 
 * Dale Kim
 * DocuSign Interview Assignment
 * 7/5/2017
 */

package myHouse;

public class ColdTemperature implements HumanCommands{

	//default false and as we put each clothing piece on, they will flip to true as described below!
	//when that piece of clothing is on (boolean = true), if user tries to put on that same clothing twice, returns fail (Rule #3)
	boolean wearingFootwear, wearingHeadwear, wearingSocks, wearingShirt, wearingJacket, wearingPants;
	//Initial state inside our cozy house (Rule #1)
	boolean insideHouse = true;
	//Initial state with our PJs on (Also part of Rule #1)
	boolean wearingPJs = true;
	//A counter to keep track of how many pieces of clothing is on our human, on a cold day. (Everything on)!
	//Since the condition for ColdTemperature is all 6 pieces of clothing, our checkList is complete at int value of 6. (Rule #9)
	int checkList = 0;

	@Override
	public void putOnFootwear() {
		//If we are not wearing footwear and wearing pants and wearing socks, proceed! Rule #6 & Rule #7
		if(!wearingFootwear && wearingPants && wearingSocks && !wearingPJs) {
			wearingFootwear = true;
			checkList++;
			System.out.print("boots,");
		} else {
			failure();
		}
	}

	@Override
	public void putOnHeadwear() {
		//Just making sure, if I am not wearing a headwear already and we are wearing a shirt, proceed. (Rule #8)
		if(!wearingHeadwear && wearingShirt && !wearingPJs) {
			wearingHeadwear = true;
			checkList++;
			System.out.print("hat,");
		} else {
			failure();
		}
	}

	@Override
	public void putOnSocks() {
		if(!wearingSocks && !wearingPJs) {
			wearingSocks = true;
			checkList++;
			System.out.print("socks,");
		} else {
			failure();
		}
	}

	@Override
	public void putOnShirt() {
		if(!wearingShirt && !wearingPJs) {
			wearingShirt = true;
			checkList++;
			System.out.print("shirt,");
		} else {
			failure();
		}
	}

	@Override
	public void putOnJacket() {
		//Check if I'm not wearing a jacket already and I have a shirt on. (Rule #8)
		if(!wearingJacket && wearingShirt && !wearingPJs) {
			wearingJacket = true;
			checkList++;
			System.out.print("jacket,");
		} else {
			failure();
		}
	}

	@Override
	public void putOnPants() {
		if(!wearingPants && !wearingPJs) {
			wearingPants = true;
			checkList++;
			System.out.print("pants,");
		} else {
			failure();
		}
	}

	@Override
	public void leaveHouse() {
		if(insideHouse && checkList == 6) {
			insideHouse = false;
			System.out.print("leaving house");
		} else {
			failure();
		}
	}

	//Rule #2, every method has a check if PJ's are off before else they fail.
	@Override
	public void removePJs() {
		if(wearingPJs) {
			wearingPJs = false;
			System.out.print("Removing PJs,");
		} else {
			failure();
		}
	}

	//
	@Override
	public void failure() {
		System.out.print("fail");
		System.exit(0);
	}

	@Override
	public void defaultMessage() {
		System.out.println("Invalid input, please refer to the command manual, exiting.");
	}
}