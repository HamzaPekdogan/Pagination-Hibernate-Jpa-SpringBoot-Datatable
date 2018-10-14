package medya.soft.com.Repository;

import medya.soft.com.EntityModel.StudentInClassEntityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class StudentInClassCriteriaRepository { //pagination işlemi
    @Autowired
    private EntityManager em;

    public List<StudentInClassEntityModel> findAllCriteria(int start, int length, String search) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<StudentInClassEntityModel> cq = cb.createQuery(StudentInClassEntityModel.class);
        Root<StudentInClassEntityModel> from = cq.from(StudentInClassEntityModel.class);
        CriteriaQuery<StudentInClassEntityModel> selectQuery = cq.select(from);
        TypedQuery<StudentInClassEntityModel> query = em.createQuery(selectQuery).setFirstResult(start).setMaxResults(length);
        return query.getResultList();
    }
}
