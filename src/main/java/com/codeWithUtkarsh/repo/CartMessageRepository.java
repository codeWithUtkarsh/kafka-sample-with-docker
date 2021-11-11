package com.codeWithUtkarsh.repo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CartMessageRepository {

       private List<Integer> list = new ArrayList<Integer>();

       public void addMessage(String message) {
          list.add(message.length());
       }

       public String getAllMessages() {
          return list.toString();
       }
}