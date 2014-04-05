package generator;

import java.util.LinkedList;
import java.util.List;

public class Question {
    public List<String> lines;
	public List<Integer> spaces;
	public Integer[] answers;
	public ProblemComponent problem;
	
	public Question(LinkedList<String> l, LinkedList<Integer> s, int[] a, ProblemComponent p) {
		this.problem = p;
		this.lines = l;
		this.spaces = s;
		Integer[] ans = new Integer[a.length];
		for (int i = 0; i < a.length; i++) {
			ans[i] = new Integer(a[i]);
		}
		this.answers = ans;
	}

}
