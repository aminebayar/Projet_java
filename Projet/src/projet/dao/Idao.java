package projet.dao;

import java.util.List;

import application.Salarie;

public interface Idao <T> {
boolean create(T o);
boolean delete (T o);
boolean update(T o );
T findByMatricule(int id );
List <T> findAll();
boolean ajouter(Salarie s);
//List<Salarie> findmin();
}
