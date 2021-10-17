package org.example.pets;

//@Service
//@Profile("cat")
public class CatPetService implements PetService {
    @Override
    public String getPetType() {
        return "Cats Are the Best!";
    }
}
