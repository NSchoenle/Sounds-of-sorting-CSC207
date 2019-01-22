package edu.grinnell.sortingvisualizer.sortevents;

import java.util.*;

public interface SortEvent<T> {
    @SuppressWarnings("hiding")
	public <T extends Comparable<T>>void apply(ArrayList<T> arr);
    public List<Integer> getAffectedIndices(); 
    public boolean isEmphasized();
}
