package QuickSort;

import java.util.Stack;

//재귀 대신 스택으로 퀵정렬 구현!
public class StackQuickSort_C6Q12 {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void quickSort(int[] a, int left, int right) {
		Stack<Integer> lstack = new Stack<Integer>();
		Stack<Integer> rstack = new Stack<Integer>();
		lstack.push(left);
		rstack.push(right);

		while (lstack.isEmpty() != true) {
			int pl = left = lstack.pop(); // 왼쪽 커서
			int pr = right = rstack.pop(); // 오른쪽 커서
			
			//pl과 pr이 이곳에서 초기화 되므로 이곳에서
			//삽입정렬과 퀵정렬을 판단
			if (right - left < 9)
				insertSort(a, left, right);
			else {
				int x = a[(left + right) / 2]; // 피벗
				do {
					while (a[pl] < x) {
						pl++;
					}
					while (a[pr] > x) {
						pr--;
					}
					if (pl <= pr) {
						swap(a, pl++, pr--);
					}	
				} while (pl <= pr);

				// left가 0 경우엔 어떡하지?
				// 분할된 요솟수가 9개 이하라면 삽입정렬 -->상단으로 이동
				/*
				 * if (pr - left <= 9) { insertSort(a, left, pr); } if (right - pl <= 9) {
				 * insertSort(a, pl, right); }
				 */
				// 요소의 개수가 많은 그룹 먼저 푸시
				/*
				 * if (pr - left >= right - pl) { if (left < pr) { lstack.push(left);
				 * rstack.push(pr); } if (pl < right) { lstack.push(pl); rstack.push(right); } }
				 * else { if (pl < right) { lstack.push(pl); rstack.push(right); } if (left <
				 * pr) { lstack.push(left); rstack.push(pr); }
				 * 
				 * }
				 */
				// 단순히 변수값을 바꾸어주면 복잡도를 줄일 수 있다!!!
				if (pr - left < right - pl) {
					int temp;
					temp = left;
					left = pl;
					pl = temp;
					temp = right;
					right = pr;
					pr = temp;
				}
				if (left < pr) {
					lstack.push(left);
					rstack.push(pr);
				}
				if (pl < right) {
					lstack.push(pl);
					rstack.push(right);
				}
			}
		}
	}

	static void insertSort(int[] a, int left, int right) {
		// 두번째 인덱스부터 검사!!
		/*
		 * --> i의 값을 중복으로 쓰면 안된다! (첫번째 for문의 i값까지 변함;;)!! for (int i = left + 1; i <=
		 * right; i++) { if (a[i - 1] > a[i]) { int temp = a[i]; for (; i > 0; i--) { if
		 * (a[i - 1] >= temp) { a[i] = a[i - 1]; } a[i] = temp; break; } } }
		 */

		for (int i = left + 1; i <= right; i++) {
			int tmp = a[i];
			int j;
			// 조건식 주의!!!
			for (j = i; j > 0 && a[j - 1] > tmp; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

}
