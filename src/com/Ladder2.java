package com;

import java.util.Arrays;
import java.util.Scanner;

public class Ladder2 {
	
	// 좌 , 우 , 서치 	
		private static int[] dr = { 0, 0};
		private static int[] dc = {-1, 1};
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			
			int [][] Ladder = new int[100][100];
			int [] min = new int [100]; // 각 열시작 시 총 이동거리
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
				// 아래로 내려가기
				for ( int answer =0 ; answer <100; answer++) {
					c = answer ;
					r = 0;
					
					if ( Ladder[r][c] == 1 ) { // 맨 위에 1이 있다면 
						while (true) { // 끝 ( 행 == 99 ) 만날 때 까지 내려가자
							r ++; // 한칸 내려가서
							min[answer]++;
							if ( r >= 100 ) break;
							
							/*
							 * if ( Ladder[r][c] == 2) { // 끝을 만난다면, System.out.println("#"+tc+" "+answer);
							 * 
							 * find = true; break; }
							 */
							
							if (  r == 99) { // 끝을 만난다면,
								//System.out.println("#"+tc+" "+answer);
								
								
								break;
							}
							
							// 끝이 아니고, 좌우 검색
							
								new_r = r;   
								new_c = c;
								for ( int d = 0; d<2; d++) {
									new_r = r + dr[d]; // 앞을 내다볼 위치
									new_c = c + dc[d];
									
									// boundary check
									if ( new_r < 0 || new_c < 0 || new_r >= 100 || new_c >= 100 ) {
										continue;
									}
									
									if ( Ladder[new_r][new_c] == 1) { // 좌우로 가는 길이 있다면
										LR = true;
										r = new_r;
										c = new_c; // 해당 위치로 한 칸 이동 
										min[answer]++;
										while(true) {  // 한 방향으로 계속 검사
											new_r = r + dr[d]; // 앞을 내다볼 위치
											new_c = c + dc[d];
											
											if ( new_r < 0 || new_c < 0 || new_r >= 100 || new_c >= 100 ) {
												break;
											}
											
											if ( Ladder[new_r][new_c] == 1) { // 좌우로 가는 길이 있다면
												r = new_r;
												c = new_c; // 해당 위치로 이동
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
