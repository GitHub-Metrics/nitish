package org.webonise.javacollectionassignment;

import java.util.Collections;
import java.util.List;

public class UserList {
   private final List<User> users;

   public UserList(List<User> users) {

      this.users = users;
   }

   public void displayList() {

      if (users.isEmpty()) {
         System.out.println("DB is empty");
      } else {
         for (User user : users) {
            System.out.println(user.getName() + " " + user.getdateOfBirth() + " " + user.getEmail());
         }
      }
   }

   public void sort() {
      //using comparable interface to sort user defined class list
      Collections.sort(this.users);
   }

   public List<User> getUserList() {

      return users;
   }

   public void add(User user) {

      users.add(user);
   }

   public void clear() {

      users.clear();
   }
}
