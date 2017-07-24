package zizai.service;

import zizai.model.User;

/**
 * Created by Administrator on 2017/4/24.
 */
public interface UserService {
    public User  getUserById(int id);
    public  User   getUserByName(String name);
    public  int  addUser(User  user);
    public int  updateUserPwdByName(User user);
}
