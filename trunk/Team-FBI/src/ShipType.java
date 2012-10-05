public enum ShipType {
	
	private Ship fighter;
	private Ship hauler;
	private Ship bullDog;
	private Ship carrier;
	private Ship battleShip;
	private Ship yelowJacket;
	private Ship destroyer;
	private Ship heat;
	
	public setEverything(){
		ShipType.fighter.setHull(100);
		ShipType.fighter.setCost(100);
		ShipType.fighter.setCargoCapacity(20);
		Shiptype.fighter.setFuelCapacity(100);
	}
	 
	
}