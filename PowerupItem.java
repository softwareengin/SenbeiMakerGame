
public class PowerupItem_344829 {
	/*各パワーアップアイテムを表す定数*/
	static final int HAND = 1;
	static final int JIJII = 2;
	static final int FARM = 3;
	static final int FACTORY = 4;
	static final int MINE = 5;
	
	static final int ITEMABI[] = {1, 5, 20, 100, 400};   
	static final int ITEMCOST[] = {15, 100, 500, 3000, 10000};
	
	private int type;      //アイテムの種類
	private double ability;   //現在の性能値
	
	public PowerupItem_344829(int type) {
		this.type = type;
		ability = ITEMABI[type - 1];
	}

	public void powerup() {      //アイテムをパワーアップ
		ability *= 1.3;
	}
	
	public int getAbility() {
	return (int)ability;
	}
	public int getType() {
		return type;
	}
}	