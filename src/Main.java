public class Main {

    public static String[] model = new String[10];

    public static void main(String[] args) {
        testRemoveTodoList();

    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList() {
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
     * Menampilkan view show todo list
     */
    public static void viewShowTodoList(){

    }

    /**
     * Menampilkan view add todo list
     */
    public static void viewAddTodoList(){

    }

    /**
     * Menampilkan view delete todo list
     */
    public static void viewRemoveTodoList(){

    }

}