package PetClinics;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Pet> pets = new LinkedHashMap<>();
        Map<String, Clinic> clinics = new LinkedHashMap<>();
        while (n-->0){
            String[] cmd = scanner.nextLine().split("\\s+");
            switch (cmd[0]){
                case "Create":
                    if (cmd[1].equals("Pet")){
                        Pet pet = new Pet(cmd[2],Integer.parseInt(cmd[3]),cmd[4]);
                        pets.putIfAbsent(pet.getName(),pet);
                    }else {
                        try {
                            Clinic clinic = new Clinic(cmd[2], Integer.parseInt(cmd[3]));
                            clinics.putIfAbsent(clinic.getName(),clinic);
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    String petName = cmd[1];
                    String clinicName = cmd[2];
                    System.out.println(clinics.get(clinicName).add(pets.get(petName)));
                    break;
                case "Release":
                    System.out.println(clinics.get(cmd[1]).release());
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(cmd[1]).hasEmptyRooms());
                    break;
                case "Print":
                    if (cmd.length==2){
                        for (Pet room:clinics.get(cmd[1]).getRooms()
                             ) {
                            if (room!=null) {
                                System.out.println(room.toString());
                            }else {
                                System.out.println("Room empty");
                            }
                        }
                    }else {
                        if (clinics.get(cmd[1]).getRooms()[Integer.parseInt(cmd[2])-1] == null) {
                            System.out.println("Room empty");
                        } else {
                            System.out.println(clinics.get(cmd[1]).getRooms()[Integer.parseInt(cmd[2])-1].toString());
                        }
                    }
                    break;
            }
        }
    }
}
