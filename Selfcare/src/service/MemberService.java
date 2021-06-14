package service;

import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import domain.Member;
import persistence.MemberRepository;

public class MemberService {
	private final MemberRepository memberRepository = MemberRepository.getInstance();
	public MemberService() {}
	public void signUp(Member member) {
		memberRepository.save(member);
	}
	public boolean logIn(Member member) {
		return memberRepository.logIn(member);
	}
}
