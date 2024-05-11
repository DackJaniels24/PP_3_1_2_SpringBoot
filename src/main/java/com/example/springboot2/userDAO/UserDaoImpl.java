package com.example.springboot2.userDAO;

import com.example.springboot2.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
@PersistenceContext(unitName = "entityManager")
private EntityManager entityManager;

    @Override
    public List<User> index(){
        return entityManager.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public User show(int id) {
        TypedQuery<User> q = entityManager.createQuery("select u from User u where u.id=:id", User.class);
        q.setParameter("id", id);
         return q.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void remove(int id) {
        entityManager.remove(show(id));
    }

    @Override
    public void update(int id, User user) {
        entityManager.merge(user);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
}
