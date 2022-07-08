package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;

//    @PersistenceUnit
//    private EntityManagerFactory emf;

    // member를 저장하는 메서드(save)
    public void save(Member member) {
        em.persist(member);
    }

    // 원하는 member의 id를 기반으로 조회하는 메서드
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    // member list를 뽑는 메서드
    public List<Member> findAll() {
        List<Member> memberList = em.createQuery("select m from Member m", Member.class).getResultList();
        return memberList;
    }

    // 이름을 기준으로 member 찾기.
    public List<Member> findByName(String name) {
        List<Member> findMembeyByName = em.createQuery("select m from Member m where m.name = :username", Member.class)
                .setParameter("username", name)
                .getResultList();
        return findMembeyByName;
    }
}