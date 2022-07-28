package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    //싱글톤이라서 static 안써도됨 1개만 생성 보장
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequens = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    //싱글톤 만들때는 생성자만들어서 아무나 생성하지 못하게 막아야됨
    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequens);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
