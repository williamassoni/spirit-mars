package br.com.assoni.mars.objects;

import br.com.assoni.mars.enums.Direction;
import br.com.assoni.mars.enums.MarsExceptionType;
import br.com.assoni.mars.enums.Orientation;
import br.com.assoni.mars.exception.MarsException;
import br.com.assoni.mars.objects.location.Location;

public class Robot {
	private Orientation orientation;
	private Location location;
	
	public Robot(Location location){
		this.location = location;
		this.orientation = Orientation.NORTH;
	}
	
	public Robot turn(Direction direction){
		this.orientation = orientation.turn(direction);
		return this;
	}
	
	public Robot walk() {
		this.location.move(this.orientation);	
		
		if(!this.location.isValidLocation()){
			throw new MarsException(MarsExceptionType.INVALID_LOCATION);
		}
		return this;
	}
	
	public String getPosition(){
		return String.format("(%s, %s, %s)",location.getCurrentLatitude(),location.getCurrentLongitude(),this.orientation.getKey());
	}
	
	public Location getLocation(){
		return this.location;
	}
}