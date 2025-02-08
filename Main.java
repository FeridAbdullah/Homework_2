import java.util.Arrays;
import java.util.Random;

class Pet {
    String species;
    String nickname;
    int age;
    int trickLevel; // 1 to 100
    String[] habits;

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    // Methods
    public void eat() {
        System.out.println("I am eating");
    }

    public void respond() {
        System.out.println("Hello, owner. I am " + nickname + ". I miss you!");
    }

    public void foul() {
        System.out.println("I need to cover it up");
    }

    @Override
    public String toString() {
        return species + "{nickname='" + nickname + "', age=" + age + ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) + "}";
    }
}

class Human {
    String name;
    String surname;
    int year;
    int iq;
    Pet pet;
    Human mother;
    Human father;
    String[][] schedule; // 2D array for schedule

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Human father, Human mother) {
        this(name, surname, year);
        this.father = father;
        this.mother = mother;
    }

    public Human(String name, String surname, int year, int iq, Pet pet, Human father, Human mother, String[][] schedule) {
        this(name, surname, year, father, mother);
        this.iq = iq;
        this.pet = pet;
        this.schedule = schedule;
    }

    // Methods
    public void greetPet() {
        System.out.println("Hello, " + pet.nickname);
    }

    public void describePet() {
        String slyness = pet.trickLevel > 50 ? "very sly" : "almost not sly";
        System.out.println("I have a " + pet.species + ", it is " + pet.age + " years old, it is " + slyness);
    }

    public void feedPet(boolean timeToFeed) {
        if (timeToFeed) {
            System.out.println("Hm... I will feed " + name + "'s " + pet.species);
        } else {
            Random random = new Random();
            int chance = random.nextInt(101);
            if (pet.trickLevel > chance) {
                System.out.println("Hm... I will feed " + name + "'s " + pet.species);
            } else {
                System.out.println("I think " + name + "'s " + pet.species + " is not hungry.");
            }
        }
    }

    @Override
    public String toString() {
        return "Human{name='" + name + "', surname='" + surname + "', year=" + year + ", iq=" + iq +
                ", mother=" + (mother != null ? mother.name + " " + mother.surname : "Unknown") +
                ", father=" + (father != null ? father.name + " " + father.surname : "Unknown") +
                ", pet=" + pet + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a pet
        Pet dog = new Pet("dog", "Rock", 5, 75, new String[]{"eat", "drink", "sleep"});

        // Create parents
        Human mother = new Human("Jane", "Karleone", 1955);
        Human father = new Human("Vito", "Karleone", 1950);

        // Define a schedule (2D array)
        String[][] schedule = {
                {"Monday", "Go to the gym"},
                {"Tuesday", "Work on the project"},
                {"Wednesday", "Meet friends"},
                {"Thursday", "Watch a movie"},
                {"Friday", "Go shopping"},
                {"Saturday", "Relax"},
                {"Sunday", "Family dinner"}
        };

        // Create a child
        Human child = new Human("Michael", "Karleone", 1977, 90, dog, father, mother, schedule);

        // Display all details
        System.out.println(child);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(dog);

        // Call available methods
        child.greetPet();
        child.describePet();
        dog.eat();
        dog.respond();
        dog.foul();

        // Try feeding the pet
        child.feedPet(false);
    }
}