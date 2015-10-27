
import java.util.*;
import java.util.Map.Entry;

public class test1 {

	public static void main(String[] args){

	//deque

	Deque<Integer> di =  new LinkedList<Integer>();
	di.offerLast(4);
	di.offerLast(7);
	di.offerLast(2);
	System.out.println(di.pollFirst());
	System.out.println(di.pollFirst());
	System.out.println(di.pollFirst());

	//Queue

	Queue<String> que = new LinkedList<String>();
	que.offer("shao");
	que.offer("an");
	que.offer("qi");
	que.add("handsome");
	String item1 = que.poll();
	String item2 = que.remove();
	String item3 = que.peek();
	String item4 = que.element();

	System.out.println(item1);
	System.out.println(item2);
	System.out.println(item3);
	System.out.println(item4);
	for (String temp : que) {
		System.out.println(temp);
	}

	//HashMap

	Map<String, String> countryNames = new HashMap<String, String>();
	countryNames.put("GB", "Great Britain");
	countryNames.put("FR", "France");
	countryNames.put("IT", "Italy");
	countryNames.put("FW", "Far Far Away");

	String name = countryNames.get("FR");
    
    System.out.println(name);

    for (String temp : countryNames.keySet()) {

    	System.out.println(temp + " : " + countryNames.get(temp));
    }

    for (String result : countryNames.values()) {

    	System.out.println("Now let me present to you: " + result);
    }

    for (Entry<String, String> plutot : countryNames.entrySet()) {
    	String key = plutot.getKey();
    	String value = plutot.getValue();
    	System.out.println(key + " :: " + value);
    }

    //TreeMap


    Map<String, String> treecountryNames = new TreeMap<String, String>();
	treecountryNames.put("GB", "Great Britain");
	treecountryNames.put("FR", "France");
	treecountryNames.put("IT", "Italy");
	treecountryNames.put("FW", "Far Far Away");

	String treename = treecountryNames.get("FR");
    
    System.out.println(name);

    for (String temp : treecountryNames.keySet()) {

    	System.out.println(temp + " : " + treecountryNames.get(temp));
    }

    for (String result : treecountryNames.values()) {

    	System.out.println("Now let me present to you: " + result);
    }

    for (Entry<String, String> plutot : treecountryNames.entrySet()) {
    	String key = plutot.getKey();
    	String value = plutot.getValue();
    	System.out.println(key + " :: " + value);
    }

    //HashSet

    Set<String> ss = new HashSet<String>();
    ss.add("shao");
    ss.add("an");
    ss.add("qi");
    ss.add("feng");
    ss.add("huimao");
    for (String temp : ss) {
    	System.out.println(temp);
    }

    //LinkedHashSet

    Set<String> ls = new LinkedHashSet<String>();

    ls.add("shao");
    ls.add("an");
    ls.add("qi");
    ls.add("feng");
    ls.add("huimao");

    for (String temp : ls) {
        System.out.println(temp);
    }

    //TreeSet

    Set<String> ts = new TreeSet<String>();
    ts.add("shao");
    ts.add("an");
    ts.add("qi");
    ts.add("handsome");
    ts.add("sunwukong");
    ts.add("cangjingkong");
    for (String temp : ts) {
    	System.out.println(temp);
    }


    int[] array = new int[]{4,3,2};

    List<Integer> list = Arrays.asList(3,4,5);

    System.out.println(list);

    Arrays.sort(array);
    for (int ele : array) {
    System.out.println(ele);
}
}

}