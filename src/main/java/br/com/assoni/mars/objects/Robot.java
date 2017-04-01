package br.com.assoni.mars.objects;

import br.com.assoni.mars.enums.Direction;
import br.com.assoni.mars.enums.Orientation;

public class Robot {
	private Orientation orientation;
	private Location location;
	
	public Robot(World world){
		this.location = Location.createNewLocation(world,0L, 0L);
		this.orientation = Orientation.NORTH;
	}
	
	public Robot turn(Direction direction){
		this.orientation = orientation.turn(direction);
		return this;
	}
	
	public Robot walk() {
		this.location.move(this.orientation);	
		
		if(!this.location.isValidLocation()){
			throw new RuntimeException("...");
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