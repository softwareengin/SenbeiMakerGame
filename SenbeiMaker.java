/*
 * SenbeiMakerTestから受け取るtypeは１〜５であるとして処理を行っている
 * 
 * 問題点
 * 何回パワーアップしたのかユーザはわからない
 * アイテムを入れる配列の後ろにあるアイテムは（あとに装着したアイテム）パワーアップされにくい
 */

public class SenbeiMaker {
	private int senbeiNum;    //せんべいの枚数を表す  
	private int ability;      //製造機の初期能力を表す
	private int itemabi;      //パワーアップアイテムの合計能力を表す
	private PowerupItem powItem[] = new PowerupItem[256];  
	private int itemNum;   //パワーアップアイテムの数を表す
	
	public SenbeiMaker(int abi) { 
		ability = abi;      //製造機の初期値を設定
		senbeiNum = 0;
		itemNum = 0;
	}
	public int getSenbeiNum() { 
		return senbeiNum;
	}
	
	public int makeSenbei() {   //せんべいを焼く処理
		
		int makeNum = ability + itemabi;
		senbeiNum += makeNum;    //初期性能とパワーアップアイテムの能力値だけせんべいが増える
		
		return senbeiNum;
	}
	

	public void makePowerupItem(int type) {     //パワーアップアイテム追加処理
		/*アイテム保有数が限界の時、せんべいが足りない時　処理終了*/
		if (type < 1 || type > 5) return;//不正な値の場合何もしない  
		if (itemNum > 256) return;   
		if (senbeiNum < PowerupItem.ITEMCOST[type - 1]) 
			return;
		
		powItem[itemNum] = new PowerupItem(type);
		senbeiNum -= PowerupItem.ITEMCOST[type - 1];   //せんべいの消費
		itemabi += powItem[itemNum].getAbility();           //アイテム性能をパワーアップ
		
		itemNum++;     //アイテム保有数を+１
		
		printMakeItem(type);
	}
	
	public void developPowerupItem(int type) {   //せんべいがある限りしていしたアイテムを強化
	    if (type < 1 || type > 5) return;//不正な値の場合何もしない 
		int cost = PowerupItem.ITEMCOST[type - 1] * 10;   //強化に必要なせんべいの枚数を計算
		itemabi = 0;     //アイテムの能力を初期化
		
		while (senbeiNum > cost) {    //パワーアップできそうなら以下の処理を繰り返す
		    senbeiNum -= cost;  
		    
		    for (int i = 0; i < itemNum; i++) {    
			if (senbeiNum < cost) break;    //せんべいが足りなくなったら
			if (powItem[i].getType() == type) {   //アイテムを検索
			    senbeiNum -= cost;  //せんべいの消費
			    powItem[i].powerup();   //パワーアップ
			}
		    }
		}
		itemabi = calItemAbility();
		printPowerupItem(type);
	}
	
	public int calItemAbility() { 	//パワーアップアイテムの能力を計算
		int power = 0;    //アイテムの合計せんべい焼き能力を表す
		for (int i = 0; i < itemNum; i++) {   //計算
			power += powItem[i].getAbility();
		}
		return power;
	}
	
	public void printMakeItem(int type) {   //アイテム装着時のプロンプト出力
	    System.out.print("make:");
		
	    switch (type) {    //typeにあった出力を選択
	    case 1:
		System.out.println("HAND");
		break;
	    case 2:
		System.out.println("JIJI");
		break;
	    case 3:
		System.out.println("FARM");
		break;
	    case 4:
		System.out.println("FACTORY");
		break;
	    case 5:
		System.out.println("MINE");
	    }
	    System.out.println("ItemNum:" + itemNum);   //アイテムの保有数を出力
	}
	
	public void printPowerupItem(int type) {
	    System.out.print("powerup:");
	    
	    switch (type) {    //typeにあった出力を選択
	    case 1:
		System.out.println("HAND");
		break;
	    case 2:
		System.out.println("JIJI");
		break;
	    case 3:
		    System.out.println("FARM");
		    break;
	    case 4:
		System.out.println("FACTORY");
		break;
	    case 5:
		System.out.println("MINE");
	    }
	}
	
	}
    