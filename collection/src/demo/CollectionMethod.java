package demo;

import org.omg.IOP.ComponentIdHelper;

import java.lang.annotation.Target;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author Wangzhiwen
 * @ClassName CollectionMethod
 * @Description：collection接口是所有集合类的父接口，其中包含了一些可以通用的方法。
 * @Date 2019/7/23 16:31
 * @Version 1.0
 */
public class CollectionMethod {
    public static void main(String[] args) {

    }
}

/**
 * 集合和数组的区别： 1.数组初始化时长度是一定的，集合可以动态扩容。
 *                2.数组可以存基本数据类型和引用类型，集合中只能存引用类型。
 *                3.数组无法保存两个值之间有映射关系的数据，集合中Map可以。
 */
class Method{
    public void MethodTest(){
        Collection collection = new ArrayList();
        /**
         * add，向集合中添加元素。集合中只能加入对象，无法加入基本数据类型
         */
        boolean add = collection.add("add方法");
        /**
         * Java有自动装箱，所有直接存入数值。会被转换为其包装类型
         */
        collection.add(23);
        /**
         * size方法，返回int类型。获取当前集合中包含的元素个数
         */
        System.out.println(collection.size());
        /**
         * remove方法，返回boolean类型。删除集合中存在的某一个对象，传入的也是对象。
         */
        boolean remove = collection.remove(23);
        /**
         * contains方法，返回boolean类型。判断集合中是否包含某一个元素对象
         */
        System.out.println(collection.contains("add方法"));
        /**
         * isEmpty方法，返回boolean类型。判断集合是否为空，即是size是否为0.这个方法的底层实现就是size == 0
         */
        boolean empty = collection.isEmpty();
        /**
         * toArray方法，将集合转换为数组
         */
        Object[] objects = collection.toArray();
        /**
         * addAll方法，直接加入一个集合到另一个集合中
         */
        Collection collection1 = new ArrayList();
        collection1.add(45);
        collection.addAll(collection1);
        /**
         * containsAll方法，判断集合中是否包含另一个集合的全部元素
         */
        boolean containsAll = collection.containsAll(collection1);
        /**
         * removeAll方法，移除集合中包含在另一个集合里的全部元素
         */
        boolean removeAll = collection.removeAll(collection1);
        /**
         * retainAll方法，两个取交集
         */
        boolean retainAll = collection.retainAll(collection1);

        /**
         * iterator方法，返回遍历接口对象。用来迭代集合内的元素，根据掉件移除集合中某些元素时只能使用迭代器来实现。
         */
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        /**
         * Java8新增forEach方法来遍历集合，他是一个默认方法。可以使用lambda表达式来实现，
         */
        collection.forEach(obj -> {
            System.out.println(obj);
        });
        /**
         * 删除集合中的某元素，使用迭代器删除
         */
        Iterator iterator1 = collection.iterator();
        while (iterator1.hasNext()){
            Object next = iterator1.next();
            if (Objects.equals(next,25)){
                iterator1.remove();
            }
        }
        /**
         * Java8新增的接口，更加简便的实现删除。predicate操作集合
         */
        collection.removeIf(o -> Objects.equals(o,25));
        /**
         *函数式接口，使用lambda表达式实现接口。是为了避免使用new匿名内部类的方式，比较繁琐。
         */
        // predicate接口中，只有test方法是必须被实现的。其余的方法均为default类型，不用强制实现。
        int i = calAll(collection, o -> o.equals(56));
        calAll(collection, new Predicate() {
            @Override
            public boolean test(Object o) {
                return false;
            }
        });
        //calAll(collection, o -> o.toString());
        /**
         * 返回流式API
         */
        Stream stream = collection.stream();

        List<Person> people = new ArrayList<>();
        Person person = new Person();
        person.setAge(18);
        person.setIdCart("student");
        person.setName("coco");

        Person person1 = new Person();
        person.setAge(22);
        person.setIdCart("NoStudent");
        person.setName("coco1");

        Person person2 = new Person();
        person.setAge(85);
        person.setIdCart("student");
        person.setName("coco3");

        Person person3 = new Person();
        person.setAge(89);
        person.setIdCart("NoStudent");
        person.setName("coco4");
        people.add(person);
        people.add(person1);
        people.add(person2);
        people.add(person3);
        /**
         * 使用stream流的filter方法，传入Predicate实现类。选择好泛型类型，实现test方法。写入过滤的逻辑
         */
        people.stream().filter(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.isStudent();
            }
        });
        /**
         * 使用lambda表达式来实现Predicate，传入的参数是person4，isStudent是实例方法。
         * person4.isStudent()就是实现test方法的实现体，匿名类。已实现可返回实现对象，但是没有名字且出现执行一次。
         */
        people.stream().filter(person4 -> person4.isStudent());
        /**
         * 下面这个是lambda表达式的对方法的直接引用，更加简洁。
         * 对实现函数式接口，方法体中需要调用当前对象拥有的方法时。可以使用lambda表达式直接引用该方法
         */
        Stream<Person> personStream = people.stream().filter(Person::isStudent);
        people =  personStream.collect(Collectors.toList());
    }

    /**
     * 使用predicate的test方法，筛选满足条件的集合。不在执行循环来判断。新增的谓词接口，十分方便对集合进行过滤，适合做判断。
     */
    public int calAll(Collection collection, Predicate predicate){
    int total = 0;
        for (Object o : collection) {
            // test方法，用来判断传入的对象是否满足predicate设定的条件
            if (predicate.test(o)){
                total++;
            }
        }
        return total;
    }

    /**
     * Java8新增的stream操作集合，stream、IntStream、DoubleStream、LongStream流式接口。有许多计算集合中最大、最小、平均等的方法。
     * 适合对集合进行统计运行，流式API中有许多方法可以传入predicate对象。直接对集合元素进行条件判断，Java8中集合中对此新增了stream方法。
     * 返回stream对象
     */
    void stream(){
        IntStream build = IntStream.builder()
                .add(15)
                .add(16)
                .add(17)
                .add(18)
                .add(255)
                .build();
        System.out.println("集合中最大的元素是："+build.max().getAsInt());
        System.out.println("集合中最小的元素是："+build.min().getAsInt());
        System.out.println("集合所有元素中平方大于999999的元素："+ build.allMatch(value -> value*value>9999));
    }
}

/**
 * set集合的基本使用，无序不允许重复。
 */
class SetCollection{
    /**
     * set集合接口的实现类：HashSet，典型实现。大多时候都是用这个类实现set，
     * 它是按照Hash算法来存储集合中的元素，每个对象通过Hash算法得到的hash值都是不同的。根据hash值可以直接定位到该元素存储的具体位置，所有查找的效率比较高。
     * HashSet具有以下特点：
     *  1.不能保证元素的顺序，可能与存入的顺序不同。
     *  2.HashSet是线程不安全的
     *  3.可以存入null值
     * 向HashSet中存取数据时，首先调用该对象的equals方法。判断对象与其他元素上一个元素是否相同，如果不相同根据hash算法获得hash值。
     * 根据hash值找到具体的存储位置。如果equals方法返回的值相同，在判断hash值是否相同。如果hash值不同，这就与set集合的规则产生了冲突。
     * 如果equals方法返回的是false，但是hashcode值一样。这将会到导致在同一个hashcode值内存上，产生链表来存储hashcode值相同的元素。
     *
     * 所以，用set集合来存储元素对象时。该对象必须重写equals和hashCode方法。保证hashCode相同时equals返回的是true
     *
     */
    class HashSetMethod{
        public void method1(){
            Set set = new HashSet();
        }
    }

    /**
     * LinkedHashSet：是HashSet的子类，也是根据HashCode值来存储元素。但是内部使用的是链表来维护次序，所以遍历时元素的顺序和添加时的顺序是相同的。
     * 因为使用了链表，所以他的效率没有HashSet快。
     */
    static class LinkedHashSetMethod{
        public void method1(){
            Set set = new LinkedHashSet();
            set.add("one");
            set.add("two");
            set.add("three");
            set.add("four");
            set.add("five");
            System.out.println(set);// [one, two, three, four, five]
            set.remove("two");
            System.out.println(set);// [one, three, four, five]
            set.add("two");
            System.out.println(set);// [one, three, four, five, two]
        }

        public static void main(String[] args) {
          LinkedHashSetMethod linkedHashSetMethod = new LinkedHashSetMethod();
          linkedHashSetMethod.method1();
        }
    }

    /**
     * ThreeSet：sortSet接口的实现类，主要实现了对元素排序的功能。并增加了几个方法：获取第一个、最后一个、前一个、后一个以及三种截取集合的方法。
     * 采用红黑树的数据结构来存储集合元素。
     * TreeSet最好存储同一类型的元素，不同类型的元素使用comparator接口中的比较方法时会产生异常。
     * 使用TreeSet来存储元素时，元素类必须实现了Comparator接口。TreeSet存储元素时，会调用比较的方法。如果返回值不为0就可以添加。代表不相同
     * 也必须重写equals方法，必须保证当equals返回true时，comparatorTo返回的是0。代表是相同的元素，不允许再次添加。
     * 当equals返回false时，comparatorTo返回的不为0。代表不是相同的元素，可以添加。
     *
     *
     * 注意：当加入的是可变元素（对象，属性值可以改变）之后，最好不要修改元素属性的值。因为如果修改了之后的属性值，正是comparatorTo方法比较需要的值。
     * 可能导致，修改就集合中与其他元素相同了。此时如果想要删除刚才实例变量被改变的袁术，会无法删除。所以当元素被加入到此集合中是，最好是不在修改其属性值。
     */
    static class TreeSetMethod{
        private void method1(){
            TreeSet treeSet = new TreeSet();
            treeSet.add(89);
            treeSet.add(40);
            treeSet.add(-90);
            treeSet.add(90);
            treeSet.add(20);
            Comparator comparator = treeSet.comparator(); // 没有使用特定排序时，内部使用自然排序且Comparator为null
            System.out.println(comparator);
            System.out.println(treeSet.toString()); // [-90, 20, 45, 89, 90]
            treeSet.forEach(System.out::println);
            System.out.println("获取第一个元素："+treeSet.first());
            System.out.println("获取最后一个元素："+treeSet.last());
            System.out.println("返回集合中小于30的第一个元素："+treeSet.lower(30));
            System.out.println("返回集合中大于88的第一个元素："+treeSet.higher(88));
            System.out.println("返回集合中元素值在50-90之间的集合："+treeSet.subSet(50,90));
            System.out.println("返回子集，小于40："+treeSet.headSet(40));
            System.out.println("返回集合，大于等于40："+treeSet.tailSet(40));
        }

        public static void main(String[] args) {
            TreeSetMethod treeSetMethod = new TreeSetMethod();
            treeSetMethod.method1();
        }
    }
}

/**
 * List集合：有序可以重复。
 */
class ListCollection{

}
