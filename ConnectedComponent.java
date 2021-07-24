package questions.practice;

import java.util.Arrays;
import java.util.List;

//https://www.geeksforgeeks.org/connected-components-in-an-undirected-graph/
//https://leetcode.com/discuss/interview-question/799545/goldman-sachs-oa-2020
//https://leetcode.com/problems/number-of-provinces/solution/

public class ConnectedComponent {
    private boolean[] visited;
    private List<String> related;

    public int countGroups(List<String> related){
        this.related = related;
        visited = new boolean[related.size()];
        int count = 0;
        for(int i=0;i<related.size();i++){
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        return count;
    }

    private void dfs(int index){
        if(visited[index])  return;
        visited[index] = true;
        for (int j = 0; j < related.get(index).length(); j++) {
            if (related.get(index).charAt(j) == '1') {
                dfs(j);
            }
        }
    }

    public static void main(String[] args) {
        // related is like an adjacent matrix
        {
            List<String> related =
                    Arrays.asList("110", "110", "001");
            ConnectedComponent cc = new ConnectedComponent();
            System.out.println(cc.countGroups(related));
        }
        {
            List<String> related =
                    Arrays.asList("1100", "1110", "0110", "0001");
            ConnectedComponent cc = new ConnectedComponent();
            System.out.println(cc.countGroups(related));
        }
        {
            List<String> related =
                    Arrays.asList("10000", "01000", "00100", "00010", "00001");
            ConnectedComponent cc = new ConnectedComponent();
            System.out.println(cc.countGroups(related));
        }
    }
}
