package aquaGroup.dao;

import aquaGroup.model.Fish;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FishDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;

    public List<Fish> getFishs() {
        return entityManager.createQuery("SELECT f FROM Fish f", Fish.class).getResultList();
    }

    public Fish getFishById(Long id) {
        return entityManager.createQuery("SELECT f FROM Fish f WHERE f.id = :id", Fish.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public boolean addFish(Fish fish) {
        try {
            userTransaction.begin();
            entityManager.persist(fish);
            userTransaction.commit();
            return true;
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }

    public boolean updateFishMember(Fish fishMember) {
        try {
            userTransaction.begin();
            if (fishMember != null) {
                entityManager.merge(fishMember);
            }
            userTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }

    public boolean deleteFishById(Long id) {
        try {
            userTransaction.begin();
            var result = entityManager.createQuery("SELECT f FROM Fish f WHERE f.id = :id", Fish.class)
                    .setParameter("id", id)
                    .getSingleResult();
            if (result != null) {
                entityManager.remove(result);
            }
            userTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }

    }
}
