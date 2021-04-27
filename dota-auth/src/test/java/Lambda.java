import org.apache.commons.lang.math.NumberUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda {
	enum Top{HAH}
	private Set<Top> tops;
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("1", "3");
		map.merge("1", "2", (count, inc) -> count + inc);

		String s = "x";
		// map.computeIfAbsent(key, k -> new HashSet<V>()).add(v);
		System.out.println(map.computeIfAbsent("2", (v1) ->s));

		// function reference
//		map.entrySet().forEach(System.out::println);-

		List<String> list = new ArrayList<>();
		list.add("1");
		list.stream().map(Integer::parseInt).forEach(System.out::println);
		list.stream().map(String::toLowerCase).forEach(System.out::println);
		list.stream().collect(Collectors.toMap(k->k, v->v, (v1, v2) -> v1));
		list.stream().collect(Collectors.groupingBy(v -> v));
		list.stream().collect(Collectors.groupingBy((NumberUtils::toLong)));
		list.stream().sorted(Comparator.comparing(NumberUtils::toLong));

		EnumSet<Top> tops = EnumSet.allOf(Top.class);
		tops.forEach(System.out::println);
		tops.retainAll()
	}
}

enum Day {
	MONDAY, TUESDAY, WEDNESDAY,
	THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
class Worker {
	String name;
	Set<Day> availableDays;

	public Worker(String name, Set<Day> availableDays) {
		this.name = name;
		this.availableDays = availableDays;
	}

	public String getName() {
		return name;
	}

	public Set<Day> getAvailableDays() {
		return availableDays;
	}
}

