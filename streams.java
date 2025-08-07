import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Employee1{
    Integer id;
    String name,job;
    Boolean status;

    @Override
    public String toString() {
        return "Employee1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", status=" + status +
                '}';
    }

    public Employee1(Integer id, String name, String job, Boolean status){
        this.id=id;
        this.name=name;
        this.job=job;
        this.status=status;
    }
}
class Date implements Comparable<Date>{
    LocalDate date;
    public Date(LocalDate date){
        this.date=date;
    }
    @Override
    public int compareTo(Date o) {
        return this.date.compareTo(o.date);
    }
}
public class Employeeattendance {
    public static void main(String[] args) {
        local();
    }
       static   Random random = new Random();
       static   Boolean status[] = {true, false, false, true, true, false, true};
       static   Map<Date, Employee1> map = new HashMap<>();

    static void local() {
        LocalDate date = LocalDate.now();
        for (int i = 0; i < 7; i++) {
            map.put(new Date(date.plusDays(i)), new Employee1(101, "Abi", "it", random.nextBoolean()));
            map.put(new Date(date.plusDays(i)), new Employee1(102, "Banu", "it", random.nextBoolean()));
            map.put(new Date(date.plusDays(i)), new Employee1(103, "Saindhu", "it", random.nextBoolean()));
        }
        System.out.println(101 + "\t id:\t" + map.entrySet().stream().filter(a -> a.getValue().id == 101 && a.getValue().status).count() * 10000);
        System.out.println(102 + "\t id:\t" + map.entrySet().stream().filter(a -> a.getValue().id == 102 && a.getValue().status).count() * 10000);
        System.out.println(103 + "\t id:\t" + map.entrySet().stream().filter(a -> a.getValue().id == 103 && a.getValue().status).count() * 10000);
    for(Map.Entry<Date,Employee1> v:map.entrySet())
    {
        System.out.println("Name : \t"+v.getValue().name+" \t id :\t"+v.getValue().id+"\t status :\t"+v.getValue().status);
    }
    }
}