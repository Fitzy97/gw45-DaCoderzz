//DaCoderzz (Sean Fitzgerald, James Kong, Julie Kim)
//APCS2 pd8
//HW34
//2014-04-30

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter {

    public void processActors(ArrayList<Actor> actors) {
	if (actors.size() ==0) {
	    Color c = getColor();
	    int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
	    int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
	    int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
	    setColor(new Color(red, green, blue));
	}

       	Location a = getAdjacentLocation( getDirection() );
	Location b = getAdjacentLocation( getDirection() + 180 );
	Actor front = grid.get(a);
	Actor behind = grid.get(b);
	if (front != null)
	    setColor( front.getColor() );
	else if (behind != null)
	    setColor( behind.getColor() );
	else {
	    Color c = getColor();
	    int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
	    int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
	    int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
	    setColor(new Color(red, green, blue));
	}
    }

    /**
     * Turns towards the new location as it moves.
     */
    public void makeMove(Location loc) {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }
}
