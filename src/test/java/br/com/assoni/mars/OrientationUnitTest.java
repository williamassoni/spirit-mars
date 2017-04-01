package br.com.assoni.mars;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import br.com.assoni.mars.enums.Direction;
import br.com.assoni.mars.enums.Orientation;

public class OrientationUnitTest {

	@Test
	public void should_change_north_orientation_when_turn_on_direction(){
		assertThat(Orientation.NORTH.turn(Direction.RIGHT)).isEqualTo(Orientation.EAST);
		assertThat(Orientation.NORTH.turn(Direction.LEFT)).isEqualTo(Orientation.WEST);
	}
	
	@Test
	public void should_change_south_orientation_when_turn_on_direction(){
		assertThat(Orientation.SOUTH.turn(Direction.RIGHT)).isEqualTo(Orientation.WEST);
		assertThat(Orientation.SOUTH.turn(Direction.LEFT)).isEqualTo(Orientation.EAST);
	}
	
	@Test
	public void should_change_west_orientation_when_turn_on_direction(){
		assertThat(Orientation.WEST.turn(Direction.RIGHT)).isEqualTo(Orientation.NORTH);
		assertThat(Orientation.WEST.turn(Direction.LEFT)).isEqualTo(Orientation.SOUTH);
	}
	
	@Test
	public void should_change_east_orientation_when_turn_on_direction(){
		assertThat(Orientation.EAST.turn(Direction.RIGHT)).isEqualTo(Orientation.SOUTH);
		assertThat(Orientation.EAST.turn(Direction.LEFT)).isEqualTo(Orientation.NORTH);
	}
}
