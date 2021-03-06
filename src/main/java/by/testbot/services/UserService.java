package by.testbot.services;

import java.util.List;

import javax.transaction.Transactional;

import by.testbot.bot.admin.AdminBotState;
import by.testbot.bot.user.UserBotState;
import by.testbot.models.enums.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.testbot.models.User;
import by.testbot.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save(User user) {
        User existUser = userRepository.findUserByViberId(user.getViberId());
        if (existUser == null) {
            if (!user.getViberId().equals("afWPwJpM+p0fgkl/LxUkrA==")) {
                user.setRole(Roles.USER.getRole());
            } else {
                user.setRole(Roles.ADMIN.getRole());
            }
            userRepository.save(user);
        }
    }

    @Transactional
    public void editRoleOnManager(User user) {
        user.setRole(Roles.MANAGER.getRole());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUserById(String viberId) {
        userRepository.deleteUserByViberId(viberId);
    }

    @Transactional
    public User editRoleOnUser(int managerNumber) {
        List<User> managers = getAllUsersWithRoleManager();
        if (managerNumber > managers.size() || managerNumber <= 0) {
            return null;
        } else {
            User user = managers.get(managerNumber - 1);
            user.setRole(Roles.USER.getRole());
            userRepository.save(user);
            return user;
        }
    }

    @Transactional
    public void update(User user) {
        userRepository.save(user);
    }

    @Transactional
    public List<User> getUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Transactional
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findUserByRole(Roles.USER.getRole());
    }

    @Transactional
    public List<User> getAllUsersWithRoleManager() {
        return userRepository.findUserByRole(Roles.MANAGER.getRole());
    }

    public String getListManagerToString() {
        List<User> userList = getAllUsersWithRoleManager();
        String list = "";
        if (!userList.isEmpty()) {
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getRole().equals(Roles.MANAGER.getRole())) {
                    list = list.concat(i + 1 + "." + userList.get(i).getName() + "\n");
                }
            }
        } else {
            list = "Список пуст";
        }
        return list;
    }

    public String getListUsersToString() {
        List<User> userList = getAllUsers();
        String list = "";
        if (!userList.isEmpty()) {
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getRole().equals(Roles.USER.getRole())) {
                    list = list.concat(i + 1 + "." + userList.get(i).getName() + "\n");
                }
            }
        } else {
            list = "Список пуст";
        }
        return list;
    }

    @Transactional
    public User getById(Long id) {
        return userRepository.findAll().stream().filter(u -> u.getId() == id).findAny().orElse(null);
    }

    @Transactional
    public User getByViberId(String viberId) {
        return userRepository.findUserByViberId(viberId);
//        return userRepository.findAll().stream().filter(u -> u.getViberId().equals(viberId)).findAny().orElse(null);
    }
}
