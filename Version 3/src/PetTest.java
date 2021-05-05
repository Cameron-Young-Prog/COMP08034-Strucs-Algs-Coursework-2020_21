import java.lang.Exception;

public class PetTest {
    public static void main(String[] args) throws Exception {
        Pet pet = new Pet();
        Integer option = 0;
        
        do {
            System.out.println("0: Quit");
            System.out.println("1: Insert animal");
            System.out.println("2: Remove animal");
            System.out.println("3: Find animal");
            System.out.println("4: Display tree alphabetically");
            System.out.println("5: Insert product");
            System.out.println("6: Search for product");
            System.out.println("7: Remove a product");
            
            try {
                option = Input.getInteger("option: ");
                switch (option)  {
                    case 0:
                        System.out.println("quitting program");
                        break;
                    case 1:
                        do {
                            String value = Input.getString("value: ");
                            try {
                                pet.insert(value);
                                System.out.println("inserted");
                                System.out.println(value);
                            } catch (Exception e) {
                                System.out.println("insert invalid - value not unique");
                            }
                            }while(Repeat.repeat());
                            break;
                    

                    case 2:
                        String delete = Input.getString("delete: ");
                        pet.remove(delete);
                        System.out.println("removed");
                        
                        System.out.println(delete);
                        break;
                        
                    
                    case 3:
                        String search = Input.getString("search for: ");
                        
                        try {
                            PetNode foundPet = new PetNode();
                            foundPet = pet.find(search);
                            System.out.println(foundPet);
                        } catch (Exception e) {
                            System.out.println("insert invalid - value not found");
                        }
                       
                        break;
                        

                    case 4: 
                        System.out.println(pet.toString());
                        break;
    

                    case 5:
                        String animalSearch = Input.getString("Search for animal to add product to: ");
                            
                        try {
                            PetNode foundPet = new PetNode();
                            foundPet = pet.find(animalSearch);
                            String productSearch = Input.getString("Product to add: ");
                            foundPet.getList().listInsert(foundPet, productSearch);
    
    
                        } catch (Exception e) {
                            System.out.println("insert invalid - value not found");
                        }
                    
                        break;


                    case 6:
                        String animalFind = Input.getString("What animal is the product for: ");
                        try {
                            PetNode foundPet = new PetNode();
                            foundPet = pet.find(animalFind);
                            String product = Input.getString("Product to search: ");
                            Boolean found = foundPet.getList().search(foundPet, product);
                            if (found) {
                                System.out.println("'" + product + "'" + " found: " + found);
                            } else {
                                System.out.println("'" + product + "'" + " not found!");
                            }
                        } catch (Exception e) {
                            System.out.println("insert invalid - value not found");
                        }
                        
                        break;

                    case 7:
                        String animalRemove = Input.getString("What animal is the product for: ");
                        try {
                            PetNode foundPet = new PetNode();
                            foundPet = pet.find(animalRemove);
                            String product = Input.getString("Product to remove: ");
                            foundPet.getList().remove(foundPet, product);
                            System.out.println("'" + product + "'" + " successfully removed!");
                        } catch (Exception e) {
                            System.out.println("insert invalid - value not found");
                        }
                        break;
                            
                        
    
                    default:
                        System.out.println("insert invalid - value not found");
                        break;
                               
            }

            } catch (Exception e) {
                System.out.println("insert invalid - value not unique");
            }
                
    } while (option != 0);
           
    }
}

