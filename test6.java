public void Replace(String s, String s1, String s2) {
	assert s1 != null && s2 != null && s != null;
	if (s1.length() < s2.length()) {
		int wordCount = 0;
		String temp = s;
		int pos = 0;
		len = temp.length();
		int i = 0;

		while (strstr(temp, pos, s1) != -1) {
			wordCount++;		
			pos = strstr(temp, pos, s1);
			index[i] = pos; //记录子字符串位置
			i++;
		}


		//find how many s1s there are in s
		//算出newsize
		//从后往前替换
	} else {
		//find how many s1s there are in s
		//算出newsize
		//从前往后替换
	}
}



int strstr(const string& s, const int startIndex, const string& s1);
