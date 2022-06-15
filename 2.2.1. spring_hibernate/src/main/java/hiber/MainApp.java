package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      List<Car> cars = new ArrayList<>();
      cars.add(new Car("LADA", 2106));
      cars.add(new Car("Porsche", 911));
      cars.add(new Car("BMW", 7));
      cars.add(new Car("Toyota", 4));

      List<User> users = userService.listUsers();
      userService.setCarsForUsers(users,cars);

      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      List<User> usersCars1 = userService.getUserCar("LADA", 2106);
      for (User userCar : usersCars1) {
         System.out.println("Id = " + userCar.getId());
         System.out.println("First Name = " + userCar.getFirstName());
         System.out.println("Last Name = " + userCar.getLastName());
         System.out.println("Email = " + userCar.getEmail());
         System.out.println("Car = " + userCar.getCar());
         System.out.println();
      }

      List<User> usersCars2 = userService.getUserCar("BMW", 7);
      for (User userCar : usersCars2) {
         System.out.println("Id = " + userCar.getId());
         System.out.println("First Name = " + userCar.getFirstName());
         System.out.println("Last Name = " + userCar.getLastName());
         System.out.println("Email = " + userCar.getEmail());
         System.out.println("Car = " + userCar.getCar());
         System.out.println();
      }

      context.close();
   }
}
