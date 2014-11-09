
public class SenbeiMaker {
	private int senbeiNum;    
	private int ability;      
	private PowerupItem powItem[] = new PowerupItem[256];   
	private int itemNum;   
	
	public SenbeiMaker(int abi) { 
		ability = abi;
		senbeiNum = 0;
		itemNum = 0;
	}
	public int getSenbeiNum() { 
		return senbeiNum;
	}
	
	public int makeSenbei() {   
		senbeiNum += ability;
		return senbeiNum;
	}
	
	public void makePowerupItem(int type) {    
		if (itemNum > 256) return;   
		if (senbeiNum < PowerupItem.ITEMCOST[type - 1]) 
			return;
		
		powItem[itemNum] = new PowerupItem(type);
		senbeiNum -= PowerupItem.ITEMCOST[type - 1]; 
		ability += powItem[itemNum].getAbility();           
		
		itemNum++;     
		System.out.println("makeitem:");
	}
	
	public void developPowerupItem(int type) {   
		int cost = PowerupItem.ITEMCOST[type - 1] * 10;
		while (senbeiNum > cost) {
			senbeiNum -= cost;  
			for (int i = 0; i < itemNum; i++) {    
				if (powItem[i].getType() == type)    
					powItem[i].powerup();
			}
		}
	}
	
}
