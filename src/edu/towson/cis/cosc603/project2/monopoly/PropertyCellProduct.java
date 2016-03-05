package edu.towson.cis.cosc603.project2.monopoly;


public class PropertyCellProduct {
	private int rent;

	public void setRent(int rent) {
		this.rent = rent;
	}

	/**
	 * Gets the rent.
	 * @return  the rent
	 */
	public int getRent(int numHouses, Player theOwner, String colorGroup) {
		int rentToCharge = rent;
		rentToCharge = calculateMonopoliesRent(rentToCharge, theOwner,
				colorGroup);
		if (numHouses > 0) {
			rentToCharge = rent * (numHouses + 1);
		}
		return rentToCharge;
	}

	/**
	 * Calculates the rent.
	 * @param originalRent  the ordinary amount of rent for this property
	 * @return  the amount of rent to charge adjusted for any monopolies
	 */
	public int calculateMonopoliesRent(int originalRent, Player theOwner,
			String colorGroup) {
		String[] monopolies = theOwner.getMonopolies();
		int rentToCharge = originalRent;
		for (int i = 0; i < monopolies.length; i++) {
			if (monopolies[i].equals(colorGroup)) {
				rentToCharge = rent * 2;
			}
		}
		return rentToCharge;
	}
}