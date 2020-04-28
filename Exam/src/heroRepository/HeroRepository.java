package heroRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeroRepository {
    private List<Hero> data;

    public HeroRepository() {
        this.data = new ArrayList<>();
    }

    public  void add(Hero hero){
        this.data.add(hero);
    }

    public void remove(String name){
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)){
                this.data.remove(i);
                break;
            }
        }
    }

    public Hero getHeroWithHighestStrength(){
        List<Hero> byStrenght = this.data.stream().sorted((h1, h2) ->{
            if (h1.getItem().getStrength()>h2.getItem().getStrength()){
                return -1;
            }else if (h1.getItem().getStrength()<h2.getItem().getStrength()){
                return 1;
            }
            return 0;
        }).collect(Collectors.toList());
        return byStrenght.get(0);
    }

    public Hero getHeroWithHighestAgility(){
        List<Hero> byAgility = this.data.stream().sorted((h1, h2) ->{
            if (h1.getItem().getAgility()>h2.getItem().getAgility()){
                return -1;
            }else if (h1.getItem().getAgility()<h2.getItem().getAgility()){
                return 1;
            }
            return 0;
        }).collect(Collectors.toList());
        return byAgility.get(0);
    }

    public Hero getHeroWithHighestIntelligence(){
        List<Hero> byIntelligence = this.data.stream().sorted((h1, h2) ->{
            if (h1.getItem().getIntelligence()>h2.getItem().getIntelligence()){
                return -1;
            }else if (h1.getItem().getIntelligence()<h2.getItem().getIntelligence()){
                return 1;
            }
            return 0;
        }).collect(Collectors.toList());
        return byIntelligence.get(0);
    }

    public int getCount(){
        return this.data.size();
    }

    @Override
    public String toString() {
        StringBuilder repository = new StringBuilder();
        for (Hero hero:this.data
             ) {
            repository.append(hero.toString());
        }
        return repository.toString();
    }
}
