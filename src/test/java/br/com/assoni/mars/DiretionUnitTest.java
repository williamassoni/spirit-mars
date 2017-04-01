package br.com.assoni.mars;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

import br.com.assoni.mars.enums.Direction;
import br.com.assoni.mars.exception.MarsException;

public class DiretionUnitTest {

	@Test
	public void should_extract_direction(){
		assertThat(Direction.extract("R")).isEqualTo(Direction.RIGHT);
		assertThat(Direction.extract("L")).isEqualTo(Direction.LEFT);
	}
	
	@Test
	public void should_throw_exception_when_invalid_direction(){
		assertThatThrownBy(() -> {Direction.extract("A");}).hasSameClassAs(MarsException.class);
	}
}
