package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

import edu.grinnell.sortingvisualizer.sorts.Sorts;

public class CompareEvent<T> implements SortEvent<T> {
	private boolean emphasis;
	private List<Integer> affectedIndices;
	private int i;
	private int j;
	
	public int result;
	
	public CompareEvent(int i, int j){
		this.i = i;
		this.j = j;
		this.emphasis = false;
		this.affectedIndices = new ArrayList<>();
	}
	@SuppressWarnings("hiding")
	@Override
	public <T extends Comparable<T>> void apply(ArrayList<T> arr) {
		this.affectedIndices.add(0,i);
		this.affectedIndices.add(1,j);
		result = arr.get(i).compareTo(arr.get(j));
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
