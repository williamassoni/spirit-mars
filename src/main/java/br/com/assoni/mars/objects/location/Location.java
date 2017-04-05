package br.com.assoni.mars.objects.location;

import br.com.assoni.mars.enums.Orientation;

public class Location {
	/** X */
	private Long latitude;
	
	/** Y */
	private Long longitude;
	
	private World world;
	
	public Location(World world,Long latitude,Long longitude){
		this.latitude = latitude;
		this.longitude = longitude;
		this.world = world;
	}
	
	public Long getCurrentLatitude(){
		return this.latitude;
	}
	
	public Long getCurrentLongitude(){
		return this.longitude;
	}
	
	public Location move(Orientation orientation){
		switch (orientation) {
			case NORTH:
				this.longitude++;
				return this;
			case SOUTH:
				this.longitude--;
				return this;
			case EAST:
				this.latitude++;
				return this;
			case WEST:
				this.latitude--;
				return this;
			default:
				throw new RuntimeException("Invalid Orientation");
		}
	}

	public Boolean isValidLocation() {
		return this.world.isValidLatitude(this.latitude) && this.world.isValidLongitude(this.longitude);
	}
}
