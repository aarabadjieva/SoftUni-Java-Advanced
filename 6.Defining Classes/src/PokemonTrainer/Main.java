package PokemonTrainer;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        while (!line.equals("Tournament")){
            String[] data = line.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String element = data[2];
            int health = Integer.parseInt(data[3]);
            Pokemon pokemon = new Pokemon(pokemonName,element,health);
            if (!trainers.containsKey(trainerName)){
                Trainer trainer = new Trainer(trainerName,new ArrayList<>());
                trainers.put(trainerName,trainer);
            }
            trainers.get(trainerName).getPokemons().add(pokemon);
            line = scanner.nextLine();
        }
        String element = scanner.nextLine();
        while (!element.equals("End")){
            for (Trainer trainer:trainers.values()
                 ) {
                boolean isWinning = false;
                for (Pokemon pokemon:trainer.getPokemons()
                     ) {
                    if (pokemon.getElement().equals(element)){
                        isWinning = true;
                    }
                }
                if (isWinning){
                    trainer.setBadges(trainer.getBadges()+1);
                }else {
                    if (trainer.getPokemons().size() > 0){
                        for (int i = trainer.getPokemons().size() - 1; i >= 0; i--) {
                            trainer.getPokemons().get(i).setHealth(trainer.getPokemons().get(i).getHealth() - 10);
                            if (trainer.getPokemons().get(i).getHealth() <= 0) {
                                trainer.getPokemons().remove(trainer.getPokemons().get(i));
                            }
                        }
                }
                }
            }
            element = scanner.nextLine();
        }
        trainers.values().stream().sorted(Comparator.comparing(Trainer::getBadges).reversed()).forEach(t-> System.out.println(t.toString()));
    }
}
