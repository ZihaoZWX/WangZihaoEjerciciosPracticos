
package ejercicio2jas2d1;

import ejercicio2jas2d1.models.Events;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Zihao Wang
 */
public class Main {

    public static void main(String[] args) {
        List<Events>events=new ArrayList<>();
        events.add(new Events("new year",LocalDate.of(2024,12,31),"meeting"));
        events.add(new Events("Ballon d'Or",LocalDate.of(2023,10,30),"global"));
        events.add(new Events("World cup final",LocalDate.of(2022,12,18),"universal"));
        events.add(new Events("Laureus",LocalDate.of(2023,5,8),"global"));
        events.add(new Events("Hallowen",LocalDate.of(2024,10,31),"meeting"));
        events.stream().filter(event->event.getDate().equals(LocalDate.of(2022,12,18))).forEach(goat->System.out.println("This was the gratest day of the History of our Universe "+goat.toString()+", when sir Lionel Andres Messi Cuccittini humiliated entire France with his incomparable football"));
        
        events.stream().collect(Collectors.groupingBy(Events::getCategory)).forEach((event,eventCategory) -> {
            System.out.println(event);
            eventCategory.forEach(data->System.out.println(data));
        });
        Optional<Events>closestEvent=events.stream().min(Comparator.comparing(event->Math.abs(ChronoUnit.DAYS.between(LocalDate.now(), event.getDate()))));
        closestEvent.ifPresent(event->System.out.println("The closest event is \n"+event));
    }
    
}
