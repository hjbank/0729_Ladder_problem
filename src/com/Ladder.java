package com;

import java.util.Scanner;

public class Ladder {

	static final int SIZE=100;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		for( int tc = 1; tc <= 10; tc++) {
			sc.hasNextInt(); //  �ǹ̾��� �� �ޱ�
			
			int[][] map = new int[SIZE][SIZE];
			
			// ����
			for ( int i=0; i< SIZE; i++) {
				for( int j=0; j<SIZE; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// ��ٸ� �ٱ��� ��ȣ���� ���������� ������ �迭
			int [] lanes = new int[SIZE];
			// �������� �ִ� ��ġ�� ������ ����
			int goalIdx =0;
			
		 	int idx = 0; // ��ٸ� ���� �ִ� ��ġ
		 	
		 	for ( int j=0; j<SIZE; j++) { // ��� ���� �� ���� ���鼭
		 		
		 		// ��ٸ� ���� �߰ߵǸ�  idx��°�� �߰ߵ� ��ٸ� ���� ��ȣ�� �����صΰ� idx�� ����
		 		if( map[SIZE-1][j] != 0) {
		 			if ( map[SIZE-1][j] == 2) 
			 			goalIdx= j;
			 		
		 			lanes[idx++] =j;
		 		}
		 		
		 	}	
		 		
		 		// �߰ߵ� ��ٸ� ���� ������ ? idx �� 
		 		int curIdx = goalIdx;
		 		// �ö���
		 		for ( int i= SIZE -1; i>= 0; i--) {
		 			// ����.. ���� curIdx ��° �쿡 �ִ�.
		 			// ������ ���������� �ƴϴ� ��� �˻� lanes[curIdx] >= 0
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
