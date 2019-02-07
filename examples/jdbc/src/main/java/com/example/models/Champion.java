package com.example.models;

import java.io.Serializable;

public class Champion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2397721896141094732L;
	private Integer championId;
	private String championName;
	private String ability1;
	private String ability2;
	private String ability3;
	private String ability4;
	private String passive;
	private Float health;
	
	public Champion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Champion(Integer championId, String championName, String ability1, String ability2, String ability3,
			String ability4, String passive, Float health) {
		super();
		this.championId = championId;
		this.championName = championName;
		this.ability1 = ability1;
		this.ability2 = ability2;
		this.ability3 = ability3;
		this.ability4 = ability4;
		this.passive = passive;
		this.health = health;
	}

	public Integer getChampionId() {
		return championId;
	}

	public void setChampionId(Integer championId) {
		this.championId = championId;
	}

	public String getChampionName() {
		return championName;
	}

	public void setChampionName(String championName) {
		this.championName = championName;
	}

	public String getAbility1() {
		return ability1;
	}

	public void setAbility1(String ability1) {
		this.ability1 = ability1;
	}

	public String getAbility2() {
		return ability2;
	}

	public void setAbility2(String ability2) {
		this.ability2 = ability2;
	}

	public String getAbility3() {
		return ability3;
	}

	public void setAbility3(String ability3) {
		this.ability3 = ability3;
	}

	public String getAbility4() {
		return ability4;
	}

	public void setAbility4(String ability4) {
		this.ability4 = ability4;
	}

	public String getPassive() {
		return passive;
	}

	public void setPassive(String passive) {
		this.passive = passive;
	}

	public Float getHealth() {
		return health;
	}

	public void setHealth(Float health) {
		this.health = health;
	}

	@Override
	public String toString() {
		return "Champion [championId=" + championId + ", championName=" + championName + ", ability1=" + ability1
				+ ", ability2=" + ability2 + ", ability3=" + ability3 + ", ability4=" + ability4 + ", passive="
				+ passive + ", health=" + health + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ability1 == null) ? 0 : ability1.hashCode());
		result = prime * result + ((ability2 == null) ? 0 : ability2.hashCode());
		result = prime * result + ((ability3 == null) ? 0 : ability3.hashCode());
		result = prime * result + ((ability4 == null) ? 0 : ability4.hashCode());
		result = prime * result + ((championId == null) ? 0 : championId.hashCode());
		result = prime * result + ((championName == null) ? 0 : championName.hashCode());
		result = prime * result + ((health == null) ? 0 : health.hashCode());
		result = prime * result + ((passive == null) ? 0 : passive.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Champion other = (Champion) obj;
		if (ability1 == null) {
			if (other.ability1 != null)
				return false;
		} else if (!ability1.equals(other.ability1))
			return false;
		if (ability2 == null) {
			if (other.ability2 != null)
				return false;
		} else if (!ability2.equals(other.ability2))
			return false;
		if (ability3 == null) {
			if (other.ability3 != null)
				return false;
		} else if (!ability3.equals(other.ability3))
			return false;
		if (ability4 == null) {
			if (other.ability4 != null)
				return false;
		} else if (!ability4.equals(other.ability4))
			return false;
		if (championId == null) {
			if (other.championId != null)
				return false;
		} else if (!championId.equals(other.championId))
			return false;
		if (championName == null) {
			if (other.championName != null)
				return false;
		} else if (!championName.equals(other.championName))
			return false;
		if (health == null) {
			if (other.health != null)
				return false;
		} else if (!health.equals(other.health))
			return false;
		if (passive == null) {
			if (other.passive != null)
				return false;
		} else if (!passive.equals(other.passive))
			return false;
		return true;
	}
}
