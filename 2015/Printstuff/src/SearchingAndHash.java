
public class SearchingAndHash {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt();
	}
	int []array; 
	
	public Driver() {
		array = new int[12000000];
		
		Random gen = new Random();
		int seed = 0;
		
		for (int i = 0; i < array.length; i++) {
			seed = seed + gen.nextInt(12)+2;
			array[i] = seed;
		}
		System.out.println("Array initialized");
	}
	
	
	public void doIt() {
		
		int failure = (array[array.length/2] + array[array.length/2+1]) / 2;
		int success = array[array.length/2];
		System.out.println("Linear success " + linearSearch(array, success));
		System.out.println("Linear failure " + linearSearch(array, failure));
		
		System.out.println("Binary success " + binarySearch(array, success));
		System.out.println("Binary failure " + binarySearch(array, failure));

		System.out.println("rec Binary success " + recursiveBinarySearch(array, success));
		System.out.println("rec Binary failure " + recursiveBinarySearch(array, failure));
	}
	
	private int linearSearch(int array[], int target) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			count++;
			if (array[i] == target) {
				System.out.println("Found number in " + count + " tries");
				return i;
			}
		}
		System.out.println("Did not find number in " + count + " tries");

		return -1;
	}
	
	private int binarySearch(int array[], int target) {
		int count  = 0;
		int lo = 0;
		int hi = array.length-1;
		
		while (lo <= hi) {
			count++;
			int mid = (lo + hi) / 2;
			
			if (array[mid] == target) {
				System.out.println("Found number in " + count + " tries");
				return mid;
			}
			
			if (array[mid] < target) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		System.out.println("Did not find number in " + count + " tries");
		
		return -1;
	}
	
	int recCount;
	private int recursiveBinarySearch(int array[], int target) {
		recCount = 0;
		return recBinSearch(array, target, 0, array.length-1);
	}
	
	private int recBinSearch(int array[], int target, int lo, int hi) {
		
		// BASE CASE
		if (lo > hi) {
			System.out.println("Did not find number in " + recCount + " tries");

			return -1;
		}

		recCount++;
		
		int mid = (lo + hi) / 2;
		
		if (array[mid] == target) {
			System.out.println("Found number in " + recCount + " tries");

			return mid;
		}
		
		if (array[mid] < target) {
			return recBinSearch(array, target, mid+1, hi);
		} else {
			return recBinSearch(array, target, lo, mid-1);
		}
		
	}
  /*
   * HASH UNDER THIS
   */
	
	private static final int TABLE_SIZE = 31; 
	private static final int NEVER_USED = -1;
	private static final int PREVIOUSLY_USED = -2;
	int probeFactor;
	int tableCount;

	int []table;

	//public OpenAddressHash() {
		table = new int[TABLE_SIZE];
		for (int i = 0; i < table.length; i++) {
			table[i] = NEVER_USED;
		}
		tableCount = 0;
	}

	private int hashFunction(int target) {
		return target % TABLE_SIZE;
	}

	private void initializeProbe() {
		probeFactor = 1;
	}

	private int probe(int loc) {
		int rtn = loc + (probeFactor * probeFactor);
		probeFactor++;

		return rtn;
	}

	private boolean tableFull() {
		return tableCount == table.length;
	}

	public boolean add(int target) {

		// We can't insert into a full table
		if (tableFull()) {
			return false;
		}

		// If it already exists we are done.
		if (search(target)) {
			return true;
		}

		int loc = hashFunction(target);

		if ((table[loc] == NEVER_USED) || (table[loc] == PREVIOUSLY_USED)) {
			// insert here
			table[loc] = target;
			return true;
		} else {
			// COLLISION
			initializeProbe();
			boolean done = false;

			// Probe for new location
			loc = probe(loc);
			while (!done) {

				if ((table[loc] == NEVER_USED) || (table[loc] == PREVIOUSLY_USED)) {
					// insert here
					table[loc] = target;
					done = true;
				} else {
					loc = probe(loc);
				}

			}

			return true;
		}
	}

	public boolean search(int target) {
		if (indexSearch(target) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	private int indexSearch(int target) {
		int loc = hashFunction(target);

		if ((table[loc] == target)) {
			// Found it
			return loc;
		} else {
			// Not in that bucket, keep looking
			initializeProbe();
			boolean done = false;
			int rtn = NEVER_USED;
			
			loc = probe(loc);
			while (!done) {
				
				if (table[loc] == target) {
					rtn = loc;
					done = true;
				} else {
					// Is the data not present?
					if (table[loc] == NEVER_USED) {
						rtn = NEVER_USED;
						done = true;
					} else {
						// Get the next bucket
						loc = probe(loc);
					}
				}
			}
			return rtn;
		}
	}
	
	public boolean delete(int target) {
		int loc = indexSearch(target);
		
		if (target >= 0 ) {
			table[loc] = PREVIOUSLY_USED;
			return true;
		} else {
			return false;
		}
	}


	public String toString() {
		String rtn = "";
		
		for (int i = 0; i < table.length; i++) {
			rtn += "table[" + i + "] = " + ((table[i] == NEVER_USED) ? "NEVER_USED" : 
				(table[i] == PREVIOUSLY_USED) ? "PREVIOUSLY_USED" : table[i]) + "\n";
		}
		
		return rtn;
	}
	
	public void doIt() {
		OpenAddressHash oaHash = new OpenAddressHash();
		
		System.out.println(oaHash);
		
		oaHash.add(10);
		oaHash.add(41);
		oaHash.add(72);

		oaHash.add(67);
		System.out.println(oaHash);
		
		oaHash.delete(41);

		System.out.println("Search for 72 = " + oaHash.search(72));
		System.out.println(oaHash);
		
		oaHash.add(11);
		System.out.println(oaHash);
	}


}
