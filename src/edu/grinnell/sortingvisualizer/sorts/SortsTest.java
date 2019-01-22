package edu.grinnell.sortingvisualizer.sorts;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class SortsTest {
	/**
	 * PM"s fromArray
	 * @param test2 - an int array
	 * @return an ArrayList<Integer>
	 */
	public static ArrayList<Integer> fromArray(int[] test2){
		ArrayList<Integer> l = new ArrayList<>();
		for(int x : test2){
			l.add(x);
		}
		return l;
	}
	int [] unsortedTest1= {1,5,7,9,2,3,4};
	ArrayList<Integer> testArr1 = fromArray(unsortedTest1); 
	int[] unsortedTest1copy = unsortedTest1.clone();
	ArrayList<Integer> testArr1copy = fromArray(unsortedTest1); 
	int[] sortedTest1 = {1,2,3,4,5,7,9};
	ArrayList<Integer> testArrSorted1 = fromArray(sortedTest1);
	
	
	int [] unsortedTest2= {1,2,3,4,5,7,9};
	ArrayList<Integer> testArr2 = fromArray(unsortedTest2); 
	int[] unsortedTest2copy = unsortedTest2.clone();
	ArrayList<Integer> testArr2copy = fromArray(unsortedTest2);
	int[] sortedTest2 = {1,2,3,4,5,7,9};
	ArrayList<Integer> testArrSorted2 = fromArray(sortedTest2);
	
	int [] unsortedTest3= {0};
	ArrayList<Integer> testArr3 = fromArray(unsortedTest3); 
	int[] unsortedTest3copy = unsortedTest3.clone();
	ArrayList<Integer> testArr3copy = fromArray(unsortedTest3);
	int[] sortedTest3 = {0};
	ArrayList<Integer> testArrSorted3= fromArray(sortedTest3);
	
	int [] unsortedTest4= {9,7,5,4,3,2,1};
	ArrayList<Integer> testArr4 = fromArray(unsortedTest4); 
	int[] unsortedTest4copy = unsortedTest4.clone();
	ArrayList<Integer> testArr4copy = fromArray(unsortedTest4);
	int[] sortedTest4 = {1,2,3,4,5,7,9};
	ArrayList<Integer> testArrSorted4= fromArray(sortedTest4);
	
	@Test
	public void selectionSortTest() {
		
		assertEquals(testArrSorted1,Sorts.eventSort(testArr1copy,Sorts.selectionSort(testArr1)));
		assertEquals(testArrSorted2,Sorts.eventSort(testArr2copy,Sorts.selectionSort(testArr2)));
		assertEquals(testArrSorted3,Sorts.eventSort(testArr3copy,Sorts.selectionSort(testArr3)));
		assertEquals(testArrSorted4,Sorts.eventSort(testArr4copy,Sorts.selectionSort(testArr4)));
	}
	@Test
	public void insertionSortTest() {
		assertEquals(testArrSorted1,Sorts.eventSort(testArr1copy,Sorts.insertionSort(testArr1)));
		assertEquals(testArrSorted2,Sorts.eventSort(testArr2copy,Sorts.insertionSort(testArr2)));
		assertEquals(testArrSorted3,Sorts.eventSort(testArr3copy,Sorts.insertionSort(testArr3)));
		assertEquals(testArrSorted4,Sorts.eventSort(testArr4copy,Sorts.insertionSort(testArr4)));
	}
	@Test
	public void bubbleSortTest(){
		assertEquals(testArrSorted1,Sorts.eventSort(testArr1copy,Sorts.bubbleSort(testArr1)));
		assertEquals(testArrSorted2,Sorts.eventSort(testArr2copy,Sorts.bubbleSort(testArr2)));
		assertEquals(testArrSorted3,Sorts.eventSort(testArr3copy,Sorts.bubbleSort(testArr3)));
		assertEquals(testArrSorted4,Sorts.eventSort(testArr4copy,Sorts.bubbleSort(testArr4)));
		
	}
	@Test
	public void mergeSortTest(){
		assertEquals(testArrSorted1,Sorts.eventSort(testArr1copy,Sorts.mergeSort(testArr1)));
		assertEquals(testArrSorted2,Sorts.eventSort(testArr2copy,Sorts.mergeSort(testArr2)));
		assertEquals(testArrSorted3,Sorts.eventSort(testArr3copy,Sorts.mergeSort(testArr3)));
		assertEquals(testArrSorted4,Sorts.eventSort(testArr4copy,Sorts.mergeSort(testArr4)));	
	}
	@Test
	public void quickSortTest(){
		assertEquals(testArrSorted1,Sorts.eventSort(testArr1copy,Sorts.quickSort(testArr1)));
		assertEquals(testArrSorted2,Sorts.eventSort(testArr2copy,Sorts.quickSort(testArr2)));
		assertEquals(testArrSorted3,Sorts.eventSort(testArr3copy,Sorts.quickSort(testArr3)));
		assertEquals(testArrSorted4,Sorts.eventSort(testArr4copy,Sorts.quickSort(testArr4)));
		
	}
}
