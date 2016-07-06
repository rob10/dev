
public class Sorting {
	
	public class Driver {

		//public static void main(String[] args) {
			// TODO Auto-generated method stub

			Driver me = new Driver();
			me.doIt();
		}
		
		
		int []dts = {2, 3, 1, 34, 12, 22, 45, 54, 18, 4, 7};
		
		private int[] cloneData() {
			int []rtn = new int[dts.length];
			
			for (int i = 0; i < dts.length; i++) {
				rtn[i] = dts[i];
			}
			
			return rtn;
		}
		
		private void printData(int[] array) {
			
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + ", ");
			}
			System.out.println();
		}
		
		public void doIt() {
			int []bubble = cloneData();
			int []selection = cloneData();
			int []insertion = cloneData();
			
			printData(bubble);
			bubbleSort(bubble);
			printData(bubble);

			printData(selection);
			selectionSort(selection);
			printData(selection);

			printData(insertion);
			insertion = insertionSort(insertion);
			printData(insertion);
	}
		
		public void bubbleSort(int[] array) {
			
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length-1; j++) {
					if (array[j] > array[j+1]) {
						int temp = array[j];
						array[j] = array[j+1];
						array[j+1] = temp;
					}
				}
			}
		}
		
		public void selectionSort(int[] array) {
			int whereToInsert = 0;
			int smallestIndex = 0;
			
			for (int i = 0; i < array.length; i++) {
				smallestIndex = whereToInsert;
				
				// Scan list to find smallest remaining number
				for (int j = whereToInsert; j < array.length; j++) {
					if (array[smallestIndex] > array[j]) {
						smallestIndex = j;
					}
				}
				
				// Put the smallest guy in his place
				int temp = array[smallestIndex];
				array[smallestIndex] = array[whereToInsert];
				array[whereToInsert] = temp;
				
				whereToInsert++;

			}
		}
		
		public int[] insertionSort(int[] array) {
			int []rtn = new int[array.length];
			int whereToInsert = 0;
			int smallestIndex = 0;
			
			for (int i = 0; i < array.length; i++) {
				smallestIndex = whereToInsert;
				
				// Scan list to find smallest remaining number
				for (int j = 0; j < array.length; j++) {
					if (array[smallestIndex] > array[j]) {
						smallestIndex = j;
					}
				}
				
				// Put the smallest guy in his place
				rtn[whereToInsert] = array[smallestIndex];
				array[smallestIndex] = Integer.MAX_VALUE;
				
				whereToInsert++;

			}
			
			return rtn;
		}

	//}
		
		/*
		 * recursive sort
		 * merge and quick
		 * 
		 */
		//public class SortDriver {

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				SortDriver me = new SortDriver();
				me.doIt();
				
			}
			
			public void doIt() {
				
				int [] array = {23, 12, 45, 34, 67, 2, 98, 89, 1, 15, 22, 129, 132, 138};
				
//				int [] a2 = array.clone();
				int [] a2 = new int[10];
				int num = a2.length;
				for (int i = 0; i < a2.length; i++) {
					a2[i] = num--;
				}
				a2 = array;
				
				re = 0;
				System.out.println(pa(a2, 0, a2.length));
				System.out.println("sorting");
				quickSort(a2, 0, a2.length-1);
				//mergesort(a2, 0, a2.length);
				System.out.println("sorted");
				System.out.println(pa(a2, 0, a2.length));
				
				int [] a3 = {1, 5, 6, 4, 7, 8};

				//mergesort(a3, 0, a3.length);
				//System.out.println(re);
			}
			
			int re = 0;
			public void mergesort(int data[], int first, int n) {
				int n1;
				int n2;
				re++;
				
				if (n > 1) {
					n1 = n / 2;
					n2 = n - n1;
					
					//System.out.println(pa(data, first, n1));
					//System.out.println(pa(data, first+n1, n2));
					mergesort(data, first, n1);
					mergesort(data, first+n1, n2);

					merge(data, first, n1, n2);
				}
			}
			
			private void merge(int[] data, int first, int n1, int n2) {
				
				int [] temp = new int[n1+n2];
				int copied = 0;
				int copied1 = 0;
				int copied2 = 0;
				int i;
				System.out.println("Merging...");
				System.out.println(pa(data, first, n1));
				System.out.println((pa(data, first+n1, n2)));
				System.out.println();
				while ((copied1 < n1) && (copied2 < n2)) {
					if (data[first+copied1] < data[first + n1 + copied2]) 
						temp[copied++] = data[first + (copied1++)];
					else
						temp[copied++] = data[first + n1 + (copied2++)];
				}
				
				// Left side
				while (copied1 < n1) {
					temp[copied++] = data[first + (copied1++)];
				}
				
				// remainder
				for (i = 0; i < copied; i++) {
					data[first+i] = temp[i];
				}
				
				//System.out.println(pa(data, first, n1+n2));
			}
			
			private String pa(int[] array, int first, int len) {
				String rtn = "";
				
				for (int i = first; i < first+len; i++) {
					if (i < array.length)
						rtn += "[" + i + "] = " + array[i] + ", ";
					if ((i > 0) && ((i % 15) == 0)) {
						rtn += "\n";
					}
		 		}
				rtn += "\n";
				return rtn;
			}
			
			public int partition(int arr[], int left, int right)

			{

			      int i = left, j = right;
			      int tmp;
			      int pivot = arr[(left + right) / 2];

			      System.out.println("Pivot is " + pivot);
			      while (i <= j) {
			            while (arr[i] < pivot)
			                  i++;
			            while (arr[j] > pivot)
			                  j--;

			            if (i <= j) {
			                  tmp = arr[i];
			                  arr[i] = arr[j];
			                  arr[j] = tmp;
			                  i++;
			                  j--;
			            }

			      }

			      return i;

			}

			void quickSort(int arr[], int left, int right) {
				//System.out.println("left " +left + " right " + right);
			      int index = partition(arr, left, right);
			      System.out.println(pa(arr, left, arr.length));
			      if (left < index - 1)
			            quickSort(arr, left, index - 1);

			      System.out.println(pa(arr, left, arr.length ));
			      if (index < right)
			            quickSort(arr, index, right);

			}


		//}


}
