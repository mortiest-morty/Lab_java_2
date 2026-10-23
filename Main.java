import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


// ======================== Время - задание 1.4 ========================
class Time{
    private int seconds;

    Time(){
        this.seconds = 0;
    }
    Time(int x){
        this.seconds = x;
    }

    void setTime(int x){
        this.seconds = x;
    }

    int getTime(){
        return this.seconds;
    }

    public String toString(){
        if (this.seconds > 86400) this.seconds = getTime() - 86400;
        String hour = Integer.toString(this.seconds/3600);
        String minute = Integer.toString((this.seconds%3600)/60);
        String second = Integer.toString(this.seconds%60);

        String result = hour + ":" + minute + ":" + second;

        return result;
    }

    void show(){
        System.out.println(toString());
    }
}

// ======================== Дом - задание 1.5 ========================
class Home{
    private int floor;

    Home(){
        this.floor = 0;
    }
    Home(int x){
        this.floor = x;
    }

    void setFloors(int x){
        this.floor = x;
    }

    int getFloors(){
        return this.floor;
    }

    public String toString(){
        String result = "Дом с " + Integer.toString(this.floor);
        if (this.floor % 10 == 1 && this.floor % 100 != 11){
            result += " этажом ";
        }
        else{
            result += " этажами ";
        }
        return result;
    }

    void show(){
        System.out.println(toString());
    }
}

// ======================== Сотрудники и отделы - задание 2.4 ========================
class Employee24{
    private String name;
    private Department24 department;   

    Employee24(){
        this.name = "";
        this.department = null;
    }
    Employee24(String Name){
        this.name = Name;
        this.department = null;
    }

    void setName(String Name) {this.name = Name;}

    String getName(){
        return this.name;
    }
    Department24 getDepartment(){
        return this.department;
    }

    // связь устанавливается только через Department24.addEmployee
    void setDepartment(Department24 d) {
        this.department = d;
    }

    public String toString(){
        if (department == null) {
            return name + " (без отдела)";
        }
        if (department.getBoss() == this) {
            return name + " начальник отдела " + department.getName();
        }
        return name + " работает в отделе " + department.getName()
                + " ,начальник которого " + department.getBoss().getName();
    }

    void show(){
        System.out.println(toString());
    }
}

class Department24{
    private String name;
    private List<Employee24> employees;
    private Employee24 boss;   // начальник — тоже сотрудник

    Department24(String name){
        this.name = name;
        this.employees = new ArrayList<>();
        this.boss = null;
    }

    void addEmployee(Employee24 e) {
        if (!employees.contains(e)) {
            employees.add(e);
            e.setDepartment(this);
        }
    }

    void setBoss(Employee24 boss) {
        this.boss = boss;
        addEmployee(boss);
    }

    String getName() { return name; }
    Employee24 getBoss() { return boss; }

    List<Employee24> getEmployees() {
        return new ArrayList<>(employees);
    }

    public String toString() { return name; }
}

// ======================== Сотрудники и отделы - задание 3.4 ========================
class Employee34{
    private String name;
    private Department34 department;

    Employee34(){
        this.name = "";
        this.department = null;
    }
    Employee34(String Name){
        this.name = Name;
        this.department = null;
    }

    void setName(String Name) {this.name = Name;}

    String getName(){
        return this.name;
    }
    Department34 getDepartment(){
        return this.department;
    }

    void setDepartment(Department34 d) {
        this.department = d;
    }

    // ключевой метод для задания 3.4 
    // имея ссылку на сотрудника, получаем список всех сотрудников его отдела
    List<Employee34> getColleagues() {
        if (department == null) return new ArrayList<>();
        return department.getEmployees();
    }

    public String toString(){
        if (department == null) {
            return name + " (без отдела)";
        }
        if (department.getBoss() == this) {
            return name + " начальник отдела " + department.getName();
        }
        return name + " работает в отделе " + department.getName()
                + ", начальник которого " + department.getBoss().getName();
    }

    void show(){
        System.out.println(toString());
    }
}

class Department34{
    private String name;
    private List<Employee34> employees;
    private Employee34 boss;

    Department34(String name){
        this.name = name;
        this.employees = new ArrayList<>();
        this.boss = null;
    }

    void addEmployee(Employee34 e) {
        if (!employees.contains(e)) {
            employees.add(e);
            e.setDepartment(this);
        }
    }

    void setBoss(Employee34 boss) {
        this.boss = boss;
        addEmployee(boss);
    }

    String getName() { return name; }
    Employee34 getBoss() { return boss; }

    List<Employee34> getEmployees() {
        return new ArrayList<>(employees);
    }

    public String toString() { return name; }
}

// ======================== Дом - задание 4.3 ========================
class Home4{
    private final int floor;   // нельзя изменить после создания

    Home4(){
        this.floor = 0;
    }

    Home4(int x){
       this.floor = x;
    }

    int getFloors(){
        return this.floor;
    }

    public String toString(){
        String result = "Дом с " + this.floor;
        if (this.floor % 10 == 1 && this.floor % 100 != 11){
            result += " этажом ";
        }
        else{
            result += " этажами ";
        }
        return result;
    }

    void show(){
        System.out.println(toString());
    }
}



// ======================== Пистолет - задание 5.1 ========================
class Gun{
    private int cartridges;

    Gun(){
        this.cartridges = 5;
    }
    Gun(int x){
        this.cartridges = x;
    }

    void setCartridges(int x) {this.cartridges = x;}

    int getCartridges(){
        return this.cartridges;
    }

    public String toString(){
        if (this.cartridges == 0){
            return "\nКлац!";
        }
        else{
            this.cartridges -= 1;
            return "\nБах!";
        }
    }

    void show(){
        System.out.println(toString());
    }
}


// ======================== MAIN ========================
public class Main{

    private final Scanner scanner;

    Main(){
        this.scanner = new Scanner(System.in, "Cp866");
    }

    // =================== ввод ===================
    int readInt2() {
        while (true) {
            String input = scanner.nextLine().strip();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число!");
            }
        }
    }

    int readInt() {
        while (true) {
            System.out.print("Введите цифру: ");
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } else {
                System.out.println("Ошибка! Это не число.");
                scanner.nextLine();
            }
        }
    }

    int readIntInRange(int min, int max) {
        while (true) {
            int x = readInt();
            if (x >= min && x <= max) {
                return x;
            }
            System.out.println("Ошибка! Требуется число от " + min + " до " + max);
        }
    }

    boolean isValidName(String str) {
        if (str == null || str.isBlank()) {
            System.out.println("Ошибка! Имя не может быть пустым!");
            return false;
        }
        if (!str.matches("^[\\p{L}\\s]+$")) {
            System.out.println("Ошибка! Имя или название не может содержать цифры, символы!");
            return false;
        }
        return true;
    }

    // =================== меню 3: сотрудники и отделы - задание 2.4 ===================
    void menu3(){
        System.out.print("Введите количество сотрудников: ");
        int n = readInt2();
        while (n <= 0){
            System.out.println("Ошибка! Попробуйте снова!!!");
            System.out.print("Введите число: ");
            n = readInt2();
        }

        Map<String, Department24> departments = new LinkedHashMap<>();
        List<Employee24> employees = new ArrayList<>();

        for(int i = 0; i < n; i++){
            Employee24 employee = new Employee24();

            System.out.print("\nВведите имя сотрудника: ");
            String Name = scanner.nextLine().strip();
            while (Name.isEmpty() || !isValidName(Name)) {
                System.out.print("Введите имя сотрудника снова: ");
                Name = scanner.nextLine().strip();
            }
            employee.setName(Name);

            System.out.print("Введите название отдела сотрудника: ");
            String Department = scanner.nextLine().strip();
            while (Department.isEmpty() || !isValidName(Department)) {
                System.out.print("Введите название отдела снова: ");
                Department = scanner.nextLine().strip();
            }

            // получаем или создаём отдел
            Department24 dep = departments.get(Department);
            if (dep == null) {
                dep = new Department24(Department);
                departments.put(Department, dep);
            }
            dep.addEmployee(employee);

            employees.add(employee);
        }

        // выбор отдела и начальника
        List<Department24> depList = new ArrayList<>(departments.values());

        System.out.println("\nВыберите отдел, для которого хотите выбрать начальника: ");
        for (int i = 0; i < depList.size(); i++){
            System.out.println((i + 1) + " - " + depList.get(i).getName());
        }
        int choice1 = readIntInRange(1, depList.size());
        Department24 chosenDep = depList.get(choice1 - 1);

        System.out.println("\nВыберите начальника для данного отдела: ");
        List<Employee24> depEmployees = chosenDep.getEmployees();
        for (int i = 0; i < depEmployees.size(); i++){
            System.out.println((i + 1) + " - " + depEmployees.get(i).getName());
        }

        System.out.print("Введите имя сотрудника: ");
        String BossName = scanner.nextLine().strip();

        boolean isCorrectBoss = false;
        while (!isCorrectBoss) {
            if (!isValidName(BossName)) {
                System.out.print("Введите имя сотрудника снова: ");
                BossName = scanner.nextLine().strip();
                continue;
            }
            boolean found = false;
            for (Employee24 e : depEmployees){
                if (e.getName().equals(BossName)){
                    found = true;
                    break;
                }
            }
            if (found) {
                isCorrectBoss = true;
            } else {
                System.out.print("Сотрудник с таким именем не найден в отделе " + chosenDep.getName() + ".\nВведите снова: ");
                BossName = scanner.nextLine().strip();
            }
        }

        // ставим начальника
        Employee24 bossEmp = null;
        for (Employee24 e : depEmployees){
            if (e.getName().equals(BossName)) { bossEmp = e; break; }
        }
        chosenDep.setBoss(bossEmp);

        // вывод
        System.out.print("\n==== Доступные отделы для вывода ====\n");
        for (int i = 0; i < depList.size(); i++){
            System.out.println((i + 1) + " - " + depList.get(i).getName());
        }
        System.out.print("Введите число: ");
        int choice2 = readInt2();
        while (choice2 <= 0 || choice2 > depList.size()){
            System.out.println("Ошибка! Попробуйте снова!!!");
            System.out.print("Введите число: ");
            choice2 = readInt2();
        }
        Department24 showDep = depList.get(choice2 - 1);

        System.out.print("\n==== Все сотрудники данного отдела ====\n");
        for (Employee24 e : showDep.getEmployees()){
            System.out.println(e);
        }
    }

    // =================== меню 6: сотрудники и отделы - задание 3.4 ===================
    void menu6(){
        System.out.print("Введите количество сотрудников: ");
        int n = readInt2();
        while (n <= 0){
            System.out.println("Ошибка! Попробуйте снова!!!");
            System.out.print("Введите число: ");
            n = readInt2();
        }

        Map<String, Department34> departments = new LinkedHashMap<>();
        List<Employee34> employees = new ArrayList<>();

        for(int i = 0; i < n; i++){
            Employee34 employee = new Employee34();

            System.out.print("\nВведите имя сотрудника: ");
            String Name = scanner.nextLine().strip();
            while (Name.isEmpty() || !isValidName(Name)) {
                System.out.print("Введите имя сотрудника снова: ");
                Name = scanner.nextLine().strip();
            }
            employee.setName(Name);

            System.out.print("Введите название отдела сотрудника: ");
            String Department = scanner.nextLine().strip();
            while (Department.isEmpty() || !isValidName(Department)) {
                System.out.print("Введите название отдела снова: ");
                Department = scanner.nextLine().strip();
            }

            Department34 dep = departments.get(Department);
            if (dep == null) {
                dep = new Department34(Department);
                departments.put(Department, dep);
            }
            dep.addEmployee(employee);

            employees.add(employee);
        }

        // назначаем начальников для всех отделов по очереди
        List<Department34> depList = new ArrayList<>(departments.values());

        for (Department34 dep : depList) {
            System.out.println("\nВыберите начальника для отдела " + dep.getName() + ":");
            List<Employee34> depEmployees = dep.getEmployees();
            for (int i = 0; i < depEmployees.size(); i++){
                System.out.println((i + 1) + " - " + depEmployees.get(i).getName());
            }

            System.out.print("Введите имя сотрудника: ");
            String BossName = scanner.nextLine().strip();

            boolean isCorrectBoss = false;
            while (!isCorrectBoss) {
                if (!isValidName(BossName)) {
                    System.out.print("Введите имя сотрудника снова: ");
                    BossName = scanner.nextLine().strip();
                    continue;
                }
                boolean found = false;
                for (Employee34 e : depEmployees){
                    if (e.getName().equals(BossName)){
                        found = true;
                        break;
                    }
                }
                if (found) {
                    isCorrectBoss = true;
                } else {
                    System.out.print("Сотрудник с таким именем не найден в отделе " + dep.getName() + ".\nВведите снова: ");
                    BossName = scanner.nextLine().strip();
                }
            }

            Employee34 bossEmp = null;
            for (Employee34 e : depEmployees){
                if (e.getName().equals(BossName)) { bossEmp = e; break; }
            }
            dep.setBoss(bossEmp);
        }

        // выбираем сотрудника и выводим всех сотрудников его отдела
        System.out.println("\n==== Выберите сотрудника, чтобы увидеть всех сотрудников его отдела ====");
        for (int i = 0; i < employees.size(); i++){
            System.out.println((i + 1) + " - " + employees.get(i).getName());
        }

        int choice = readIntInRange(1, employees.size());
        Employee34 chosen = employees.get(choice - 1);

        // вывод как в задании 2.4: через toString() — имя, отдел, начальник
        System.out.println("\n==== Все сотрудники отдела " + chosen.getDepartment().getName() + " ====");
        for (Employee34 e : chosen.getColleagues()){
            System.out.println(e);
        }
    }

    // =================== меню 4: дом - задание 4.3 ===================
    void menu4(){
        System.out.print("Введите количество этажей: ");
        int floor = readInt2();
        while (floor < 0 ){
            System.out.println("Ошибка! Введите число больше 0!");
            System.out.print("Введите количество этажей: ");
            floor = readInt2();
        }

        Home4 home = new Home4(floor);
        home.show();
    }

    // =================== меню 5: пистолет - задание 5.1 ===================
    void menu5(){
        System.out.println("1 - создать пистолет с 5 патронами (по умолчанию)");
        System.out.println("2 - создать пистолет с заданным числом патронов");
        int mode = readIntInRange(1, 2);

        Gun gun;
        if (mode == 1){
            gun = new Gun();
        } else {
            System.out.print("Введите начальное количество патронов: ");
            int c = readInt2();
            while (c < 0){
                System.out.println("Ошибка! Патронов не может быть меньше 0!");
                System.out.print("Введите количество патронов: ");
                c = readInt2();
            }
            gun = new Gun(c);
        }

        System.out.println("Сколько раз выстрелить?");
        int shots = readInt2();
        while (shots < 0){
            System.out.println("Ошибка! Введите число >= 0!");
            System.out.print("Введите число: ");
            shots = readInt2();
        }

        for (int i = 0; i < shots; i++){
            gun.show();
        }
        System.out.println("\nОстаток патронов: " + gun.getCartridges());
    }

    // ======================== главное меню ========================
    void printMainMenu() {
        System.out.println("(^-^)");
        System.out.println("Выберите задание:\n"
                + " 1 - класс время\n"
                + " 2 - класс дом\n"
                + " 3 - класс Сотрудники и отделы (задание 2.4)\n"
                + " 4 - Сотрудники и отделы (задание 3.4)\n"
                + " 5 - класс дом (задание 4.3)\n"
                + " 6 - пистолет\n"
                + " 0 - выход");
    }

    void run(){
        while (true) {
            printMainMenu();
            int answ = readIntInRange(0, 6);

            if (answ == 0) {
                System.out.println("\nх-х bye~!");
                System.out.println("\n   /\\_/\\  ");
                System.out.println("  ( o.o ) ");
                break;
            }

            if (answ == 1){
                System.out.print("Введите время в секундах: ");
                int sec = readInt2();
                while (sec < 0 ){
                    System.out.println("Ошибка! Введите число больше 0!");
                    System.out.print("Введите время в секундах: ");
                    sec = readInt2();
                }
                Time clock = new Time(sec);
                clock.show();
            }
            else if (answ == 2){
                System.out.print("Введите ко-во этажей в доме: ");
                int floor = readInt2();
                while (floor < 0 ){
                    System.out.println("Ошибка! Введите число больше 0!");
                    System.out.print("Введите ко-во этажей в доме: ");
                    floor = readInt2();
                }
                Home DrHouse = new Home(floor);
                DrHouse.show();
            }
            else if (answ == 3){
                menu3();
            }
            else if (answ == 4){
                menu6();
            }
            else if (answ == 5){
                menu4();
            }
            else if (answ == 6){
                menu5();
            }
        }
    }

    // единственный статический метод — точка входа
    public static void main(String[] args) {
        new Main().run();
    }
}
