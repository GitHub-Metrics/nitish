package org.webonise.javacollectionassignment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UserMap {
   private final Set<User> userSet;
   private final Map<Integer, User> users;

   public UserMap(Set<User> userSet) {

      this.userSet = userSet;
      users = new HashMap<>();
      mappingToHashMap();
   }

   private void mappingToHashMap() {

      Iterator<User> iterator = userSet.iterator();

      int i = 0;
      User user;
      while (iterator.hasNext()) {
         user = iterator.next();
         users.put(i++, user);
      }
   }

   public void displayMap() {

      if (users.isEmpty()) {
         System.out.println("no userMap found");
      } else {
         Set<Integer> keyset = users.keySet();
         User user;
         for (Integer key : keyset) {
            user = users.get(key);
            System.out.println(key + " : " + user.getName() + ", " + user.getdateOfBirth() + ", " + user.getEmail());
         }
      }
   }

   public void clear() {

      users.clear();
   }

   public String containKey(Integer key) {

      return users.containsKey(key) ? "YES" : "NO";
   }

   public User get(Integer key) {

      return users.get(key);
   }

   public String containValue(User value) {

      return users.containsValue(value) ? "YES" : "NO";
   }

   public void add(Integer key, User user) {

      users.put(key, user);
   }

   public void remove(Integer key) {

      users.remove(key);
   }

   public void replace(Integer key, User value) {

      users.remove(key, value);
   }
}
