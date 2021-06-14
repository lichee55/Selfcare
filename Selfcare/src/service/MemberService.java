package service;

import persistence.MemberRepository;

public class MemberService {
	private final MemberRepository memberRepository = MemberRepository.getInstance();
	public MemberService() {}
	
}
