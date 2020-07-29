package com;

import java.util.Scanner;

public class Ladder {

	static final int SIZE=100;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		for( int tc = 1; tc <= 10; tc++) {
			sc.hasNextInt(); //  의미없는 값 받기
			
			int[][] map = new int[SIZE][SIZE];
			
			// 저장
			for ( int i=0; i< SIZE; i++) {
				for( int j=0; j<SIZE; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 사다리 줄기의 번호들을 순차적으로 저장할 배열
			int [] lanes = new int[SIZE];
			// 목적지가 있는 위치를 저장할 변수
			int goalIdx =0;
			
		 	int idx = 0; // 사다리 살이 있는 위치
		 	
		 	for ( int j=0; j<SIZE; j++) { // 모든 열을 한 바퀴 돌면서
		 		
		 		// 사다리 살이 발견되면  idx번째에 발견된 사다리 살의 번호를 저장해두고 idx를 증가
		 		if( map[SIZE-1][j] != 0) {
		 			if ( map[SIZE-1][j] == 2) 
			 			goalIdx= j;
			 		
		 			lanes[idx++] =j;
		 		}
		 		
		 	}	
		 		
		 		// 발견된 사다리 살의 갯수는 ? idx 개 
		 		int curIdx = goalIdx;
		 		// 올라가자
		 		for ( int i= SIZE -1; i>= 0; i--) {
		 			// 내가.. 지금 curIdx 번째 살에 있다.
		 			// 왼쪽이 낭떠러지가 아니다 라는 검사 lanes[curIdx] >= 0
		 			if ( lanes[curIdx]- 1 >= 0 && map[i][lanes[curIdx] -1 ] == 1) {
		 				curIdx --;
		 			}
		 			else if ( lanes[curIdx] + 1 < SIZE && map[i][lanes[curIdx] + 1 ] == 1) 
		 				curIdx ++;
		 		}
		 	
			System.out.println("#"+tc+" " + lanes[curIdx]);
		}
		
	}

}
