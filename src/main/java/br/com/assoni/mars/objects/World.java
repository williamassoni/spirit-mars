package br.com.assoni.mars.objects;

public class World {
	private static final Long MAX_LATITUDE = 5L;
	private static final Long MAX_LONGITUDE = 5L;
	
	public Boolean isValidLatitude(Long latitude){
		return latitude >= 0 && latitude <= MAX_LATITUDE;
	}
	
	public Boolean isValidLongitude(Long longitude){
		return longitude >= 0 && longitude <= MAX_LONGITUDE;
	}
}
