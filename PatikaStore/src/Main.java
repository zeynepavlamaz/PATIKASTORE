import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        boolean notFinished = true;
        int userChoice = 4;


        while (notFinished){
            System.out.println();
            System.out.println("<<<<<<<<<<<<<<<< Patika Store Ürün Yönetim Paneli >>>>>>>>>>>>>>>>");
            System.out.println();
            System.out.println("İşleminizi Seçiniz");
            System.out.println("Notebook İşlemleri için 1");
            System.out.println("Cep Telefonu İşlemleri için 2");
            System.out.println("Marka Listeleme için 3");
            System.out.println("Çıkış İçin 4");
            System.out.print("Tercihiniz: ");

            try {
                userChoice = scan.nextInt();
            }catch (Exception e){
                System.out.println("Please enter a value between 1 and 4...");
                e.printStackTrace();
                continue;
            }

            switch (userChoice){
                case 1:
                    System.out.println("1 - List of notebooks");
                    System.out.println("2 - Add notebook");
                    System.out.println("3 - Delete notebook");
                    System.out.print("Your choice:");
                    int userNotebookChoice;
                    try {
                        userNotebookChoice = scan.nextInt();
                    }catch (Exception e){
                        System.out.println("Please enter 1 or 2...");
                        break;
                    }

                    switch (userNotebookChoice){
                        case 1:
                            listNoteBooks();
                            break;
                        case 2:
                            addNoteBook();
                            break;

                        case 3:
                            if (deleteNoteBook()){
                                System.out.println("Your notebook succesfully removed from our database!");
                                break;
                            }else{
                                System.out.println("Sorry we couldn't find your notebook in our database!");
                                break;
                            }
                    }
                    break;
                case 2:
                    System.out.println("1 - List of mobile phones");
                    System.out.println("2 - Add mobile phone");
                    System.out.println("3 - Delete mobile phone");
                    System.out.print("Your choice:");
                    int userMobilePhoneChoice;
                    try {
                        userMobilePhoneChoice = scan.nextInt();
                    }catch (Exception e){
                        System.out.println("Please enter 1 or 2...");
                        break;
                    }

                    switch (userMobilePhoneChoice){
                        case 1:
                            listMobilePhones();
                            break;
                        case 2:
                            addMobilePhones();
                            break;
                        case 3:
                            if (deleteMobilePhone()){
                                System.out.println("Your mobile phone succesfully removed from our database!");
                                break;
                            }else {
                                System.out.println("Sorry we couldn't find your mobile phone in our database!");
                                break;
                            }
                    }
                    break;

                case 3:
                    System.out.println("Our Brands:");
                    for (Brand brand: Brand.brands){
                        System.out.println("- " + brand.getBrandName());
                    }
                    Thread.sleep(2000);
                    break;

                case 4:
                    System.out.println("We would like to see you again...");
                    notFinished = false;
                    break;
            }

        }

    }






    public static void addMobilePhones(){
        System.out.println("Please enter the features of your mobile phone");
        try {
            System.out.print("Price of your mobile phone (just type number): ");
            int mPhonePrice = scan.nextInt();
            System.out.print("Would you like to add discount if yes please enter the percentage (just type number): ");
            int mPhoneDiscount = scan.nextInt();
            System.out.print("How many do you have (just type number): ");
            int mPhoneStock = scan.nextInt();
            System.out.print("How much storage does your mobile phone has (just type number): ");
            int mPhoneMemory = scan.nextInt();
            System.out.print("How much battery MAH does your mobile phone has (just type number): ");
            int mPhoneMAH = scan.nextInt();
            System.out.print("How much RAM does your mobile phone has (just type number): ");
            int mPhoneRAM = scan.nextInt();
            System.out.print("What is your mobile phones name (just type words): ");
            String mPhoneName = scan.next();
            System.out.print("What is your mobile phones screen size (just type number like 2,1 , 3,4 , 17,4): ");
            double mPhoneScreen = scan.nextDouble();
            System.out.print("What is your mobile phones color (just type words): ");
            String mPhoneColor = scan.next();
            System.out.println("What is your mobile phones brand ?");
            int counter = 1;
            for (Brand brand: Brand.brands){
                System.out.println(counter+ " - " + brand.getBrandName());
                counter++;
            }
            System.out.print("Enter the id of the brand that you choose: ");
            int brandID = scan.nextInt();
            String mobilePhoneBrandName = null;
            switch (brandID){
                case 1:
                    mobilePhoneBrandName = "Apple";
                    break;
                case 2:
                    mobilePhoneBrandName = "Casper";
                    break;
                case 3:
                    mobilePhoneBrandName = "Huawei";
                    break;
                case 4:
                    mobilePhoneBrandName = "Lenovo";
                    break;
                case 5:
                    mobilePhoneBrandName = "Monster";
                    break;
                case 6:
                    mobilePhoneBrandName = "Samsung";
                    break;
                case 7:
                    mobilePhoneBrandName = "Xiaomi";
                    break;
                default:
                    mobilePhoneBrandName = "Samsung";
                    break;

            }


            MobilePhone.mobilePhones.add(new MobilePhone(mPhonePrice,mPhoneDiscount,mPhoneStock,mPhoneMemory,mPhoneMAH,mPhoneRAM,mPhoneName,mPhoneScreen,mPhoneColor,new Brand(mobilePhoneBrandName)));
            System.out.println("Thank you! Your mobile phone has been added to our database...");

            listMobilePhones();

        }catch (Exception e){
            System.out.println("Please enter values in correct format...");
            e.printStackTrace();
        }
    }




    public static boolean deleteMobilePhone(){
        System.out.print("Please enter the exact id of the mobile phone that you wand to delete: ");
        String deleteMobilePhone = scan.next();

        for (MobilePhone mobilePhone: MobilePhone.mobilePhones) {
            if (Objects.equals(mobilePhone.getRealId(), deleteMobilePhone)){
                MobilePhone.mobilePhones.remove(mobilePhone);
                return true;
            }
        }

        return false;
    }

    public static void listMobilePhones(){
        int userOrderChoice = 0;
        System.out.print("In what order do you want to list the mobile phones! 1 - A-Z by brand name 2 - By id: ");
        try {
            userOrderChoice = scan.nextInt();
        }catch (Exception e){
            e.printStackTrace();
        }

        switch (userOrderChoice){
            case 0:
                System.out.println("Please enter 1 or 2...");
                break;
            case 1:
                System.out.printf("----------------------------------------------------------------------------------------------------------------------%n");
                System.out.printf("| ID | Product Name                          | Price   | Brand     | Storage     | Screen        | Ram               |%n");
                System.out.printf("----------------------------------------------------------------------------------------------------------------------%n");
                for (MobilePhone mobilePhone : MobilePhone.mobilePhones){
                    System.out.printf("| %-10s | %-8s                      | %4s $  | %6s    | %7s GB  | %8s INC  | %9s GB     |%n",mobilePhone.getRealId().substring(0,7),mobilePhone.getName().toUpperCase(),mobilePhone.getPrice() - (mobilePhone.getPrice() * (mobilePhone.getDiscountRate()/100.0)),mobilePhone.getBrandName().getBrandName().toUpperCase(),mobilePhone.getMemoryAmount(),mobilePhone.getScreenSize(),mobilePhone.getRAM());
                }

                System.out.print("---------------------------------------------------------------------------------------------------");
                break;
            case 2:
                TreeSet<MobilePhone> mobilePhoness = new TreeSet<>(new IdOrderComparator());
                mobilePhoness = MobilePhone.mobilePhones;

                System.out.printf("----------------------------------------------------------------------------------------------------------------------%n");
                System.out.printf("| ID | Product Name                          | Price   | Brand     | Storage     | Screen        | Ram               |%n");
                System.out.printf("----------------------------------------------------------------------------------------------------------------------%n");
                for (MobilePhone mobilePhone : mobilePhoness){
                    System.out.printf("| %-10s | %-8s                      | %4s $  | %6s    | %7s GB  | %8s INC  | %9s GB     |%n",mobilePhone.getRealId().substring(0,7),mobilePhone.getName().toUpperCase(),mobilePhone.getPrice() - (mobilePhone.getPrice() * (mobilePhone.getDiscountRate()/100.0)),mobilePhone.getBrandName().getBrandName().toUpperCase(),mobilePhone.getMemoryAmount(),mobilePhone.getScreenSize(),mobilePhone.getRAM());
                }

                System.out.print("---------------------------------------------------------------------------------------------------");
                break;

        }


    }

    // Notebook silme işlemi
    public static boolean deleteNoteBook(){
        System.out.print("Please enter the exact id of the notebook that you wand to delete: ");
        String deleteNotebook = scan.next();

        for (Notebook notebook: Notebook.noteBooks) {
            if (Objects.equals(notebook.getRealId(), deleteNotebook)){
                Notebook.noteBooks.remove(notebook);
                return true;
            }
        }

        return false;
    }

    public static void addNoteBook(){
        System.out.println("Please enter the features of your note book");
        try {
            System.out.print("Price of your notebook (just type number): ");
            int notebookPrice = scan.nextInt();
            System.out.print("Would you like to add discount if yes please enter the percentage (just type number): ");
            int notebookDiscount = scan.nextInt();
            System.out.print("How many do you have (just type number): ");
            int notebookStock = scan.nextInt();
            System.out.print("How much storage does your notebook has (just type number): ");
            int notebookMemory = scan.nextInt();
            System.out.print("How much RAM does your notebook has (just type number): ");
            int notebookRAM = scan.nextInt();
            System.out.print("What is your notebooks name (just type words): ");
            String notebookName = scan.next();
            System.out.print("What is your notebooks color (just type words): ");
            String notebookColor = scan.next();
            System.out.println("What is your notebooks brand ?");
            int counter = 1;
            for (Brand brand: Brand.brands){
                System.out.println(counter+ " - " + brand.getBrandName());
                counter++;
            }
            System.out.print("Enter the id of the brand that you choose: ");
            int brandID = scan.nextInt();
            String notebookBrandName = null;
            switch (brandID){
                case 1:
                    notebookBrandName = "Apple";
                    break;
                case 2:
                    notebookBrandName = "Casper";
                    break;
                case 3:
                    notebookBrandName = "Huawei";
                    break;
                case 4:
                    notebookBrandName = "Lenovo";
                    break;
                case 5:
                    notebookBrandName = "Monster";
                    break;
                case 6:
                    notebookBrandName = "Samsung";
                    break;
                case 7:
                    notebookBrandName = "Xiaomi";
                    break;
                default:
                    notebookBrandName = "Samsung";
                    break;

            }

            System.out.print("What is your notebooks screen size (just type number like 2,1 , 3,4 , 17,4): ");
            double notebookScreen = scan.nextDouble();

            Notebook.noteBooks.add(new Notebook(notebookPrice,notebookDiscount,notebookStock,notebookMemory,notebookRAM,notebookName,notebookColor,new Brand(notebookBrandName),notebookScreen));
            System.out.println("Thank you! Your notebook has been added to our database...");

            listNoteBooks();

        }catch (Exception e){
            System.out.println("Please enter values in correct format...");
            e.printStackTrace();
        }
    }


    // Notebook listeleme işlemi
    public static void listNoteBooks(){
        int userOrderChoice = 0;
        System.out.print("In what order do you want to list the notebooks! 1 - A-Z by brand name 2 - By id: ");
        try {
            userOrderChoice = scan.nextInt();
        }catch (Exception e){
            e.printStackTrace();
        }

        switch (userOrderChoice){
            case 0:
                System.out.println("Please enter 1 or 2...");
                break;
            case 1:
                System.out.printf("----------------------------------------------------------------------------------------------------------------------%n");
                System.out.printf("| ID | Product Name                          | Price   | Brand     | Storage     | Screen        | Ram               |%n");
                System.out.printf("----------------------------------------------------------------------------------------------------------------------%n");
                for (Notebook noteBook : Notebook.noteBooks){
                    System.out.printf("| %-10s | %-8s                      | %4s $  | %6s    | %7s GB  | %8s INC  | %9s GB     |%n",noteBook.getRealId().substring(0,7),noteBook.getName().toUpperCase(),noteBook.getPrice() - (noteBook.getPrice() * (noteBook.getDiscountRate()/100.0)),noteBook.getBrandName().getBrandName().toUpperCase(),noteBook.getMemoryAmount(),noteBook.getScreenSize(),noteBook.getRAM());
                }

                System.out.print("---------------------------------------------------------------------------------------------------");
                break;
            case 2:
                TreeSet<Notebook> noteBookss = new TreeSet<>(new IDOrderComparatorNoteBook());
                noteBookss = Notebook.noteBooks;

                System.out.printf("----------------------------------------------------------------------------------------------------------------------%n");
                System.out.printf("| ID | Product Name                          | Price   | Brand     | Storage     | Screen        | Ram               |%n");
                System.out.printf("----------------------------------------------------------------------------------------------------------------------%n");
                for (Notebook noteBook : noteBookss){
                    System.out.printf("| %-10s | %-8s                      | %4s $  | %6s    | %7s GB  | %8s INC  | %9s GB     |%n",noteBook.getRealId().substring(0,7),noteBook.getName().toUpperCase(),noteBook.getPrice() - (noteBook.getPrice() * (noteBook.getDiscountRate()/100.0)),noteBook.getBrandName().getBrandName().toUpperCase(),noteBook.getMemoryAmount(),noteBook.getScreenSize(),noteBook.getRAM());
                }

                System.out.print("---------------------------------------------------------------------------------------------------");
                break;

        }
    }
}