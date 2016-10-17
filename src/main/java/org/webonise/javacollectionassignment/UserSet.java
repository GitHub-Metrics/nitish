package org.webonise.javacollectionassignment;

import java.util.Set;

public class UserSet {

   private final Set<User> users;

   public UserSet(Set<User> users) {

      this.users = users;
   }

   public void displaySet() {

      if (users.isEmpty()) {
         System.out.println("no users found");
      } else {
         for (User user : users) {
            System.out.println(user.getName() + " " + user.getdateOfBirth() + " " + user.getEmail());
         }
      }
   }

   public Set<User> getUserSet() {

      return users;
   }

   public void add(User user) {

      users.add(user);
   }

   public void clear() {

      users.clear();
   }
}
