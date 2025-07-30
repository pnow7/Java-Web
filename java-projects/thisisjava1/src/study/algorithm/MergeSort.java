package study.algorithm;

/* 병합 정렬

분할 정복(Divide and Conquer) 방식에 기반



*/


import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {1, 5, 6, 3, 2, 11, 0, -1, 10, 12, 8};
		//0부터 length-1(배열길이)
		System.out.println("arr 배열 길이: " + arr.length);
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	// 분할 과정
	public static void mergeSort(int[] arr, int left, int right) {
		// left가 right보다 작을 때만 (두 개 이상의 요소가 있을 때만)
		if(left < right) {
			// 중간 인덱스 계산
			int mid = (left+right)/2;
			
			// 왼쪽 절반 재귀 호출
			mergeSort(arr, left, mid);
			
			// 오른쪽 절반 재귀 호출
			mergeSort(arr, mid+1, right);
			
			// 정렬된 두 절반 병합
			merge(arr, left, mid, right);
		}
	}
	
	// 병합 과정
	public static void merge(int[] arr, int left, int mid, int right) {
		
		int[] tmp = new int[arr.length];
		int i = left;
		int j = mid + 1;
		int k = left;
		
		// 양쪽 배열 비교하며 tmp 배열에 정렬된 순서로 채워 넣기
		while(i <= mid && j <= right) {
			if(arr[i] <= arr[j]) {
				tmp[k++] = arr[i++];
			}
			else {
				tmp[k++] = arr[j++];
			}
		}
		
		// 왼쪽 배열에 남아있는 요소가 있다면 모두 tmp 배열로 복사
		while(i <= mid) {
			tmp[k++] = arr[i++];
		}
		
		// 오른쪽 배열에 남아있는 요소가 있다면 모두 tmp 배열로 복사
		while(j <= right) {
			tmp[k++] = arr[j++];
		}
		
		// tmp 배열의 정렬된 내용을 원래 arr 배열로 다시 복사
		for(int index = left; index < k; index++) {
			arr[index] = tmp[index];
		}
	}
	
}


