package com.ice.zk.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      numbers.add(i);
    }
    System.out.println("before: " + numbers);

    Iterator<Integer> iterator = numbers.iterator();
    while (iterator.hasNext()) {
      Integer next = iterator.next();
      if (next % 2 == 0) {
        iterator.remove();
      }
    }

    System.out.println("after: " + numbers);
  }

}
