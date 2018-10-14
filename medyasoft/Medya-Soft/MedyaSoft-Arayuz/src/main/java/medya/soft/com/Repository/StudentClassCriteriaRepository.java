package medya.soft.com.Repository;

import medya.soft.com.EntityModel.StudentClassEntityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class StudentClassCriteriaRepository { //pagination işlemi
    @Autowired
    private EntityManager em;

    public List<StudentClassEntityModel> findAllCriteria(int start, int length, String search) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<StudentClassEntityModel> cq = cb.createQuery(StudentClassEntityModel.class);
        Root<StudentClassEntityModel> from = cq.from(StudentClassEntityModel.class);
        CriteriaQuery<StudentClassEntityModel> selectQuery = cq.select(from);
        TypedQuery<StudentClassEntityModel> query = em.createQuery(selectQuery).setFirstResult(start).setMaxResults(length);
        return query.getResultList();
    }
}
