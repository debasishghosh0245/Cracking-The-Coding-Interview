import java.util.*;
public class ItineraryFromTickets_332 {

	public static void main(String[] args){
		List<List<String>> tickets=new ArrayList<List<String>>();
		tickets.add(Arrays.asList(new String[]{"JFK","SFO"}));
		tickets.add(Arrays.asList(new String[]{"JFK","ATL"}));
		tickets.add(Arrays.asList(new String[]{"SFO","ATL"}));
		tickets.add(Arrays.asList(new String[]{"ATL","JFK"}));
		tickets.add(Arrays.asList(new String[]{"ATL","SFO"}));
		System.out.println(findItinerary(tickets));
	}
	
	public static String findItinerary(List<List<String>> tickets) {
		
		StringBuilder sb=new StringBuilder();
		HashMap<String,String> srcDestMap=new HashMap<>();
		for(List<String> list:tickets){
			 srcDestMap.put(list.get(0),list.get(1));
		}

		HashMap<String,Boolean> srcMap=new HashMap<>();
		for(Map.Entry<String,String> entry:srcDestMap.entrySet()){
			//destination never be the source
			srcMap.put(entry.getValue(),false);
			if(!srcMap.containsKey(entry.getKey())){
				srcMap.put(entry.getKey(),true);
			}else{
				srcMap.put(entry.getKey(),false);
			}
		}
		
		String source="";
		for(String key: srcMap.keySet()){
			if(srcMap.get(key)==true){
			    source=key;
			}
		
		}
		sb.append(source);
		while(true){
			if(srcDestMap.containsKey(source)){
				source=srcDestMap.get(source);
				sb.append("->"+source);
			}
			else{
				break;
			}
		}
        return sb.toString();
    }
}