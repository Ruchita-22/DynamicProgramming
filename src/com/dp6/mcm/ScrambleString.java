package com.dp6.mcm;

import java.util.HashMap;

public class ScrambleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "great";
		String b = "rgeat";
		// o/p = true
		System.out.print(isScramble(a,b));
		
	}
	private static boolean isScramble(String a, String b) {
        if(a.length() != b.length())    return false;
        HashMap<String, Boolean> map = new HashMap<>();

        return solve(a,b);
        
    }
	private static boolean solve(String a, String b) {
		
        if(a.compareTo(b)==0)    return true;
        if(a.length()<=1) return false;
        
        int n = a.length();
        boolean flag = false;
        
        for(int i=1;i<=n-1;i++) {
        
        	boolean case1 = solve(a.substring(0, i), b.substring(n-i)) && solve(a.substring(i), b.substring(0, n-i));		//swap
        	boolean case2 = solve(a.substring(0, i), b.substring(0, i)) && solve(a.substring(i), b.substring(i));			// no swap
        	
        	if(case1 || case2) {
        		flag = true;
        		break;
        	}
        }

        return flag;
    }
	private static boolean solveMem(String a, String b,HashMap<String, Boolean> map) {
		
        if(a.compareTo(b)==0)    return true;
        if(a.length()<=1) return false;
        String key = a+" "+b;
        if(map.containsKey(key))	return map.get(key);
        int n = a.length();
        boolean flag = false;
        
        for(int i=1;i<=n-1;i++) {
        	
        	boolean case1 = solveMem(a.substring(0, i), b.substring(n-i),map) && solveMem(a.substring(i), b.substring(0, n-i),map);
        	boolean case2 = solveMem(a.substring(0, i), b.substring(0, i),map) && solveMem(a.substring(i), b.substring(i),map);
        	
        	if(case1 || case2) {
        		flag = true;
        		break;
        	}
        }
        map.put(key, flag);
        return flag;
    }

}
