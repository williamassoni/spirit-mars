package br.com.assoni.mars.objects.location;

import br.com.assoni.mars.enums.Direction;

public interface Moviment <T> {

	T turn(Direction direction);
}
