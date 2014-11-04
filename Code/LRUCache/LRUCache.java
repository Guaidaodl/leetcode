/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 *
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 *
 * @author Guaidaodl
 */

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DoubleLinkedNode {
        int val;
        int key;
        DoubleLinkedNode next;
        DoubleLinkedNode pre;

        DoubleLinkedNode(int key, int val) {
            this.key = key;
            this.val =val;
            next = null;
            pre = null;
        }
    }
    int keyNum;
    int capacity;
    DoubleLinkedNode valueCacheList;
    Map<Integer, DoubleLinkedNode> keyMap;
    public LRUCache(int capacity) {
        keyMap = new HashMap<Integer, DoubleLinkedNode>(capacity);
        this.capacity = capacity;
        keyNum = 0;
        valueCacheList = new DoubleLinkedNode(-1, 0);
        valueCacheList.next = valueCacheList;
        valueCacheList.pre = valueCacheList;
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) {
            return -1;
        }

        DoubleLinkedNode node = keyMap.get(key);
        moveNodeToHead(node);

        return node.val;
    }
    public void set(int key, int value) {
        if (keyMap.containsKey(key)) {
            DoubleLinkedNode node = keyMap.get(key);
            node.val = value;
            moveNodeToHead(node);
        } else if (keyNum < capacity){
            DoubleLinkedNode node = new DoubleLinkedNode(key, value);
            insertNodeToHead(node);
            keyMap.put(key, node);
            keyNum++;
        } else {
            DoubleLinkedNode node = valueCacheList.pre;
            keyMap.remove(node.key);
            keyMap.put(key, node);
            node.key = key;
            node.val = value;
            moveNodeToHead(node);
        }
    }
    void insertNodeToHead(DoubleLinkedNode node) {
        node.next = valueCacheList.next;
        node.pre = valueCacheList;
        valueCacheList.next.pre = node;

        valueCacheList.next = node;
        if (valueCacheList.pre == valueCacheList) {
            valueCacheList.pre = node;
        }
    }
    void moveNodeToHead(DoubleLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        insertNodeToHead(node);
    }
}