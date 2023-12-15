package com.jake.algorithm.dfs;

import java.util.LinkedList;
import java.util.Stack;

public class Dfs {

    public static void dfsByRecursive(Node node) {

        node.visited = true;
        System.out.println(node.name + " ");

        for(Node neighbor : node.neighbors) {
           if(!neighbor.visited) {
               dfsByRecursive(neighbor);
           }
        }
    }

    public static void dfsByStack(Node start) {
        Stack<Node> stack = new Stack<>();
        stack.push(start);
        start.visited = true;

        while(!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.name + " ");

            for(Node neighbor : current.neighbors) {
                if(!neighbor.visited) {
                    stack.push(neighbor);
                    neighbor.visited = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 노드 구성
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");

        A.neighbors.add(B);

        B.neighbors.add(G);
        B.neighbors.add(C);
        B.neighbors.add(D);

        C.neighbors.add(D);

        D.neighbors.add(E);

        E.neighbors.add(F);
        E.neighbors.add(G);

        G.neighbors.add(H);

        Node[] nodes = {A, B, C, D, E, F, G, H};

        dfsByRecursive(A);

        dfsByStack(A);
    }
}


class Node {
    String name;
    LinkedList<Node> neighbors;
    boolean visited;

    public Node(String name) {
        this.name = name;
        this.neighbors = new LinkedList<>();
        this.visited = false;
    }
}