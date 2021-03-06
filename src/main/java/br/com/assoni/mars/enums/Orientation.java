package br.com.assoni.mars.enums;

public enum Orientation {
	NORTH("N"){
		@Override
		public Orientation turn(Direction direction) {
			return direction == Direction.RIGHT ? Orientation.EAST:Orientation.WEST;
		}
	},
	SOUTH("S"){
		@Override
		public Orientation turn(Direction direction) {
			return direction == Direction.RIGHT ? Orientation.WEST:Orientation.EAST;
		}
	},
	EAST("E"){
		@Override
		public Orientation turn(Direction direction) {
			return direction == Direction.RIGHT ? Orientation.SOUTH:Orientation.NORTH;
		}
	},
	WEST("W"){
		@Override
		public Orientation turn(Direction direction) {
			return direction == Direction.RIGHT ? Orientation.NORTH:Orientation.SOUTH;
		}
	};
	
	private String key;
	
	private Orientation(String key){
		this.key = key;
	}
	
	public String getKey(){
		return key;
	}
	
	public abstract Orientation turn(Direction direction);
}
