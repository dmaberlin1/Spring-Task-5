package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private SessionFactory sessionFactory;

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public List<User> getUserByCarModelAndSeries(String carModel, int carSeries) {
      String hql = "from User u where u.car.model = :carModel and u.car.series = :carSeries";
      Query query =sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter("carModel",carModel);
      query.setParameter("carSeries",carSeries);
      return query.list();
   }



}
