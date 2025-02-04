package reactor;

import reactor.core.publisher.Flux;

import static java.time.Duration.ofMillis;

public class ex {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Using flatMap():");
        Flux.range(1, 15)
                .flatMap(item -> Flux.just(item).delayElements(ofMillis(1)))
                .subscribe(x -> System.out.print(x + " "));

        Thread.sleep(100);

        System.out.println("\n\nUsing concatMap():");
        Flux.range(1, 15)
                .concatMap(item -> Flux.just(item).delayElements(ofMillis(1)))
                .subscribe(x -> System.out.print(x + " "));

        Thread.sleep(100);
        System.out.println("\n\nUsing switchMap():");
        Flux.range(1, 15)
                .switchMap(item -> Flux.just(item).delayElements(ofMillis(1)))
                .subscribe(x -> System.out.print(x + " "));

        Thread.sleep(100);
    }
}
