import java.lang.Exception;

public class PetTest {
    public static void main(String[] args) throws Exception {
        Pet pet = new Pet();
        Integer option = 0;
    
        do {
            System.out.println("0: quit");
            System.out.println("1: insert");
            System.out.println("2: remove");
            System.out.println("3: find");
            System.out.println("4: display tree alphabetically");
            
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
