package obj;

public class Cell implements Comparable<Cell> {
    private String name;
    private int age;

    public Cell() {
    }

    public Cell(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public Cell clone() throws CloneNotSupportedException {
        return (Cell) super.clone();
    }

    @Override
    public int compareTo(Cell o) {
        return this.age - o.age;
    }
}
