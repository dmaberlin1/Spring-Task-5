package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
//во всех по дефолту  будет  рид онли, в нужных изменить в ручную на false
public class CarRepository implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }



    @Override
    public List<Car> listCars() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }
}
