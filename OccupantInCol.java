//Sean Fitzgerald -- DaCoderzz
//APCS2 pd08
//HW35
//2014-05-02

public class OccupantIntCol {

    private Object occupant;
    private int col;

    public Object getOccupant() { return occupant; }

    public int getCol() { return col; }

    public Object setOccupant( Object newOcc ) {
	Object old = occupant;
	occupant = newOcc;
	return old;
    }

    public int setCol( in newCol ) {
	int old = col;
	col = newCol;
	return old;
    }

}
