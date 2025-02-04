package main.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerEx {
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        List<Action> fr1Actions = new ArrayList<>();
        fr1Actions.add(Action.BUMAGA);
        fr1Actions.add(Action.KAMEN);
        fr1Actions.add(Action.NOJNICI);
        List<Action> fr2Actions = new ArrayList<>();
        fr2Actions.add(Action.NOJNICI);
        fr2Actions.add(Action.BUMAGA);
        fr2Actions.add(Action.BUMAGA);
        new BestFriends("Миша",fr1Actions,exchanger);
        new BestFriends("Петя",fr2Actions,exchanger);
    }
}

enum Action {
    KAMEN, NOJNICI, BUMAGA
}

class BestFriends extends Thread {
    String name;
    private List<Action> actions;
    private Exchanger exchanger;

    public BestFriends(String name, List<Action> actions, Exchanger exchanger) {
        this.name = name;
        this.actions = actions;
        this.exchanger = exchanger;
        this.start();
    }

    private void whoWins(Action myAtion, Action frendAction) {
        if ((myAtion == Action.BUMAGA && frendAction == Action.KAMEN)
                || (myAtion == Action.KAMEN && frendAction == Action.NOJNICI)
                || (myAtion == Action.NOJNICI && frendAction == Action.BUMAGA)) {
            System.out.println(name+" выиграл");
        }
    }

    public void run() {
        Action reply;
        for (Action action : actions) {
            try {
                reply = (Action) exchanger.exchange(action);
                whoWins(action,reply);
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}