/* 
 * Dale Kim
 * DocuSign Interview Assignment
 * 7/5/2017
 */

package myHouse;

public class HotTemperature implements HumanCommands {

	//default false and as we put each clothing piece on, they will flip to true as described below!
	//when that piece of clothing is on (boolean = true), if user tries to put on that same clothing twice, returns fail (Rule #3)
	boolean wearingFootwear, wearingHeadwear, wearingShirt, wearingPants;
	//Initial state inside our cozy house (Rule #1)
	boolean insideHouse = true;
	//Initial state with our PJs on (Also part of Rule #1)
	boolean wearingPJs = true;
	//A counter to keep track of how many pieces of clothing is on our human, on a hot day. (No socks/jacket)
	//Since the condition for HotTemperature is just 4 pieces of clothing, our checkList is complete at int value of 4. (Rule #9)
	int checkList = 0;

	@Override
	public void putOnFootwear() {
		//If we are not wearing footwear and pants check, we really are wearing pants, proceed! Rule #6 & Rule #7
		if(!wearingFootwear && wearingPants && !wearingPJs) {
			wearingFootwear = true;
			checkList++;
			System.out.print("sandals,");
		} else {
			failure();
		}
	}

	@Override
	public void putOnHeadwear() {
		//Just making sure, if we are not wearing headwear and we are wearing a shirt, proceed! (Rule #8)
		if(!wearingHeadwear && wearingShirt && !wearingPJs) {
			wearingHeadwear = true;
			checkList++;
			System.out.print("sun visor,");
		} else {
			failure();
		}
	}

	@Override
	public void putOnSocks() {
		//It's too hot, auto-fail. (Rule #4)
		failure();
	}

	@Override
	public void putOnShirt() {
		if(!wearingShirt && !wearingPJs) {
			wearingShirt = true;
			checkList++;
			System.out.print("t-shirt,");
		} else {
			failure();
		}
	}

	@Override
	public void putOnJacket() {
		//It's too hot, auto-fail. (Rule #5)
		failure();
	}

	@Override
	public void putOnPants() {
		if(!wearingPants && !wearingPJs) {
			wearingPants = true;
			checkList++;
			System.out.print("shorts,");
		} else {
			failure();
		}
	}

	@Override
	public void leaveHouse() {
		if(insideHouse && checkList == 4) {
			insideHouse = false;
			System.out.print("leaving house");
		} else {
			failure();
		}
	}

	@Override
	public void removePJs() {
		if(wearingPJs) {
			wearingPJs = false;
			System.out.print("Removing PJs,");
		} else {
			failure();
		}
	}

	//Rule #2, every method has a check if PJ's are off before else they fail.
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