package com.example.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import org.springframework.web.client.RestTemplate;

import ch.qos.logback.core.net.QueueFactory;

public class msTest {

	public static void main(String[] args) {
		int x = 10;
		x+=x-=x-x;
		System.out.println(x);
		
		List arrayList = new ArrayList<>();
		arrayList.subList(1, 2);
		arrayList.get(1);
		arrayList.add(1);
		arrayList.isEmpty();
		arrayList.remove(1);
		
		List linkedList = new LinkedList<>();
		linkedList.add(1);
		linkedList.remove(2);
		linkedList.get(1);
		linkedList.subList(0, 1);
		
		
		Set hashSet = new HashSet<>();
		hashSet.add(1);
		hashSet.remove(2);
		hashSet.contains(21);
		hashSet.isEmpty();
		
		Set treeSet = new TreeSet<>();
		treeSet.removeAll(arrayList);
		
		Map<Integer, Double> hashMap = new HashMap<>();
		hashMap.get(1);
		hashMap.put(1, 2.0);
		hashMap.remove(1);
		hashMap.size();
		
		Queue<Integer> que = new PriorityQueue<>();
		que.peek();
		que.poll();
		que.add(1);
		
		
		try {
			ServerSocket serverSocket = new ServerSocket(6654);
			Socket socket = new Socket("172.0.0.1",6654);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Deque<Integer> deque = new ArrayDeque<>();
		deque.pop();
		deque.push(1);
		
	}

}
