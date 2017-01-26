import java.util.*;

class Order{
    String order = "";
    public Order(String string){
        this.order = string;
    }
}
class OrderDependency{
    Order cur;
    Order pre;
    public OrderDependency(Order o1, Order o2){
        cur = o1;
        pre = o2;
    }
}

public class OrderDep {
    public static List<Order> getOrderList(List<OrderDependency> orderDependencies) {
        List<Order> res = new ArrayList<>();
        Set<Order> set = new HashSet<>();
        Map<Order, List<Order>> preMap = new HashMap<>();
        Map<Order, Integer> inMap = new HashMap<>();
        for (OrderDependency dep : orderDependencies) {
            set.add(dep.cur);
            set.add(dep.pre);
            if (!preMap.containsKey(dep.pre)) {
                preMap.put(dep.pre, new ArrayList<Order>());
            }
            if (!preMap.containsKey(dep.cur)) {
                preMap.put(dep.cur, new ArrayList<Order>());
            }
            preMap.get(dep.pre).add(dep.cur);
            if (!inMap.containsKey(dep.cur)) {
                inMap.put(dep.cur, 0);
            }
            inMap.put(dep.cur, inMap.get(dep.cur)+1);
            if (!inMap.containsKey(dep.pre)) {
                inMap.put(dep.pre, 0);
            }
        }
        Queue<Order> noPreQ = new LinkedList<>();
        for (Order o : inMap.keySet()) {
            if (inMap.get(o) == 0)
                noPreQ.offer(o);
        }
        while(!noPreQ.isEmpty()) {
            Order o = noPreQ.poll();
            res.add(o);
            List<Order> dependants = preMap.get(o);
            for (Order dep : dependants) {
                int count = inMap.get(dep);
                if (count == 1) {
                    inMap.put(dep, 0);
                    noPreQ.offer(dep);
                } else {
                    inMap.put(dep, count-1);
                }
            }
        }
        if (res.size() != set.size()) {
            return new ArrayList<Order>();
        } else
            return res;
    }
    public static void main(String[] args) {
        Order o1 = new Order("A");
        Order o2 = new Order("B");
        Order o3 = new Order("C");
        Order o4 = new Order("D");
        OrderDependency od1 = new OrderDependency(o1, o2);
        OrderDependency od2 = new OrderDependency(o2, o3);
        OrderDependency od3 = new OrderDependency(o3, o4);
        List<OrderDependency> list = new ArrayList<>();
        list.add(od1);
        list.add(od2);
        list.add(od3);

        for (Order o : getOrderList(list)){
            System.out.println(o.order);
        }
    }
}
