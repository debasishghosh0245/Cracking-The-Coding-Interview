import java.util.*;
public class AlienDictionary_269{
	
	public static void main(String[] args){
		String[] words ={"z","x","z"};
		HashMap<Character,Integer> indegree=new HashMap<>();
		HashMap<Character,List<Character>> graph=constructGraph(words,indegree);
		System.out.println(alienOrder(indegree,graph));
	}
	
	public static HashMap<Character,List<Character>> constructGraph(String[] words,
		HashMap<Character,Integer> indegree){
		HashMap<Character,List<Character>> graph=new HashMap<>();
		for(String word:words){
			for(char ch: word.toCharArray()){
				indegree.put(ch,0);
				graph.put(ch,new ArrayList<Character>());
			}
		}
		for(int i=0;i<words.length-1;i++){
			String word1=words[i];
			String word2=words[i+1];
			int length=Math.min(word1.length(),word2.length());
			for(int j=0;j<length;j++){
				if(word1.charAt(j) !=word2.charAt(j)){
					char srcVertex=word1.charAt(j);
					char nbrVertex=word2.charAt(j);
					List<Character> neighbours=graph.get(srcVertex);
					neighbours.add(nbrVertex);
					graph.put(srcVertex,neighbours);
					indegree.put(nbrVertex,indegree.getOrDefault(nbrVertex,0)+1);
					break;
				}
			}
		}
		/* for(Map.Entry<Character,List<Character>> entry:graph.entrySet()){
			System.out.print(entry.getKey()+"-->");
			System.out.println(entry.getValue());
		} */
		//System.out.println("Indegree "+indegree);
		return graph;
	}
	
	
	public static String alienOrder(HashMap<Character,Integer> indegree,
		HashMap<Character,List<Character>> graph) {
		Queue<Character> queue=new LinkedList<>();
		StringBuilder sb=new StringBuilder();
		for(Map.Entry<Character,Integer> entry: indegree.entrySet()){
			if(entry.getValue()==0){
				queue.add(entry.getKey());
			}
		}
		while(!queue.isEmpty()){
			Character ch=queue.remove();
			sb.append(ch);
			List<Character> neighbours=graph.get(ch);
			if(null!=neighbours){
				for(Character nbr: neighbours){
					indegree.put(nbr,indegree.get(nbr)-1);
					if(indegree.get(nbr)==0){
						queue.add(nbr);
					}
				}
			}
		}
		if(sb.length() < indegree.size()) {
            return "";
        }
		return sb.toString();
	}
}