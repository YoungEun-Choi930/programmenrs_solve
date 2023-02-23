package SWEA;

import java.io.BufferedReader;
<<<<<<< HEAD
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5644_무선충전 {

	private static int[][] BC;
	private static int ans, M, A;
	private static final int[][] delta = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// input, init
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			int[] personA = new int[M];
			int[] personB = new int[M];
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ; i < M ; i++) {
				personA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ; i < M ; i++) {
				personB[i] = Integer.parseInt(st.nextToken());
			}
			
			BC = new int[A][4];
			for(int i = 0 ; i < A; i++) {
				st = new StringTokenizer(br.readLine()," ");
				BC[i][0] = Integer.parseInt(st.nextToken());	//x
				BC[i][1] = Integer.parseInt(st.nextToken());	//y
				BC[i][2] = Integer.parseInt(st.nextToken());	//c
				BC[i][3] = Integer.parseInt(st.nextToken());	//p
			}
			// ====================================================
			// solve
			ans = 0;
			
			int Ax = 1, Ay = 1, Bx = 10, By = 10;
			// 초기위치에서 확인
			Charge(Ax, Ay, Bx, By);
			
			//이동하면서 확인
			for(int time = 0 ; time < M ; time++) {
				// move
				Ax += delta[personA[time]][0];
				Ay += delta[personA[time]][1];
				Bx += delta[personB[time]][0];
				By += delta[personB[time]][1];
				
				System.out.println(time+"==move== "+Ax+","+Ay+" | "+Bx+","+By);
				// 이동한 자리에 BC가 있는지 확인
				Charge(Ax, Ay, Bx, By);
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
=======
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution5644_무선충전 {
	

	private static StringBuilder sb = new StringBuilder();
	private static final int[][] delta = {{0,0},{0,-1},{1,0},{0,1},{-1,0}};
	private static int[][] BC;
	private static int M, A, answer;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// input
			String[] split = br.readLine().split(" ");
			M = Integer.parseInt(split[0]);  // 총 이동시간
			A = Integer.parseInt(split[1]);  // BC의 개수

			//이동정보
			int[] moveA = new int[M];
			int[] moveB = new int[M];

			String[] splitA = br.readLine().split(" ");
			String[] splitB = br.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(splitA[i]);
				moveB[i] = Integer.parseInt(splitB[i]);
			}

			// BC의 정보
			BC = new int[A][4];
			for(int i = 0 ; i < A ; i++) {
				split = br.readLine().split(" ");
				BC[i][0] = Integer.parseInt(split[0]);
				BC[i][1] = Integer.parseInt(split[1]);
				BC[i][2] = Integer.parseInt(split[2]);
				BC[i][3] = Integer.parseInt(split[3]);
			}

			// =========================================================
			answer = 0;
			
			// 출발
			int Ax = 1, Ay = 1, Bx = 10, By = 10;

			// 시작지점에서 확인
			Charge(Ax, Ay, Bx, By);

			for (int time = 0; time < M; time++) {
				//System.out.println("=====================");
				// move
				Ax += delta[moveA[time]][0];
				Ay += delta[moveA[time]][1];
				Bx += delta[moveB[time]][0];
				By += delta[moveB[time]][1];
				
				Charge(Ax, Ay, Bx, By);
			}

			// output
			sb.append("#" + test_case + " ");
			sb.append(answer).append("\n");
		}

>>>>>>> 2ca90f1d79e8cfd56296f9efdcd1721df0dded6e
		System.out.println(sb);
	}
	
	private static void Charge(int Ax, int Ay, int Bx, int By) {
<<<<<<< HEAD
		int pA = 0, pB = 0;
		int idxA = -1, idxB = -1;
		boolean both = false;
		int sum = 0;
		for(int bc = 0 ; bc < A ; bc++) {
			boolean a = isBCRange(bc, Ax, Ay);
			boolean b = isBCRange(bc, Bx, By);
			int curp = BC[bc][3];
			if(a&&b) {	//동시에 충전하면 반반 나눠가진다.
				if(pA > curp/2) a = false;
				if(pB > curp/2) b = false;
				
				if(a&&b) {
					curp /= 2;
					pA = pB = curp;
					idxA = idxB = bc;
					both = true;
					a = b = false;
				}
			}
			if(a && pA < curp) {	//충전기 2개중에 성능 좋은곳 선택
				pA = curp;
				idxA = bc;
				if(both) {
					pB = BC[idxB][3];
					both = false;
				}
				System.out.println("charge A "+ bc + " : "+ curp);
			}
			if(b && pB < curp) {	//충전기 2개중에 성능 좋은곳 선택
				pB = curp;
				idxB = bc;
				if(both) {
					pA = BC[idxA][3];
					both = false;
				}
				System.out.println("charge B "+ bc + " : "+ curp);
			}
		}
		//충전량 다시 구하기.
//		if(idxA != -1) pA = BC[idxA][3];
//		if(idxB != -1) pB = BC[idxB][3];
//		if(idxA != -1 && idxA == idxB) {
//			pA /= 2;
//			pB /= 2;
//		}
		ans += pA + pB;
	}
	
	private static boolean isBCRange(int bc, int x, int y) {
		return Math.abs(BC[bc][1]-x)+Math.abs(BC[bc][0] -y) <= BC[bc][2];
	}
=======
		//BC 범위안에있는지 확인
		boolean[] chargeA = new boolean[A];
		boolean[] chargeB = new boolean[A];
		for(int bc = 0 ; bc < A ; bc++) {
			if(isBCRange(bc, Ax, Ay)) chargeA[bc] = true;
			if(isBCRange(bc, Bx, By)) chargeB[bc] = true;
		}
		

		// 모든 경우의 수에 해당하는 합 구하기
		int max = 0;
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				
				int sum = 0;
				if (i == j && chargeA[i] == true && chargeB[j] == true) {  // 같은 BC에 접속한 경우
					sum = BC[i][3];  // 반 나눠서 충전한 것의 합이므로
				}
				else {  // 다른 BC에 접속한 경우
					if (chargeA[i] == true) {
						sum += BC[i][3];
					}

					if (chargeB[j] == true) {
						sum += BC[j][3];
					}
				}

				if (max < sum) {
					max = sum;
				}
			}
		}

		answer += max;
	}
	
	private static boolean isBCRange(int bc, int x, int y) {
		return Math.abs(BC[bc][0] - x) + Math.abs(BC[bc][1] - y) <= BC[bc][2];
	}

>>>>>>> 2ca90f1d79e8cfd56296f9efdcd1721df0dded6e
}
