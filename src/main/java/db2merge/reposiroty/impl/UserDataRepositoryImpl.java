package db2merge.reposiroty.impl;

import java.util.List;

import db2merge.dto.UserData;
import db2merge.reposiroty.UserDataRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataRepositoryImpl implements UserDataRepository {
    EntityManagerFactory emf;

    @Autowired
    public UserDataRepositoryImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<UserData> findAll() {
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("""
            SELECT
                usr."id",
                usr."name",
                ct."phone",
                ct."email",
                ct."address"
            FROM
                "data"."user" AS usr
            LEFT JOIN
                "data"."contacts" AS ct
            ON
            ct."id" = usr."id"
        """);

        List<UserData> list = query.getResultList();
        em.close();

        return list;
    }
}
