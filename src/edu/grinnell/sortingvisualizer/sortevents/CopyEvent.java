package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

import edu.grinnell.sortingvisualizer.sorts.Sorts;

public class CopyEvent<T> implements SortEvent<T> {
	private boolean emphasis;
	private List<Integer> affectedIndices;
	private T val;
	private int ind;
	
	public CopyEvent(int ind, T val){
		this.ind = ind;
		this.val = val;
		this.emphasis = true;
		this.affectedIndices = new ArrayList<>();
		affectedIndices.add(ind);
	}
	@SuppressWarnings({ "unchecked", "hiding" })
	@Override
	public <T extends Comparable<T>> void apply(ArrayList<T> arr) {
		
		arr.set(this.ind, (T) this.val);
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
