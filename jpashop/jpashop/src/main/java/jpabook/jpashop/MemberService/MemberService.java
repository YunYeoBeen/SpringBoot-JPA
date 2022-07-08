package jpabook.jpashop.MemberService;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional(readOnly = false)
    public Long join(Member member){
        // 중복회원을 검증하는 로직
       validateDuplicateMember(member);
       memberRepository.save(member);
       return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        List<Member> findMember = memberRepository.findByName(member.getName());
        if(!findMember.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findMembers(){
        List<Member> findAll = memberRepository.findAll();
        return findAll;
    }

    // 회원 한명 조회
    public Member findMember(Long memberId){
        Member findOne = memberRepository.findOne(memberId);
        return findOne;
    }



}
