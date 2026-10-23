import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


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
class Employee{
    private String name;
	private String department;
	private String boss;

    Employee(){
        this.name = "";
		this.department = "";
		this.boss = "";
    }
    Employee(String Name, String Department, String Boss){
		this.name = Name;
        this.department = Department;
		this.boss = Boss;
    }

    void setName(String Name) {this.name = Name;}
	void setDepartment(String Department) {this.department = Department;}
	void setBoss(String Boss) {this.boss = Boss;}

    String getName(){
        return this.name;
    }
	String getDepartment(){
		return this.department;
	}
	String getBoss(){
		return this.boss;
	}

    public String toString(){
		String result;
		if (this.name.equals(this.boss)){
			result = this.name + " начальник отдела " + this.department;
		}
		else{
			result = this.name + " работает в отделе " + this.department + " ,начальник которого " + this.boss;
		}
		return result;
    }

    void show(){
        System.out.println(toString());
    }
}

// ======================== Сотрудники и отделы - задание 3.4 ========================




// ======================== Дом - задание 4.3 ========================
class Home4{
    private final int floor; 

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

static int readInt2(Scanner scanner) {
    while (true) {
        String input = scanner.nextLine().trim(); // Считывает всю строку, включая Enter
        
        try {
            return Integer.parseInt(input); // Пытается превратить в число
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Введите целое число!");
        }
    }
}

// Читает целое число с защитой от не-числа
static int readInt(Scanner scanner) {
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

// Читает число в диапазоне [min, max]
static int readIntInRange(Scanner scanner, int min, int max) {
    while (true) {
        int x = readInt(scanner);
        if (x >= min && x <= max) {
            return x;
        }
        System.out.println("Ошибка! Требуется число от " + min + " до " + max);
    }
}


public static boolean isValidName(String str) {
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

// =================== менюшки для классов ===================
static void menu3(Scanner scanner){
    System.out.print("Введите количество сотрудников: ");
    int n = readInt2(scanner);
    while (n <= 0){
        System.out.println("Ошибка! Попробуйте снова!!!");
        System.out.print("Введите число: ");
        n = readInt2(scanner);
    }

    Set<String> setDepart = new LinkedHashSet<>();
    List<Employee> employees = new ArrayList<>();   // было Employee[] arrEmployees

    for(int i = 0; i<n; i++ ){
        Employee employee = new Employee();

        System.out.print("\nВведите имя сотрудника: ");
        String Name = scanner.nextLine().trim();
        
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
        employee.setDepartment(Department);

        setDepart.add(Department);
        employees.add(employee);                    // было arrEmployees[i] = employee;
    }
    String[] arrDepart = setDepart.toArray(new String[0]);

    System.out.println("\nВыберите отдел, для которого хотите выбрать начальника: ");
    for (int i = 0; i < arrDepart.length; i++){
        System.out.println((i + 1) + " - " + arrDepart[i]);
    }

    int choice1 = readIntInRange(scanner, 1, arrDepart.length);
    String Dep = arrDepart[choice1 - 1];

    int printNum = 0;
    System.out.println("\nВыберите начальника для данного отдела: ");
    for (Employee e : employees){
        if (e.getDepartment().equals(Dep)){
            printNum+=1;
            System.out.println(printNum + " - " + e.getName());
        }
    }

    System.out.print("Введите имя сотрудника: ");
    String BossName = scanner.nextLine().trim();

    boolean isCorrectBoss = false;
    while (!isCorrectBoss) {
        if (!isValidName(BossName)) {
            System.out.print("Введите имя сотрудника снова: ");
            BossName = scanner.nextLine().trim();
            continue;
        }

        boolean correctName = false;
        for (Employee e : employees){
            if (e.getName().equals(BossName) && e.getDepartment().equals(Dep)){
                correctName = true;
                break;
            }
        }

        if (correctName) {
            isCorrectBoss = true;
        } else {
            System.out.print("Сотрудник с таким именем не найден в отделе " + Dep + ". Введите снова: ");
            BossName = scanner.nextLine().trim();
        }
    }

    // устанавливаю всем сотрудникам имя руководителя их отдела
    for (Employee e : employees){
        if (e.getDepartment().equals(Dep)){
            e.setBoss(BossName);
        }
    }

    System.out.print("\n==== Доступные отделы для вывода ====\n");
    for (int i = 0; i < arrDepart.length; i++){
        System.out.println((i+1) + " - " + arrDepart[i]);
    }

    System.out.print("Введите число: ");
    int choice2 = readInt2(scanner);
    while (choice2 <= 0 || choice2 > arrDepart.length){
        System.out.println("Ошибка! Попробуйте снова!!!");
        System.out.print("Введите число: ");
        choice2 = readInt2(scanner);
    }

    System.out.print("\n==== Все сотрудники данного отдела ====\n");
    for (Employee e : employees){
        if(arrDepart[choice2 - 1].equals(e.getDepartment())){
            System.out.println(e);
        }
    }
}
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        System.out.println("(^-^)");
        System.out.println("Выберите задание:\n 1 - класс время\n 2 - класс дом\n 3 - класс Сотрудники и отделы\n 4 - класс Сотрудники и отделы\n 5 - класс дом\n 6 - пистолет");
        int answ = readIntInRange(scanner, 1, 6 );

        if (answ == 1){
            System.out.print("Введите время в секундах: ");
    		int sec = readInt2(scanner);
            while (sec < 0 ){
                System.out.println("Ошибка! Введите число больше 0!");
                System.out.print("Введите время в секундах: ");
                sec = readInt2(scanner);
            }

    		Time clock = new Time(sec);
			clock.show();
        }
		if (answ == 2){
			System.out.print("Введите ко-во этажей в доме: ");
    		int floor = readInt2(scanner);
            while (floor < 0 ){
                System.out.println("Ошибка! Введите число больше 0!");
                System.out.print("Введите ко-во этажей в доме: ");
                floor = readInt2(scanner);
            }
    		Home DrHouse = new Home(floor);
			DrHouse.show();
		}
		if (answ == 3){
            menu3(scanner);
		}
    }
}