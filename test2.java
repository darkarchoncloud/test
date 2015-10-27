public class Deduplicate {

public void deDuplicate(int[] input) {
	assert input != null;
	if (input.length == 0) {
		return;
	}

	int target = 0;
	for (int i = 0; i < input.length; i++) {
		if (input[i] == input[i+1]) {
			continue;
		} else {
			input[++target] = input[i];
		}

	}
}

int index = 1;
for (int i = 1; i < n; i++) {
if (A[index - 1] != A[i])
A[index++] = A[i];
}