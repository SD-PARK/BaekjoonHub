import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Stack<String> st = new Stack<>();
        for(String i : s.split(" ")) {
            if(i.equals("Z"))
                st.pop();
            else
                st.push(i);
        }
        for(int i=st.size(); i>0; i--) {
            answer += Integer.parseInt(st.pop());
        }
        return answer;
    }
}