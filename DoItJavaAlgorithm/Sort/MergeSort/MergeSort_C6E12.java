package MergeSort;
//병합정렬의 시간복잡도 == O(nlogn)

//배열 병합의 시간복잡도는 O(n)이고 요소 n개일때 병합정렬의 단계 logn만큼 필요하므로
//서로 떨어져 있는 요소를 교환하는 것이 아니므로 안정적인 정렬

public class MergeSort_C6E12 {

	static int[] buff; // 작업용 배열

	// a[left] ~ a[right]를 재귀적으로 병합 정렬
	static void __mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int i;
			int center = (left + right) / 2;
			int p = 0;
			int j = 0;
			int k = left;

			__mergeSort(a, left, center); // 배열의 앞부분을 병합정렬
			__mergeSort(a, center + 1, right); // 배열의 앞부분을 병합정렬

			for (i = left; i <= center; i++) {
				buff[p++] = a[i];
			}
			// p == 임시작업한 인덱스 j==left , i==center+1 k==새로운인덱
			while (i <= right && j < p) {
				a[k++] = (buff[j] < a[i]) ? buff[j++] : a[i++];
			}
			// 이해가 잘 안감!!! --> 버퍼 비우기.
			while (j < p) {
				a[k++] = buff[j++];
			}
		}
	}

	static void mergeSort(int[] a, int n) {
		buff = new int[n]; // 작업용 배열을 생성합니다.
		__mergeSort(a, 0, n - 1);// 배열 전체를 병합정렬 합니다
		buff = null; // 작업용 배열을 해제합니다.
	}
}
