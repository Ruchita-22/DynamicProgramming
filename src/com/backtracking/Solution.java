package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Input output method
	// Recursion tree
	private static void printPowerSet(String in, String op) {
		// TODO Auto-generated method stub
		if (in.length() == 0) {
			System.out.println(op);
			return;
		}
		String op1 = op;
		String op2 = op;
		op2 = op2 + in.charAt(0);
		in = in.substring(1);
		printPowerSet(in, op2);
		printPowerSet(in, op1);
		return;
	}

	private static void permuteWithSpace(String in, String op) {
		// TODO Auto-generated method stub
		if (in.length() == 0) {
			System.out.println(op);
			return;
		}
		String op1 = op;
		String op2 = op;
		op1 = op1 + " " + in.charAt(0);
		op2 = op2 + in.charAt(0);
		in = in.substring(1);
		permuteWithSpace(in, op2);
		permuteWithSpace(in, op1);
		return;
	}

	private static void permuteWithCaseChange(String in, String op) {
		// TODO Auto-generated method stub
		if (in.length() == 0) {
			System.out.println(op);
			return;
		}
		String op1 = op;
		String op2 = op;
		op1 = op1 + in.charAt(0);
		op2 = op2 + Character.toUpperCase(in.charAt(0));
		in = in.substring(1);
		permuteWithCaseChange(in, op2);
		permuteWithCaseChange(in, op1);
		return;
	}

	private static void letterChange(String in, String op) {
		// TODO Auto-generated method stub
		if (in.length() == 0) {
			System.out.println(op);
			return;
		}
		char ch = in.charAt(0);
		if (Character.isAlphabetic(ch)) {
			String op1 = op;
			String op2 = op;
			op1 = op1 + Character.toLowerCase(ch);
			op2 = op2 + Character.toUpperCase(ch);
			in = in.substring(1);
			letterChange(in, op1);
			letterChange(in, op2);
			return;

		} else {
			String op1 = op;
			op1 = op1 + ch;
			in = in.substring(1);
			letterChange(in, op1);
			return;

		}
	}
    //22. Generate Parentheses
	static List<String> res1;
    public List<String> generateParenthesis(int n) {
        res1 = new ArrayList<>();

        solve(n,n,"");

        return res1;
        
    }
    private static void solve(int ob,int cb, String str){
        if(ob==0 && cb==0){
            res1.add(str);
            return;
        }
        if(ob != 0){
            solve(ob-1,cb,str+'(');
        }
        if(ob<cb){
            solve(ob,cb-1,str+')');
        }
    }
	
	////////////////////////////////////////////////////////
	static ArrayList<ArrayList<Integer>> res;
	static HashSet<ArrayList<Integer>> set;

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> arr) {
		res = new ArrayList<>();
		set = new HashSet<>();
		solve(arr, arr.size(), 0);

		return res;
	}

	private static void solve(ArrayList<Integer> arr, int n, int pos) {
		if (pos == n) {
			if (!set.contains(arr)) {
				ArrayList<Integer> t = new ArrayList<>(arr);
				set.add(t);
				res.add(t);
			}
			return;
		}
		for (int i = pos; i < n; i++) {
			swap(arr, i, pos);
			solve(arr, n, pos + 1);
			swap(arr, i, pos);
		}
	}

	private static void swap(ArrayList<Integer> arr, int i, int j) {
		int temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}

	///////////////////////////////////////////////////////////////////////////////////
	static ArrayList<ArrayList<Integer>> list;
	// static HashSet<ArrayList<Integer>> set;

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {
		list = new ArrayList<>();
		set = new HashSet<>();
		Collections.sort(arr);
		solve(arr, sum, 0, 0, new ArrayList<>());
		return list;
	}

	private static void solve(ArrayList<Integer> arr, int sum, int pos, int currSum, ArrayList<Integer> temp) {
		if (pos == arr.size()) {
			if (currSum == sum && !set.contains(temp)) {
				ArrayList<Integer> t = new ArrayList<>(temp);
				set.add(t);
				list.add(t);
			}
			return;
		}
		// take
		currSum = currSum + arr.get(pos);
		temp.add(arr.get(pos));
		solve(arr, sum, pos + 1, currSum, temp);

		// dont take
		currSum = currSum - arr.get(pos);
		temp.remove(temp.size() - 1);
		solve(arr, sum, pos + 1, currSum, temp);

	}
	////////////////////////////////////////////
//	static ArrayList<ArrayList<Integer>> res;
//    static HashSet<ArrayList<Integer>> set;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> arr) {
        res = new ArrayList<>();
        set = new HashSet<>();
        
        Collections.sort(arr);
        solve(arr, arr.size(),0, new ArrayList<Integer>());
        
        Collections.sort(res, new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2){
                int len = Math.min(l1.size(), l2.size());
                for(int i=0;i<len;i++){
                    if(l1.get(i)<l2.get(i)) return -1;
                    if(l1.get(i)>l2.get(i)) return 1;
                }
                if(l1.size()<l2.size()) return -1;
                if(l1.size()>l2.size()) return 1;
                return 0;
            }
        });
        
        return res;
    }
    private static void solve(ArrayList<Integer> arr, int n, int pos,ArrayList<Integer> temp){
        if(pos==n){
        	if(!set.contains(temp)){
        		//it will create a copy as temp is keep on changing
                ArrayList<Integer> t = new ArrayList<>(temp);
                set.add(t);
                res.add(t);
            }
            return;
        }
        temp.add(arr.get(pos));
        solve(arr,n, pos+1,temp);
        temp.remove(temp.size()-1);
        solve(arr, n, pos+1,temp);
    }
    
    ////////////////////////////////////////////////////////////////
    //39. Combination Sum
    //40. Combination Sum II
    static List<List<Integer>> res2;
    public List<List<Integer>> combinationSum2(int[] arr, int k) {
        res = new ArrayList<>();
        Arrays.sort(arr);
        solve(0,0,arr,k,new ArrayList<>());
        return res2;
    }

    private static void solve(int i,int sum, int arr[],int k, List<Integer> temp){
        if(sum>k) return;
        if(i==arr.length){
            List<Integer> t = new ArrayList<>(temp);
            if(sum==k){
                res2.add(t);
            }
            return;
        }
        sum += arr[i];
        temp.add(arr[i]);
        solve(i+1, sum, arr, k, temp);

        sum -= arr[i];
        temp.remove(temp.size()-1);
        while(i+1< arr.length && arr[i]==arr[i+1]) 
            i++;
        solve(i+1, sum, arr, k, temp);
    }
    //216. Combination Sum III
    //static List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int n, int k) {
        int arr[] = new int[9];
        for(int i=0;i<9;i++)   arr[i] = i+1;
        res = new ArrayList<>();
        solve(0,0,arr,n,k,new ArrayList<>());
        return res2;
        
    }
    private static void solve(int i,int sum, int arr[],int n,int k, List<Integer> temp){
        if(sum>k) return;
        if(i==arr.length){
            List<Integer> t = new ArrayList<>(temp);
            if(sum==k && t.size()==n){
                res2.add(t);
            }
            return;
        }
        sum += arr[i];
        temp.add(arr[i]);
        solve(i+1, sum, arr,n, k, temp);

        sum -= arr[i];
        temp.remove(temp.size()-1);
        solve(i+1, sum, arr,n, k, temp);
    }
    
    

}
