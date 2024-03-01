package hello.core.singleton;

public class SingletonService {

    // 싱글톤 패턴을 구현하는 방법 중 하나임

    // 딱 1개의 인스턴스만 생성
    private static final SingletonService instance = new SingletonService();

    // public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 함
    public static SingletonService getInstance() {
        return instance;
    }

    // 다른 곳에서 singeltonService를 못만들게 private 사용
    private SingletonService() {
    }

    public static void main(String[] args) {
//        SingletonService singletonService1 = new SingletonService();
//        SingletonService singletonService2 = new SingletonService();

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
