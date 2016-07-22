package com.kirelcodes.pokecraft.pokemons.enums;

public enum PokeState {
	BURN(1), FREEZE(0), PARALYSIS(0), POISON(0), BADLY_POSION(0), SLEEP(0), CONFUSED(0),
	CURSED(0), NIGHTMARE(0), TRAPPED(0), TORMENTED(0), TAUNTED(0), HYPNO(0);

	private int bonus;

	PokeState(int bonus) {
		this.bonus = bonus;
	}

	public int getBonus() {
		return this.bonus;
	}
}
