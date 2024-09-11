package com.ufabc.app;

import com.ufabc.app.service.NodeService;

public class App {
    public static void main(String[] args) {
        NodeService.initializeNode();
        System.out.println("Hello World!");
    }
}
