/* 
 * Dale Kim
 * DocuSign Interview Assignment
 * 7/5/2017
 */

package myHouse;

//one day there may be a rainy day or a windy day or a day where its hailing and you don't want to leave the house
interface HumanCommands {
	//command 1
	void putOnFootwear();
	//command 2
	void putOnHeadwear();
	//command 3
	void putOnSocks();
	//command 4
	void putOnShirt();
	//command 5
	void putOnJacket();
	//command 6
	void putOnPants();
	//command 7
	void leaveHouse();
	//command 8
	void removePJs();
	//fail
	void failure();
	//default message
	void defaultMessage();
}
