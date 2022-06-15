package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional
   @Override
   public void addCar(Car car) {
      userDao.addCar(car);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional(readOnly = true)
   @Override
   public List<Car> listCars() {
      return userDao.listCars();
   }

   @Transactional
   @Override
   public void setCarsForUsers(List<User> users, List<Car> cars) {
      for (int i = 0; i < users.size(); i++) {
         users.get(i).setCar(cars.get(i));
         addCar(cars.get(i));
      }
   }

   @Transactional
   @Override
   public List<User> getUserCar(String model, int series) {
      return userDao.getUserCar(model, series);
   }

}
