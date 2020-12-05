import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> maleNames = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> femaleNames = Arrays.asList("Susan", "Mary", "Vanda", "Nikita", "Elena", "Linda");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            Sex sex = Sex.values()[new Random().nextInt(Sex.values().length)];
            String name = (sex == Sex.MAN)
                    ? maleNames.get(new Random().nextInt(maleNames.size()))
                    : femaleNames.get(new Random().nextInt(femaleNames.size()));

            persons.add(new Person(
                    name,
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    sex,
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        Stream<Person> personsStream = persons.stream();
        long underageCount = personsStream
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println(String.format("Количество несовершеннолетних: %d человек", underageCount));

        personsStream = persons.stream();
        List<String> inductees = personsStream
                .filter(person -> person.getSex() == Sex.MAN
                        && person.getAge() >= 18
                        && person.getAge() < 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(String.format("Количество призывников: %d человек", inductees.size()));

        personsStream = persons.stream();
        List<Person> workingAgePopulation = personsStream
                .filter(person -> person.getEducation() == Education.HIGHER
                        && person.getAge() >= 18
                        && ((person.getSex() == Sex.MAN && person.getAge() < 65)
                            || (person.getSex() == Sex.WOMEN && person.getAge() < 60)))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(String.format("Количество трудоспособного населения с ВО: %d человек", workingAgePopulation.size()));

    }

}
