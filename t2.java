static int coin[4] = {25, 10, 5, 1};


public void findCombination(int money_left, int level, int sol[]) {
	if (level == 3) {
		sol[level] = money_left;
		print(sol);
		return;
	}

	for (int i = 0; i <= money_left / coin[level]; i++) {
		sol[level] = i;
		findCombination(money_left - i*coin[level], level+1, sol[]);
	}
}