package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

import edu.grinnell.sortingvisualizer.sorts.Sorts;

public class SwapEvent<T> implements SortEvent<T> {
	private boolean emphasis;
	private List<Integer> affectedIndices;
	private int i;
	private int j;
	
	
	public SwapEvent (int val1, int val2){
		this.i = val1;
		this.j = val2;
		this.emphasis = true;
		this.affectedIndices = new ArrayList<>();
		this.affectedIndices.add(i);
		this.affectedIndices.add(j);
	}
	
	@SuppressWarnings("hiding")
	@Override
	public <T extends Comparable<T>> void apply(ArrayList<T> arr) {
		Sorts.swap(arr,i,j);
	}

	@Override
	public List<Integer> getAffectedIndices() {
		return affectedIndices;
	}

	@Override
	public boolean isEmphasized() {
		return emphasis;
	}
}
