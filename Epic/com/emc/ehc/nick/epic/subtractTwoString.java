package com.emc.ehc.nick.epic;
import java.util.*;

public class subtractTwoString {
	public static ArrayList<Integer> substract(int[] m, int[] n) {
		if (m == null || n == null) return null;
		int sizeM = m.length;
		int sizeN = n.length;
		if(sizeM<sizeN)	return substract(n,m);
		int borrow = 0;
		int i = sizeM - 1;
		int j = sizeN - 1;
		ArrayList<Integer> res = new ArrayList<Integer>();
		while (true) {
			if (i < 0) {
				//if (j >= 0 || borrow > 0) return substract(n, m);	// m is less than n
				// remove 0s at the front
				while (res.size() > 1 && res.get(0) == 0) {
					res.remove(0);
				}
				return res;
			}
			int tmp = m[i] - borrow;
			if (j >= 0) {
				tmp -= n[j];
			}
			if (tmp >= 0) {
				borrow = 0;
			} else {
				tmp += 10;	// borrow 1 digit
				borrow = 1;
			}
			res.add(0, tmp);	// add at the front
			i--;
			j--;
		}
	}
	
	public static void main(String[] args) {
		int[] n = {1, 2, 3, 4, 5};
		int[] m = {4, 5, 3, 5};
		ArrayList<Integer> res = substract(m, n);
		System.out.println(res);
	}
}

