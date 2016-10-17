package org.webonise.javacollectionassignment;

import java.util.List;
import java.util.Set;

public interface UserDB {
   List<User> getListOfUsers() throws Exception;
   Set<User> getSetOfUsers() throws Exception;
}
