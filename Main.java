import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	 private final static void clearConsole() {
        final String os = System.getProperty("os.name");

        try {
            if (os.contains("Linux") || os.contains("Mac")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            } else if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
	
	
     
     static final Scanner scanner = new Scanner(System.in);
   
	
	
	
    public static void main(String[] args) {
		
        System.out.println("\t+---------------------------------------+");
        System.out.println("\t|\t\tLOGIN PAGE\t\t|");
        System.out.println("\t+---------------------------------------+\n");
        
        while (true) {
            if (login()) {
				clearConsole();
                printShowHomePage();
                
            } else {
                System.out.println("Invalid login. Please try again.");
            }
        }
    }
	public static void printLogin() {
		System.out.println("\t+---------------------------------------+");
        System.out.println("\t|\t\tLOGIN PAGE\t\t|");
        System.out.println("\t+---------------------------------------+\n");
		
		}
    public static boolean login() {

        final String user = "dilshan";
        final int password = 1234;

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nUser Name: ");
        String inputN = scanner.nextLine();
        
        if (inputN.equals(user)) {
            
            System.out.print("Password: ");
            int inputP = scanner.nextInt();
            
            if (inputP == password) {
                return true;
            } else {
                System.out.println("\nPassword is incorrect. Please try again!");
                return false;
            }
        } else {
            System.out.println("\nUser name is invalid. Please try again!");
            return false;
        }
    }
     public static void printShowHomePage() {
		 
		    System.out.println("\n\t+----------------------------------------------------------------+");
			System.out.println("\t|\t\tWELCOME TO MY STOCK MANAGMENT SYSTEM\t\t |");
			System.out.println("\t+----------------------------------------------------------------+\n\n");
        
        
			System.out.print("\n[1] Change Credentials");
            System.out.print("\t\t[2] Supplier Management");
            System.out.print("\n\n[3] Stock Management");
            System.out.print("\t\t[4] Logout");
            System.out.print("\n\n[5] Exit");
		 
		 showHomePage();
	 }
     public static void showHomePage() {
		 
		   
            
            System.out.print("\n\n\nEnter  an option to contnue  > ");   
            
        while (true) {
	     	Scanner scanner = new Scanner(System.in); 
			
           
            int cho = scanner.nextInt();
			scanner.nextLine(); 
      switch (cho) {
                case 1:
					clearConsole();
                   printChangeCredentials();
                    break;
                case 2:
					clearConsole();
                    supplierManagement();
                    break;
                case 3:
					clearConsole();
                    stockManagement();
                    break;
                case 4:
					clearConsole();
					return;
                  
                case 5:
					clearConsole();
                    System.exit(0); 
                default:
                    System.out.println("Invalid option. Please try again.");
                    showHomePage();
            }
        }
    }
    
    
    public static void printChangeCredentials() {
		
	    System.out.println("\n\t+------------------------------------------------+");
		System.out.println("\t|\t\tCHANGE THE CREDENTIALS\t\t |");
		System.out.println("\t+------------------------------------------------+\n\n");
		
		changeCredentials();
		 
		}
    
    public static void changeCredentials() {
		
		System.out.println("\nChange Credentials is not available");
		System.out.print("Do you want go home page(Y/N)? ");
			char option2 = scanner.next().charAt(0);
					scanner.nextLine(); 
        
					if (option2 == 'Y' || option2 == 'y') {
							clearConsole();
							printShowHomePage();
				
						} else if (option2 == 'N' || option2 == 'n') {
							changeCredentials();
							

						} else {
						System.out.println("Invalid option. Please try again.\n\n");
						changeCredentials();
					}
		}
			
    
    
     static final String[][] suppliers = new String[100][2]; // Supplier ID and Name
     static int supplierCount = 0;

     public static void supplierManagement() {
		 
        Scanner scanner = new Scanner(System.in);

			System.out.println("\n\t+------------------------------------------------+");
			System.out.println("\t|\t\tSUPPLER MANAGEMNT\t\t |");
			System.out.println("\t+------------------------------------------------+\n\n");
			
			
			System.out.print("\n\n[1] Add Supplier");
            System.out.print("\t\t[2] Update Supplier");
            System.out.print("\n\n[3] Delete Supplier");
            System.out.print("\t\t[4] View Suppliers");
            System.out.print("\n\n[5] Search Supplier");
            System.out.print("\t\t[6] Home Page");
		
        while (true) {
            
            
            System.out.print("\n\n\nEnter  an option to contnue  > ");
               
            int choice = scanner.nextInt();
			scanner.nextLine(); 
			
            switch (choice) {
                case 1:
					clearConsole();
                    printAddSupplier();
                    break;
                case 2:
					clearConsole();
                    printUpdateSupplier();
                    break;
                case 3:
					clearConsole();
                    printDeleteSupplier();
                    break;
                case 4:
                    clearConsole();
                    printViewSupplier();
                    break;
                case 5:
					clearConsole();
                    printSearchSupplier();
                    break;
                case 6:
					clearConsole();
                    printShowHomePage();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
	
	
	public static void printAddSupplier() {
		 
		 System.out.println("\n\t+----------------------------------------+");
		 System.out.println("\t|\t\tADD SUPPLER \t\t |");
		 System.out.println("\t+----------------------------------------+\n\n");
		 addSupplier();
		 
		 }
 
    public static void addSupplier() {
      
        
        System.out.print("Enter supplier ID: ");
        String id = scanner.nextLine();
        for (String[] supplier : suppliers) {
            if (supplier[0] != null && supplier[0].equals(id)) {
                System.out.println("Supplier ID already exists. try another  supplir id");
                addSupplier();
            }
        }
        System.out.print("Enter supplier name: ");
        String name = scanner.nextLine();
        suppliers[supplierCount][0] = id;
        suppliers[supplierCount][1] = name;
        supplierCount++;
        
        System.out.print("\n\nSupplier added successfully. Do you want to add another supplier(Y/N)? ");
        char option = scanner.next().charAt(0);
        scanner.nextLine(); 
        
         if (option == 'Y' || option == 'y') {
				addSupplier();
				
            } else if (option == 'N' || option == 'n') {
                clearConsole();
                supplierManagement();

            } else {
    
                
				System.out.print("\n\nInvalid option. Please try again. Do you want to add another supplier(Y/N)? ");
				char option2 = scanner.next().charAt(0);
					scanner.nextLine(); 
        
					if (option2 == 'Y' || option2 == 'y') {
							addSupplier();
				
						} else if (option2 == 'N' || option2 == 'n') {
							clearConsole();
							supplierManagement();

						} else {
						System.out.println("Invalid option. Please try again.\n\n");
						addSupplier();
					}
            }
        }
    public static void printUpdateSupplier() {
		 
		 System.out.println("\n\t+----------------------------------------+");
		 System.out.println("\t|\t\tUPDATE SUPPLER \t\t |");
		 System.out.println("\t+----------------------------------------+\n\n");
		 updateSupplier();
		 
		 }

    public static void updateSupplier() {
		
        System.out.print("Enter supplier ID to update: ");
        String id = scanner.nextLine();
        for (int i = 0; i < supplierCount; i++) {
            if (suppliers[i][0].equals(id)) {
                System.out.print("Enter new supplier name: ");
                String newName = scanner.nextLine();
                suppliers[i][1] = newName;
                
                System.out.print("\n\nSupplier update successfully. Do you want to update another supplier(Y/N)?");
                char option = scanner.next().charAt(0);
                
                scanner.nextLine(); 
        
				if (option == 'Y' || option == 'y') {
						updateSupplier();
				
					} else if (option == 'N' || option == 'n') {
						clearConsole();
						supplierManagement();

					} else {
						System.out.println("Invalid option. Please try again.");
						updateSupplier();
					}
                
                
            }
        }
        System.out.println("cant find suppler id. try argan !");
        updateSupplier();
    }

	public static void printDeleteSupplier() {
		 System.out.println("\n\t+----------------------------------------+");
		 System.out.println("\t|\t\tDELETE SUPPLER \t\t |");
		 System.out.println("\t+----------------------------------------+\n\n");
		
		 deleteSupplier();
	
		}

	public static void deleteSupplier() {
        System.out.print("Enter supplier ID to delete : ");
        String id = scanner.nextLine();
        for (int i = 0; i < supplierCount; i++) {
            if (suppliers[i][0].equals(id)) { 
                suppliers[i][0] = null; 
                suppliers[i][1] = null; 
               
                System.out.print("\n\nSupplier delete successfully. Do you want to update another supplier(Y/N)? ");
                char option = scanner.next().charAt(0);
                
                scanner.nextLine(); 
        
				if (option == 'Y' || option == 'y') {
						 deleteSupplier();
				
					} else if (option == 'N' || option == 'n') {
						clearConsole();
						supplierManagement();

					} else {
						System.out.println("Invalid option. Please try again !");
						deleteSupplier();
					}
  
            }
        }
        System.out.println("cant find suppler id. try argan !");
        deleteSupplier();
    }
	
	
	public static void printViewSupplier() {
		 
		 System.out.println("\n\t+----------------------------------------+");
		 System.out.println("\t|\t\tVIEW SUPPLER \t\t |");
		 System.out.println("\t+----------------------------------------+\n\n");
		 viewSuppliers();
		 
		 }
	 public static void viewSuppliers() {
		 
		System.out.println("+--------------------+--------------------+");
        System.out.println("|   SUPPLIER ID      |    SUPPLIER NAME   |");
        System.out.println("+--------------------+--------------------+");
        
       
        for (int i = 0; i < supplierCount; i++) {
			
			 System.out.print("| ");
			 
            for (int j = 0; j <=1; j++) {
                 System.out.printf("%-18s", suppliers[i][j]);
                if (j == 0) {
                    System.out.print(" | ");
                }
            }
            System.out.println(" |");
            
        }
        System.out.println("+--------------------+--------------------+");
		System.out.println();	
          
      
      
            System.out.print("\n\nDo you  want to go supplier manage page (Y/N)? ");
                char option = scanner.next().charAt(0);
                
                scanner.nextLine(); 
        
				if (option == 'Y' || option == 'y') {
						 clearConsole();
						 supplierManagement();
				
					} else if (option == 'N' || option == 'n') {
						
						viewSuppliers();

					} else {
						System.out.println("Invalid option. Please try again !");
						
						viewSuppliers();
					}
            
        
    }

	
	
	public static void printSearchSupplier() {
		 
		 System.out.println("\n\t+----------------------------------------+");
		 System.out.println("\t|\t\tSEARCH SUPPLER \t\t |");
		 System.out.println("\t+----------------------------------------+\n\n");
		 searchSupplier();
		 
		 }
	
	public static void searchSupplier() {
        System.out.print("Enter supplier ID to search : ");
        String id = scanner.nextLine();
        for (int i = 0; i < supplierCount; i++) {
            if (suppliers[i][0].equals(id)) {
                System.out.println("\nSupplier ID : " + suppliers[i][0]);
                System.out.println("Supplier Name : " + suppliers[i][1]);
                
                System.out.print("\n\nSupplier search successfully. Do you want to seach another supplier(Y/N)? ");
                char option = scanner.next().charAt(0);
                
                scanner.nextLine(); 
        
				if (option == 'Y' || option == 'y') {
						 searchSupplier();
				
					} else if (option == 'N' || option == 'n') {
						clearConsole();
						supplierManagement();

					} else {
						System.out.println("Invalid option. Please try again !");
						searchSupplier();
					}
            }
        }
        System.out.println("cant find suppler id. try argan !");
        searchSupplier();
    }

	public static void stockManagement() {
			System.out.println("\n\t+------------------------------------------------+");
			System.out.println("\t|\t\t STOCK MANAGMENT \t\t |");
			System.out.println("\t+------------------------------------------------+\n\n");
			
			
			System.out.print("[1] Manage Item Categories");
            System.out.print("\t\t[2] Add Item");
            System.out.print("\n\n[3] Get Items Supplier Wise");
            System.out.print("\t\t[4] View Items");
            System.out.print("\n\n[5] Rank Items Per Unit Price");
            System.out.print("\t\t[6] Back to Home");
        
        while (true) {
            
            System.out.print("\n\n\nEnter  an option to contnue  > ");   
            
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
					clearConsole();
					manageItemCategory();
                    break;
                case 2:
					clearConsole();
                    printAddItem();
                    break;
                case 3:
					clearConsole();
                    printGetItemsSupplierWise();
                    break;
                case 4:
					clearConsole();
                    printViewItems();
                    break;
                case 5:
					clearConsole();
                    printRankItemsPerUnitPrice();
                    break;
                case 6:
					clearConsole();
					printShowHomePage(); 
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

	public static void manageItemCategory() {
		 
        Scanner scanner = new Scanner(System.in);

			System.out.println("\n\t+------------------------------------------------+");
			System.out.println("\t|\t\tMANAGE ITEM CATAGORY\t\t |");
			System.out.println("\t+------------------------------------------------+\n\n");
			
			
			System.out.print("\n\n[1] Add New Item Catagory");
            System.out.print("\t\t[2] Delete Item CatagorY");
            System.out.print("\n\n[3] Upade Item Catagor");
            System.out.print("\t\t\t[4] Stock Management");
            
		
        while (true) {
            
            
            System.out.print("\n\n\nEnter  an option to contnue  > ");
               
            int choice = scanner.nextInt();
			scanner.nextLine(); 
			
            switch (choice) {
                case 1:
					clearConsole();
                    printAddNewItemCatagory();
                    break;
                case 2:
					clearConsole();
                    printDeleteItemCatagory();
                    break;
                case 3:
					clearConsole();
                    printUpadeItemCatagor();
                    break;
                case 4:
                    clearConsole();
                    stockManagement();
                    break;
                
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

	 
      
      static String[][] categories = new String[100][1]; // Category Name
      static int categoryCount = 0;
 
	  public static void printAddNewItemCatagory() {
		 
		 System.out.println("\n\t+----------------------------------------+");
		 System.out.println("\t|\tADD ITEM CATEGORRY \t\t |");
		 System.out.println("\t+----------------------------------------+\n\n");
		 addNewItemCatagory();
		 
		 } 

     public static void addNewItemCatagory() {
		 
        System.out.print("\nEnter Category Name: ");
        String categoryName = scanner.nextLine();
        
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i][0].equals(categoryName)) {
                System.out.println("Category already exists. Try again.");
                addNewItemCatagory();
            }
        }
        
        categories[categoryCount][0] = categoryName;
        categoryCount++;
        System.out.print("\n\nCategory add successfully. Do you want to add another category(Y/N)?");
                char option = scanner.next().charAt(0);
                
                scanner.nextLine(); 
        
				if (option == 'Y' || option == 'y') {
						addNewItemCatagory();
				
					} else if (option == 'N' || option == 'n') {
						clearConsole();
						manageItemCategory();

					} else {
						System.out.println("Invalid option. Please try again.");
						addNewItemCatagory();
					}
		}
        

	 public static void printUpadeItemCatagor(){
		 
		 System.out.println("\n\t+----------------------------------------+");
		 System.out.println("\t|\tUPDATE ITEM CATEGORY \t\t |");
		 System.out.println("\t+----------------------------------------+\n\n");
		 updateItemCategory();
		 
		 }

				
	  public static void updateItemCategory() {
		  
        System.out.print("Enter existing Category Name: ");
        String oldCategoryName = scanner.nextLine();
        
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i][0].equals(oldCategoryName)) {
                System.out.print("Enter new Category Name: ");
                String newCategoryName = scanner.nextLine();
                categories[i][0] = newCategoryName;
                System.out.print("\n\nCatagor update successfully. Do you want to update another Catagorey (Y/N)?");
                char option = scanner.next().charAt(0);
                
                scanner.nextLine(); 
        
				if (option == 'Y' || option == 'y') {
						updateItemCategory();
				
					} else if (option == 'N' || option == 'n') {
						clearConsole();
						supplierManagement();

					} else {
						System.out.println("Invalid option. Please try again.");
						updateItemCategory();
					}
            }
        }
        System.out.println("Category not found.Try again");
        updateItemCategory();
    }
	
	public static void printDeleteItemCatagory() {
		 System.out.println("\n\t+----------------------------------------+");
		 System.out.println("\t|\tDELETE ITEM CATAGORY \t\t |");
		 System.out.println("\t+----------------------------------------+\n\n");
		
		 deleteItemCategory();
	
		}
    public static void deleteItemCategory() {
        System.out.print("Enter Category Name: ");
        String categoryName = scanner.nextLine();
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i][0].equals(categoryName)) {
                categories[i][0] = null;
                
                
               System.out.print("\n\nCatagory delete successfully. Do you want to delete Catagory another (Y/N)? ");
                char option = scanner.next().charAt(0);
                
                scanner.nextLine(); 
        
				if (option == 'Y' || option == 'y') {
						deleteItemCategory();
				
					} else if (option == 'N' || option == 'n') {
						clearConsole();
						manageItemCategory();

					} else {
						System.out.println("Invalid option. Please try again !");
						deleteItemCategory();
					}
  
            }
        }
        System.out.println("cant find Catagory try argan !");
        deleteItemCategory();
    }
			
	  static String[][] items = new String[100][6]; // code, supplierId, catagory, description, unitPrice, quantity
      static int itemCount = 0;
	
	public static void printAddItem() {
		 
		 System.out.println("\n\t+----------------------------------------+");
		 System.out.println("\t|\t\tADD ITEM \t\t |");
		 System.out.println("\t+----------------------------------------+\n\n");
		 addItem();
		 
		 }
	
	  public static void addItem() {
        if (categoryCount == 0) {
            System.out.print("\n\noops ! it seems that you dont have any item categorey in the system .");  
            System.out.print("\nDo you want to add new item category(Y/N)?");
               char option = scanner.next().charAt(0);
                
                scanner.nextLine(); 
        
				if (option == 'Y' || option == 'y') {
						clearConsole();
						printAddNewItemCatagory();
				
					} else if (option == 'N' || option == 'n') {
						clearConsole();
						stockManagement();

					} else {
						System.out.println("Invalid option. Please try again.");
						addItem();
					}
        }
        
        if (supplierCount == 0) {
            System.out.print("\n\noops ! it seems that you dont have any supplier in the system .");  
            System.out.print("\nDo you want to add new supplier (Y/N)?");
                char option = scanner.next().charAt(0);
                
                scanner.nextLine(); 
        
				if (option == 'Y' || option == 'y') {
						clearConsole();
						printAddSupplier();
						
				
					} else if (option == 'N' || option == 'n') {
						clearConsole();
						stockManagement();

					} else {
						System.out.println("Invalid option. Please try again.");
						addItem();
					}
        }
        
        System.out.print("\nEnter Item Code   :");
        String itemCode = scanner.nextLine();
       
        
        for (int i = 0; i < itemCount; i++) {
            if (items[i][0].equals(itemCode)) {
                System.out.println("\nItem Code already exists. Try again.\n");
                addItem();
            }
        }
        
        
        System.out.println("\nEnter Supplier list :");
        
        System.out.println("+--------------------+--------------------+");
        System.out.println("|   SUPPLIER ID      |    SUPPLIER NAME   |");
        System.out.println("+--------------------+--------------------+");
        
       
        for (int i = 0; i < supplierCount; i++) {
			
			 System.out.print("| ");
			 
            for (int j = 0; j <=1; j++) {
                 System.out.printf("%-18s", suppliers[i][j]);
                if (j == 0) {
                    System.out.print(" | ");
                }
            }
            System.out.println(" |");
            
        }
        System.out.println("+--------------------+--------------------+");
		System.out.println();		
                
        System.out.print("Enter the supplier ID  > ");
        String supplierID = scanner.nextLine();
        
        
        boolean validSupplier = false;
        for (int i = 0; i < supplierCount; i++) {
            if (suppliers[i][0].equals(supplierID)) {
                validSupplier = true;
                break;
            }
        }
        if (!validSupplier) {
            System.out.println("\nInvalid Supplier ID. Try again.\n");
            addItem();
        }
        
        System.out.println("\nItem Categories   :");
         
        System.out.println("+----------------------+");
        System.out.println("|     CATEGORY NAME    |");
        System.out.println("+----------------------+");
        	
        for (int i = 0; i < categoryCount; i++) {
			
			System.out.print("| ");
			
            for (int j = 0; j < 1; j++) {
                System.out.printf("%-20s",categories[i][j]);
                
                 
            }
            System.out.println(" |");
        }
        System.out.println("+----------------------+");
		System.out.println();

        
        System.out.print("Enter the category name  > ");
        String category = scanner.nextLine();
        
        boolean validCategory = false;
        for (int i = 0; i < categoryCount; i++) {
            if (categories[i][0].equals(category)) {
                validCategory = true;
                break;
            }
        }
        if (!validCategory) {
            System.out.println("\nInvalid Category. Try again.\n");
            addItem();
        }
        
        System.out.print("\nEnter Description : ");
        String description = scanner.nextLine();
        
         
        System.out.print("Enter Unit Price : ");
        String unitPrice = scanner.nextLine();
        
        
        System.out.print("Enter Quantity : ");
        String quantity = scanner.nextLine();
        
        
        
         items[itemCount][0] = itemCode;
         items[itemCount][1] = supplierID;
         items[itemCount][2] = category;
         items[itemCount][3] = description;
		 items[itemCount][4] = unitPrice;
		 items[itemCount][5] = quantity;
        
         itemCount++;
        
        System.out.println("\nItem added successfully.");
        System.out.print("\nDo you want to add new item category(Y/N)?");
               char option = scanner.next().charAt(0);
                
                scanner.nextLine(); 
        
				if (option == 'Y' || option == 'y') {
							addItem();
				
					} else if (option == 'N' || option == 'n') {
						clearConsole();
						stockManagement();

					} else {
						System.out.println("Invalid option. Please try again.");
						addItem();
				
					}
    
    
    
    }
	
	public static void printGetItemsSupplierWise() {
		 System.out.println("\n\t+----------------------------------------+");
		 System.out.println("\t|\t\tSEARCH SUPPLIER \t |");
		 System.out.println("\t+----------------------------------------+\n\n");
		
		 getItemsSupplierWise();
	
		}
	
	public static void getItemsSupplierWise() {
		
        System.out.print("Enter Supplier ID : ");
        String supplierID = scanner.nextLine();
        

       
            System.out.println("+----------------+----------------+----------------+----------------+----------------+----------------+");
			System.out.println("| ITEM CODE      | SUPPLIER ID    |   CATEGOREY    | DESCRIPTION    |  UNIT PRICE    |  QTY ON HAND   |");
			System.out.println("+----------------+----------------+----------------+----------------+----------------+----------------+");
         
        for (int i = 0; i < itemCount; i++) {
			
		
            if (items[i][1].equals(supplierID)) {
				
                System.out.print("| ");
                
                for (int j = 0; j < 6; j++) {
                    System.out.printf("%-14s",items[i][j]); //eka coolum ekk '-' gana %-14s gatte
                     if (j < 5) {
                    System.out.print(" | ");
                    }
                }
                System.out.println(" |");
                
            }

        }
       System.out.println("+----------------+----------------+----------------+----------------+----------------+----------------+");
        
            
            System.out.print("\nNo items found for this supplier !  Do you want to another search (Y/N)?");
               char optio = scanner.next().charAt(0);
                
                scanner.nextLine(); 
        
				if (optio == 'Y' || optio == 'y') {
							getItemsSupplierWise();
				
					} else if (optio == 'N' || optio == 'n') {
						clearConsole();
						stockManagement();

					} else {
						System.out.println("Invalid option. Please try again.");
						getItemsSupplierWise();
				
					}

    
		
        System.out.print("\nSearch successfully !  Do you want to another search (Y/N)?");
               char option = scanner.next().charAt(0);
                
                scanner.nextLine(); 
        
				if (option == 'Y' || option == 'y') {
							getItemsSupplierWise();
				
					} else if (option == 'N' || option == 'n') {
						clearConsole();
						stockManagement();

					} else {
						System.out.println("Invalid option. Please try again.");
						getItemsSupplierWise();
				
					} 
    
    }
    
    public static void printViewItems(){
		 
		 System.out.println("\n\t+----------------------------------------+");
		 System.out.println("\t|\t\tVIEW ITEMS \t\t |");
		 System.out.println("\t+----------------------------------------+\n\n");
		 viewItems();
		 
		 }
    
	public static void viewItems() {
		
		if (itemCount == 0) {
			
			System.out.print("\noops !. items not found !. Do you want to add item (Y/N)?");
               char option = scanner.next().charAt(0);
                
                scanner.nextLine(); 
        
				if (option == 'Y' || option == 'y') {
							clearConsole();
							printAddItem();
				
					} else if (option == 'N' || option == 'n') {
						clearConsole();
						stockManagement();

					} else {
						System.out.println("Invalid option. Please try again.");
						viewItems();
				
					} 
			
			}
		
			System.out.println("+----------------+----------------+----------------+----------------+----------------+----------------+");
			System.out.println("| ITEM CODE      | SUPPLIER ID    |   CATEGOREY    | DESCRIPTION    |    PRICE       |  QTY           |");
			System.out.println("+----------------+----------------+----------------+----------------+----------------+----------------+");
         
        for (int i = 0; i < itemCount; i++) {

                System.out.print("| ");
                
                for (int j = 0; j < 6; j++) {
                    System.out.printf("%-14s",items[i][j]); //eka coolum ekk '-' gana %-14s gatte
                     if (j < 5) {
                    System.out.print(" | ");
                    }
                }
                System.out.println(" |");


        }
       System.out.println("+----------------+----------------+----------------+----------------+----------------+----------------+");

        
        System.out.print("\nview successfully !  Do you want to again view item (Y/N)?");
               char option = scanner.next().charAt(0);
                
                scanner.nextLine(); 
        
				if (option == 'Y' || option == 'y') {
							viewItems();
				
					} else if (option == 'N' || option == 'n') {
						clearConsole();
						stockManagement();

					} else {
						System.out.println("Invalid option. Please try again.");
						viewItems();
				
					} 
    }
	
	 public static void printRankItemsPerUnitPrice(){
		 
		 System.out.println("\n\t+----------------------------------------+");
		 System.out.println("\t|\tRANKED UNIT PRICE\t\t |");
		 System.out.println("\t+----------------------------------------+\n\n");
		 rankItemsPerUnitPrice();
		 
		 }
	
	
	private static void rankItemsPerUnitPrice() {

        if (itemCount == 0) {
			
			System.out.print("\noops !. items not found !. Do you want to add item (Y/N)?");
               char option = scanner.next().charAt(0);
                
                scanner.nextLine(); 
        
				if (option == 'Y' || option == 'y') {
							clearConsole();
							printAddItem();
				
					} else if (option == 'N' || option == 'n') {
						clearConsole();
						stockManagement();

					} else {
						System.out.println("Invalid option. Please try again.");
						rankItemsPerUnitPrice();
				
					} 
			
			}
        
        for (int i = 0; i < itemCount - 1; i++) {
            for (int j = 0; j < itemCount - 1 - i; j++) {
                if (Double.parseDouble(items[j][4]) > Double.parseDouble(items[j + 1][4])) {
                    String[] temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }
        
            System.out.println("+----------------+----------------+----------------+----------------+----------------+----------------+");
			System.out.println("| ITEM CODE      | SUPPLIER ID    |   CATEGOREY    | DESCRIPTION    |    PRICE       |  QTY           |");
			System.out.println("+----------------+----------------+----------------+----------------+----------------+----------------+");
         
        for (int i = 0; i < itemCount; i++) {

                System.out.print("| ");
                
                for (int j = 0; j < 6; j++) {
                    System.out.printf("%-14s",items[i][j]); //eka coolum ekk '-' gana %-14s gatte
                     if (j < 5) {
                    System.out.print(" | ");
                    }
                }
                System.out.println(" |");

        }
       System.out.println("+----------------+----------------+----------------+----------------+----------------+----------------+");
        
        System.out.print("\n Do you want to go stock manage page (Y/N)?");
        char option = scanner.next().charAt(0);
                
                scanner.nextLine(); 
        
				if (option == 'Y' || option == 'y') {
							clearConsole();
						stockManagement();
				
					} else if (option == 'N' || option == 'n') {
						rankItemsPerUnitPrice();

					} else {
						System.out.println("Invalid option. Please try again.");
						rankItemsPerUnitPrice();
				
					} 
    }
		

}
