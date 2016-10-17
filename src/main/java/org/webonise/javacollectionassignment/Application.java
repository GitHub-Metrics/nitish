package org.webonise.javacollectionassignment;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Application {
   public static void main(String[] args) {

      Application application = new Application();

      try {
         application.listDemo();
         System.out.println("\n\n");
         application.setDemo();
         System.out.println("\n\n");
         application.mapDemo();
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }

   private void listDemo() throws Exception {

      UserList userList;
      UserDB userDB = new MongoDB("localhost", 27017, "User", "users");
      userList = new UserList(userDB.getListOfUsers());

      System.out.println("\n==============List obtained from DB===============");
      userList.displayList();

      System.out.println("\n==============Add User to UserList===============");
      User user = new User("Kuldeep Singh", "18-06-1993", "kuldeepsingh@gmial.com");
      userList.add(user);
      userList.displayList();

      System.out.println("\n==============After Sorting by name===============");
      userList.sort();
      userList.displayList();

      System.out.println("\n==============Equals Demo===============");
      List<User> users = userList.getUserList();
      User user1 = users.get(0);
      User user2 = users.get(2);

      System.out.println("is " + user1.getName() + " equals to " + user2.getName() + "?");
      if (user1.equals(user2)) System.out.println("Yes");
      else System.out.println("No");

      System.out.println("\n================Comparator Demo==================");
      Collections.sort(users, new DateOfBirthComparator());
      userList.displayList();

      System.out.println("\n==============clear UserList===============");
      userList.clear();
      userList.displayList();
   }

   private void setDemo() throws Exception {

      UserSet userSet;

      UserDB userDB = new MongoDB("localhost", 27017, "User", "users");
      userSet = new UserSet(userDB.getSetOfUsers());

      System.out.println("\n==============Set obtained from DB===============");
      userSet.displaySet();

      System.out.println("\n==============Add User to UserSet===============");
      User user = new User("Kuldeep Singh", "18-06-1993", "kuldeepsingh@gmail.com");
      userSet.add(user);
      userSet.displaySet();

      System.out.println("\n==============Equals Demo===============");
      Set<User> users = userSet.getUserSet();
      Iterator<User> iterator = users.iterator();
      User user1 = iterator.next();
      User user2 = iterator.next();

      System.out.println("is " + user1.getName() + " equals to " + user2.getName() + "?");
      if (user1.equals(user2)) System.out.println("Yes");
      else System.out.println("No");

      System.out.println("\n==============clear UserSet===============");
      userSet.clear();
      userSet.displaySet();
   }

   private void mapDemo() throws Exception {

      UserSet userSet;
      UserMap userMap;

      UserDB userDB = new MongoDB("localhost", 27017, "User", "users");
      userSet = new UserSet(userDB.getSetOfUsers());
      userMap = new UserMap(userSet.getUserSet());

      System.out.println("\n==============Map===============");
      userMap.displayMap();

      System.out.println("\n==============Map.containKey(Object key)===============");
      System.out.println("is 2 key exits ?");
      System.out.println(userMap.containKey(2));

      System.out.println("\n==============Map.containValue(Object value)===============");
      System.out.println("is value at 2 exits ?");
      System.out.println(userMap.containValue(userMap.get(2)));

      System.out.println("\n==============Add User to UserMap===============");
      User user = new User("Kuldeep Singh", "18-06-1993", "kuldeepsingh@gmial.com");
      userMap.add(3, user);
      userMap.displayMap();

      System.out.println("\n==============remove User from UserMap===============");
      userMap.remove(2);
      userMap.displayMap();

      System.out.println("\n==============Add replace User in UserMap===============");
      user = new User("Kuldeep Sharma", "18-06-1993", "kuldeepsingh@gmial.com");
      userMap.replace(1, user);
      userMap.displayMap();

      System.out.println("\n==============clear UserMap===============");
      userMap.clear();
      userMap.displayMap();
   }
}
