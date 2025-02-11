package dataStructure.linkedList;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 146. LRU 缓存
 * 中等
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。

 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 *
 * 提示：
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 */
public class LRUCache {
    //使用hash表和双向链表来实现
    private final HashMap<Integer, Node> map;
    private final LinkedList<Node> link;
    //这里还要设置一个最大容量
    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        //注意这里直接创建对象
        this.link = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        //如果没有这个值
        if(!map.containsKey(key)){
            return -1;
        }
        //获取当前值
        Node node = map.get(key);
        int value = node.value;
        //进行操作。最近使用过的放在链表头

        //先删除
        link.remove(node);
        //移到链表头
        link.addFirst(node);

        return value;


    }

    //更新或者插入
    public void put(int key, int value) {
        //如果存在就进行更新，并且放在第一位
        if (map.containsKey(key)){
            Node node = map.get(key);
            link.remove(node);
            //更新
            node.value = node.value;
            //添加到头部
            link.addFirst(node);
        }else {
            //如果不存在，需要判断是否超出容量
            if (link.size() == capacity){
                //删除队尾元素,注意这里返回了当前node
                Node node = link.removeLast();
                //删除map中的映射
                map.remove(node.key);
            }
            //创建新节点并且添加
            Node newNode = new Node(key, value);
            link.addFirst(newNode);
            map.put(key, newNode);

        }

    }

    //内部类，双向链表的节点
    class Node{
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
