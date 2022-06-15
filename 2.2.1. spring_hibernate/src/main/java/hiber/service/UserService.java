package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void addCar(Car car);
    List<User> listUsers();
    List<Car> listCars();
    void setCarsForUsers(List<User> users,List<Car> cars);
    List<User> getUserCar(String series, int model);
}
