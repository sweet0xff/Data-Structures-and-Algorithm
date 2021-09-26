package com.github.sweet.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author sweet
 * @description
 * @date 2021/9/25 13:58
 */
public class LRUCache<K, V> implements Iterable<K> {
    final static int MAX = 3;

    LinkedHashMap<K, V> cache = new LinkedHashMap<>();

    public void cache(K key, V value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        } else if (cache.size() >= MAX) {
            Iterator<K> iterator = cache.keySet().iterator();
            K first = iterator.next();
            cache.remove(first);
        }
        cache.put(key, value);
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        return cache.get(key);
    }

    @Override
    public Iterator<K> iterator() {
        Iterator<Map.Entry<K, V>> iterator = cache.entrySet().iterator();
        return new Iterator<K>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public K next() {
                return iterator.next().getKey();
            }
        };
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> test = new LinkedHashMap<>();
        Iterator<Map.Entry<Integer, String>> iterator = test.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(iterator.next());
        }

        LRUCache<String, Integer> lru = new LRUCache<>();
        lru.cache("A", 1);
        lru.cache("B", 2);
        lru.cache("C", 3);

        lru.cache("D", 4);
        lru.cache("C", 10);
        System.out.println(
                "leave <-"+
                        StreamSupport.stream(lru.spliterator(), false)
                                .map(Object::toString)
                                .collect(Collectors.joining("<-"))
        );



    }
}
