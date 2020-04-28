package repository;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private static final int ID = 0;
    private Map<Integer, Person> data;
    private int id;
    public Repository() {
        this.data = new HashMap<>();
        this.id = ID;
    }

    public void add(Person person){
        this.data.put(id++,person);
    }

    public Person get(int id){
        return data.get(id);
    }

    public boolean update(int id, Person newPerson){
        if (this.data.containsKey(id)){
            this.data.replace(id, newPerson);
            return true;
        }
        return false;
    }

    public boolean delete(int id){
        if (this.data.containsKey(id)){
            this.data.remove(id);
            return true;
        }
        return false;
    }

    public int getCount(){
        return this.data.size();
    }
}
