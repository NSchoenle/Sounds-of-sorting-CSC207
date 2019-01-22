package edu.grinnell.sortingvisualizer.sorts;


import java.util.*;
import edu.grinnell.sortingvisualizer.sortevents.CopyEvent;
import edu.grinnell.sortingvisualizer.sortevents.SwapEvent;
import edu.grinnell.sortingvisualizer.NoteIndices;
import edu.grinnell.sortingvisualizer.sortevents.CompareEvent;
import edu.grinnell.sortingvisualizer.sortevents.SortEvent;

public class Sorts {
	/**
	 * Swaps two elements of an ArrayList
	 * @param l - an ArrayList
	 * @param i - an integer, the index of one element to be swapped
	 * @param j - an integer, the index of the other element
	 */
	public static <T>void swap(ArrayList<T> l, int i, int j){
		T t = l.get(i);
		l.set(i,l.get(j));
		l.set(j, t);
	}

	/**
	 * Compares all of the elements after sorting is complete
	 * @param l - a list of sortEvents
	 * @param arr - an ArrayList
	 */
	public static <T extends Comparable <T>>void endCompare(List<SortEvent<T>> l, ArrayList<T> arr) {
		for (int i = 0; i < arr.size() - 1; i++) {
			CompareEvent<T> c1 = new CompareEvent<>(i, i + 1);
			l.add(c1);
			c1.apply(arr);
		}
	}
	/**
	 * selectionSorts an ArrayList
	 * @param arr - an ArrayList
	 * @return events, a list of sort events logged by sorting an array
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(ArrayList<T> arr) {
		List<SortEvent<T>> events = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.size(); j++) {
				CompareEvent<T> compare = new CompareEvent<>(j, minIndex);
				events.add(compare);
				compare.apply(arr);
				if (compare.result< 0) {
					minIndex = j;
				}
			}
			SwapEvent<T> swap = new SwapEvent<>(i, minIndex);
			events.add(swap);
			swap.apply(arr);
		}
		endCompare(events, arr);
		return events;
		
	}

	/**
	 * insertionSorts an ArrayList
	 * @param arr - an ArrayList
	 * @return events, a list of sort events logged by sorting an array
	 */
		public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(ArrayList<T> arr) {
		List<SortEvent<T>> events = new ArrayList<>();
		for (int i = 1; i < arr.size(); i++) {
			for (int j = i; j > 0; j--) {

				CompareEvent<T> c1 = new CompareEvent<>(j - 1, j);
				c1.apply(arr);
				events.add(c1);

				if (c1.result <= 0) {
					continue;
				} else {
					SwapEvent<T> s1 = new SwapEvent<>(j, j - 1);
					s1.apply(arr);
					events.add(s1);
				}
			}
		}
		endCompare(events, arr);
		return events;

	}

		/**
		 * bubbleSorts an ArrayList
		 * @param arr - an ArrayList
		 * @return events, a list of sort events logged by sorting an array
		 */
  public static <T extends Comparable<T>> List<SortEvent<T>> bubbleSort(ArrayList<T> arr) {
	  List<SortEvent<T>> events = new ArrayList<>();
	  for(int i = arr.size() -1; i >0; i--){
    		for (int j= 0; j<=i-1; j++){
    			CompareEvent<T> c1 = new CompareEvent<>(j,j+1);
    			c1.apply(arr);
    			events.add(c1);
    			if (c1.result>0){
    				SwapEvent<T> s1 = new SwapEvent<>(j, j+1);
    				s1.apply(arr);
    				events.add(s1);
    			}
    		}
    	}
	  endCompare(events, arr);
        return events;
    }
    /**
     * merges two ArrayLists into one
     * @param arr - the original ArrayList
     * @param arr1 - the first half of the ArrayList
     * @param arr2 - the second half of the ArrayList
     * @param events - a list of logged sort events
     */
  
	public static <T extends Comparable<T>> void merge(ArrayList<T> arr, ArrayList<T> arr1, ArrayList<T> arr2,
			ArrayList<SortEvent<T>> events) {
		int arr1Ind = 0;
		int arr2Ind = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr1Ind >= arr1.size() && arr2Ind < arr2.size()) {
				CopyEvent<T> cp1 = new CopyEvent<>(i,arr2.get(arr2Ind));
				cp1.apply(arr);
				events.add(cp1);
				arr2Ind++;
			} else if (arr1Ind < arr1.size() && arr2Ind >= arr2.size()) {
				CopyEvent<T> cp2 = new CopyEvent<>(i,arr1.get(arr1Ind));
				cp2.apply(arr);
				events.add(cp2);
				arr1Ind++;
			} else if (arr1.get(arr1Ind).compareTo(arr2.get(arr2Ind)) <= 0) {
				CopyEvent<T> cp3 = new CopyEvent<>(i,arr1.get(arr1Ind));
				cp3.apply(arr);
				events.add(cp3);
				arr1Ind++;
			} else if (arr1.get(arr1Ind).compareTo(arr2.get(arr2Ind)) >= 0) {
				CopyEvent<T> cp4 = new CopyEvent<>(i,arr2.get(arr2Ind));
				cp4.apply(arr);
				events.add(cp4);
				arr2Ind++;
			}
		}
	}

/**
 * Performs a mergeSort on a given ArrayList
 * @param arr- an ArrayList
 * @return- events, a list of sort events logged by sorting an array
 */
	public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(ArrayList<T> arr) {
		ArrayList<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
		int mid;
		int lo = 0;
		int hi = arr.size() - 1;
		if (lo >= hi) {
			return events;
		}

		mid = arr.size() / 2;

		ArrayList<T> arr1 = new ArrayList<T>(mid);
		for (int x = 0; x < mid; x++) {
			arr1.add(x, arr.get(x));
		}

		ArrayList<T> arr2 = new ArrayList<T>(mid);
		for (int x = mid; x < arr.size(); x++) {
			arr2.add(x - mid, arr.get(x));
		}

		mergeSort(arr1);
		mergeSort(arr2);

		merge(arr, arr1, arr2, events);
		
		endCompare(events, arr);
		return events;
	}

	
	
    /**
     * Partitions the ArrayList based on a given pivot
     * @param arr - an ArrayList
     * @param low - an integer
     * @param hi - an integer
     * @param pivotIndex - an integer
     * @return - the index of the pivot value after sorting
     */
	public static <T extends Comparable<T>> int partitionEvent(ArrayList<T> arr, int low, int hi, int pivotIndex,
			List<SortEvent<T>> events) {
		int i = low;
		int j = hi;
		
		while (i < j) {
			while (i<= hi && arr.get(i).compareTo(arr.get(pivotIndex)) < 0) {
				events.add(new CompareEvent<T>(i, pivotIndex));
				i++;
			}
			if (i<= hi){
				events.add(new CompareEvent<T>(i, pivotIndex));
				}
			while (j>= low && arr.get(j).compareTo(arr.get(pivotIndex)) > 0) {
				events.add(new CompareEvent<T>(j, pivotIndex));
				j--;
			}
			if (j>=low){
				events.add(new CompareEvent<T>(j, pivotIndex));
			}
			if (i < j) {
				SwapEvent<T> swap = new SwapEvent<>(i++, j--);
				swap.apply(arr);
				events.add(swap);
			}
		}
		if (arr.get(i).compareTo(arr.get(pivotIndex)) < 0) {
			i++;
		}
		SwapEvent<T> s2 = new SwapEvent<>(pivotIndex, i);
		s2.apply(arr);
		events.add(s2);

		return i;
	}
	/**
	 * QuickSortHelper
	 * @param arr - an ArrayList
	 * @param lo - an integer 
	 * @param hi- an integer
	 * @param events- a list of sort events logged by the function
	 */
	public static <T extends Comparable<T>> void quickSortHelperEvent(ArrayList<T> arr, int lo, int hi,
			List<SortEvent<T>> events) {
		
		int pivotInd = hi;
		
		int index = partitionEvent(arr, lo, hi-1, pivotInd, events);
		if (lo < index - 1) {
			quickSortHelperEvent(arr, lo, index - 1, events);
		}
		if (index+1 < hi) {
			quickSortHelperEvent(arr, index+1, hi, events);
		}
	}
/**
 * Quick Sort Driver
 * @param arr - an ArrayList
 * @return events, a list of sort events logged by sorting an array
 */
	public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(ArrayList<T> arr) {
		int lo = 0;
		int hi = arr.size() - 1;
		List<SortEvent<T>> events = new ArrayList<>();
		quickSortHelperEvent(arr, lo, hi, events);
		endCompare(events, arr);
		return events;
	}

/**
 * Sorts an ArrayList based off of a list of events
 * @param l - an ArrayList
 * @param events - a List of Sort Events produced by sorting an ArrayList with one of the 
 * 					sorts.
 * @return - l, the sorted array list
 */
	public static <T extends Comparable<T>> ArrayList<T> eventSort(ArrayList<T> l, List<SortEvent<T>> events) {
		for (int i = 0; i < events.size(); i++) {
			if (events.get(i).getClass() == CompareEvent.class) {
				events.get(i).apply(l);
			} else if (events.get(i).getClass() == SwapEvent.class) {
				events.get(i).apply(l);
			} else if (events.get(i).getClass() == CopyEvent.class) {
				events.get(i).apply(l);
			}
		}
		
		return l;
	}
   
    
	/**
     * PM's ArrayList from int array
     * @param test2 - an integer array
     * @return an ArrayList made of the contents of test2
     */
    public static ArrayList<Integer> fromArray(int[] test2){
		ArrayList<Integer> l = new ArrayList<>();
		for(int x : test2){
			l.add(x);
		}
		return l;
	}

    /**
     * PM's ArrayList to String
     * @param l- an array list
     * @return
     */
	public static <T> String listToString(ArrayList<T> l) {
		if (l.size() == 0) {
			return "[]";
		} else {
			StringBuffer buf = new StringBuffer();
			buf.append("[");
			buf.append(l.get(0));
			for (int i = 1; i < l.size(); i++) {
				buf.append(", ");
				buf.append(l.get(i));
			}
			buf.append("]");
			return buf.toString();
		}
	}
}
