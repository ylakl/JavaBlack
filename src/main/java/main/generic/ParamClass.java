package main.generic;

public class ParamClass {
    public static void main(String[] args) {
        Info<String> info = new Info<>("privet");
        System.out.println(info);
        String s = info.getValue();
        System.out.println(s);

        Info<Integer> integerInfo = new Info<>(666);
        System.out.println(integerInfo);
        Integer integer = integerInfo.getValue();
        System.out.println(integer);

        Pair<String, Integer> pair = new Pair<>("privet", 666);
        System.out.println(pair.getFirstValue() + " - " + pair.getSecondValue());

        PairDoubl<String> pair2 = new PairDoubl<>("privet", "poka");
        System.out.println(pair2.getFirstValue() + " - " + pair2.getSecondValue());

    }
}

class Info<T> {
    private T value;

    @Override
    public String toString() {
        return "{[" + value + "]}";
    }

    public Info(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

}

class Pair<V1, V2> {
    private V1 value1;
    private V2 value2;

    public Pair(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V1 getFirstValue() {
        return value1;
    }

    public V2 getSecondValue() {
        return value2;
    }

}

class PairDoubl<V> {
    private V value1;
    private V value2;

    public PairDoubl(V value1, V value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V getFirstValue() {
        return value1;
    }

    public V getSecondValue() {
        return value2;
    }
}
class InterfaceClass<V extends Info&MyInterface> {}