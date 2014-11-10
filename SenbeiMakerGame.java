import java.io.*;

public class SenbeiMakerGame {
	public static void main (String[] args) {
		
		String baff = null;     //キーボードバッファ
		SenbeiMaker maker = new SenbeiMaker(1);
	try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (baff.equals("q")) {    //qキーの押下まで繰り返す
			System.out.print("<");
			baff = in.readLine();     //キーボード入力の読み込み
			if (baff.equals("make")) {   //make処理を書く
				maker.makeSenbei();//せんべい焼くぜ
				
			}
			else if (baff.equals("item")) {   //アイテム作成処理
				System.out.println("Item select");
				System.out.println("1:HAND 2:JIJI 3:FARM 4:FACTORY 5:MINE");
				System.out.print("<");
				baff = in.readLine();    //キーボード入力の読み込み
				
				//アイテム作成処理
				maker.makePowerItem(baff);
			}
			else if (baff.equals("pwup")) {
				System.out.println("PowerupItem select");
				System.out.println("1:HAND 2:JIJI 3:FARM 4:FACTORY 5:MINE");
				System.out.print("<");
				baff = in.readLine();    //キーボード入力の読み込み
				
				//パワーアップ処理
				maker.developPowerupItem();
				
			}
			else if (baff.equals("show")) {    //showの処理どうすりゃいい
				
			}
			else {   //入力が不正なとき
				System.out.println("そんなコマンドないよ");
			}
			
		}
				
			
	} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}

}
