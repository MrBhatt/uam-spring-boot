
package com.dbune.uam.service;

import java.util.List;
import com.dbune.uam.model.User;

public interface UserService {

    public List<User> getUsers();

    public User getUser(long id);

}
