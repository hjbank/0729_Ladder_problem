package com;

import java.util.Arrays;
import java.util.Scanner;

public class Ladder2 {
	
	// �� , �� , ��ġ 	
		private static int[] dr = { 0, 0};
		private static int[] dc = {-1, 1};
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			
			int [][] Ladder = new int[100][100];
			int [] min = new int [100]; // �� ������ �� �� �̵��Ÿ�
			int minpos = 9999999;
			int temp = 9999999;
			int r = 0 ;
			int c = 0 ;
			boolean find = false;
			boolean LR = false;
			int new_c= 0;
			int new_r= 0;
			for ( int tc=1; tc<=10; tc++) {
				// store
				int first = sc.nextInt();
				
				
				for ( int i=0; i<100; i++) {
					for( int j=0; j<100;j ++) {
						Ladder[i][j] = sc.nextInt();
					}
				}
				find = false;
				LR = false;
				// �Ʒ��� ��������
				for ( int answer =0 ; answer <100; answer++) {
					c = answer ;
					r = 0;
					
					if ( Ladder[r][c] == 1 ) { // �� ���� 1�� �ִٸ� 
						while (true) { // �� ( �� == 99 ) ���� �� ���� ��������
							r ++; // ��ĭ ��������
							min[answer]++;
							if ( r >= 100 ) break;
							
							/*
							 * if ( Ladder[r][c] == 2) { // ���� �����ٸ�, System.out.println("#"+tc+" "+answer);
							 * 
							 * find = true; break; }
							 */
							
							if (  r == 99) { // ���� �����ٸ�,
								//System.out.println("#"+tc+" "+answer);
								
								
								break;
							}
							
							// ���� �ƴϰ�, �¿� �˻�
							
								new_r = r;   
								new_c = c;
								for ( int d = 0; d<2; d++) {
									new_r = r + dr[d]; // ���� ���ٺ� ��ġ
									new_c = c + dc[d];
									
									// boundary check
									if ( new_r < 0 || new_c < 0 || new_r >= 100 || new_c >= 100 ) {
										continue;
									}
									
									if ( Ladder[new_r][new_c] == 1) { // �¿�� ���� ���� �ִٸ�
										LR = true;
										r = new_r;
										c = new_c; // �ش� ��ġ�� �� ĭ �̵� 
										min[answer]++;
										while(true) {  // �� �������� ��� �˻�
											new_r = r + dr[d]; // ���� ���ٺ� ��ġ
											new_c = c + dc[d];
											
											if ( new_r < 0 || new_c < 0 || new_r >= 100 || new_c >= 100 ) {
												break;
											}
											
											if ( Ladder[new_r][new_c] == 1) { // �¿�� ���� ���� �ִٸ�
												r = new_r;
												c = new_c; // �ش� ��ġ�� �̵�
												min[answer]++;
											}
											else break;
											
										}
									}
									if (LR) {
										LR = false;
										break;
									}
								}
								
							
						}
					}
					
					
				}
//				//test
//				
//				for ( int i=0; i<100; i++) {
//					System.out.print(min[i]+" ");
//				}
//				
				for( int i=0; i< 100; i++) {
				
					
					  if ( min[i] > 0 && min[i] < temp ) {
						  temp = min[i]; 
						  minpos = i;					  
					  }
					 
				}
				
				System.out.println("#"+tc+" "+minpos);
				
				Arrays.fill(min, 0);
				
				temp = 999999;
			}
		}

}
