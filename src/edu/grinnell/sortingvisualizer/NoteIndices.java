package edu.grinnell.sortingvisualizer;

import java.util.ArrayList;
import java.util.*;
/**
 * A collection of indices into a Scale object. These indices are the subject of
 * the various sorting algorithms in the program.
 */
public class NoteIndices {
	private ArrayList<Integer> notes;
	private ArrayList<Integer> highlights;
	private ArrayList<Integer> shuffledArray;
	/**
	 * @param n
	 *            the size of the scale object that these indices map into
	 */
	public NoteIndices(int n) {
		this.notes = new ArrayList<>(n);
		this.highlights = new ArrayList<>(n);
		this.shuffledArray = new ArrayList<>(n);
	}

	/**
	 * Reinitializes this collection of indices to map into a new scale object
	 * of the given size. The collection is also shuffled to provide an initial
	 * starting point for the sorting process.
	 * 
	 * @param n - the size of the scale object that these indices map into
	 */
	            
	public void initializeAndShuffle(int n) {
		ArrayList<Integer> scaleObject = new ArrayList<>(n);
		for (int i = 0; i<n; i++){
			scaleObject.add(i);
		}
		notes = scaleObject;
		Collections.shuffle(scaleObject);
		shuffledArray = scaleObject;
	}

	/** @return the indices of this NoteIndices object */
	public ArrayList<Integer> getNotes() {
		return notes;
	}

	public ArrayList<Integer> getShuffledArray(){
		return shuffledArray;
	}
	/**
	 * Highlights the given index of the note array
	 * 
	 * @param index
	 *            the index to highlight
	 */
	public void highlightNote(int index) {
		if (this.highlights == null){
			this.highlights.set(0, index);
			}
		this.highlights.add (index);
	}

	/** @return true if the given index is highlighted */
	public boolean isHighlighted(int index) {
		if (this.highlights == null){
			return false;
			}
		for (int i = 0; i < this.highlights.size(); i++){
			if (this.highlights.get(i) == index){
				return true;
			}
		}
		return false;
	}

	/** Clears all highlighted indices from this collection */
	public void clearAllHighlighted() {
		this.highlights = new ArrayList<>(0);
	}
}
