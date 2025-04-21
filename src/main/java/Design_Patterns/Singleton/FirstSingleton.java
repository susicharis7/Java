package Design_Patterns.Singleton;

class Singleton {
    private static Singleton instance;
    /* kreiramo privatnu instancu kojoj mozemo pristupiti samo preko staticke metode getInstance(), i
       time osiguravamo da se ne moze kreirati vise od jedne instance ove klase.
    */


    /*
    private Constructor - osigurava da jedino getInstance() moze kontrolisati stvaranje instance i niko vise
     */
    private Singleton() {

    }


    /*
    provjerava da li je instanca prazna - ako jeste, znaci da nijedna dosad instanca nije kreirana !
    tako da ako je prazna, instanca poziva privatni konstruktor i kreira novu instancu
    ta instanca se zatim dodjeluje "instance" promjenjivoj
    na kraju metoda vraca instancu
    kad se kreira, svi sljedeci pozivi metodi vracaju tu istu instancu
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    /*
    kad pozovemo getInstance(), vratiti ce istu instancu i nece kreirati novu !!
     */
}

class Main {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        System.out.println(obj1 == obj2);
    }
}
