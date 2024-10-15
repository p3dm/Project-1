package week_3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/***
 * Given a family tree represented by child-parent (c,p) relations in which c is a child of p. Perform queries about the family tree:
 * descendants <name>: return number of descendants of the given <name>
 * generation <name>: return the number of generations of the descendants of the given <name>
 *
 * Note that: the total number of people in the family is less than or equal to 10
 * 4
 * Input
 * Contains two blocks. The first block contains information about child-parent, including lines (terminated by a line containing ***), each line contains: <child> <parent> where <child> is a string represented the name of the child and <parent> is a string represented the name of the parent. The second block contains lines (terminated by a line containing ***), each line contains two string <cmd> and <param> where <cmd> is the command (which can be descendants or generation) and <param> is the given name of the person participating in the  query.
 * Output
 * Each line is the result of a corresponding query.
 * Example
 * Input
 * Peter Newman
 * Michael Thomas
 * John David
 * Paul Mark
 * Stephan Mark
 * Pierre Thomas
 * Mark Newman
 * Bill David
 * David Newman
 * Thomas Mark
 * ***
 * descendants Newman
 * descendants Mark
 * descendants David
 * generation Mark
 * ***
 * Output
 * 10
 * 5
 * 2
 * 2
 */
class Node2{
    String name;
    List<Node2> children;
    Node2(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
    void addChild(Node2 child) {
        children.add(child);
    }
}
class TreeFamily{
    Map<String, Node2> nodes = new HashMap<>();

    void addRelation(String childName, String parentName){
        Node2 parent = nodes.computeIfAbsent(parentName, k -> new Node2(parentName));
        Node2 child = nodes.computeIfAbsent(childName, k -> new Node2(childName));
        parent.addChild(child);
    }

    int countDecendants(Node2 node){
        int count = 0;
        for(Node2 child : node.children){
            count += 1 + countDecendants(child);
        }
        return count;
    }

    int countGeneration(Node2 node){
        int max = 0;
        for(Node2 child : node.children){
            max = Math.max(max, 1 + countGeneration(child));
        }
        return max;
    }

    int getDecendants(String name){
        Node2 node = nodes.get(name);
        if(node == null){
            return 0;
        }
        return countDecendants(node);
    }

    int getGeneration(String name){
        Node2 node = nodes.get(name);
        if(node == null){
            return 0;
        }
        return countGeneration(node);
    }
}
public class Family_tree {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeFamily tree = new TreeFamily();
        String line;
        while((line = br.readLine()) != null){
            if(line.equals("***")){
                break;
            }
            String[] arr = line.split(" ");
            String child = arr[0];
            String parent = arr[1];
            tree.addRelation(child, parent);
        }

        while((line = br.readLine()) != null){
            if(line.equals("***")){
                break;
            }
            String[] arr = line.split(" ");
            String cmd = arr[0];
            String param = arr[1];

            if(cmd.equals("descendants")){
                System.out.println(tree.getDecendants(param));
            } else if(cmd.equals("generation")){
                System.out.println(tree.getGeneration(param));
            }
        }
    }
}