package lec10.java;

public interface JavaFlyable {

    default void act() {
        System.out.println("파닥 파닥");
    }

}
