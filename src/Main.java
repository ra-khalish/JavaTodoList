import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class Main {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        viewShowTodoList();

    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList() {
        System.out.println("TODOLIST");
        for (int i=0; i<model.length; i++){
            var todo = model[i];
            var no = i+1;

            if (todo != null){
                System.out.println(no+". "+ todo);
            }
        }
    }

    public static void testShowTodoList(){
        model[0] = "Rafi belajar java dasar";
        model[1] = "Rafi belajar dengan semagnat";
        showTodoList();
    }

    /**
     * Menambah todo ke list
     */
    public static void addTodoList(String todo){
        // cek array
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null){
                isFull = false;
                break;
            }
        }

        // jika penuh, kita resize ukuran array 2x lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // tambah todo ke list
        for (int i = 0; i < model.length; i++) {
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList(){
        for (int i = 0; i < 24; i++) {
            addTodoList("Contoh todo list ke "+ i);
        }
        showTodoList();
    }



    /**
     * Menghapus todo dari list
     */
    public static boolean removeTodoList(Integer number){
        if ((number-1) >= model.length){
            return false;
        } else if (model[number-1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length-1) ) {
                    model[i] = null;
                } else
                    model[i] = model[i+1];
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima ");

        var result = removeTodoList(15);
        System.out.println(result); // negative case jika yg diremove lebih dari range array

        result = removeTodoList(7);
        System.out.println(result); // negative case jika yg di remove sudah kosong

        result = removeTodoList(2);
        System.out.println(result); // positive case

        showTodoList();
    }

    /**
     * Input todo lsit
     */
    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Name");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println("Channel" + channel);
    }

    /**
     * Menampilkan view show todo list
     */
    public static void viewShowTodoList(){
        while (true){
            showTodoList();

            System.out.println("Menu :");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }

    }

    public static void testViewShowTodoList(){
        addTodoList("Belajar java");
        addTodoList("Belajar CI/CD");
        addTodoList("Haruss semangat");
        viewShowTodoList();
    }

    /**
     * Menampilkan view add todo list
     */
    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODO");

        var todo = input("Todo (x Jika batal)");

        if (todo.equals("x")) {
            // batal
        } else {
            addTodoList(todo);
        }

    }

    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");

        viewAddTodoList();

        showTodoList();
    }

    /**
     * Menampilkan view delete todo list
     */
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODO");

        var number = input("Nomor todo (x Jika batal)");

        if (number.equals("x")) {
            // batal
        } else {
           boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todo "+number);
            }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tuga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }

}