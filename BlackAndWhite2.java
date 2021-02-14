
import java.util.*;

public class BlackAndWhite2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		int myPoint = 99; // 나의 포인트. 시작시 99점 부여
		int botPoint = 99; // 컴퓨터의 포인트 . 시작시 99점 부여
		
		int round = 1; // 라운드. 9라운드 까지 있음
		
		int myNum = 0; // 나의 점수. 5점되면 끝남
		int botNum = 0; // 너의 점수. 5점되면 끝남.
		
		int[] botSet = new int[9];
		while (botSet[0] + botSet[1] + botSet[2] + botSet[3] + botSet[4] + botSet[5] + botSet[6] + botSet[7] + botSet[8] != 99) {
			for (int i = 0; i < 9; i++) {
				botSet[i] = random.nextInt(40);
			}
			if (botSet[0] + botSet[1] + botSet[2] + botSet[3] + botSet[4] + botSet[5] + botSet[6] + botSet[7] + botSet[8] == 99) {
				continue;
			}
		}
// 		System.out.println(botSet[0] + " " + botSet[1] + " " + botSet[2] + " " + botSet[3] + " " + botSet[4] + " " + botSet[5] + " " + botSet[6] + " " + botSet[7] + " " + botSet[8]);
		
		int mySet = 0;
		
		boolean finish = false;
		boolean mySetTest = false;
		
		while (finish == false) {
			
			if (round == 10 || myNum == 5 || botNum == 5) {
				System.out.println("게임이 종료되었습니다.");
				if (myNum > botNum) {
					System.out.println("당신이 승리하셨습니다.");
				} else if (botNum > myNum) {
					System.out.println("당신은 패배하셨습니다.");
				} else if (botNum == myNum) {
					System.out.println("무승부입니다.");
				}
				break;
			}
			
			System.out.println("---------------------------------------");
			System.out.println("현재 점수는 : " + myNum + " vs " + botNum +" 이며, 현재 당신의 포인트는 : " + myPoint);
			System.out.println(round + " 라운드 시작합니다.");
			botPoint = botPoint-botSet[round-1];
			if (botSet[round-1] >= 10) {
				System.out.println("컴퓨터가 제시한 점수는 백 입니다.");
			} else {
				System.out.println("컴퓨터가 제시한 점수는 흑 입니다.");
			}
			
			if (botPoint >= 80) {
				System.out.println("상대방의 포인트는 ■ ■ ■ ■ ■");
			} else if (botPoint >= 60) {
				System.out.println("상대방의 포인트는 ■ ■ ■ ■ □");
			} else if (botPoint >= 40) {
				System.out.println("상대방의 포인트는 ■ ■ ■ □ □");
			} else if (botPoint >= 20) {
				System.out.println("상대방의 포인트는 ■ ■ □ □ □");
			} else if (botPoint >= 0) {
				System.out.println("상대방의 포인트는 ■ □ □ □ □");
			}
			
			System.out.println("당신의 차례입니다. 포인트를 제시하시오");

			mySet = scan.nextInt();

			myPoint = myPoint - mySet;
			System.out.println("당신이 제시한 점수는 : " + mySet + " 입니다.");
			
			if (botSet[round-1] > mySet) {
				System.out.println("이번 라운드는 당신이 패배하였습니다");
				botNum++;
			} else if (botSet[round-1] == mySet) {
				System.out.println("무승부입니다.");
			} else if (botSet[round-1] < mySet) {
				System.out.println("이번 라운드는 당신이 승리하셨습니다.");
				myNum++;
			} 
			round++;
		}

	}
	
}
