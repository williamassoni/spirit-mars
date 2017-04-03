package br.com.assoni.mars;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import br.com.assoni.mars.enums.Direction;

public class DiretionUnitTest {

	@Test
	public void should_extract_direction(){
		assertThat(Direction.extract("R").get()).isEqualTo(Direction.RIGHT);
		assertThat(Direction.extract("L").get()).isEqualTo(Direction.LEFT);
	}
}
