//James Kong --- DACODERZZ
//APCS2 pd 08
//HW35
//2014-05-02
 /* WORK DONE BY JAMES */
import info.gridworld.grid.*;

import java.util.*;
import java.util.ArrayList;

public class Unbounded<E> extends AbstractGrid<E>{
    private Object[][] anArray;
    private int row;// same as column

    public Unbounded(){
	row = 16;//starts 16 x 16
	anArray = new Object[row][row];
    }

    public int getNumRows(){
	return -1; //because it's unbounded
    }

    public int getNumCols(){
	return -1;
    }

    public boolean isValid (Location loc){
	return loc.getRow() > -1 && loc.getCol() > -1;
    }

    public E put(Location loc, E obj){
	if (loc != null || obj != null){
	    while (loc.getRow() >= row || loc.getCol() >= row){
		row = row * 2;
	    }
	    Object[][] newA = new Object[row][row];
	    for (int i = 0;, i < row; i ++){
		for (int j = 0; j < row; j++){
		    newA[i][j] = anArray[i][j];
		}
	    }
	    anArray= newA;
	    row = anArray.length;
	    E ret = get(loc);
	    anArray[loc.getRow()][loc.getCol()] = obj;
	    return ret;
	}
	return null;
    }
    public E remove(Location loc){
	if (!isValid(loc) || (loc.getRow() >= row || loc.getCol() >= row))
	    return null;
	E ret = get(loc);
	anArray[loc.getRow()][loc.getCol()] = null;
	return ret;
    }

    public E get(Location loc){
	if (!isValid(loc)|| (loc.getRow() >= row || loc.getCol()>= row))
	    return null;
	E ret = anArray[loc.getRow()][loc.getCol()];
    }

    public ArrayList<Location> getOccupiedLocations(){
	ArrayList<Location> ret = new ArrayList<Location>();
	for (int i = 0; i < row; i ++){
	    for (int j = 0; j < row; j++){
		Location aLocation = new Location (i, j);
		if (anArray[i][j] != null)
		    ret.add(aLocation);
	    }
	}
    }
}
