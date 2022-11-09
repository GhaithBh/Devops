package tn.esprit.rh.achat.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.rh.achat.entities.CategorieProduit;

@Repository
public interface CategorieProduitRepository extends CrudRepository<CategorieProduit, Long>{

}
