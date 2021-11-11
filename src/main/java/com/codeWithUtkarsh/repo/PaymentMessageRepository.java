package com.codeWithUtkarsh.repo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PaymentMessageRepository {

       private List<String> list = new ArrayList<String>();

       public void addMessage(String message) {
          list.add(message);
       }

       public String getAllMessages() {
          return list.toString();
       }
}